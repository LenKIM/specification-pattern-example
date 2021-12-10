package org.example.domain.specification;


import org.example.abstracts.specification.AbstractSpecification;
import org.example.domain.Toy;

public class ToyWeightBetweenSpecification extends AbstractSpecification<Toy> {

    private int min;
    private int max;

    public ToyWeightBetweenSpecification(int min, int max) {
        super();
        this.min = min;
        this.max = max;
    }

    public boolean isSatisfiedBy(Toy t) {
        return (t.getWeight() > min && t.getWeight() < max);
    }

}
