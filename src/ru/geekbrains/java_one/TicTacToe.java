package ru.geekbrains.java_one;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static boolean checkLines (int y, int x, char c) {
        for (int i = 0; i < dotsToWin; i++) {
            if (!isValidCell(y + i, x) || field[y + i][x] != c) {
                break;
            } else if (i == dotsToWin - 1) {
                return true;
            }
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (!isValidCell(y, x + i) || field[y][x + i] != c) {
                break;
            } else if (i == dotsToWin - 1) {
                return true;
            }
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (!isValidCell(y + i, x + i) || field[y + i][x + i] != c) {
                break;
            } else if (i == dotsToWin - 1) {
                return true;
            }
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (!isValidCell(y - i, x + i) || field[y - i][x + i] != c) {
                break;
            } else if (i == dotsToWin - 1) {
                return true;
            }
        }
        return false;
    }

    static boolean checkWin (char c) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (checkLines(i, j, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static char[][] field;
    private static int fieldSize;
    private static int dotsToWin;

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

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
        dotsToWin = 3;
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

    private static boolean checkSomePlayerWin(char dot) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isEmptyCell(i, j)) {
                    field[i][j] = dot;
                    if (checkWin(dot)) {
                        if (dot == HUMAN_DOT) {
                            field[i][j] = AI_DOT;
                        }
                        return true;
                    } else {
                        field[i][j] = EMPTY_DOT;
                    }
                }
            }
        }
        return false;
    }

    private static void aiTurn() {
        int x;
        int y;
        if (checkSomePlayerWin(AI_DOT)) {
            System.out.println("AI ");
        } else if (checkSomePlayerWin(HUMAN_DOT)) {
            System.out.println("AI заблокировал");
        } else {
            do {
                x = RANDOM.nextInt(fieldSize);
                y = RANDOM.nextInt(fieldSize);
            } while (!isEmptyCell(y, x));
            field[y][x] = AI_DOT;
        }
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

    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

}
