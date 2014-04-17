/*
 * Project:  jCommons-API
 * Outline:  jCommons framework API components
 *
 * File:     ConnectionPool.java
 * Folder:   /.../com/soulwarelabs/jcommons/sql
 * Revision: 1.01, 17 April 2014
 * Created:  12 February 2014
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
package com.soulwarelabs.jcommons.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * SQL database connection pool.
 *
 * @see Connection
 *
 * @since v1.0
 *
 * @author Ilya Gubarev
 * @version 17 April 2014
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
     * @since v1.0
     */
    Connection getConnection() throws SQLException;
}
