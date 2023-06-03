package ru.gb.lesson_3.my_code;

public class SalaryEmploy extends BaseEmploy{
    private double salary;

    @Override
    public double countSalary() {
        return salary;
    }
    public SalaryEmploy(String name, int age) {
        super(name, age);
    }
    public SalaryEmploy(String name, int age, double salary) {
        super(name, age, salary, "Salary");
        this.salary = salary;
    }

    @Override
    public int compare(BaseEmploy o1, BaseEmploy o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }
}
