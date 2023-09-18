package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee{

    private Worker(String surName, String name, double salary){
        super(surName, name, salary);
        //System.out.println("Constructor - Worker");
    }

    public static Employee getInstance(){
        return new Worker(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(30000, 250000));
    }

    public static List<Employee> getEmployees(int count, List<Employee> employees){
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s: рабочий; дата рождения: %s; среднемесячная з/п (фиксированная месячная оплата): %.2f (руб.), ",
                surName, name, birthday, calculateSalary());
    }
}
