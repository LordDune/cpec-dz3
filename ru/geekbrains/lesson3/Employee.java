package ru.geekbrains.lesson3;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Random;

public abstract class Employee implements Comparable<Employee>, Iterator<String> {

    //region Public Methods

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
        //return calculateSalary() == o.calculateSalary() ? 0 :
        //        calculateSalary() > o.calculateSalary() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", birthday =" + birthday +
                '}';
    }

    @Override
    public boolean hasNext() {
        return index++ < 4;
    }

    @Override
    public String next() {
        switch (index) {
            case 1:
                //return firstName;
                return String.format("Имя: %s", name);
            case 2:
                //return lastName;
                return String.format("Фамилия: %s", surName);
            case 3:
                //return age;
                return String.format("Дата рождения: %s", birthday);
            default:
                //return salary;
                return String.format("Среднемесячная з/п: %.2f (руб.)", calculateSalary());

        }
    }

    //endregion

    //region Constructors And Initializers

    {
        //System.out.println("Initialize - Employee");
        id = ++counter;
    }

    private Employee(){
        this("#Surnane#", "#Name#");
    }

    private Employee(String surName, String name){
        this(surName, name, 500);
    }

    protected Employee(String surName, String name, double salary){
        //System.out.println("Constructor - Employee");
        if (salary < 500){
            throw new RuntimeException("Ставка заработной платы должна быть не менее 500");
        }
        this.surName = surName;
        this.name = name;
        this.salary = salary;
        this.birthday = RandomDate.set();
    }

    //endregion

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setSalary(double salary) {
        if (salary < 30000){
            throw new RuntimeException("Уровень заработной платы должен быть не менее 30000");
        }
        this.salary = salary;
    }

    public void setBirthday(String localdate) {
        birthday = LocalDate.parse(localdate);
    }

    //endregion

    //region Fields

    private int id;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    /**
     * дата рождения
     */
    protected LocalDate birthday;

    //endregion

    //region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
    protected static Random random = new Random();
    private static int counter = 1000;

    private static int index;

    //endregion

}
