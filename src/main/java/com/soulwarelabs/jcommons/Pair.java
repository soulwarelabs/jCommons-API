/*
 * Project:  jCommons-API
 * Outline:  jCommons framework API components
 *
 * File:     Pair.java
 * Folder:   /.../com/soulwarelabs/jcommons
 * Revision: 1.02, 10 June 2014
 * Created:  14 February 2014
 * Authors:  Ilya Gubarev
 *
 * Copyright (c) 2013-2014 Soulware Labs, Ltd.
 * Contact information is available at http://www.soulwarelabs.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soulwarelabs.jcommons;

import java.io.Serializable;

/**
 * Key-value container.
 * <p>
 * Designed to be logically comparable by the key.
 *
 * @param <K> key type.
 * @param <V> value type.
 *
 * @since v1.0.0
 *
 * @author Ilya Gubarev
 * @version 10 June 2014
 */
public class Pair<K, V> implements Serializable {

    private K key;
    private V value;

    /**
     * Creates a new instance of key-value container.
     *
     * @since v1.0.0
     */
    public Pair() {
        this(null);
    }

    /**
     * Creates a new instance of container.
     *
     * @param key contained key.
     *
     * @since v1.0.0
     */
    public Pair(K key) {
        this(key, null);
    }

    /**
     * Creates a new instance of container.
     *
     * @param key contained key.
     * @param value contained value.
     *
     * @since v1.0.0
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets a key contained inside.
     *
     * @return contained key.
     *
     * @since v1.0.0
     */
    public K getKey() {
        return key;
    }

    /**
     * Sets a new key to be contained inside.
     *
     * @param key contained key.
     *
     * @since v1.0.0
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Creates a new instance of value container.
     *
     * @return contained value.
     *
     * @since v1.0.0
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets a new value to be contained inside.
     *
     * @param value contained value.
     *
     * @since v1.0.0
     */
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Pair<?, ?> other = (Pair<?, ?>) object;
        if (key != other.key && (key == null || !key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 5;
        result = 67 * result + (key != null ? key.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", key, value);
    }
}
