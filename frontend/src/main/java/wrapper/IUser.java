package wrapper;
import java.util.Set;
public interface IUser {
    public void setFirstname(String firstname);

    public String getPhone();

    public void setPassword(String password);

    public void setLastname(String lastname);

    public void setEvents(Set<IEvent> events);

    public int getId();

    public String getUsername();

    public Set<IEvent> getEvents();

    public void setId(int id);

    public String getFirstname();

    public void setUsername(String username);

    public String getRole();

    public void setPhone(String phone);

    public String getPassword();

    public String getLastname();

    public void setRole(String role);

    public String toString();
}