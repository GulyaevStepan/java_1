package ru.geekbrains.java_one;

public class Staffer {
    private String name;
    private final int YEAR = 2020;
    private int birthYear;
    private int salary;
    private int id;

    // Несколько буферных переменных, но потонциально полезные и для других целей.
    // Можно также использовать, чтобы узнать число сотрудников в компании.
    private static int freeId = 1;
    // Суммарные расходы компании на зарплаты в чистом виде.
    private static long sumSalary = 0L;
    private static int sumAge = 0;

    public Staffer (String name, int birthYear, int salary) {
        this.name = name;
        this.birthYear = birthYear;
        this.salary = salary;
        id = freeId;
        freeId++;
        this.sumSalary += salary;
        this.sumAge += getAge();
    }

    public String getName () {
        return name;
    }

    public int getAge () {
        return YEAR-birthYear;
    }

    public int getSalary () {
        return salary;
    }

    public int getId () {
        return id;
    }

    /*Самое интересное - 6, 7 задание.
    * 6 задание я выполнил двумя способами.
    * В первом случае метод посчитает средний возраст/зарплату всех сотрудников.
    * Это главное преимущество этого решения. Большая компания разделена на отделы.
    * У каждого скорее всего свой массив сотрудников, а нужна статистика всего предприятия.
    * Второе решение наоборот - может посчитать один массив (отдел), но вся компания ему будет не под силу.
    * В итоге я решил, что здесь уместна перегрузка методов.*/
    public static int getArithmeticSalary () {
        if (freeId == 1) {
            return 0;
        } else {
            return (int) (sumSalary / (freeId - 1));
        }
    }

    public static int getArithmeticSalary (Staffer[] arr) {
        Long sum = 0L;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getSalary();
        }
        return (int) (sum / arr.length);
    }

    public static int getArithmeticAge () {
        if (freeId == 1) {
            return 0;
        } else {
            return sumAge / (freeId - 1);
        }
    }

    public static int getArithmeticAge (Staffer[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getAge();
        }
        return sum / arr.length;
    }

    /*С повышением зарплат неного трудней.
    * Тут в общем та же история. Тоже хотелось бы иметь 2 метода,
    * где один будет повышать зарплату какому-то подразделению или вообще отдельному работнику,
    * а второй сам прошерстит всех когда-либо (как-либо) нанятых,
    * но до сих пор не уволеных сотрудников и повысил кому надо зарплату.
    * Только я не смог придумать, как класс будет внутри себя хранить подобные данные.
    * Массив с ссылками на экземпляры внутри класса? масло маслянное получается. */
    public static void upSalary (Staffer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() >= 45) {
                arr[i].salary += 5000;
            }
        }
    }

}
