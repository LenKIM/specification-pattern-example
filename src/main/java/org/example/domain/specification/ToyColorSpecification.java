package org.example.domain.specification;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.domain.entity.Toy;

public class ToyColorSpecification extends AbstractSpecification<Toy> {

    private final String color;

    public ToyColorSpecification(String color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfiedBy(Toy toy) {
        return toy.getColor().equals(color);
    }
}
