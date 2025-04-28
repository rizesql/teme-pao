package org.pao.ex1;

public class CounterOutTask implements Task {
    private static int count = 0;

    @Override
    public void run() {
        count++;
        System.out.println(count);
    }
}
