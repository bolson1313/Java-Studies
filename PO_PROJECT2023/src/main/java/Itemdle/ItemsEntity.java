package Itemdle;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "items")
public class ItemsEntity{

    @Id
    @Column(name = "id", unique = true)
    private int id;

    private String img_src;
    private String name;
    private String user;
    private String tag;
    private String effect;
    private String quality;
    private int price;
    private boolean buyable;
    private boolean upgrade;

    public ItemsEntity(){

    }

    public ItemsEntity(int id, String img_src, String name, String user, String tag, String effect, String quality, int price, boolean buyable, boolean upgrade) {
        this.id = id;
        this.img_src = img_src;
        this.name = name;
        this.user = user;
        this.tag = tag;
        this.effect = effect;
        this.quality = quality;
        this.price = price;
        this.buyable = buyable;
        this.upgrade = upgrade;
    }

    @Override
    public String toString() {
        return "ItemsEntity{" +
                "id=" + id +
                ", img_src='" + img_src + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", tag='" + tag + '\'' +
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

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
