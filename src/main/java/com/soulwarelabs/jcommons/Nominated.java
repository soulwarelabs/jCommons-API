package com.soulwarelabs.jcommons;

public abstract class Nominated extends Structure implements Nominal {

    private String name;
    private String description;

    public Nominated() {

    }

    public Nominated(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
