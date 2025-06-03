package org.pao;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        var set = new MyHashSet();

        set.add(1);
        set.add(2);
        set.add(2); // duplicat, nu ar trebui să crească entries

        set.addAll(List.of(2, 3, 4, 4)); // 2 și 4 sunt duplicate

        System.out.println("Set: " + set);               // [1, 2, 3, 4]
        System.out.println("Entries: " + set.entries()); // 4

        var list = new MyLinkedList();

        list.add(1);
        list.add(2);
        list.add(2);                      // Duplicat
        list.addAll(List.of(2, 3, 4, 4)); // Duplicat

        System.out.println("Conținut listă: " + list); // [1, 2, 2, 2, 3, 4, 4]
        System.out.println("Entries (adăugări totale): " + list.entries());
    }
}
