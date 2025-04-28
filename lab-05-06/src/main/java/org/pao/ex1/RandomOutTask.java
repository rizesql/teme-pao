package org.pao.ex1;

import java.util.Random;

public class RandomOutTask implements Task {
    private final int num;

    public RandomOutTask(Random gen) {
        this.num = gen.nextInt();
    }

    @Override
    public void run() {
        System.out.println(num);
    }
}
