package kursovik.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ihor Solohub.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public CustomUser getCustomerByLogin(String login) {
        return customerRepository.findByLogin(login);
    }

    @Override
    @Transactional
    public void addCustomer(CustomUser customUser) {
        customerRepository.save(customUser);
    }

    @Override
    @Transactional
    public void updateCustomer(CustomUser customUser) { // тоже хз чи робитиме(з тієї ж опери)
        customerRepository.save(customUser);
    }
}
