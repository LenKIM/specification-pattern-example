package org.example.domain;

import java.util.HashSet;
import java.util.Set;

public class Child {
    private final String name;
    private final int age;
    private final Set<Toy> favouriteToys = new HashSet<>();

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<Toy> getFavouriteToys() {
        return favouriteToys;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favouriteToys=" + favouriteToys +
                '}';
    }
}
