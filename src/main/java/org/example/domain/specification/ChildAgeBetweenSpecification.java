package org.example.domain.specification;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.domain.Child;

public class ChildAgeBetweenSpecification extends AbstractSpecification<Child> {

    private final int min;
    private final int max;

    public ChildAgeBetweenSpecification(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isSatisfiedBy(Child child) {
        return child.getAge() >= min && child.getAge() <= max;
    }
}
