package wrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class IUserServiceImplImpl implements IUserServiceImpl , Proxy {
    private int userserviceimpl_id;

    private ObjectNode xx;

    public int getProxyId() {
        return userserviceimpl_id;
    }

    public IUserServiceImplImpl(int userserviceimpl_id) {
        this.userserviceimpl_id = userserviceimpl_id;
    }

    public IUserServiceImplImpl() {
        this.userserviceimpl_id = BeanUtil.getBean(UserTemplate.class).createUserServiceImpl1();
        System.out.println("init user service : " + userserviceimpl_id);
    }

    public IUser getUserById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_getUserById(userserviceimpl_id, param_node);
        IUser return_user = new User(return_node.get("return").asInt());
        return return_user;
    }

    public void addUser(IUser u) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("u", ((Proxy)u).getProxyId());
        System.out.println(param_node);
        System.out.println("userservice id : " + userserviceimpl_id);
        System.out.println("user id : " + ((Proxy)u).getProxyId());
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_addUser(userserviceimpl_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void updateUser(IUser u) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("u", ((Proxy)u).getProxyId());
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_updateUser(userserviceimpl_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public void removeUser(int id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("id", id);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_removeUser(userserviceimpl_id, param_node);
        // No need to prepare a void type.;
        // void return type, so no return statement.;
    }

    public List<IUser> listUsers() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_listUsers(userserviceimpl_id);
        List<IUser> return_list = new ArrayList();
        ArrayNode return_list_array = (ArrayNode) return_node.get("return");
        Iterator<JsonNode> return_list_iterator = return_list_array.elements();
        while (return_list_iterator.hasNext()) {
            JsonNode return_list_node = return_list_iterator.next();
            IUser return_list_element = new User(return_list_node.asInt());
            return_list.add(return_list_element);
        } 
        return return_list;
    }

    public boolean isUserValid(String username, String password) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("username", username);
        ((ObjectNode)param_node).put("password", password);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_isUserValid(userserviceimpl_id, param_node);
        boolean return_boolean = return_node.get("return").asBoolean();
        return return_boolean;
    }

    public String toString() {
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_toString(userserviceimpl_id);
        String return_string = return_node.get("return").asText();
        return return_string;
    }

    public IUser getUserByName(String username) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode param_node = mapper.createObjectNode();
        ((ObjectNode)param_node).put("username", username);
        JsonNode return_node = BeanUtil.getBean(UserTemplate.class).UserServiceImpl_getUserByName(userserviceimpl_id, param_node);
        IUser return_user = new User(return_node.get("return").asInt());
        return return_user;
    }
}