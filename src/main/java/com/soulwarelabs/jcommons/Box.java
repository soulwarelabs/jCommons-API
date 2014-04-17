/*
 * Project:  jCommons-API
 * Outline:  jCommons framework API components
 *
 * File:     Box.java
 * Folder:   /.../com/soulwarelabs/jcommons
 * Revision: 1.03, 17 April 2014
 * Created:  10 February 2014
 * Author:   Ilya Gubarev
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
 * Value container.
 *
 * @param <T> value type.
 *
 * @since v1.0
 *
 * @author Ilya Gubarev
 * @version 17 April 2014
 */
public class Box<T> implements Serializable {

    private T value;

    /**
     * Creates a new instance of value container.
     *
     * @since v1.0
     */
    public Box() {

    }

    /**
     * Creates a new instance of value container.
     *
     * @param value contained value.
     *
     * @since v1.0
     */
    public Box(T value) {
        this.value = value;
    }

    /**
     * Gets a value contained inside.
     *
     * @return contained value.
     *
     * @since v1.0
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets a new value to be contained inside.
     *
     * @param value contained value.
     *
     * @since v1.0
     */
    public void setValue(T value) {
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
        Box<?> other = (Box<?>) object;
        if ((value != other.value) &&
                (value == null || !value.equals(other.value))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 67 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s", value);
    }
}
