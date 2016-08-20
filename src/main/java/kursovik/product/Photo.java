package kursovik.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

/**
 * @author Ihor Solohub.
 */
@Entity
@Table(name = "Photos")
public class Photo {
    @Id
    private long id = new Random(10_000).nextLong();

    private  byte[] body;

    public Photo(byte[] bytes) {}

    public Photo(long id, byte[] body) {
        this.id = id;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
