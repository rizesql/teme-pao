package org.pao.ex2;

import org.pao.ex1.Task;

public class Queue implements Container {
    private final Task[] buf;
    private int cnt = 0;
    private int idx = 0;

    public Queue(int size) {
        this.buf = new Task[size];
    }

    @Override
    public boolean empty() {
        return cnt == 0;
    }

    private boolean full() {
        return cnt == buf.length;
    }

    private int head() {
        if (buf.length == 0 || empty()) {
            return -1;
        }

        return idx;
    }

    private int tail() {
        if (buf.length == 0 || empty()) {
            return -1;
        }

        return (idx + cnt - 1) % buf.length;
    }

    private int nextTail() {
        if (buf.length == 0 || full()) {
            return -1;
        }

        return (idx + cnt) % buf.length;
    }

    @Override
    public void add(Task task) {
        var pos = nextTail();
        if (pos == -1) {
            System.out.println("Queue is full");
            return;
        }

        buf[pos] = task;
        cnt++;
    }

    @Override
    public Task remove() {
        var pos = head();
        if (pos == -1) {
            System.out.println("Queue is empty");
            return null;
        }

        idx = (idx + 1) % buf.length;
        cnt--;

        return buf[pos];
    }
}
