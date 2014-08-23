package com.soulwarelabs.jcommons;

import java.io.Serializable;

public abstract class Pojo implements Copyable, Serializable {

    public static String print(Object object) {
        throw new UnsupportedOperationException();
    }
}
