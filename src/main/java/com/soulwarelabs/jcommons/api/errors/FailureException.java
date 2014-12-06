/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     FailureException.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/errors
 * Revision: 1.02, 27 November 2014
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
package com.soulwarelabs.jcommons.api.errors;

/**
 * Runtime exception.
 * <p>
 * Occurs due to some functional failure.
 *
 * @see Failure
 * @see RuntimeException
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 27 November 2014
 */
public class FailureException extends RuntimeException {

    private final Failure failure;

    /**
     * Creates a new instance of exception.
     *
     * @param failure an initial failure.
     *
     * @see Failure
     *
     * @since v1.1.0
     */
    public FailureException(Failure failure) {
        this.failure = failure;
    }

    /**
     * Creates a new instance of exception.
     *
     * @param failure an initial failure.
     * @param cause an initial exception.
     *
     * @see Failure
     *
     * @since v2.0.0
     */
    public FailureException(Failure failure, Throwable cause) {
        super(cause);
        this.failure = failure;
    }

    /**
     * Gets an initial failure of the exception.
     *
     * @return an initial failure.
     *
     * @see Failure
     *
     * @since v1.1.0
     */
    public Failure getFailure() {
        return Failure.copy(failure);
    }

    @Override
    public String getMessage() {
        return failure != null ? failure.print().toString() : null;
    }
}
