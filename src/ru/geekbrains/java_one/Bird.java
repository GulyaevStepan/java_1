package ru.geekbrains.java_one;

public class Bird extends Animal {

    double maxRun;
    final double MAX_RUN_NORM = 5;
    double maxJump;
    final double MAX_JUMP_NORM = 0.2;
    int error = 10;

    Bird () {
        double maxRun = MAX_RUN_NORM - MAX_RUN_NORM/error + Main.RANDOM.nextDouble()*MAX_RUN_NORM/(error/2);
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
