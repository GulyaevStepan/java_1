package ru.geekbrains.java_one;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            FileOutputStream fileOut1 = new FileOutputStream("file1.txt");
            PrintStream psFile1 = new PrintStream(fileOut1);
            for (int i = 0; i < 2; i++) {
                psFile1.println("Hello world!");
                psFile1.println("I love world.");
            }
            FileOutputStream fileOut2 = new FileOutputStream("file2.txt");
            PrintStream psFile2 = new PrintStream(fileOut2);
            for (int i = 0; i < 2; i++) {
                psFile2.println("Hello Java!");
                psFile2.println("I love Java.");
            }
            fileOut1.close();
            fileOut2.close();
            psFile1.close();
            psFile2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /*
    * Метод прост: в конец одного файла прибавляется текст другого.
    * */
    public static void addText (String addText, String sumText) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(sumText, true);
        PrintStream psFile = new PrintStream(fileOut);

        FileInputStream fileIn = new FileInputStream (addText);
        Scanner scFile = new Scanner(fileIn);

        while (scFile.hasNext()) {
            psFile.println(scFile.nextLine());
        }

        fileIn.close();
        fileOut.close();
        scFile.close();
        psFile.close();
    }

    /*
    * Я назвал его "поисковик слов". Технически он может найти и словосочетания,
    * но в пределах одной строки.
    * За основу я взял уже готовый метод .findInLine(string).
    * */
    public static boolean findWord (String text, String word) throws IOException {
        FileInputStream findWordFileIn = new FileInputStream(text);
        Scanner scFindWordFile = new Scanner(findWordFileIn);

        while (scFindWordFile.hasNext()) {
            if (scFindWordFile.findInLine(word) != null) {
                findWordFileIn.close();
                scFindWordFile.close();
                return true;
            }

            if (scFindWordFile.hasNextLine()){
                scFindWordFile.nextLine();
            }

        }
        findWordFileIn.close();
        scFindWordFile.close();
        return false;
    }

    /*
    * Гвоздь программы - неработающий метод, который должен был заменить "поисковик слов".
    * Идея была такая: сканировать текст по словам и сравнивать с оригиналом.
    * Оригинал, естественно тоже надо отсканировать по словам, этого-то у меня и не удалось.
    * В перспективе здесь будет ещё одна проблема, которую придётся решать.
    * Это сквозная проверка. Пример. Я ищу "дом сад дом самолёт"
    * в тексте "дом сад дом сад дом самолёт", вернёт ложь.
    * */
    public static boolean findText (String text, String pattern) throws IOException {
        FileInputStream findTextFileIn = new FileInputStream(text);
        Scanner scFindTextFile = new Scanner(findTextFileIn);
        //FileInputStream patternFileIn = new FileInputStream(pattern);
        Scanner scPatternFile = new Scanner(pattern);

        int wordCount = 0;
        while (scPatternFile.hasNext()){
            scPatternFile.next();
            wordCount++;
        }
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = scPatternFile.next();
        }

        while (scFindTextFile.hasNext()) {

            if (scFindTextFile.hasNext(words[0])) {
                for (int i = 0; i < wordCount; i++) {
                    if (scFindTextFile.hasNext(words[i])) {
                        scFindTextFile.next();
                        if (scFindTextFile.hasNextLine()){
                            scFindTextFile.nextLine();
                        }
                    } else {
                        break;
                    }
                }
                findTextFileIn.close();
                //patternFileIn.close();
                scFindTextFile.close();
                scPatternFile.close();
                return true;
            }


            scFindTextFile.next();
            if (scFindTextFile.hasNextLine()){
                scFindTextFile.nextLine();
            }
        }

        findTextFileIn.close();
        //patternFileIn.close();
        scFindTextFile.close();
        scPatternFile.close();
        return false;
    }

}
