package com.soulwarelabs.jcommons;

public abstract class Classified<T> extends Nominated
        implements Classifiable<T> {

    private @Key T code;

    public Classified() {
        
    }

    public Classified(T code, String name, String description) {
        super(name, description);
        this.code = code;
    }

    @Override
    public T getCode() {
        return code;
    }

    @Override
    public void setCode(T code) {
        this.code = code;
    }
}