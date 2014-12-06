/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Credentials.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/api/security
 * Revision: 1.03, 06 December 2014
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
package com.soulwarelabs.jcommons.api.security;

import com.soulwarelabs.jcommons.api.Key;
import com.soulwarelabs.jcommons.api.Secret;
import com.soulwarelabs.jcommons.api.Structure;

/**
 * Authentication pair.
 *
 * @see Structure
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 06 December 2014
 */
public class Credentials extends Structure {

    private String login;
    private String password;

    /**
     * Creates a new authentication pair.
     *
     * @since v1.1.0
     */
    public Credentials() {

    }

    /**
     * Creates a new authentication pair.
     *
     * @param login user login.
     * @param password user password.
     *
     * @since v1.1.0
     */
    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Gets user login name.
     *
     * @return user login.
     *
     * @since v1.1.0
     */
    @Key
    public String getLogin() {
        return login;
    }

    /**
     * Sets user login name.
     *
     * @param login user login.
     *
     * @since v1.1.0
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets user password.
     *
     * @return user password.
     *
     * @since v1.1.0
     */
    @Key
    @Secret
    public String getPassword() {
        return password;
    }

    /**
     * Sets user password.
     *
     * @param password user password.
     *
     * @since v1.1.0
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
