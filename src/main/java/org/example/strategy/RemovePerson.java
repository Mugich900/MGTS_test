package org.example.strategy;

import org.example.models.Person;

import java.util.List;
import java.util.Scanner;

public class RemovePerson implements DataStrategy {
    @Override
    public void strategy(List<Person> people) {
        if(people.size() != 0){
            Scanner in = new Scanner(System.in);
            System.out.println("Введите идентификатор контакта");
            String id = in.next();
            try {
                people.remove(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                System.out.println("Введен не коректный идентификатор контакта\n");
            }
        }
        else
            System.out.println("Нет ни одного контакта\n");

    }
}
