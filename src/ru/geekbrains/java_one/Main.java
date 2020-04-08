package ru.geekbrains.java_one;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int [] array2 = new int [8];
        int [] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int [] array4 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int [][] array5 = new int[5][5];
        int [] array6 = {10, 1, 2, 3, 4};
        int [] array7 = {0, 1, 2, 3, 4};
        int [] array8 = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(Arrays.toString(task1(array1)));
        System.out.println(Arrays.toString(task2(array2)));
        System.out.println(Arrays.toString(task3(array3)));
        System.out.println("min "+ taskMin4(array4) + " max " + taskMax4(array4));
        for (int i = 0; i < array5.length; i++) {
            System.out.println(Arrays.toString(task5(array5)[i]));
        }
        System.out.println(task6(array6));
        System.out.println(Arrays.toString(task7(array7,8)));
        System.out.println(Arrays.toString(task8(array8,-2)));

    }

    public static int[] task1 (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] == 0) {
                arr [i] = 1;
            } else {
                arr [i] = 0;
            }
        }
        return arr;
    }

    public static int [] task2 (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr [i] = i*3+1;
        }
        return arr;
    }

    public static int [] task3 (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] < 6) {
                arr [i] = arr [i] * 2;
            }
        }
        return arr;
    }

    public static int taskMin4 (int [] arr) {
        int min = arr [0];
        for (int i = 1; i < arr.length; i++) {
            if (arr [i] < min) {
                min = arr [i];
            }
        }
        return min;
    }

    public static int taskMax4 (int [] arr) {
        int max = arr [0];
        for (int i = 1; i < arr.length; i++) {
            if (arr [i] > max) {
                max = arr [i];
            }
        }
        return max;
    }

    public static int [][] task5 (int [][] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[j].length; i++) {
                if (i == j || i + j == arr.length-1) {
                    arr [j][i] = 1;
                }
            }
        }
        return arr;
    }

    public static boolean task6 (int [] arr) {
        double sumHalf = 0;
        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            sumHalf += arr[i] / 2.0;
        }
        //sumHalf /= 2;
        for (int i = 0; sumLeft < sumHalf; i++) {
            sumLeft += arr[i];
        }
        /*int j = 0;
        while (sumLeft < sumHalf) {
            sumLeft += arr[j++];
        }*/
        return sumLeft == sumHalf;
    }

    public static int [] task7 (int [] arr, int n) {
        int [] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (i + n >= arr.length || i + n < 0) {
                if (i + n >= arr.length) {
                    n -= arr.length;
                } else if (i + n < 0) {
                    n += arr.length;
                }
            }
            array[i+n] = arr[i];
        }
        return array;
    }

    /*8 задание решено не полностью.
    Метод можно обмануть, если длинна массива кратна числу n.
    Или Вообще выйти аварийно, если n больше длины массива.*/
    public static int [] task8 (int [] arr, int n) {
        int a = 0;
        if (n == 0) return arr;
        if (n > 0) {
            a = arr [arr.length-n];
        } else if (n < 0) {
            a = arr [-n];
        }
        int b = arr [0];
        int index = 0;
        int i = 0;

        do {
            i += n;
            while (i >= arr.length || i < 0) {
                if (i >= arr.length) {
                    i -= arr.length;
                } else if (i < 0) {
                    i += arr.length;
                }
            }

            arr [index] = a;
            a = b;
            b = arr[i];

            index += n;
            while (index >= arr.length || index < 0) {
                if (index >= arr.length) {
                    index -= arr.length;
                } else if (index < 0) {
                    index += arr.length;
                }
            }
            if (i == 0) break;
        } while (true);

        /*Это как раз тот пример, когда длинна массива кратна числу n.
        Самый частый случай - длина и n чётные. Однако все варианты не перечислить.
        Наверняка есть способ обойти эту уязвимость, но я его не нашёл.*/
        if (n % 2 == 0 && arr.length % 2 == 0) {
            if (n > 0) {
                a = arr [arr.length-n+1];
            } else if (n < 0) {
                a = arr [-n+1];
            }
            b = arr [1];
            index = 1;
            i = 1;
            do {
                i += n;
                while (i >= arr.length || i < 0) {
                    if (i >= arr.length) {
                        i -= arr.length;
                    } else if (i < 0) {
                        i += arr.length;
                    }
                }

                arr [index] = a;
                a = b;
                b = arr[i];

                index += n;
                while (index >= arr.length || index < 0) {
                    if (index >= arr.length) {
                        index -= arr.length;
                    } else if (index < 0) {
                        index += arr.length;
                    }
                }
                if (i == 1) break;
            } while (true);
        }

        return arr;
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
