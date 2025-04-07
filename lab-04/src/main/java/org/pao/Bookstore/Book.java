package org.pao.Bookstore;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int pageCount;

    public Book(String title, String author, String publisher, int pageCount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return """
                BOOK_TITLE: %s
                BOOK_AUTHOR: %s
                BOOK_PUBLISHER: %s
                """.formatted(title.toUpperCase(), author, publisher.toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;

        return getPageCount() == book.getPageCount()
                && Objects.equals(getTitle(), book.getTitle())
                && Objects.equals(getAuthor(), book.getAuthor())
                && Objects.equals(getPublisher(), book.getPublisher());
    }
}
