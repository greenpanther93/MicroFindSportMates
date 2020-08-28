package wrapper;
import java.util.List;
public interface IEventServiceImpl {
    public void removeEvent(int id);

    public List<IEvent> listUserEvents(int id);

    public List<IEvent> listEvents();

    public void addEvent(IEvent e);

    public IEvent getEventById(int id);

    public void updateEvent(IEvent e);

    public void addParticipant(int id, IUser u);

    public String toString();

    public List<IEvent> searchEvent(String type, String date, String num_L, String num_U);
}