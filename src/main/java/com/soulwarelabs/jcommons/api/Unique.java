/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Unique.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/api
 * Revision: 1.00, 03 December 2014
 * Created:  03 December 2014
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
package com.soulwarelabs.jcommons.api;

/**
 * Identifiable nominable structure.
 *
 * @param <T> identifier type.
 *
 * @see Identifiable
 *
 * @since v2.0.0
 *
 * @author Ilya Gubarev
 * @version 03 December 2014
 */
public abstract class Unique<T> extends Nominated implements Identifiable<T> {

    private T id;

    /**
     * Creates a new instance of the structure.
     *
     * @since v2.0.0
     */
    public Unique() {

    }

    /**
     * Creates a new instance of the structure.
     *
     * @param id structure's identifier.
     * @param name structure's name.
     * @param description structure's description.
     *
     * @since v2.0.0
     */
    public Unique(T id, String name, String description) {
        super(name, description);
        this.id = id;
    }

    @Key
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
