package org.example.domain.specification;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.abstracts.specification.Specification;
import org.example.domain.Toy;
import org.example.domain.ToyType;

public class ToySpecifiedByType extends AbstractSpecification<Toy> {

    private Specification<ToyType> spec;

    public ToySpecifiedByType(Specification<ToyType> spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(Toy toy) {
        return spec.isSatisfiedBy(toy.getType());
    }
}
