/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Credentials.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/data
 * Revision: 1.01, 24 August 2014
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
package com.soulwarelabs.jcommons.data;

import com.soulwarelabs.jcommons.Pojo;
import com.soulwarelabs.jcommons.namings.Secret;

/**
 * Authentication pair.
 * <p>
 * Designed to be logically comparable by both the login and the password.
 *
 * @see Pojo
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 24 August 2014
 */
public class Credentials extends Pojo {

    /**
     * Creates a new copy of authentication pair.
     *
     * @param credentials original authentication pair (optional).
     * @return copied authentication pair (optional).
     *
     * @since v1.1.0
     */
    public static Credentials copy(Credentials credentials) {
        if (credentials == null) {
            return null;
        }
        return new Credentials(credentials.login, credentials.password);
    }

    private String login;
    private @Secret String password;

    /**
     * Creates a new authentication pair.
     *
     * @since v1.1.0
     */
    public Credentials() {
        this(null, null);
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

    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T copy() {
         // NOTE: possible exception is documented for Copyable.copy()
        return (T) copy(this);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Credentials other = (Credentials) object;
        if (login == null ? other.login != null : !login.equals(other.login)) {
            return false;
        }
        if (password == null ? other.password != null :
                !password.equals(other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 29 * result + (login != null ? login.hashCode() : 0);
        result = 29 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
