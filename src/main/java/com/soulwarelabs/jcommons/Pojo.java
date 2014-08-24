/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Pojo.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons
 * Revision: 1.02, 23 August 2014
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

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.soulwarelabs.jcommons.namings.HiddenField;
import com.soulwarelabs.jcommons.namings.SecretField;

/**
 * Data structure.
 *
 * @see Copyable
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 23 August 2014
 */
public abstract class Pojo implements Copyable, Serializable {

    /**
     * Gets a string presentation of specified object.
     *
     * @param object an object to be printed (optional).
     * @return string presentation of the object.
     *
     * @since v1.1.0
     */
    public static StringBuilder print(Object object) {
        return print(object, false);
    }

    private static StringBuilder print(Object object, boolean unbrace) {
        if (object == null) {
            return printNull();
        }
        if (object instanceof Collection<?>) {
            return printCollection((Collection<?>) object);
        }
        if (object instanceof Map<?, ?>) {
            return printMap((Map<?, ?>) object);
        }
        if (object instanceof Printable) {
            return printText(((Printable) object).print(), unbrace);
        }
        if (object instanceof Pojo) {
            return printPojo(((Pojo) object));
        }
        if (object instanceof CharSequence) {
            return printText((CharSequence) object, unbrace);
        }
        return printText(object.toString(), unbrace);
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
            result.append("\"").append(print(obj, true)).append("\"");
            result.append(": ").append(print(map.get(obj)));
            if (++index < map.size()) {
                result.append(", ");
            } 
        }
        return result.append("}");
    }

    private static StringBuilder printNull() {
        return new StringBuilder("null");
    }

    private static StringBuilder printPojo(Pojo pojo) {
        return printMap(pojo.getPojoFields());
    }

    private static StringBuilder printText(CharSequence text, boolean unbrace) {
        if (unbrace) {
            return new StringBuilder(text);
        } else {
            return new StringBuilder("\"").append(text).append("\"");
        }
    }

    /**
     * Creates a new data structure.
     *
     * @since v1.1.0
     */
    public Pojo() {

    }

    private Map<String, Object> getPojoFields() {
        Map<String, Object> result = new LinkedHashMap<String, Object>(); 
        Class<?> type = getClass();
        while (type != Pojo.class) {
            for (Field field : type.getDeclaredFields()) {
                try {
                    if (field.isAnnotationPresent(HiddenField.class)) {
                        continue;
                    }
                    Object value;
                    if (field.isAnnotationPresent(SecretField.class)) {
                        value = "*";
                    } else {
                        field.setAccessible(true);
                        value = field.get(this);
                        field.setAccessible(false);
                    }
                    result.put(field.getName(), value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            type = type.getSuperclass();
        }
        return result;
    }
}
