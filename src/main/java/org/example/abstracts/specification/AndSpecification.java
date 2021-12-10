package org.example.abstracts.specification;

import java.util.HashSet;
import java.util.Set;

public class AndSpecification<T> extends AbstractSpecification<T> {

    private Set<Specification<T>> set = new HashSet<>();

    public AndSpecification(AbstractSpecification<T> a, Specification<T> b) {
        set.add(a);
        set.add(b);
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        for (Specification<T> s : set) {
            if (!s.isSatisfiedBy(t)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public AbstractSpecification<T> and(Specification<T> s) {
        set.add(s);
        return this;
    }
}
