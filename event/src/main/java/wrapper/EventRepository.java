package wrapper;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.findsportmates.model.Event;


public interface EventRepository extends CrudRepository<Event, Integer> {

	//@Query(nativeQuery = true, value = "select * FROM user where role = ?1")
	List<Event> findByHostId(int hostId);
	
	@Query(nativeQuery = true, value = "select * from event event where event.type like ?1 and event.date like ?2 and event.time like ?3")
	List<Event> searchTypeAndDateTime(String _type, String _date, String _time);

	@Query(nativeQuery = true, value = "select * from event event where event.type like ?1")
	List<Event> searchType(String _type);
	
	@Query(nativeQuery = true, value = "select * from event event where event.date like ?1 and event.time like ?2")
	List<Event> searchDateTime(String _date, String _time);

}
