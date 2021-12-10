package org.example.domain.entity;

public class ToyType {
    private final String name;

    public ToyType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ToyType [name=" + name + "]";
    }
}
