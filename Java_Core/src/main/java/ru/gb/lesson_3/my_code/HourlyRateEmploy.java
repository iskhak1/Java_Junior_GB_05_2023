package ru.gb.lesson_3.my_code;

public class HourlyRateEmploy extends BaseEmploy{

    private double coefficient = (20.8 * 8);

    public HourlyRateEmploy(String name, int age) {
        super(name, age);
    }

    @Override
    public double countSalary() {
        return getSalary()*coefficient;
    }

    public HourlyRateEmploy(String name, int age, double hourly_rate_salary) {
        super(name, age, hourly_rate_salary, "Hourly_rate");

    }

    @Override
    public String toString() {
        return String.format("name %s age %d salary %,.2f ",getName(),getAge(),countSalary());

    }
    @Override
    public int compare(BaseEmploy o1, BaseEmploy o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }
}
