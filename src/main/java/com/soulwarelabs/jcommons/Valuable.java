package com.soulwarelabs.jcommons;

public interface Valuable<T> {

    T getValue();

    void setValue(T value);
}
