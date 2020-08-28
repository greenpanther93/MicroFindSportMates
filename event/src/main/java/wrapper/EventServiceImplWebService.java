package wrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.findsportmates.model.Event;
import com.findsportmates.model.User;
import com.findsportmates.service.EventService;
import com.findsportmates.service.EventServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EventServiceImplWebService {
    private ObjectNode xx;

    private InstanceDatabase yy;
    
    @Autowired
    private EventService eventService;

    @GetMapping("/EventServiceImplService1/")
    int createEventServiceImpl1() {
        return InstanceDatabase.addObject(eventService);
    }

    @PostMapping("/EventServiceImplService/{proxy_id}/removeEvent")
    public JsonNode removeEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        int id = node.get("id").asInt();
        eventserviceimpl.removeEvent(id);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/EventServiceImplService/{proxy_id}/listUserEvents")
    public JsonNode listUserEvents(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        int id = node.get("id").asInt();
        List<Event> return_list = eventserviceimpl.listUserEvents(id);
        ArrayNode return_node_list = mapper.createArrayNode();
        ((ObjectNode)return_node).put("return", return_node_list);
        for (Event return_list_element : ((Iterable<Event>)return_list)) {
            return_node_list.add(InstanceDatabase.addObject(return_list_element));
        }
        return return_node;
    }

    @GetMapping("/EventServiceImplService/{proxy_id}/listEvents")
    public JsonNode listEvents(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        List<Event> return_list = eventserviceimpl.listEvents();
        ArrayNode return_node_list = mapper.createArrayNode();
        ((ObjectNode)return_node).put("return", return_node_list);
        for (Event return_list_element : ((Iterable<Event>)return_list)) {
            return_node_list.add(InstanceDatabase.addObject(return_list_element));
        }
        return return_node;
    }

    @PostMapping("/EventServiceImplService/{proxy_id}/addEvent")
    public JsonNode addEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        Event e = (Event)InstanceDatabase.getObject(node.get("e").asInt());
        eventserviceimpl.addEvent(e);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/EventServiceImplService/{proxy_id}/getEventById")
    public JsonNode getEventById(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        int id = node.get("id").asInt();
        Event return_event = eventserviceimpl.getEventById(id);
        ((ObjectNode)return_node).put("return", InstanceDatabase.addObject(return_event));
        return return_node;
    }

    @PostMapping("/EventServiceImplService/{proxy_id}/updateEvent")
    public JsonNode updateEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        Event e = (Event)InstanceDatabase.getObject(node.get("e").asInt());
        eventserviceimpl.updateEvent(e);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/EventServiceImplService/{proxy_id}/addParticipant")
    public JsonNode addParticipant(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        int id = node.get("id").asInt();
//        IUser u = new IUserImpl(node.get("u").asInt());
        User u = new User();
        eventserviceimpl.addParticipant(id, u);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/EventServiceImplService/{proxy_id}/toString")
    public JsonNode toString(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        String return_string = eventserviceimpl.toString();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @PostMapping("/EventServiceImplService/{proxy_id}/searchEvent")
    public JsonNode searchEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        EventServiceImpl eventserviceimpl = (EventServiceImpl)InstanceDatabase.getObject(proxy_id);
        String type = node.get("type").asText();
        String date = node.get("date").asText();
        String num_L = node.get("num_L").asText();
        String num_U = node.get("num_U").asText();
        List<Event> return_list = eventserviceimpl.searchEvent(type, date, num_L, num_U);
        ArrayNode return_node_list = mapper.createArrayNode();
        ((ObjectNode)return_node).put("return", return_node_list);
        for (Event return_list_element : ((Iterable<Event>)return_list)) {
            return_node_list.add(InstanceDatabase.addObject(return_list_element));
        }
        return return_node;
    }
}