package org.example.domain.specification;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.domain.ToyType;

public class ToyTypeNameSpecification extends AbstractSpecification<ToyType> {

    private String name;

    public ToyTypeNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(ToyType t) {
        return t.getName().equals(name);
    }

}
