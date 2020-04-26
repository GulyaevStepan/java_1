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
        /*removeAll();
        JButton[][] arr= new JButton[fieldSizeX][fieldSizeX];
        for (int i = 0; i < fieldSizeX; i++){
            for (int j = 0; j < fieldSizeX; j++) {
                arr[i][j] = (JButton) add(new JButton(i + "*" + j));
            }
        }*/



        removeAll();

        GridLayout gameMap = new GridLayout(fieldSizeX, fieldSizeX);
        setLayout(gameMap);

        for (int i = 0; i < /*(fieldSizeX * fieldSizeX)*/5; i++){
            add(new JButton("*" + i));
        }

        System.out.printf("mode: %d, size: %d, len: %d\n", gameMode, fieldSizeX, winLength);

    }






}
