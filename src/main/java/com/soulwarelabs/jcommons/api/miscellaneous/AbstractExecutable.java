/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     AbstractExecutable.java
 * Folder:   src/main/java/com/soulwarelabs/jcommons/api/miscellaneous
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
package com.soulwarelabs.jcommons.api.miscellaneous;

import java.util.Collection;
import java.util.LinkedList;

import com.soulwarelabs.jcommons.api.Executable;
import com.soulwarelabs.jcommons.api.ExecutionStatus;
import com.soulwarelabs.jcommons.api.Handler;

/**
 * Basic executable implementation.
 *
 * @see Executable
 *
 * @since v2.0.0
 *
 * @author Ilya Gubarev
 * @version 06 December 2014
 */
public abstract class AbstractExecutable implements Executable {

    private final Collection<Handler<Void, Object>> progressHandlers;

    private volatile ExecutionStatus status;
    private volatile boolean stopRequired;

    /**
     * Creates a new instance of the object.
     *
     * @since v2.0.0
     */
    public AbstractExecutable() {
        progressHandlers = new LinkedList<Handler<Void, Object>>();
        status = ExecutionStatus.WAITING;
    }

    @Override
    public ExecutionStatus getStatus() {
        return status;
    }

    /**
     * Adds new progress handler.
     *
     * @param handler progress handler.
     *
     * @see Handler
     *
     * @since v2.0.0
     */
    public void addProgressHandler(Handler<Void, Object> handler) {
        progressHandlers.add(handler);
    }

    @Override
    public void run() {
        synchronized (this) {
            if (stopRequired) {
                return;
            }
            status(ExecutionStatus.RUNNING, 0);
        }
        process();
    }

    @Override
    public void stop() {
        synchronized (this) {
            stopRequired = true;
            if (status == ExecutionStatus.WAITING) {
                status(ExecutionStatus.CANCELED);
            }
        }
    }

    /**
     * Gets whether stop was required.
     *
     * @return true if stop was required.
     *
     * @since v2.0.0
     */
    protected boolean isStopRequired() {
        return stopRequired;
    }

    /**
     * Performs main execution process.
     *
     * @since v2.0.0
     */
    protected abstract void process();

    /**
     * Updates current execution status.
     *
     * @param status current execution status.
     *
     * @see ExecutionStatus
     *
     * @since v2.0.0
     */
    protected void status(ExecutionStatus status) {
        status(status, null);
    }

    /**
     * Updates current execution status.
     *
     * @param status current execution status.
     * @param data additional execution data.
     *
     * @see ExecutionStatus
     *
     * @since v2.0.0
     */
    protected void status(ExecutionStatus status, Object data) {
        this.status = status;
        for (Handler<Void, Object> handler : progressHandlers) {
            handler.call(data);
        }
    }
}
