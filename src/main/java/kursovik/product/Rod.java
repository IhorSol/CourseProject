package kursovik.product;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

/**
 * @author Ihor Solohub
 */
@Entity
@Table(name = "Rods")
public class Rod implements Serializable{     //changed!

    @Id
    private long id = new Random(10_000).nextLong();

    private String name;
    private int price;
    private RodType rodType;
    private int castingMin;
    private int castingMax;
    private final String category = "Rod";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id") // зробить колонку в таблиці фото
    private Photo photo;

    public Rod() {}

    public Rod(String name, int price, RodType rodType, int kastingMin, int kastingMax, Photo photo) {
        this.name = name;
        this.price = price;
        this.rodType = rodType;
        this.castingMin = kastingMin;
        this.castingMax = kastingMax;
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

    public RodType getRodType() {
        return rodType;
    }

    public void setRodType(RodType rodType) {
        this.rodType = rodType;
    }

    public int getCastingMin() {
        return castingMin;
    }

    public void setCastingMin(int castingMin) {
        this.castingMin = castingMin;
    }

    public int getCastingMax() {
        return castingMax;
    }

    public void setCastingMax(int castingMax) {
        this.castingMax = castingMax;
    }

    public String getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }
}
