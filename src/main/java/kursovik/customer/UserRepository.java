package kursovik.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Ihor Solohub.
 */
public interface UserRepository extends JpaRepository<CustomUser, Long>{
    @Query("SELECT c FROM Customer c where c.login = :login")
    CustomUser findByLogin(@Param("login") String login);
}
