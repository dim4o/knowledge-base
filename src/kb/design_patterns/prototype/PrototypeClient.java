package kb.design_patterns.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

abstract class Person {
    protected String name;
    protected Double salary;

    protected Person(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", name, salary, getPosition());
    }

    protected abstract Person clone();

    protected abstract String getPosition();
}

class Developer extends Person {

    protected Developer(String name, Double salary) {
        super(name, salary);
    }

    /**
     * Produces a deep copy of the object.
     */
    @Override
    public Person clone() {
        return new Developer(name, salary);
    }

    @Override
    protected String getPosition() {
        return "DEV";
    }
}

class Manager extends Person {

    protected Manager(String name, Double salary) {
        super(name, salary);
    }

    /**
     * Produces a deep copy of the object.
     */
    @Override
    public Person clone() {
        return new Manager(name, salary);
    }

    @Override
    protected String getPosition() {
        return "MNG";
    }
}

class PrototypeRegistryFactory {
    private static final Map<Long, Person> employeesPrototype = new HashMap<>();

    public static void loadData() {
        // simulating some expensive loading from DB or remote resource:
        employeesPrototype.put(1l, new Manager("D.N", 10500.0d));
        employeesPrototype.put(2l, new Developer("N.S", 7500.0d));
        employeesPrototype.put(3l, new Manager("B.N", 17500.0d));
        employeesPrototype.put(4l, new Developer("U.N", 10000.0d));
    }

    /**
     * @return a Map with all prototypes.
     */
    public static Map<Long, Person> getAll() {
        return employeesPrototype.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone()));
    }

    /**
     * Static Factory Method
     * 
     * @return a prototype of a person
     */
    public static Person getPrototype(Long registryKey) {
        try {
            return employeesPrototype.get(registryKey).clone();
        } catch (NullPointerException e) {
            return null;
        }
    }
}

public class PrototypeClient {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        PrototypeRegistryFactory.loadData();

        Person p1 = PrototypeRegistryFactory.getPrototype(1l);
        Person p2 = PrototypeRegistryFactory.getPrototype(2l);
        Person p3 = PrototypeRegistryFactory.getPrototype(3l);
        Person p4 = PrototypeRegistryFactory.getPrototype(4l);
        Person p5 = PrototypeRegistryFactory.getPrototype(12l);

        Map<Long, Person> all = PrototypeRegistryFactory.getAll();
        all.get(1l).setSalary(20_000.0d);

        System.out.println(PrototypeRegistryFactory.getAll());
        System.out.println(all);

        // {1=(D.N, 10500.0, MNG), 2=(N.S, 7500.0, DEV), 3=(B.N, 17500.0, MNG), 4=(U.N, 10000.0, DEV)}
        // {1=(D.N, 20000.0, MNG), 2=(N.S, 7500.0, DEV), 3=(B.N, 17500.0, MNG), 4=(U.N, 10000.0, DEV)}
    }

}
