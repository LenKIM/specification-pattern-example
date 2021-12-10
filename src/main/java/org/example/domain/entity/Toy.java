package org.example.domain.entity;

public class Toy {
    private final String name;
    private final String color;
    private final ToyType type;
    private final double weight;


    public Toy(String name, String color, ToyType type, double weight) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public ToyType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                ", weight=" + weight +
                '}';
    }
}
