package org.example.abstracts.specification;

public abstract class AbstractSpecification<T> implements Specification<T> {

    public abstract boolean isSatisfiedBy(T t);

    public AbstractSpecification<T> or(Specification<T> s){
        return new OrSpecification<T>(this, s);
    }

    public AbstractSpecification<T> and(Specification<T> s){
        return new AndSpecification<>(this,s);
    }

    public AbstractSpecification<T> not(){
        return new NotSpecification<>(this);
    }

    public AbstractSpecification<T> alwaysTrue(){
        return new AlwaysTrueSpecification<>(this);
    }

    private static class AlwaysTrueSpecification<T> extends AbstractSpecification<T> {
        public AlwaysTrueSpecification(AbstractSpecification<T> abstractSpecification) {
            super();
        }

        @Override
        public boolean isSatisfiedBy(T t) {
            return true;
        }
    }
}
