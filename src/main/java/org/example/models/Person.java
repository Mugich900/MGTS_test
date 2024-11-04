package org.example.models;

import java.util.Scanner;

public class Person {
    private Scanner in = new Scanner(System.in);
    private String name;
    private String surname;
    private String passNumber;

    //Создание объекта Person по известным параметрам (используется при загрузке данных)
    public Person(String name, String surname, String passNumber) {
        this.name = name;
        this.surname = surname;
        this.passNumber = passNumber;
    }

    //Создание объекта пользователя по данны, которые вводит юзер
    public Person(){
        System.out.println("Введите имя");
        this.name = in.next();
        System.out.println("Введите фамилию");
        this.surname = in.next();
        setPassNumber();
    }

    public void setPassNumber(){
        System.out.println("Введите номер пропуска");
        String passNumber = in.next();
        if(passNumber.matches("[0-9A-F]*") && passNumber.length() == 8)
            this.passNumber = passNumber;
        else{
            System.out.println("Некоректный формат пропуска");
            setPassNumber();
        }
    }

    public String getPassNumber(){
        return this.passNumber;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.passNumber;
    }
}
