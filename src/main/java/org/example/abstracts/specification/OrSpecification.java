package org.example.abstracts.specification;

import java.util.HashSet;
import java.util.Set;

public class OrSpecification<T> extends AbstractSpecification<T> {

    private Set<Specification<T>> set = new HashSet<>();

    public OrSpecification(AbstractSpecification<T> a, Specification<T> b) {
        set.add(a);
        set.add(b);
    }


    @Override
    public boolean isSatisfiedBy(T t) {
        for (Specification<T> s : set) {
            if (s.isSatisfiedBy(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractSpecification<T> or(Specification<T> s) {
        set.add(s);
        return this;
    }
}
