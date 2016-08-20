package kursovik.customer;

import javax.persistence.*;

/**
 * @author Ihor Solohub
 */
@Entity
@Table(name = "Customers")
public class CustomUser {
    @Id
    @GeneratedValue
    private long id;

    private String login;
    private String password;

    private String customerName;
    private String customerPhone;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public CustomUser() {}

    public CustomUser(UserRole role, String email, String customerPhone, String customerName, String password) {
        this.role = role;
        this.email = email;
        this.customerPhone = customerPhone;
        this.customerName = customerName;
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public UserRole getRole() {
        return role;
    }
}
