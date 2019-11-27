package Readables;

import Library.ReadableType;



import java.time.LocalDateTime;
import java.util.HashMap;

public abstract class Readable  {

    private String name;
    private String publisher;
    private HashMap<LocalDateTime , LocalDateTime> history;
    private ReadableType type;
    private LocalDateTime lastTaken;
    private int maxPeriod;

    public Readable(String name, String publisher, ReadableType readableType) {
        this.name = name;
        this.publisher = publisher;
        history = new HashMap<>();
        type=readableType;
    }


    public  String getName(){
        return name;
    }
    public void takeBook(){

        lastTaken = LocalDateTime.now();
        history.put(lastTaken,null);
    }

    public void returnBook() {
        if (LocalDateTime.now().isAfter(lastTaken.plusSeconds(maxPeriod))){
            int delay = -1*LocalDateTime.now().compareTo(lastTaken.plusSeconds(maxPeriod));
        }
        history.put(lastTaken,LocalDateTime.now());
    }


}
