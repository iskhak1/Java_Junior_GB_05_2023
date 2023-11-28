package ru.gb.streamXlamd;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework {

    /**
     * 0.1. Посмотреть разные статьи на Хабр.ру про Stream API
     * 0.2. Посмотреть видеоролики на YouTube.com Тагира Валеева про Stream API
     *
     * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
     * 1.1 Найти максимальное
     * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
     * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
     *
     * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
     * 2.1 Создать список из 10-20 сотрудников
     * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
     * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
     * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
     * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
     */
    public static void main(String[] args) {
        System.out.println("hello");
       // ex1
        List<Integer> numbers = Stream
                .generate(() -> ThreadLocalRandom.current().nextInt(10))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(numbers);
       // ex2
        System.out.println(numbers.stream().max(Integer::compareTo).get());
       // ex3 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        System.out.println(numbers.stream().filter(value -> value > 5).map(value -> ((value * 5) - 1)).collect(Collectors.summarizingInt(value -> value++)).getSum());
      // ex4      * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        System.out.println(numbers.stream().map(value -> (value * value) > 100).collect(Collectors.counting()));
/*
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников

 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%

 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела

 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела

 */
        List<Employee> employees = generateList();

//         * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        employees.stream().map(employee -> employee.getDeparment()).distinct().forEach(System.out::println);

//         * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        employees.stream().filter(employee -> employee.getSalary()<10_000).forEach(employee -> employee.setSalary(employee.getSalary()*1.2));


        //Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String , List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getDeparment));
        map.entrySet().stream().forEach(System.out::println);

        // * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> map1 = employees.stream().collect(Collectors.groupingBy(Employee::getDeparment, Collectors.averagingDouble(Employee::getSalary)));
        map1.entrySet().stream().forEach(System.out::println);

    }

    public static List generateList(){
        return List.of(
                new Employee("IT","Ivan",24,4740),
                new Employee("IT","Sasha",32,303301),
                new Employee("IT","Peter",29,57779),
                new Employee("IT","David",19,364678),
                new Employee("IT","Iskhak",22,196714),
                new Employee("IT","Bob",42,81240),
                new Employee("IT","Elon",41,540216),
                new Employee("IT","Gary",35,345793),
                new Employee("IT","Ivan",24,330603),
                new Employee("IT","Igor",55,442936),
                new Employee("Marketing","Lacy",24,2736),
                new Employee("Marketing","Theódóra",24,90081),
                new Employee("Marketing","Béla",24,144278),
                new Employee("Marketing","Cristian",24,4204),
                new Employee("Marketing","Danna",24,381024),
                new Employee("Finance","Karla",40,508950),
                new Employee("Finance","Adlai",21,54692),
                new Employee("Finance","Katina",40,190248),
                new Employee("Finance","Valery",61,352013),
                new Employee("Finance","Valery",59,389961),
                new Employee("Finance","Prasad",23,478060),
                new Employee("Finance","Annemarie",54,198175)
        );

    }
}
