/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Nominated.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons
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
package com.soulwarelabs.jcommons;

/**
 * Nominal structure.
 *
 * @see Nominal
 *
 * @since v2.0.0
 *
 * @author Ilya Gubarev
 * @version 03 December 2014
 */
public abstract class Nominated extends Structure implements Nominal {

    private String name;
    private String description;

    /**
     * Creates a new instance of the structure.
     *
     * @since v2.0.0
     */
    public Nominated() {

    }

    /**
     * Creates a new instance of the structure.
     *
     * @param name structure's name.
     * @param description structure's description.
     *
     * @since v2.0.0
     */
    public Nominated(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
