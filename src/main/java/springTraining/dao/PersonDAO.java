package springTraining.dao;

import org.springframework.stereotype.Component;

import springTraining.models.Person;


import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 23, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 43, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 55, "mike@wijf.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 19, "katy@haka.com"));
    }


    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(personToBeUpdated.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
