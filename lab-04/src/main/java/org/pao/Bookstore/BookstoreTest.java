package org.pao.Bookstore;

import java.util.ArrayList;
import java.util.Scanner;

public class BookstoreTest {
    private final ArrayList<Book> books = new ArrayList<>();

    public void create(Scanner in) {
        System.out.println("Create a book");
        in.nextLine();

        System.out.print("title: ");
        var title = in.nextLine();

        System.out.print("author: ");
        var author = in.nextLine();

        System.out.print("publisher: ");
        var publisher = in.nextLine();

        System.out.print("pageCount: ");
        var pageCount = in.nextInt();

        try {
            create(title, author, publisher, pageCount);
            System.out.println("Book created successfully");
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(String title, String author, String publisher, int pageCount) {
        if (title == null) {
            throw new IllegalArgumentException("title cannot be null");
        }

        if (author == null) {
            throw new IllegalArgumentException("author cannot be null");
        }

        if (publisher == null) {
            throw new IllegalArgumentException("publisher cannot be null");
        }

        if (pageCount <= 0) {
            throw new IllegalArgumentException("pageCount must be greater than 0");
        }

        books.add(new Book(title, author, publisher, pageCount));
    }

    public void get(Scanner in) {
        var id = in.nextInt();

        try {
            var book = get(id);
            System.out.println(book);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Book not found");
        }
    }

    public Book get(int id) {
        return books.get(id);
    }

    public void list() {
        for (var book : readAll()) {
            System.out.println(book);
        }
    }

    public ArrayList<Book> readAll() {
        return books;
    }

    public void update(Scanner in) {
        try {
            System.out.println("Update a book");

            System.out.print("id: ");
            var id = in.nextInt();
            in.nextLine();

            System.out.print("title: ");
            var title = in.nextLine();

            System.out.print("author: ");
            var author = in.nextLine();

            System.out.print("publisher: ");
            var publisher = in.nextLine();

            System.out.print("pageCount: ");
            var pageCount = in.nextInt();

            update(id, title, author, publisher, pageCount);
            System.out.println("Book updated successfully");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Book not found");
        }
    }

    public void update(int id, String title, String author, String publisher, int pageCount) {
        var book = books.get(id);

        if (title != null) {
            book.setTitle(title);
        }
        if (author != null) {
            book.setAuthor(author);
        }
        if (publisher != null) {
            book.setPublisher(publisher);
        }
        if (pageCount > 0) {
            book.setPageCount(pageCount);
        }

        books.set(id, book);
    }

    public void delete(Scanner in) {
        try {
            System.out.println("Delete a book");

            System.out.println("id: ");
            var id = in.nextInt();

            delete(id);
            System.out.println("Book deleted successfully");
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Book not found");
        }
    }

    public void delete(int id) {
        books.remove(id);
    }
}
