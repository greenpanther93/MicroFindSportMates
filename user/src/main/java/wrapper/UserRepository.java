package wrapper;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.findsportmates.model.Event;
import com.findsportmates.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
