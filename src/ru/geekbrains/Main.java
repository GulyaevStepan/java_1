package ru.geekbrains.java_one;

public class Main {

    public static void main(String[] args) {
        Staffer[] corporation = {
                new Staffer("Анна", 1993, 90000),
                new Staffer("Иван", 1992, 60000),
                new Staffer("Пётр", 1976, 80000),
                new Staffer("Екатерина", 1975, 150000),
                new Staffer("Степан", 1994, 70000)
        };

        System.out.println(corporation[0].getName() + " " + corporation[0].getAge());

        for (int i = 0; i < corporation.length; i++) {
            if (corporation[i].getAge() >= 40) {
                System.out.println(corporation[i].getId() + " " + corporation[i].getName() + " " + corporation[i].getAge() + " " + corporation[i].getSalary());
            }
        }
        System.out.println(Staffer.getArithmeticAge());
        System.out.println(Staffer.getArithmeticSalary());
        Staffer.upSalary(corporation);
        for (int i = 0; i < corporation.length; i++) {
            System.out.println(corporation[i].getId() + " " + corporation[i].getName() + " " + corporation[i].getAge() + " " + corporation[i].getSalary());
        }
    }


}
