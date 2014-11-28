/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     ConnectionPool.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/sql
 * Revision: 2.02, 28 November 2014
 * Created:  12 February 2014
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
package com.soulwarelabs.jcommons.sql;

import java.sql.Connection;

/**
 * SQL database connection pool.
 * <p>
 * Designed to be thread-safe.
 *
 * @see Connection
 *
 * @since v1.0.0
 *
 * @author Ilya Gubarev
 * @version 28 November 2014
 */
public interface ConnectionPool {

    /**
     * Gets an available SQL database connection from the pool.
     *
     * @return SQL database connection.
     * @throws RuntimeException if error occurs while acquiring the connection.
     *
     * @see Connection
     *
     * @since v2.0.0
     */
    Connection getConnection();
}
