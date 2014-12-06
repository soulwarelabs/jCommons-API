package com.soulwarelabs.jcommons.api;

public interface Executable extends Runnable {

    ExecutionStatus getStatus();

    void stop();
}
