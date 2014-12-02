package com.soulwarelabs.jcommons;

public abstract class Identified<T> extends Structure
        implements Identifiable<T> {

    private T id;

    public Identified() {

    }

    public Identified(T id) {
        this.id = id;
    }

    @Key
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
