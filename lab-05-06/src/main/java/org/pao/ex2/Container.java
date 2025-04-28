package org.pao.ex2;

import org.pao.ex1.Task;

public interface Container {
    void add(Task task);
    Task remove();

    boolean empty();
}
