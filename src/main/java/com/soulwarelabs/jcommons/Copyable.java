/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Copyable.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons
 * Revision: 1.02, 03 December 2014
 * Created:  17 August 2014
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
 * Copyable object.
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 03 December 2014
 */
public interface Copyable {

    /**
     * Creates a new copy of the object.
     *
     * @param <T> object type.
     * @return copy of the object.
     * @throws RuntimeException if error occurs while copying object.
     *
     * @since v1.1.0
     */
    <T> T copy();
}
