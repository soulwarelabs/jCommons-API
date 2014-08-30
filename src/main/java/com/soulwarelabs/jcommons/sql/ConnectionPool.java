/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     ConnectionPool.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/sql
 * Revision: 1.05, 30 August 2014
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
import java.sql.SQLException;

import com.soulwarelabs.jcommons.data.Credentials;

/**
 * SQL database connection pool.
 * <p>
 * The pool should be used to acquire SQL database connections either
 * anonymously or by providing user / password pair. Since that some endpoint
 * implementations may refuse to support both methods simultaneously.
 * <p>
 * Designed to be absolutely thread-safe.
 *
 * @see Connection
 *
 * @since v1.0.0
 *
 * @author Ilya Gubarev
 * @version 30 August 2014
 */
public interface ConnectionPool {

    /**
     * Gets an available SQL database connection from the pool.
     *
     * @return SQL database connection.
     * @throws SQLException if no SQL connection is available.
     *
     * @see Connection
     *
     * @since v1.0.0
     */
    Connection getConnection() throws SQLException;

    /**
     * Gets an available SQL database connection from the pool.
     *
     * @param credentials user authentication pair.
     * @return SQL database connection.
     * @throws SQLException if no SQL connection is available.
     *
     * @see Connection
     * @see Credentials
     *
     * @since v1.1.0
     */
    Connection getConnection(Credentials credentials) throws SQLException;

    /**
     * Gets an available SQL database connection from the pool.
     *
     * @param user SQL database user name.
     * @param password SQL database user password.
     * @return SQL database connection.
     * @throws SQLException if no SQL connection is available.
     *
     * @see Connection
     *
     * @since v1.0.0
     */
    Connection getConnection(String user, String password) throws SQLException;
}
