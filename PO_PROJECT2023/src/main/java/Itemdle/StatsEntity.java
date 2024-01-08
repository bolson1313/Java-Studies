package Itemdle;

import jakarta.persistence.*;

@Entity
@Table(name = "playedgames")
public class StatsEntity {
    @Id
    private int stat_id;
    private String guessed_item;
    @ManyToOne
    @JoinColumn(name = "fk_guessed_item_id")
    private ItemsEntity fk_guessed_item_id;
    private int tries;
    private String date;

    public StatsEntity() {
    }

    public StatsEntity(String guessed_item, ItemsEntity fk_guessed_item_id, int tries, String date) {
        this.guessed_item = guessed_item;
        this.fk_guessed_item_id = fk_guessed_item_id;
        this.tries = tries;
        this.date = date;
    }

    public int getStat_id() {
        return stat_id;
    }

    public void setStat_id(int stat_id) {
        this.stat_id = stat_id;
    }

    public String getGuessed_item() {
        return guessed_item;
    }

    public void setGuessed_item(String guessed_item) {
        this.guessed_item = guessed_item;
    }

    public int getFk_guessed_item_id() {
        return fk_guessed_item_id.getItem_id();
    }

    public void setFk_guessed_item_id(ItemsEntity fk_guessed_item_id) {
        this.fk_guessed_item_id = fk_guessed_item_id;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
