package org.example;

import org.example.models.Person;
import org.example.strategy.*;

import java.util.ArrayList;
import java.util.List;

//данный класс является вариатор сценариев. Внешне напоминает патерн фабрики.
public class ScenarioVariator {
    private static List<Person> people = new ArrayList<>();
    private static Boolean isLoaded = false;
    private static DataManager manager = new DataManager();
    public static boolean variator(String scenario){
        if(!isLoaded){
            people = manager.loadData(); // загрузка данных, если программа работает впервый раз
            isLoaded = true;
        }
        //Сценарии выполняющиеся при соответствующем выборе
        switch (scenario){
            case "1" -> {
                manager = new DataManager(new AddPerson()); //добавление пользователя
                manager.doStrategy(people);
                return true;
            }
            case "2" -> {
                manager = new DataManager(new GetPersons()); //получение всех пользователей
                manager.doStrategy(people);
                return true;
            }
            case "3" -> {
                manager = new DataManager(new GetPersonPassNumber());//получить все номера пропусков пользователей
                manager.doStrategy(people);
                return true;
            }
            case "4" -> {
                manager = new DataManager(new SearchPersonByPass());//получить пользователя по номеру пропуска
                manager.doStrategy(people);
                return true;
            }
            case "5" -> {
                manager = new DataManager(new RemovePerson());//удалить пользователя по идентификатору (НЕ НОМЕР ПРОПУСКА)
                manager.doStrategy(people);
                return true;
            }
            case "6" -> {
                manager.saveData(people); // Сохранить всех пользователей без завершения работы программы
                return true;
            }
            case "q" -> {
                manager.saveData(people);// Сохранить всех пользователей с завершения работы программы
                return false;
            }
            default -> {
                //вариант работы при введении не существующего варианта
                System.out.println("Функции с таким обозначением не существует!\n");
                return true;
            }
        }
    }
}
