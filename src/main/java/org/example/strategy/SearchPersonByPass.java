package org.example.strategy;

import org.example.models.Person;
import org.example.strategy.DataStrategy;

import java.util.List;
import java.util.Scanner;

public class SearchPersonByPass implements DataStrategy {
    @Override
    public void strategy(List<Person> people) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер пропуска");
        String passNumber = in.next();
        for (Person p : people) {
            if (p.getPassNumber().equals(passNumber))
                System.out.println(people.indexOf(p) + " " + p.toString());
        }
    }
}
