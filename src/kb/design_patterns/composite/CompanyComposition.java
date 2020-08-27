package kb.design_patterns.composite;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Employee {
    void showDetails();
}

class Developer implements Employee {
    private String name;
    private String position;
    private double salary;

    public Developer(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: " + name + ", position: " + position + ", salary: " + salary);
    }
}

class Manager implements Employee {
    private String name;
    private String position;
    private double salary;

    public Manager(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: " + name + ", position: " + position + ", salary: " + salary);
    }
}

class Company implements Employee {
    private List<Employee> employees = new ArrayList<>();
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Company name: " + companyName);
        employees.forEach(Employee::showDetails);
    }
}

public class CompanyComposition {
    public static void main(String[] args) {
        Employee e1 = new Developer("A.S.", "developer", 7500.0);
        Employee e2 = new Developer("D.N.", "manager", 12500.0);

        Company c = new Company("The best company");
        c.add(e1);
        c.add(e2);
        c.showDetails();
    }
}
