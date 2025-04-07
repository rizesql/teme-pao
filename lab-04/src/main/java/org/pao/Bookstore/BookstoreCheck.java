package org.pao.Bookstore;

import java.util.ArrayList;
import java.util.Scanner;

public class BookstoreCheck {
    public void hasCopies(Scanner in, BookstoreTest test) {
        try {
            System.out.println("Check for copies of a book");

            System.out.print("id: ");
            var id = in.nextInt();
            var book = test.get(id);

            if (hasCopies(book, test.readAll())) {
                System.out.println("Book has copies");
            } else {
                System.out.println("Book does not have copies");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Book not found");
        }
    }

    public boolean hasCopies(Book book, ArrayList<Book> books) {
        return books.stream().filter(book::equals).count() > 1;
    }

    public void thicker(Scanner in, BookstoreTest test) {
        System.out.println("Find the thicker book");

        System.out.print("First id: ");
        var lhsId = in.nextInt();
        System.out.print("Second id: ");
        var rhsId = in.nextInt();

        var lhs = test.get(lhsId);
        var rhs = test.get(rhsId);

        System.out.println(thicker(lhs, rhs));
    }

    public Book thicker(Book lhs, Book rhs) {
        if (lhs.getPageCount() < rhs.getPageCount()) return rhs;
        return lhs;
    }
}
