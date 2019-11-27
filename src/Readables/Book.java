package Readables;

import Library.ReadableType;

import java.time.LocalDate;

public class Book extends Readable {

    private String author;
    private LocalDate dateOfPublishing;
    private BookGenre genre;

    public Book(String name, String publisher, String author, LocalDate dateOfPublishing, BookGenre genre) {
        super(name, publisher, ReadableType.BOOKS);
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

//    @Override
//    void takeBook() {
//        this.g
//    }
}
