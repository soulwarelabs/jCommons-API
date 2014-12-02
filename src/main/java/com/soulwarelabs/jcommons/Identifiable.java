/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Identifiable.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons
 * Revision: 1.00, 27 November 2014
 * Created:  27 November 2014
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
 * Identifiable object.
 *
 * @param <T> identifier type.
 *
 * @since v2.0.0
 *
 * @author Ilya Gubarev
 * @version 27 November 2014
 */
public interface Identifiable<T> {

    /**
     * Gets object's identifier.
     *
     * @return object's identifier.
     *
     * @since v2.0.0
     */
    T getId();

    /**
     * Sets object's identifier.
     *
     * @param id object's identifier.
     *
     * @since v2.0.0
     */
    void setId(T id);
}
