package org.example.strategy;

import org.example.models.Person;

import java.util.List;

public class GetPersonPassNumber implements DataStrategy {
    @Override
    public void strategy(List<Person> people) {
        for (Person p : people)
            System.out.println(people.indexOf(p) + " " + p.getPassNumber());
    }
}
