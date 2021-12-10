package org.example;

import org.example.abstracts.specification.AbstractSpecification;
import org.example.abstracts.specification.Specification;
import org.example.domain.entity.Child;
import org.example.domain.entity.Toy;
import org.example.domain.entity.ToyType;
import org.example.domain.specification.ChildLikesSpecifiedToySpecification;
import org.example.domain.specification.ChildNameSpecification;
import org.example.domain.specification.SchoolChildrenSpecification;
import org.example.domain.specification.ToyColorSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Set<Child> children;
    private Child foo;
    private Child bar;
    private Child max;
    private Child jenny;

    @BeforeEach
    void setUp() {
        ToyType fireTruckType = new ToyType("Fire truck");
        ToyType racingCarType = new ToyType("Racing car");
        ToyType policeCarType = new ToyType("Police car");
        ToyType teddyBear = new ToyType("Teddy Bear");

        Toy ferrari = new Toy("Ferrari","Red", racingCarType,0.4);
        Toy laFireTruck = new Toy("Los Angeles Fire Truck","Red", fireTruckType,3.0);
        Toy policeCar = new Toy("New York Police Department car","White", policeCarType,0.9);
        Toy timmy = new Toy("Timmy The Bear","Brown", teddyBear,0.35);

        foo = new Child("foo",7);
        foo.getFavouriteToys().add(ferrari);
        foo.getFavouriteToys().add(laFireTruck);

        bar = new Child("bar",10);
        bar.getFavouriteToys().add(policeCar);

        max = new Child("Max",8);
        max.getFavouriteToys().add(policeCar);
        max.getFavouriteToys().add(laFireTruck);

        jenny = new Child("Jenny",5);
        jenny.getFavouriteToys().add(timmy);

        children = new HashSet<>();
        children.add(foo);
        children.add(bar);
        children.add(max);
        children.add(jenny);
    }
    /**
     * Let's find all children named Johny
     */
    @Test
    void childNameSpecification() {
        Specification<Child> spec_foo = new ChildNameSpecification("foo");
        Set<Child> collect = children.stream().filter(child -> spec_foo.isSatisfiedBy(child)).collect(Collectors.toSet());
        assertEquals(Set.of(foo), collect);
    }

    /**
     * Let's find all children who like red toys
     */
    @Test
    void toySpecification() {
        Specification<Child> spec_red = new ChildLikesSpecifiedToySpecification(new ToyColorSpecification("Red"));
        Set<Child> collect = children.stream().filter(child -> spec_red.isSatisfiedBy(child)).collect(Collectors.toSet());
        assertEquals(Set.of(foo, max), collect);
    }

    /**
     * Let's find all children who likes a toy that's not red
     */
    @Test
    void specNotRedToy() {
        Specification<Child> specNotRedToy = new ChildLikesSpecifiedToySpecification(new ToyColorSpecification("Red").not());
        Set<Child> collect = children.stream().filter(child -> specNotRedToy.isSatisfiedBy(child)).collect(Collectors.toSet());
        assertEquals(Set.of(bar, jenny), collect);
    }

    @Test
    void specRedToyAndFoo() {

        AbstractSpecification<Child> specFoo = new ChildNameSpecification("foo");
        Specification<Child> specRedToy = new ChildLikesSpecifiedToySpecification(new ToyColorSpecification("Red"));
        AbstractSpecification<Child> specRedToyAndFoo = specFoo.and(specRedToy);

        Set<Child> collect = children.stream().filter(child -> specRedToyAndFoo.isSatisfiedBy(child)).collect(Collectors.toSet());
        assertEquals(Set.of(bar), collect);
    }

    @Test
    void specSchoolChildren() {
        AbstractSpecification<Child> specSchool = new SchoolChildrenSpecification();

        Set<Child> collect = children.stream().filter(child -> specSchool.isSatisfiedBy(child)).collect(Collectors.toSet());
        assertEquals(Set.of(foo, bar, max), collect);
    }
}
