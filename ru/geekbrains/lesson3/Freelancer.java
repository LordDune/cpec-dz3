package ru.geekbrains.lesson3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee{

    private Freelancer(String surName, String name, double salary){
        super(surName, name, salary);
    }

    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(500, 2000));
    }

    public static List<Employee> getEmployees(int count, List<Employee> employees){
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return  20.8 * 8 * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s: фрилансер; дата рождения: %s; почасовая ставка: %.2f (руб.), среднемесячная з/п: %.2f (руб.)",
                surName, name, birthday, salary, calculateSalary());
    }
}