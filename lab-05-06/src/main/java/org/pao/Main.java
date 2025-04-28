package org.pao;

import org.pao.ex1.CounterOutTask;
import org.pao.ex1.OutTask;
import org.pao.ex1.RandomOutTask;
import org.pao.ex2.Queue;
import org.pao.ex2.Stack;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new OutTask("Hello, world!").run();

        new RandomOutTask(new Random()).run();

        new CounterOutTask().run();
        new CounterOutTask().run();
        new CounterOutTask().run();

        var stack = new Stack(8);
        stack.add(new OutTask("a"));
        stack.add(new OutTask("b"));
        stack.add(new OutTask("c"));

        while (!stack.empty()) {
            stack.remove().run();
        }

        var queue = new Queue(8);
        queue.add(new OutTask("x"));
        queue.add(new OutTask("y"));
        queue.add(new OutTask("z"));

        while (!queue.empty()) {
            queue.remove().run();
        }
    }
}