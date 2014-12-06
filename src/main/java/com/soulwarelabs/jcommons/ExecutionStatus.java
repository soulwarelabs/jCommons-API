package com.soulwarelabs.jcommons;

public enum ExecutionStatus {

    WAITING(false, false),

    CANCELED(false, true),

    RUNNING(true, false),

    STOPPED(true, true),

    FAILED(true, true),

    COMPLETE(true, true);

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

    public boolean isStartted() {
        return started;
    }

    public boolean isTerminated() {
        return terminated;
    }
}
