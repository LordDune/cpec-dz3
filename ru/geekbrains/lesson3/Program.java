package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Freelancer.getEmployees(2, employees);
        Worker.getEmployees(2,employees);

        System.out.println("Сортировка по имени");
        employees.sort(new EmployeeNameComparator());
        for (Employee employee: employees) {
            System.out.println(employee);
        }
        System.out.println();
        System.out.println("Сортировка по дате рождения");
        employees.sort(new EmployeeBirthdayComparator());
        for (Employee employee: employees) {
            System.out.println(employee);
        }
        System.out.println();
        System.out.println("Стандартная сортировка - по зарплате");
        Collections.sort(employees);
        for (Employee employee: employees) {
            System.out.println(employee);
        }
        System.out.println();

        System.out.println("Вывод данных о сотруднике с помощью интерфейса Iterator");
        Employee employee = employees.get(0);
        Iterator<String> components = employee;

        while (components.hasNext()) {
            System.out.println(employee.next());
        }

    }

}
