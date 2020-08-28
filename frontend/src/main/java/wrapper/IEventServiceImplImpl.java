package wrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class IEventServiceImplImpl implements IEventServiceImpl , Proxy {
    private int eventserviceimpl_id;

    private ObjectNode xx;

    public int getProxyId() {
        return eventserviceimpl_id;
    }

    public IEventServiceImplImpl(int eventserviceimpl_id) {
        this.eventserviceimpl_id = eventserviceimpl_id;
    }

    public IEventServiceImplImpl() {
        this.eventserviceimpl_id = BeanUtil.getBean(EventTemplate.class).createEventServiceImpl1();
    	System.out.println("init event service : " + eventserviceimpl_id);
    }

    public void removeEvent(int id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_removeEvent(eventserviceimpl_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public List<IEvent> listUserEvents(int id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_listUserEvents(eventserviceimpl_id, param_node);
        List<IEvent> return_list = new ArrayList();
        ArrayNode return_list_array = (ArrayNode) return_node.get("return");
        Iterator<JsonNode> return_list_iterator = return_list_array.elements();
        while (return_list_iterator.hasNext()) {
            JsonNode return_list_node = return_list_iterator.next();
            IEvent return_list_element = new Event(return_list_node.asInt());
            return_list.add(return_list_element);
        } 
        return return_list;
    }

    public List<IEvent> listEvents() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_listEvents(eventserviceimpl_id);
        List<IEvent> return_list = new ArrayList();
        ArrayNode return_list_array = (ArrayNode) return_node.get("return");
        Iterator<JsonNode> return_list_iterator = return_list_array.elements();
        while (return_list_iterator.hasNext()) {
            JsonNode return_list_node = return_list_iterator.next();
            IEvent return_list_element = new Event(return_list_node.asInt());
            return_list.add(return_list_element);
        } 
        return return_list;
    }

    public void addEvent(IEvent e) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("e", ((Proxy)e).getProxyId());
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_addEvent(eventserviceimpl_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public IEvent getEventById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_getEventById(eventserviceimpl_id, param_node);
        IEvent return_event = new Event(return_node.get("return").asInt());
        return return_event;
    }

    public void updateEvent(IEvent e) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("e", ((Proxy)e).getProxyId());
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_updateEvent(eventserviceimpl_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void addParticipant(int id, IUser u) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        ((ObjectNode)param_node).put("u", ((Proxy)u).getProxyId());
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_addParticipant(eventserviceimpl_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String toString() {
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_toString(eventserviceimpl_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public List<IEvent> searchEvent(String type, String date, String num_L, String num_U) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("type", type);
        ((ObjectNode)param_node).put("date", date);
        ((ObjectNode)param_node).put("num_L", num_L);
        ((ObjectNode)param_node).put("num_U", num_U);
        JsonNode return_node = BeanUtil.getBean(EventTemplate.class).EventServiceImpl_searchEvent(eventserviceimpl_id, param_node);
        List<IEvent> return_list = new ArrayList();
        ArrayNode return_list_array = (ArrayNode) return_node.get("return");
        Iterator<JsonNode> return_list_iterator = return_list_array.elements();
        while (return_list_iterator.hasNext()) {
            JsonNode return_list_node = return_list_iterator.next();
            IEvent return_list_element = new Event(return_list_node.asInt());
            return_list.add(return_list_element);
        } 
        return return_list;
    }
}