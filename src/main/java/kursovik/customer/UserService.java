package kursovik.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Ihor Solohub.
 */
@Repository
public interface UserService {
    CustomUser getCustomerByLogin (String login);
    void addCustomer (CustomUser customUser);
    void updateCustomer (CustomUser customUser); // ХЗ чи робитиме сам добавив
}
