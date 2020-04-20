package ru.geekbrains.java_one;

public class Cat extends Animal {


    int maxRun;
    final int MAX_RUN_NORM = 200;
    double maxJump;
    final double MAX_JUMP_NORM = 2;
    int error = 10;

    Cat () {
        int maxRun = MAX_RUN_NORM - MAX_RUN_NORM/error + Main.RANDOM.nextInt(MAX_RUN_NORM/(error/2));
        double maxJump = MAX_JUMP_NORM - MAX_JUMP_NORM/error + Main.RANDOM.nextDouble()*MAX_JUMP_NORM/(error/2);
    }

    @Override
    boolean run(double a) {
        return (maxRun >= a);
    }

    @Override
    boolean jump(double a) {
        return (maxJump >= a);
    }


}
