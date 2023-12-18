package Itemdle;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "items")
public class Items implements Serializable {

    @Column(name = "id", unique = true)
    @Id
    @GeneratedValue
    private int id;

    @Column(name="img-src")
    private String imgSrc;

    @Column(name="name")
    private String itemName;

    @Column(name="user")
    private String itemUser;

    @Column(name="tag")
    private String tags;

    @Column(name="effect")
    private String effect;

    @Column(name="quality")
    private String quality;

    @Column(name="price")
    private int price;

    @Column(name="buyable")
    private boolean buyable;

    @Column(name="upgrade")
    private boolean upgrade;


    public Items(int id, String imgSrc, String itemName, String itemUser, String tags, String effect, String quality, int price, boolean buyable, boolean upgrade) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.itemName = itemName;
        this.itemUser = itemUser;
        this.tags = tags;
        this.effect = effect;
        this.quality = quality;
        this.price = price;
        this.buyable = buyable;
        this.upgrade = upgrade;
    }

    public Items(){

    }


    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", imgSrc='" + imgSrc + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemUser='" + itemUser + '\'' +
                ", tags='" + tags + '\'' +
                ", effect='" + effect + '\'' +
                ", quality='" + quality + '\'' +
                ", price=" + price +
                ", buyable=" + buyable +
                ", upgrade=" + upgrade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUser() {
        return itemUser;
    }

    public void setItemUser(String itemUser) {
        this.itemUser = itemUser;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBuyable() {
        return buyable;
    }

    public void setBuyable(boolean buyable) {
        this.buyable = buyable;
    }

    public boolean isUpgrade() {
        return upgrade;
    }

    public void setUpgrade(boolean upgrade) {
        this.upgrade = upgrade;
    }
}
