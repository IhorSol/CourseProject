package kursovik.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

/**
 * @author Ihor Solohub
 */
@Entity
@Table(name = "Coils")
public class Coil implements Serializable{     // changed!

    @Id
    private long id = new Random(10_000).nextLong();

    private CoilType coilType;
    private String name;
    private int price;
    private int numberOfBearings;
    private String isSecondSpoolHas;
    private final String category = "Coil";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id") // зробить колонку в таблиці фото
    private Photo photo;

    public Coil() {}

    public Coil(String name, int price, CoilType coilType, int numberOfBearings, String isSecondSpoolHas, Photo photo) {
        this.name = name;
        this.price = price;
        this.coilType = coilType;
        this.numberOfBearings = numberOfBearings;
        this.isSecondSpoolHas = isSecondSpoolHas;
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

    public CoilType getCoilType() {
        return coilType;
    }

    public void setCoilType(CoilType coilType) {
        this.coilType = coilType;
    }

    public int getNumberOfBearings() {
        return numberOfBearings;
    }

    public void setNumberOfBearings(int numberOfBearings) {
        this.numberOfBearings = numberOfBearings;
    }

    public String getIsSecondSpoolHas() {
        return isSecondSpoolHas;
    }

    public void setIsSecondSpoolHas(String isSecondSpoolHas) {
        this.isSecondSpoolHas = isSecondSpoolHas;
    }

    public String getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }
}
