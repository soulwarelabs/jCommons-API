/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Structure.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons
 * Revision: 1.07, 03 December 2014
 * Created:  15 July 2014
 * Authors:  Ilya Gubarev
 *
 * Copyright (c) 2014 Soulware Labs, Ltd.
 * Contact information is available at "http://www.soulwarelabs.com".
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       "http://www.apache.org/licenses/LICENSE-2.0".
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soulwarelabs.jcommons;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Plain data structure.
 *
 * @see Copyable
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 03 December 2014
 */
public abstract class Structure implements Copyable, Printable, Serializable {

    private static class Property {

        private Method accessor;
        private Method mutator;
        private String name;
        private boolean hidden;
        private boolean key;
        private boolean secret;
    }

    private final static Map<Class, Map<String, Property>> PROPERTIES;

    static {
        PROPERTIES = new HashMap<Class, Map<String, Property>>();
    }

    /**
     * Creates a new copy of specified object.
     *
     * @param <T> object type.
     * @param object an object to be copied (optional).
     * @return a copy of the object.
     * @throws RuntimeException if error occurs while copying the object.
     *
     * @since v2.0.0
     */
    @SuppressWarnings({"unchecked"})
    public static <T> T copy(T object) {
        // NOTE: possible exception is declared
        if (object == null) {
            return null;
        } else if (object instanceof Collection<?>) {
            return (T) copy((Collection<?>) object);
        } else if (object instanceof Map<?, ?>) {
            return (T) copy((Map<?, ?>) object);
        } else if (object.getClass().isArray()) {
            return (T) copyArray(object);
        } else if (object instanceof Copyable) {
            return (T) ((Copyable) object).copy();
        } else {
            return object;
        }
    }

    /**
     * Gets a string presentation of specified object.
     *
     * @param object an object to be printed (optional).
     * @return string presentation of the object.
     *
     * @since v1.1.0
     */
    public static StringBuilder print(Object object) {
        if (object == null) {
            return new StringBuilder().append("null");
        }
        if (object instanceof Collection<?>) {
            return printCollection((Collection<?>) object);
        }
        if (object instanceof Map<?, ?>) {
            return printMap((Map<?, ?>) object);
        }
        if (object instanceof Printable) {
            return ((Printable) object).print();
        }
        if (object instanceof CharSequence) {
            return new StringBuilder((CharSequence) object);
        }
        return new StringBuilder().append(object);
    }

    private static Map<String, Property> getProperties(Class type) {
        try {
            Map<String, Property> result = PROPERTIES.get(type);
            if (result == null) {
                result = new HashMap<String, Property>();
                BeanInfo info = Introspector.getBeanInfo(type, Structure.class);
                for (PropertyDescriptor d : info.getPropertyDescriptors()) {
                    Property p = new Property();
                    p.accessor = d.getReadMethod();
                    p.mutator = d.getWriteMethod();
                    p.name = d.getName();
                    p.hidden = p.accessor.getAnnotation(Hidden.class) != null;
                    p.key = p.accessor.getAnnotation(Key.class) != null;
                    p.secret = p.accessor.getAnnotation(Secret.class) != null;
                    p.accessor.setAccessible(true);
                    p.mutator.setAccessible(true);
                    result.put(p.name, p);
                }
                PROPERTIES.put(type, result);
            }
            return result;
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> Collection<T> copy(Collection<T> collection) {
        Collection<T> result = new ArrayList<T>(collection.size());
        for (T element : collection) {
            result.add(copy(element));
        }
        return result;
    }

    private static <K, V> Map<K, V> copy(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (K key : map.keySet()) {
            V value = map.get(key);
            result.put(copy(key), copy(value));
        }
        return result;
    }

    private static Object copyArray(Object array) {
        return array;
    }

    private static StringBuilder printCollection(Collection<?> collection) {
        StringBuilder result = new StringBuilder("[");
        int index = 0;
        for (Object item : collection) {
            result.append(print(item));
            if (++index < collection.size()) {
                result.append(", ");
            } 
        }
        return result.append("]");
    }

    private static StringBuilder printMap(Map<?, ?> map) {
        StringBuilder result = new StringBuilder("{");
        int index = 0;
        for (Object obj : map.keySet()) {
            result.append(print(obj)).append(": ").append(map.get(obj));
            if (++index < map.size()) {
                result.append(", ");
            } 
        }
        return result.append("}");
    }

    /**
     * Creates a new plain data structure.
     *
     * @since v1.1.0
     */
    public Structure() {

    }

    /**
     * Gets a map presentation of the structure.
     *
     * @return mapped structure properties.
     *
     * @since v2.0.0
     */
    public Map<String, Object> getStructureProperties() {
        Map<String, Object> result = new LinkedHashMap<String, Object>(); 
        Class<?> type = getClass();
        for (Property property : getProperties(type).values()) {
            try {
                result.put(property.name, property.accessor.invoke(this));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T copy() {
        // NOTE: possible exception is declared in Copyable
        try {
            Class<?> type = getClass();
            Object result = type.newInstance();
            for (Property property : getProperties(type).values()) {
                property.mutator.invoke(result, property.accessor.invoke(this));
            }
            return (T) result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        try {
            for (Property property : getProperties(getClass()).values()) {
                if (property.key) {
                    Object value = property.accessor.invoke(this);
                    if (value == null ||
                            !value.equals(property.accessor.invoke(object))) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public int hashCode() {
        try {
            int hash = 5;
            for (Property property : getProperties(getClass()).values()) {
                if (property.key) {
                    Object value = property.accessor.invoke(this);
                    hash = 31 * hash + (value != null ? value.hashCode() : 0);
                }
            }
            return hash;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StringBuilder print() {
        try {
            Map<String, Object> fields = new HashMap<String, Object>();
            for (Property property : getProperties(getClass()).values()) {
                if (property.hidden) {
                    continue;
                }
                Object value;
                if (property.secret) {
                    value = "*";
                } else {
                    value = property.accessor.invoke(this);
                }
                fields.put(property.name, print(value));
            }
            return print(fields);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return print().toString();
    }
}
