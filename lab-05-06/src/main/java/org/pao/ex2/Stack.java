package org.pao.ex2;

import org.pao.ex1.Task;

public class Stack implements Container {
    private final Task[] buf;
    private int idx = 0;

    public Stack(int size) {
        this.buf = new Task[size];
    }

    @Override
    public boolean empty() {
        return idx == 0;
    }

    @Override
    public void add(Task task) {
        if (idx >= buf.length) {
            System.out.println("Capacity exceeded");
            return;
        }
        buf[idx++] = task;
    }

    @Override
    public Task remove() {
        if(idx <= 0) {
            System.out.println("Stack is empty");
            return null;
        }

        var removed = buf[--idx];
        buf[idx] = null;
        return removed;
    }
}
