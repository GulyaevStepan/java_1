package ru.geekbrains.java_one;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    Map() {
        setBackground(Color.CYAN);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        /*
        * У этого решения есть один недостаток.
        * Все новые кнопки, при создании новой игры (2, 3, 4...),
        * накладываются поверх уже имеющихся. Несмотря на removeAll();
        * remove(map); в классе GameWindow эту проблему тоже не решает.*/
        removeAll();
        GridLayout gameMap = new GridLayout(fieldSizeX, fieldSizeX);
        setLayout(gameMap);
        for (int i = 0; i < (fieldSizeX * fieldSizeX); i++){
            add(new JButton("*" + i));
        }
        System.out.printf("mode: %d, size: %d, len: %d\n", gameMode, fieldSizeX, winLength);
        
        /*
        Чтобы AI мог ходить, думаю решение с массивом кнопок будет лучше.
        Иначе как AI будет ориентироваться на поле
        (м. б. смайлик с паровозом?)?
        Тут только одна трудность - как его добавить?

        removeAll();
        JButton[][] arr= new JButton[fieldSizeX][fieldSizeX];
        for (int i = 0; i < fieldSizeX; i++){
            for (int j = 0; j < fieldSizeX; j++) {
                arr[i][j] = (JButton) add(new JButton(i + "*" + j));
            }
        }*/
    }






}
