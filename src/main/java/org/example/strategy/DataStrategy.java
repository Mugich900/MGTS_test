package org.example.strategy;

import org.example.models.Person;

import java.util.List;

public interface DataStrategy {
    void strategy(List<Person> people);
}
