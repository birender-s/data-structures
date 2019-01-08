package com.example.java_lib.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator Examples
 * Ref: https://www.baeldung.com/java-8-comparator-comparing
 */
public class ComparatorExamples {

    public static void main(String[] args) {

        class Employee {
            public String name;
            public int age;
            public double salary;
            public long mobile;

            public String getName() { return name;}
            public int getAge() {return age;}

            Employee(String name, int age, double salary, long mobile) {
                this.name = name;
                this.age = age;
                this.salary = salary;
                this.mobile = mobile;
            }

            @Override
            public String toString() {
                return "\nname: " + name + ", age: " + age + ", salary: " + salary + ", mobile: " + mobile;
            }
        }

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("aaaaaaa");
        list.add("B");

        Comparator<String> comparator = (String a, String b) -> {
            return a.compareTo(b);
        };

//        Collections.sort(list, comparator);
        Collections.sort(list, comparator.reversed());

        //System.out.println(list);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 23, 200000, 123));
        employees.add(new Employee("Ace", 28, 4000.0, 9922001));
        employees.add(new Employee("Bir", 23, 3000.0, 8922001));

        System.out.println("employees b4 comparators: " + employees);

        Comparator<Employee> compEmpName = Comparator.comparing(Employee::getName);
        employees.sort(compEmpName);

        System.out.println("\nemployees with Comparator.comparing(Employee::getName) " + employees);

        Comparator<Employee> compEmpAge = Comparator.comparing(Employee::getAge);
        employees.sort(compEmpAge);
        System.out.println("\nemployees with Comparator.comparing(Employee::getAge) " + employees);

        Comparator<Employee> compEmpAgeNname = Comparator.comparing(Employee::getAge).thenComparing(Employee::getName);
        employees.sort(compEmpAgeNname);
        System.out.println("\nemployees with Comparator.comparing(Employee::getAge).thenComparing(Employee::getName) " + employees);
    }

}
