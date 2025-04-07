package org.pao.Bookstore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var test = new BookstoreTest();
        var check = new BookstoreCheck();

        try (var in = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                    Commands:\s
                    \t[0] Exit
                    \t[1] Create a book
                    \t[2] Read a book
                    \t[3] Read all books
                    \t[4] Update a book
                    \t[5] Delete a book
                    \t[6] Check for copies of a book
                    \t[7] Find the thicker book
                    """);

                int command;
                do {
                    command = in.nextInt();
                } while (command < 0 || command > 7);

                if (command == 0) {
                    break;
                }

                switch (command) {
                    case 1 -> test.create(in);
                    case 2 -> test.get(in);
                    case 3 -> test.list();
                    case 4 -> test.update(in);
                    case 5 -> test.delete(in);
                    case 6 -> check.hasCopies(in, test);
                    case 7 -> check.thicker(in, test);
                }
            }
        }
    }
}
