package Itemdle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "playedgames")
public class StatsEntity {
    @Id
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "guessed_item")
    private String itemName;
    private int tries;
    @Column(name = "date")
    private String datetime;

    public StatsEntity() {
    }

    public StatsEntity(int id, String itemName, int tries, String datetime) {
        this.id = id;
        this.itemName = itemName;
        this.tries = tries;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", tries=" + tries +
                ", datetime=" + datetime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
