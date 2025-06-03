package org.pao;

import java.util.Collection;
import java.util.LinkedList;

public class MyLinkedList extends LinkedList<Integer> {
    private int entries = 0;

    public int entries() {
        return entries;
    }

    @Override
    public boolean add(Integer e) {
        var added = super.add(e);
        if (added) {
            entries++;
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        var changed = false;
        for (var e : c) {
            changed |= add(e);
        }
        return changed;
    }
}
