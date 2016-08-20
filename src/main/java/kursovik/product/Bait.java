package kursovik.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

/**
 * @author Ihor Solohub
 */
@Entity
@Table(name = "Baits")
public class Bait implements Serializable{     //changed!
    @Id
    private long id = new Random(10_000).nextLong();

    private String name;
    private int price;
    private BaitType baitType;
    private String color;
    private int weight;
    private final String category = "Bait";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id") // зробить колонку в таблиці фото
    private Photo photo;

    public Bait() {}

    public Bait(String name, int price, BaitType baitType, String color, int weight, Photo photo) {
        this.baitType = baitType;
        this.color = color;
        this.weight = weight;
        this.name = name;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BaitType getBaitType() {
        return baitType;
    }

    public void setBaitType(BaitType baitType) {
        this.baitType = baitType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }
}
