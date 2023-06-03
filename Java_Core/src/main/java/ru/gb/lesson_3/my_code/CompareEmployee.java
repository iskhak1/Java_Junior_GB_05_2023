package ru.gb.lesson_3.my_code;

import java.util.Comparator;

public class CompareEmployee implements Comparator<BaseEmploy> {


    @Override
    public int compare(BaseEmploy o1, BaseEmploy o2) {
        return (int) (o1.getSalary() -o2.getSalary());
    }
}
