/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     ExecutionStatus.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/api
 * Revision: 1.00, 06 December 2014
 * Created:  06 December 2014
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
package com.soulwarelabs.jcommons.api;

/**
 * Execution status.
 *
 * @since v2.0.0
 *
 * @author Ilya Gubarev
 * @version 06 December 2014
 */
public enum ExecutionStatus {

    /**
     * Waiting for execution.
     *
     * @since v2.0.0
     */
    WAITING(false, false),

    /**
     * Execution had been canceled before it was started.
     *
     * @since v2.0.0
     */
    CANCELED(false, true),

    /**
     * Execution is in progress.
     *
     * @since v2.0.0
     */
    RUNNING(true, false),

    /**
     * Execution was stopped explicitly.
     *
     * @since v2.0.0
     */
    STOPPED(true, true),

    /**
     * Execution terminated due to occured errors.
     *
     * @since v2.0.0
     */
    FAILED(true, true),

    /**
     * Execution terminated due to its completion.
     *
     * @since v2.0.0
     */
    COMPLETE(true, true);

    /**
     * Gets an execution status according to specified name.
     *
     * @param name execution status name.
     * @return execution status.
     *
     * @since v2.0.0
     */
    public static ExecutionStatus lookup(String name) {
        if (name == null) {
            return null;
        }
        for (ExecutionStatus status : values()) {
            if (status.name().equalsIgnoreCase(name)) {
                return status;
            }
        }
        return null;
    }

    private final boolean started;
    private final boolean terminated;

    private ExecutionStatus(boolean started, boolean terminated) {
        this.started = started;
        this.terminated = terminated;
    }

    /**
     * Gets whether execution was started.
     *
     * @return true if execution was started.
     *
     * @since v2.0.0
     */
    public boolean isStarted() {
        return started;
    }

    /**
     * Gets whether execution was terminated.
     *
     * @return true if execution was terminated.
     *
     * @since v2.0.0
     */
    public boolean isTerminated() {
        return terminated;
    }
}
