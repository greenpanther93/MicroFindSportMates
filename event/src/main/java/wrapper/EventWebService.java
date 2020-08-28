package wrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.findsportmates.model.Event;
import com.findsportmates.model.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EventWebService {

    @GetMapping("/EventService1/")
    int createEvent1() {
        Event event = new Event();
        return InstanceDatabase.addObject(event);
    }

    @PostMapping("/EventService2/")
    int createEvent2(@RequestBody
    JsonNode node) {
        int eventId = node.get("eventId").asInt();
        int hostId = node.get("hostId").asInt();
        String eventType = node.get("eventType").asText();
        String eventTime = node.get("eventTime").asText();
        String eventDate = node.get("eventDate").asText();
        String eventPlace = node.get("eventPlace").asText();
        Event event = new Event(eventId, hostId, eventType, eventTime, eventDate, eventPlace);
        return InstanceDatabase.addObject(event);
    }

    @GetMapping("/EventService/{proxy_id}/getEventPlace")
    public JsonNode getEventPlace(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String return_string = event.getEventPlace();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @PostMapping("/EventService/{proxy_id}/setEventType")
    public JsonNode setEventType(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String eventType = node.get("eventType").asText();
        event.setEventType(eventType);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/EventService/{proxy_id}/setParticipants")
    public JsonNode setParticipants(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        Set<User> participants = new HashSet();
        ArrayNode participants_array = (ArrayNode) node.get("participants");
        Iterator<JsonNode> participants_iterator = participants_array.elements();
        while (participants_iterator.hasNext()) {
            JsonNode participants_node = participants_iterator.next();
//            IUser participants_element = new IUserImpl(participants_node.asInt());
            User participants_element = new User();
            participants.add(participants_element);
        } 
        event.setParticipants(participants);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/EventService/{proxy_id}/getEventTime")
    public JsonNode getEventTime(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String return_string = event.getEventTime();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @GetMapping("/EventService/{proxy_id}/getEventId")
    public JsonNode getEventId(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        int return_int = event.getEventId();
        ((ObjectNode)return_node).put("return", return_int);
        return return_node;
    }

    @GetMapping("/EventService/{proxy_id}/getParticipants")
    public JsonNode getParticipants(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        Set<User> return_set = event.getParticipants();
        ArrayNode return_node_list = mapper.createArrayNode();
        ((ObjectNode)return_node).put("return", return_node_list);
        for (IUser return_set_element : ((Iterable<User>)return_set)) {
            return_node_list.add(((Proxy)return_set_element).getProxyId());
        }
        return return_node;
    }

    @PostMapping("/EventService/{proxy_id}/setEventId")
    public JsonNode setEventId(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        int eventId = node.get("eventId").asInt();
        event.setEventId(eventId);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/EventService/{proxy_id}/setEventTime")
    public JsonNode setEventTime(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String eventTime = node.get("eventTime").asText();
        event.setEventTime(eventTime);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/EventService/{proxy_id}/setEventPlace")
    public JsonNode setEventPlace(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String eventPlace = node.get("eventPlace").asText();
        event.setEventPlace(eventPlace);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/EventService/{proxy_id}/setHostId")
    public JsonNode setHostId(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        int hostId = node.get("hostId").asInt();
        event.setHostId(hostId);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/EventService/{proxy_id}/getEventType")
    public JsonNode getEventType(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String return_string = event.getEventType();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @GetMapping("/EventService/{proxy_id}/getEventDate")
    public JsonNode getEventDate(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String return_string = event.getEventDate();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @GetMapping("/EventService/{proxy_id}/getHostId")
    public JsonNode getHostId(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        int return_int = event.getHostId();
        ((ObjectNode)return_node).put("return", return_int);
        return return_node;
    }

    @GetMapping("/EventService/{proxy_id}/toString")
    public JsonNode toString(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String return_string = event.toString();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @PostMapping("/EventService/{proxy_id}/setEventDate")
    public JsonNode setEventDate(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        Event event = (Event)InstanceDatabase.getObject(proxy_id);
        String eventDate = node.get("eventDate").asText();
        event.setEventDate(eventDate);
        // No need to prepare a void type.;
        return return_node;
    }
}