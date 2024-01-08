package Itemdle;


import java.time.LocalDateTime;

public class Stats {

    private int id;

    private String itemName;
    private ItemsEntity guessed_item_id;
    private int tries;

    private String datetime;

    public Stats(int id, String itemName, ItemsEntity guessed_item_id, int tries, String datetime) {
        this.id = id;
        this.itemName = itemName;
        this.guessed_item_id = guessed_item_id;
        this.tries = tries;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public ItemsEntity getGuessed_item_id() {
        return guessed_item_id;
    }

    public int getTries() {
        return tries;
    }

    public String getDatetime() {
        return datetime;
    }
}
