package ru.geekbrains.java_one;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int fieldSize;
    private static char[][] field;
    private static int dotsToWin;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    public static void main(String[] args) {
        while (true) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (gameChecks(HUMAN_DOT, "Human win!")) break;
                aiTurn();
                printMap();
                if (gameChecks(AI_DOT, "AI win!")) break;
            }
            System.out.println("Play again?");
            if (!SCANNER.next().equals("Y"))
                break;
        }
        SCANNER.close();

    }

    private static void initMap() {
        fieldSize = 3;
        field = new char[fieldSize][fieldSize];
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    private static void printMap() {
        System.out.println("  X1 2 3");
        for (int y = 0; y < fieldSize; y++) {
            if (y == 0) {
                System.out.print("Y" + (y+1) + "|");
            } else System.out.print(" "+(y+1) + "|");
            for (int x = 0; x < fieldSize; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты хода X и Y (от 1 до %d) через пробел: ", fieldSize);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(isEmptyCell(y, x) && isValidCell(y, x)));
        field[y][x] = HUMAN_DOT;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSize);
            y = RANDOM.nextInt(fieldSize);
        } while (!isEmptyCell(y, x));
        field[y][x] = AI_DOT;
    }

    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

    private static boolean gameChecks(char Dot, String s) {
        if (checkWin(Dot)) {
            System.out.println(s);
            return true;
        }
        if (isMapFull()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (isEmptyCell(y, x)) return false;
            }
        }
        return true;
    }

    /*
    * Вот то, что получилось на сегодняшний день.
    * Я старался, чтобы метод был применим к массивам любой длины, был универсальным.
    * По заданию 3 реализованы проверки горизонталей и вертикалей.
    * Диагонали я к сожалению не смог полностью проверить.
    *
    * Соответственно к проработке искуственного интелекта не приступал, но была такая идея:
    * Во время хода ИИ отправляет 2 запроса checWin(AI_DOT) и checWin(HUMAN_DOT),
    * но с условием победы dotsToWin = 2, а не 3.
    * Если на первый запрос возвращается true, то ИИ делает последний ход и выигрывает.
    * Если на 2 запрпос возвращается true, то ИИ блокирует победу игрока.
    * Самое трудное - найти координаты клетки в которую надо походить ИИ.
    *
    * */
    private static boolean checkWin (char c) {
        dotsToWin = 3;
        int i;
        int j;
        int k;
        int total = 0;

        for (int y = 0; y < fieldSize; y++) {
            for (int jIndex = 0; jIndex <= fieldSize - dotsToWin; jIndex++) {
                j = jIndex;
                while (true) {
                    if (total == dotsToWin) {
                        return true;
                    } else if (!(field[y][j] == c)) {
                        total = 0;
                        break;
                    } else {
                        j++;
                        total++;
                    }
                }
            }
        }

        for (int x = 0; x < fieldSize; x++) {
            for (int iIndex = 0; iIndex <= fieldSize - dotsToWin; iIndex++) {
                i = iIndex;
                while (true) {
                    if (total == dotsToWin) {
                        return true;
                    } else if (!(field[i][x] == c)) {
                        total = 0;
                        break;
                    } else {
                        i++;
                        total++;
                    }
                }
            }
        }

        for (int kIndex = 0; kIndex <= fieldSize - dotsToWin; kIndex++) {
            k = kIndex;
            while (true) {
                if (total == dotsToWin) {
                    return true;
                } else if (!(field[k][k] == c)) {
                    total = 0;
                    break;
                } else {
                    k++;
                    total++;
                }
            }
        }

        k = 0;
        while (true) {
            if (total == dotsToWin) {
                return true;
            } else if (!(field[k][field[k].length - 1 - k] == c)) {
                total = 0;
                break;
            } else {
                k++;
                total++;
            }
        }

        //if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        //if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

}
