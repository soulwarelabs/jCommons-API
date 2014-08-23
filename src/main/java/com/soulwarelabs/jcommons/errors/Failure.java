/*
 * Project:  jCommons-API
 * Outline:  jCommons framework API components
 *
 * File:     Failure.java
 * Folder:   /.../com/soulwarelabs/jcommons/errors
 * Revision: 1.02, 23 August 2014
 * Created:  16 August 2014
 * Authors:  Ilya Gubarev
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
package com.soulwarelabs.jcommons.errors;

import java.io.Serializable;

import com.soulwarelabs.jcommons.Copyable;

/**
 * Failure descriptor.
 * <p>
 * Designed to be logically comparable by the code.
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 23 August 2014
 */
public class Failure implements Copyable, Serializable {

    /**
     * Creates a new copy of a failure descriptor.
     *
     * @param failure a failure descriptor to be copied (optional).
     * @return copy of the failure descriptor (optional).
     *
     * @since v1.1.0
     */
    public static Failure copy(Failure failure) {
        if (failure == null) {
            return null;
        }
        Failure result = new Failure();
        result.code = failure.code;
        result.details = failure.details;
        result.title = failure.title;
        return result;
    }

    private String code;
    private String details;
    private String title;

    /**
     * Creates a new instance of failure descriptor.
     *
     * @since v1.1.0
     */ 
    public Failure() {

    }

    /**
     * Gets a code of the failure.
     *
     * @return failure code.
     *
     * @since v1.1.0
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets a code of the failure.
     *
     * @param code failure code.
     *
     * @since v1.1.0
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets details of the failure.
     *
     * @return failure details (optional).
     *
     * @since v1.1.0
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets details of the failure.
     *
     * @param details failure details (optional).
     *
     * @since v1.1.0
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets a title of the failure.
     *
     * @return failure title.
     *
     * @since v1.1.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets a title of the failure.
     *
     * @param title failure title.
     *
     * @since v1.1.0
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Failure copy() {
        return copy(this);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Failure other = (Failure) object;
        if (code == null || !code.equals(other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = result * 13 + (code != null ? code.hashCode() : 0);
        result = result * 67 + (details != null ? details.hashCode() : 0);
        result = result * 29 + (title != null ? title.hashCode() : 0);
        return result;
    }

    /**
     * Gets a text view of the failure.
     *
     * @return failure text view.
     *
     * @since v1.1.0
     */
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s (%s)", title, code));
        if (details != null) {
            result.append(String.format(" - %s", details));
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return print();
    }
}
