package org.example.domain.specification;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.abstracts.specification.Specification;
import org.example.domain.Child;
import org.example.domain.Toy;

public class ChildLikesSpecifiedToySpecification extends AbstractSpecification<Child> {

    private Specification<Toy> spec;

    public ChildLikesSpecifiedToySpecification(Specification<Toy> spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(Child child) {
        for (Toy t : child.getFavouriteToys()) {
            if (spec.isSatisfiedBy(t)) {
                return true;
            }
        }
        return false;
    }
}
