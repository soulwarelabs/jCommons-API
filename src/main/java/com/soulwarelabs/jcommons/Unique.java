package com.soulwarelabs.jcommons;

public abstract class Unique<T> extends Nominated implements Identifiable<T> {

    private T id;

    public Unique() {

    }

    public Unique(T id, String name, String description) {
        super(name, description);
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
