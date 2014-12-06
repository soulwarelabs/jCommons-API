/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Logger.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/api/logging
 * Revision: 1.00, 28 November 2014
 * Created:  28 November 2014
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
package com.soulwarelabs.jcommons.api.logging;

/**
 * System logging service.
 *
 * @since v2.0.0
 *
 * @author Ilya Gubarev
 * @version 28 November 2014
 */
public interface Logger {

    /**
     * Creates a log record about specified system event.
     *
     * @param severity system event severity
     * @param data system event data.
     *
     * @see SeverityLevel
     *
     * @since v2.0.0
     */
    void log(SeverityLevel severity, Object data);
}
