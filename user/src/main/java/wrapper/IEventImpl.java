package wrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.findsportmates.model.User;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class IEventImpl implements IEvent , Proxy {
    private int event_id;

    private ObjectNode xx;

    public int getProxyId() {
        return event_id;
    }

    public IEventImpl(int event_id) {
        this.event_id = event_id;
    }

    public IEventImpl() {
        this.event_id = BeanUtil.getBean(EventTemplate.class).createEvent1();
    }

    public IEventImpl(int eventId, int hostId, String eventType, String eventTime, String eventDate, String eventPlace) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("eventId", eventId);
        ((ObjectNode)param_node).put("hostId", hostId);
        ((ObjectNode)param_node).put("eventType", eventType);
        ((ObjectNode)param_node).put("eventTime", eventTime);
        ((ObjectNode)param_node).put("eventDate", eventDate);
        ((ObjectNode)param_node).put("eventPlace", eventPlace);
        this.event_id = BeanUtil.getBean(EventTemplate.class).createEvent2(param_node);
    }

    public String getEventPlace() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_getEventPlace(event_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public void setEventType(String eventType) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("eventType", eventType);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_setEventType(event_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void setParticipants(Set<User> participants) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ArrayNode param_node_list = mapper.createArrayNode();
        ((ObjectNode)param_node).put("participants", param_node_list);
        for (User participants_element : ((Iterable<User>)participants)) {
            param_node_list.add(InstanceDatabase.addObject(participants_element));
        }
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_setParticipants(event_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String getEventTime() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_getEventTime(event_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public int getEventId() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_getEventId(event_id);
        int return_int = return_node.get("return").asInt();
        return return_int;
    }

    public Set<User> getParticipants() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_getParticipants(event_id);
        Set<User> return_set = new HashSet();
        ArrayNode return_set_array = (ArrayNode) return_node.get("return");
        Iterator<JsonNode> return_set_iterator = return_set_array.elements();
        while (return_set_iterator.hasNext()) {
            JsonNode return_set_node = return_set_iterator.next();
            User return_set_element = (User)InstanceDatabase.getObject(return_set_node.asInt());
            return_set.add(return_set_element);
        } 
        return return_set;
    }

    public void setEventId(int eventId) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("eventId", eventId);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_setEventId(event_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void setEventTime(String eventTime) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("eventTime", eventTime);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_setEventTime(event_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void setEventPlace(String eventPlace) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("eventPlace", eventPlace);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_setEventPlace(event_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void setHostId(int hostId) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("hostId", hostId);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_setHostId(event_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String getEventType() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_getEventType(event_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public String getEventDate() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_getEventDate(event_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public int getHostId() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_getHostId(event_id);
        int return_int = return_node.get("return").asInt();
        return return_int;
    }

    public String toString() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_toString(event_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public void setEventDate(String eventDate) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("eventDate", eventDate);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).Event_setEventDate(event_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }
}