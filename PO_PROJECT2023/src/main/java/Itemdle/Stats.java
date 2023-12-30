package Itemdle;


import java.time.LocalDateTime;

public class Stats {

    private int id;

    private String itemName;
    private int tries;

    private String datetime;

    public Stats(String itemName, int tries, String datetime) {
        this.itemName = itemName;
        this.tries = tries;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getTries() {
        return tries;
    }

    public String getDatetime() {
        return datetime;
    }
}
