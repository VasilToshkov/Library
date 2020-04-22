package Library;

import Readables.Book;
import Readables.BookGenre;
import Readables.Readable;

import java.util.*;

public class Library {
    private HashMap<ReadableType , Map> catalogue;

    private HashMap<BookGenre , TreeSet<Book>> books = new HashMap<>();

    public Library() {
        this.catalogue = new HashMap<ReadableType, Map>();

    }

     void addBook(Book book){
        if (!books.containsKey(book.getGenre())){
            books.put(book.getGenre(),new TreeSet<Book>((o1, o2) -> {
                if (o1.getName().equals(o2.getName())){
                    return 0;
                }
                if (o1.getDateOfPublishing().compareTo(o2.getDateOfPublishing())>=0){
                    return 1;
                }
                return -1;
            }));
        }
        books.get(book.getGenre()).add(book);
        books.put(book.getGenre(), books.get(book.getGenre()));
        catalogue.put(ReadableType.BOOKS,books);
    }

    void printCatalog(){
        System.out.println(catalogue);
    }



    void takeReadable(Readable r) {
        //evokes from UseR
        if(r.getType() == ReadableType.MAGAZINES){
            System.out.println("You can't take magazines home");
        }
        r.takeHome();
    }
    void returnBook(Readable r) {
        if(!r.isAvailable()){
            r.returnBook();
        }
        else{
            System.out.println("The book is already back");
        }

    }







//    void returnReadable(Readable r);//
//    void read();


}
