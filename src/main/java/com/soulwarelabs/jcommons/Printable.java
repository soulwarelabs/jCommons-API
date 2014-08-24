/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Printable.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons
 * Revision: 1.02, 23 August 2014
 * Created:  18 August 2014
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
 * Printable object.
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 23 August 2014
 */
public interface Printable {

    /**
     * Gets a string presentation of the object.
     *
     * @return string presentation of the object.
     *
     * @since v1.1.0
     */
    StringBuilder print();
}
