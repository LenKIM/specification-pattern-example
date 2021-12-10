package org.example.domain.specification;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.domain.Child;
import org.example.domain.Toy;

public class ChildLikesToySpecification extends AbstractSpecification<Child> {

    private final Toy toy;

    public ChildLikesToySpecification(Toy toy) {
        this.toy = toy;
    }

    @Override
    public boolean isSatisfiedBy(Child child) {
        return child.getFavouriteToys().contains(toy);
    }
}
