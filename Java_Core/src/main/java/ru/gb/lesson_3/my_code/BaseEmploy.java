package ru.gb.lesson_3.my_code;

import java.util.Comparator;

public abstract class BaseEmploy implements Comparator<BaseEmploy> {

 private String name;
 private int age;
 private double salary;
 private String type_of_contract;
     public BaseEmploy(){

     }
    public BaseEmploy(String name, int age){
        this(name,age,27500,"Salary");
    }
    public BaseEmploy(String name, int age, double salary, String type_of_contract) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.type_of_contract = type_of_contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getType_of_contract() {
        return type_of_contract;
    }

    public void setType_of_contract(String type_of_contract) {
        this.type_of_contract = type_of_contract;
    }

    public abstract double countSalary();

    @Override
    public String toString() {
        return String.format("name %s age %d salary %,.2f",name,age,salary);

    }
}
