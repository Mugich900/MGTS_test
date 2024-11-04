package org.example.strategy;

import org.example.models.Person;

import java.util.List;

public class AddPerson implements DataStrategy {
    @Override
    public void strategy(List<Person> people) {
        people.add(new Person());
    }
}
