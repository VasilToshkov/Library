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
    private boolean isAvailable= true;
    private int rentPrice;
    private int lihva;


    public Readable(String name, String publisher, ReadableType readableType, int maxPeriod,int rentPrice,int lihva) {
        this.name = name;
        this.publisher = publisher;
        history = new HashMap<>();
        type=readableType;
        this.maxPeriod = maxPeriod;
        this.rentPrice = rentPrice;
        this.lihva = lihva;
    }


    public  String getName(){
        return name;
    }
    public void takeHome(){
        lastTaken = LocalDateTime.now();
        history.put(lastTaken,null);
        isAvailable = false;
    }

    public void returnBook() {
        if (LocalDateTime.now().isAfter(lastTaken.plusSeconds(maxPeriod))){
            int delay = -1*LocalDateTime.now().compareTo(lastTaken.plusSeconds(maxPeriod));
        }
        history.put(lastTaken,LocalDateTime.now());
        isAvailable= true;
    }
    private int rentTaxes(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime returnmentDeadline = lastTaken.plusSeconds(maxPeriod);
        int extraTax =0;
        while(!isAvailable()&&now.isAfter(returnmentDeadline)){
            extraTax++;
            now.minusSeconds(1);
        }
        return extraTax*(lihva) +rentPrice;

    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public ReadableType  getType(){
        return this.type;

    }
}
