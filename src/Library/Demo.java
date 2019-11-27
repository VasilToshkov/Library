package Library;

import Readables.Book;
import Readables.BookGenre;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Demo {
    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book("vaina i mir tom1","rusko","Tolstoi", LocalDate.now(),BookGenre.CRIMINAL);
        Book book2 = new Book("vaina i mir tom2","rusko","Tolstoi", LocalDate.now(),BookGenre.CRIMINAL);
        Book book3 = new Book("vaina i mir tom3","rusko","Tolstoi", LocalDate.now(),BookGenre.CRIMINAL);
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);

    library.printCatalog();
        int delay = -1* LocalDateTime.now().get();
        System.out.println(delay);

    }
}
