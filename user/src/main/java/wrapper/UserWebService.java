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
public class UserWebService {

    @GetMapping("/UserService1/")
    int createUser1() {
        User user = new User();
        return InstanceDatabase.addObject(user);
    }

    @PostMapping("/UserService2/")
    int createUser2(@RequestBody
    JsonNode node) {
        int id = node.get("id").asInt();
        String username = node.get("username").asText();
        String password = node.get("password").asText();
        String role = node.get("role").asText();
        String phone = node.get("phone").asText();
        String firstname = node.get("firstname").asText();
        String lastname = node.get("lastname").asText();
        Set<Event> events = new HashSet();
        ArrayNode events_array = (ArrayNode) node.get("events");
        Iterator<JsonNode> events_iterator = events_array.elements();
        while (events_iterator.hasNext()) {
            JsonNode events_node = events_iterator.next();
//            Event events_element = new IEventImpl(events_node.asInt());
//            events.add(events_element);
        } 
        User user = new User(id, username, password, role, phone, firstname, lastname, events);
        System.out.println("createUser2 user: " + user.toString());
        return InstanceDatabase.addObject(user);
    }

    @PostMapping("/UserService/{proxy_id}/setFirstname")
    public JsonNode setFirstname(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String firstname = node.get("firstname").asText();
        user.setFirstname(firstname);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getPhone")
    public JsonNode getPhone(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String return_string = user.getPhone();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @PostMapping("/UserService/{proxy_id}/setPassword")
    public JsonNode setPassword(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String password = node.get("password").asText();
        user.setPassword(password);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/UserService/{proxy_id}/setLastname")
    public JsonNode setLastname(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String lastname = node.get("lastname").asText();
        user.setLastname(lastname);
        // No need to prepare a void type.;
        return return_node;
    }

    @PostMapping("/UserService/{proxy_id}/setEvents")
    public JsonNode setEvents(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        Set<Event> events = new HashSet();
        ArrayNode events_array = (ArrayNode) node.get("events");
        Iterator<JsonNode> events_iterator = events_array.elements();
        while (events_iterator.hasNext()) {
            JsonNode events_node = events_iterator.next();
//            IEvent events_element = new IEventImpl(events_node.asInt());
//            events.add(events_element);
        } 
        user.setEvents(events);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getId")
    public JsonNode getId(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        int return_int = user.getId();
        ((ObjectNode)return_node).put("return", return_int);
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getUsername")
    public JsonNode getUsername(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String return_string = user.getUsername();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getEvents")
    public JsonNode getEvents(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        Set<Event> return_set = user.getEvents();
        ArrayNode return_node_list = mapper.createArrayNode();
        ((ObjectNode)return_node).put("return", return_node_list);
        for (Event return_set_element : ((Iterable<Event>)return_set)) {
            return_node_list.add(((Proxy)return_set_element).getProxyId());
        }
        return return_node;
    }

    @PostMapping("/UserService/{proxy_id}/setId")
    public JsonNode setId(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        int id = node.get("id").asInt();
        user.setId(id);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getFirstname")
    public JsonNode getFirstname(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String return_string = user.getFirstname();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @PostMapping("/UserService/{proxy_id}/setUsername")
    public JsonNode setUsername(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String username = node.get("username").asText();
        user.setUsername(username);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getRole")
    public JsonNode getRole(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String return_string = user.getRole();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @PostMapping("/UserService/{proxy_id}/setPhone")
    public JsonNode setPhone(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String phone = node.get("phone").asText();
        user.setPhone(phone);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getPassword")
    public JsonNode getPassword(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String return_string = user.getPassword();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/getLastname")
    public JsonNode getLastname(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String return_string = user.getLastname();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @PostMapping("/UserService/{proxy_id}/setRole")
    public JsonNode setRole(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String role = node.get("role").asText();
        user.setRole(role);
        // No need to prepare a void type.;
        return return_node;
    }

    @GetMapping("/UserService/{proxy_id}/toString")
    public JsonNode toString(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        User user = (User)InstanceDatabase.getObject(proxy_id);
        String return_string = user.toString();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }
}