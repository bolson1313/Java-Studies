package Itemdle;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class ItemsEntity {
    @Id
    private int item_id;
    private String img_src;
    private String name;
    private String user;
    private String tag;
    private String effect;
    private String quality;
    private int price;
    private boolean buyable;
    private boolean upgrade;

    @OneToMany(mappedBy = "fk_guessed_item_id")
    private List<StatsEntity> fk_item_id = new ArrayList<>();

    public ItemsEntity() {
    }

    @Override
    public String toString() {
        return "ItemsEntity{" +
                "item_id=" + item_id +
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

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_srd) {
        this.img_src = img_srd;
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
