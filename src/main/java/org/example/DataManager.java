package org.example;

import org.example.models.Person;
import org.example.strategy.DataStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Класс для работы с данными
public class DataManager {

    private DataStrategy strategy;

    public DataManager(){};
    //Птерн стратегия. Благодря этому патерну определяется поведение функции doStrategy. Выполняет большую часть функций
    public DataManager(DataStrategy strategy){
        this.strategy = strategy;
    }
    public void doStrategy(List<Person> people){
        if(this.strategy != null)
            strategy.strategy(people);
        else
            System.out.println("Стратегия не выбрана!\n");
    }
    //Загрузка данных из файла data.txt
    public List<Person> loadData(){
        List<Person> people = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))){
            String line = bufferedReader.readLine();
            while (line!=null){
                people.add(new Person(line.split(" ")[0], line.split(" ")[1], line.split(" ")[2]));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтение файла: " + e.getMessage()+"\n");
        }
        return people;
    }
//Сохранение данных в файл data.txt
    public void saveData(List<Person> people){
        try(FileWriter fileWriter = new FileWriter("data.txt")) {
            for (Person p : people){
                fileWriter.write(p.toString());
                fileWriter.append("\n");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage()+"\n");
        }
    }
}
