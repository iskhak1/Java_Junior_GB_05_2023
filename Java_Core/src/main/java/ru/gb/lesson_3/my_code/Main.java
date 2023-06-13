package ru.gb.lesson_3.my_code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main implements Comparator<BaseEmploy> {


    public static void main(String[] args) {
        BaseEmploy[] baseEmploys = {
                new HourlyRateEmploy("John",24,200),
                new HourlyRateEmploy("Petr",27,300),
                new HourlyRateEmploy("Ivan",60,500),
                new HourlyRateEmploy("Julia",16,100),
                new HourlyRateEmploy("Helena",44,900),
                new SalaryEmploy("Tony",32,43860),
                new SalaryEmploy("Hary",22,60860),
                new SalaryEmploy("Peter",26,72860),
                new SalaryEmploy("Angel",82,118600),
                new SalaryEmploy("Alex",41,93860),
        };

        for (BaseEmploy e: baseEmploys) {
            System.out.println(e.toString());
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("SORTED");
        System.out.println("-------------------------------------------------------------------------------");
        List<BaseEmploy> baseEmployArrayList = Arrays.asList(baseEmploys);
        baseEmployArrayList.sort(new BaseEmploy() {
            @Override
            public double countSalary() {
                return 0;
            }

            @Override
            public int compare(BaseEmploy o1, BaseEmploy o2) {
                return (int) (o1.getSalary()-o2.getSalary());
            }
        });
        for (BaseEmploy em : baseEmployArrayList)  {
            System.out.println(em);
        }

    }

    @Override
    public int compare(BaseEmploy o1, BaseEmploy o2) {
        return (int) (o1.getSalary()-o2.getSalary());
    }
}
