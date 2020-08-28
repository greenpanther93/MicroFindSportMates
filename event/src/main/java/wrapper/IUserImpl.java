package wrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.findsportmates.model.Event;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class IUserImpl implements IUser , Proxy {
    private int user_id;

    private ObjectNode xx;

    public int getProxyId() {
        return user_id;
    }

    public IUserImpl(int user_id) {
        this.user_id = user_id;
    }

    public IUserImpl() {
        this.user_id = BeanUtil.getBean(UserTemplate.class).createUser1();
    }

    public IUserImpl(int id, String username, String password, String role, String phone, String firstname, String lastname, Set<Event> events) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        ((ObjectNode)param_node).put("username", username);
        ((ObjectNode)param_node).put("password", password);
        ((ObjectNode)param_node).put("role", role);
        ((ObjectNode)param_node).put("phone", phone);
        ((ObjectNode)param_node).put("firstname", firstname);
        ((ObjectNode)param_node).put("lastname", lastname);
        ArrayNode param_node_list = mapper.createArrayNode();
        ((ObjectNode)param_node).put("events", param_node_list);
        for (Event events_element : ((Iterable<Event>)events)) {
            param_node_list.add(((Proxy)events_element).getProxyId());
        }
        this.user_id = BeanUtil.getBean(UserTemplate.class).createUser2(param_node);
    }

    public void setFirstname(String firstname) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("firstname", firstname);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setFirstname(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String getPhone() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getPhone(user_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public void setPassword(String password) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("password", password);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setPassword(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void setLastname(String lastname) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("lastname", lastname);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setLastname(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void setEvents(Set<Event> events) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ArrayNode param_node_list = mapper.createArrayNode();
        ((ObjectNode)param_node).put("events", param_node_list);
        for (Event events_element : ((Iterable<Event>)events)) {
            param_node_list.add(((Proxy)events_element).getProxyId());
        }
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setEvents(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public int getId() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getId(user_id);
        int return_int = return_node.get("return").asInt();
        return return_int;
    }

    public String getUsername() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getUsername(user_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public Set<Event> getEvents() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getEvents(user_id);
        Set<Event> return_set = new HashSet();
        ArrayNode return_set_array = (ArrayNode) return_node.get("return");
        Iterator<JsonNode> return_set_iterator = return_set_array.elements();
        while (return_set_iterator.hasNext()) {
            JsonNode return_set_node = return_set_iterator.next();
            Event return_set_element = (Event)InstanceDatabase.getObject(return_set_node.asInt());
            return_set.add(return_set_element);
        } 
        return return_set;
    }

    public void setId(int id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setId(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String getFirstname() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getFirstname(user_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public void setUsername(String username) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("username", username);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setUsername(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String getRole() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getRole(user_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public void setPhone(String phone) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("phone", phone);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setPhone(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String getPassword() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getPassword(user_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public String getLastname() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_getLastname(user_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public void setRole(String role) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("role", role);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_setRole(user_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public String toString() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).User_toString(user_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }
}