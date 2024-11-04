package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean inWork = true;
        Scanner in = new Scanner(System.in);
        while (inWork){
            System.out.println("Выберите сценарий для выполнения\n" +
                    "1) Добавить контакт\n" +
                    "2) Посмотреть весь список контактов со всей информацией\n" +
                    "3) Посмотреть все номера пропусков\n" +
                    "4) Найти контакт по номеру пропуска\n" +
                    "5) Удалить контакт по идентификатору\n" +
                    "6) Сохранить\n" +
                    "q) Сохранить и закончить работу");

            //работа вариатора. Пока юзер не выберет вариант q - цикл будет продолжать работу
            inWork = ScenarioVariator.variator(in.next());
        }
    }
}