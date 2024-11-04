import org.example.DataManager;
import org.example.Main;
import org.example.models.Person;
import org.example.strategy.*;
import org.junit.Assert;
import org.junit.Test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    private Person p = new Person("wdqwqr", "wqeqwe", "00F1C313");
    private List<Person> people = new ArrayList<>();

    @Test
    public void addPerson() throws IOException {
        ByteArrayInputStream testIn = new ByteArrayInputStream("eqwewqewqe\nwqewqewqeqe\n00F1C313".getBytes());
        System.setIn(testIn);
        new DataManager(new AddPerson()).doStrategy(people);
        Assert.assertEquals(1, people.size());
    }
    @Test
    public void GetPersons(){
        people.add(p);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outStream);
        System.setOut(myStream);
        new DataManager(new GetPersons()).doStrategy(people);
        Assert.assertEquals(outStream.toString().trim(), people.indexOf(p) + " " + p.toString());
    }
    @Test
    public void GetPersonPassNumber(){
        people.add(p);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outStream);
        System.setOut(myStream);
        new DataManager(new GetPersonPassNumber()).doStrategy(people);
        Assert.assertEquals(outStream.toString().trim(), "0 00F1C313");
    }
    @Test
    public void SearchPersonByPass(){
        people.add(p);
        ByteArrayInputStream testIn = new ByteArrayInputStream("00F1C313".getBytes());
        System.setIn(testIn);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outStream);
        System.setOut(myStream);
        new DataManager(new SearchPersonByPass()).doStrategy(people);
        Assert.assertEquals(outStream.toString().split("\n")[1].trim(), people.indexOf(p) + " " + p.toString());
    }
    @Test
    public void RemovePerson(){
        people.add(p);
        ByteArrayInputStream testIn = new ByteArrayInputStream("0".getBytes());
        System.setIn(testIn);
        new DataManager(new RemovePerson()).doStrategy(people);
        Assert.assertEquals(0, people.size());
    }
    @Test
    public void Save() throws IOException {
        people.add(p);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
        new DataManager().saveData(people);
        Assert.assertEquals("wdqwqr wqeqwe 00F1C313",bufferedReader.readLine());
    }
}
