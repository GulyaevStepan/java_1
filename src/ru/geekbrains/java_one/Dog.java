package ru.geekbrains.java_one;



public class Dog extends Animal {
    int maxRun;
    final int MAX_RUN_NORM = 500;
    double maxJump;
    final double MAX_JUMP_NORM = 0.5;
    double maxSwim;
    final double MAX_SWIM_NORM = 10;
    int error = 10;

    Dog () {
        int maxRun = MAX_RUN_NORM - MAX_RUN_NORM/error + Main.RANDOM.nextInt(MAX_RUN_NORM/(error/2));
        double maxJump = MAX_JUMP_NORM - MAX_JUMP_NORM/error + Main.RANDOM.nextDouble()*MAX_JUMP_NORM/(error/2);
        double maxSwim = MAX_SWIM_NORM - MAX_SWIM_NORM/error + Main.RANDOM.nextDouble()*MAX_SWIM_NORM/(error/2);
    }

    @Override
    boolean run(double a) {
        return (maxRun >= a);
    }

    @Override
    boolean jump(double a) {
        return (maxJump >= a);
    }

    boolean swim(double a) {
        return (maxSwim >= a);
    }
}
