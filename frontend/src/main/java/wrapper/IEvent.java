package wrapper;
import java.util.Set;
public interface IEvent {
    public String getEventPlace();

    public void setEventType(String eventType);

    public void setParticipants(Set<IUser> participants);

    public String getEventTime();

    public int getEventId();

    public Set<IUser> getParticipants();

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