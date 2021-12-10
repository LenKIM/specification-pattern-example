package org.example.domain.specification;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.domain.Child;

public class ChildNameSpecification extends AbstractSpecification<Child> {

    private final String name;

    public ChildNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(Child child) {
        return child.getName().equals(name);
    }
}
