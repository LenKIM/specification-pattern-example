package org.example.abstracts.specification;

public class NotSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> spec;

    public NotSpecification(AbstractSpecification<T> a) {
        this.spec = a;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return spec.isSatisfiedBy(t) == false;
    }
}
