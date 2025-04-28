package org.pao.ex1;

public class OutTask implements Task {
    private final String message;

    public OutTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}
