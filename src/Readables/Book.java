package Readables;

import Library.ReadableType;

import java.time.LocalDate;

public class Book extends Readable {

    public static final int MAX_PERIOD = 300;
    public static final int RENT_PRICE = 2;
    public static final int LIHVA = 1;
    private String author;
    private LocalDate dateOfPublishing;
    private BookGenre genre;

    public Book(String name, String publisher, String author, LocalDate dateOfPublishing, BookGenre genre) {
        super(name, publisher, ReadableType.BOOKS, MAX_PERIOD, RENT_PRICE, LIHVA);
        this.author = author;
        this.dateOfPublishing = dateOfPublishing;
        this.genre = genre;

    }

    public LocalDate getDateOfPublishing() {
        return dateOfPublishing;
    }

    public BookGenre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.getName()+
                " author='" + author + '\'' +
                ", genre=" + genre ;
    }


}
