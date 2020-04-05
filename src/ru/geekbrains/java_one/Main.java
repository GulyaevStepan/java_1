package ru.geekbrains.java_one;

public class Main {

    public static void main(String[] args) {
        System.out.println(thirdTask(-10));
        System.out.println(fourthTask("Стёпа"));
        System.out.println(fifthTask(2020));
    }

    public static double firstTask (int a, int b, int c, int d) {
        return a * (b + ((double)c / d));
    }
    /*
    Альтернативный способ решения первого задания
    public static double firstTask (int a, int b, double c, int d) {
        return a * (b + (c / d));
    }*/

    public static boolean secondTask (int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static String thirdTask (int a) {
        if (a % 2 == 0) {
            return "чётное";
        } else {
            return "нечётное";
        }
    }

    public static String fourthTask (String name) {
        return "Привет, " + name + "!";
    }

    public static String fifthTask (int a) {
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            return "високосный";
        } else {
            return "невисокосный";
        }
    }

}
