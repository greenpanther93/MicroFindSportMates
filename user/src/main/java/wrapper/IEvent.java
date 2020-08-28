package wrapper;
import java.util.Set;

import com.findsportmates.model.User;
public interface IEvent {
    public String getEventPlace();

    public void setEventType(String eventType);

    public void setParticipants(Set<User> participants);

    public String getEventTime();

    public int getEventId();

    public Set<User> getParticipants();

    public void setEventId(int eventId);

    public void setEventTime(String eventTime);

    public void setEventPlace(String eventPlace);

    public void setHostId(int hostId);

    public String getEventType();

    public String getEventDate();

    public int getHostId();

    public String toString();

    public void setEventDate(String eventDate);
}