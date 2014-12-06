package com.soulwarelabs.jcommons;

public interface Executable extends Runnable {

    ExecutionStatus getStatus();

    void stop();
}
