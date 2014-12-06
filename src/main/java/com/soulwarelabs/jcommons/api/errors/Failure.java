/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Failure.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/api/errors
 * Revision: 1.07, 03 December 2014
 * Created:  16 August 2014
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
package com.soulwarelabs.jcommons.api.errors;

import com.soulwarelabs.jcommons.api.Classified;

/**
 * Failure descriptor.
 *
 * @see Classified
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 03 December 2014
 */
public class Failure extends Classified<String> {

    /**
     * Creates a new failure descriptor based on its string presentation.
     *
     * @param failure string presentation of a failure.
     * @return failure descriptor.
     * @throws RuntimeException if error occurs while parsing the failure.
     *
     * @since v1.1.0
     */
    public static Failure parse(String failure) {
        Failure result = new Failure();
        int dash = failure.indexOf('-');
        int leftBracet = failure.indexOf('(');
        int rightBracet = failure.indexOf(')');
        result.setName(failure.substring(0, leftBracet).trim());
        result.setCode(failure.substring(leftBracet + 1, rightBracet).trim());
        if (dash > 0) {
            result.setDescription(failure.substring(dash + 1).trim());
        }
        return result;
    }

    /**
     * Creates a new instance of the failure descriptor.
     *
     * @since v1.1.0
     */ 
    public Failure() {

    }

    /**
     * Creates a new instance of the failure descriptor.
     *
     * @param code failure's code.
     * @param name failure's name.
     * @param description failure's description.
     *
     * @since v2.0.0
     */ 
    public Failure(String code, String name, String description) {
        super(code, name, description);
    }

    @Override
    public StringBuilder print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s (%s)", getName(), getCode()));
        if (getDescription() != null) {
            result.append(String.format(" - %s", getDescription()));
        }
        return result;
    }
}
