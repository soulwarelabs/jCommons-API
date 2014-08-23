package com.soulwarelabs.jcommons;

import java.io.Serializable;

public abstract class Pojo implements Copyable, Printable , Serializable {

    public static String print(Object object) {
        throw new UnsupportedOperationException();
    }
}
