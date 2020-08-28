package wrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.findsportmates.dao.UserDAO;
import com.findsportmates.model.User;
import com.findsportmates.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserServiceImplWebService {
	
	@Autowired
	UserDAO userDAO;

    @GetMapping("/UserServiceImplService1/")
    int createUserServiceImpl1() {
        UserServiceImpl userserviceimpl = new UserServiceImpl();
        userserviceimpl.setuserDAO(userDAO);
        return InstanceDatabase.addObject(userserviceimpl);
    }

    @Transactional
    @PostMapping("/UserServiceImplService/{proxy_id}/getUserById")
    public JsonNode getUserById(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        int id = node.get("id").asInt();
        User return_user = userserviceimpl.getUserById(id);
        ((ObjectNode)return_node).put("return", InstanceDatabase.addObject(return_user));
        return return_node;
    }

//    @PostMapping("/UserServiceImplService/{proxy_id}/setuserDAO")
//    public JsonNode setuserDAO(@PathVariable
//    int proxy_id, @RequestBody
//    JsonNode node) {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode return_node = mapper.createObjectNode();
//        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
//        UserDAO userDAO = (UserDAO)InstanceDatabase.getObject(node.get("userDAO").asInt());
//        userserviceimpl.setuserDAO(userDAO);
//        // No need to prepare a void type.;
//        return return_node;
//    }

    @Transactional
    @PostMapping("/UserServiceImplService/{proxy_id}/addUser")
    public JsonNode addUser(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        System.out.println(node);
        User u = (User)InstanceDatabase.getObject(node.get("u").asInt());
        System.out.println("User fetched from InstanceDatabase" + u.getUsername());
        userserviceimpl.addUser(u);
        // No need to prepare a void type.;
        return return_node;
    }

    @Transactional
    @PostMapping("/UserServiceImplService/{proxy_id}/updateUser")
    public JsonNode updateUser(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        User u = (User)InstanceDatabase.getObject(node.get("u").asInt());
        userserviceimpl.updateUser(u);
        // No need to prepare a void type.;
        return return_node;
    }

    @Transactional
    @PostMapping("/UserServiceImplService/{proxy_id}/removeUser")
    public JsonNode removeUser(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        int id = node.get("id").asInt();
        userserviceimpl.removeUser(id);
        // No need to prepare a void type.;
        return return_node;
    }

    @Transactional
    @GetMapping("/UserServiceImplService/{proxy_id}/listUsers")
    public JsonNode listUsers(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        List<User> return_list = userserviceimpl.listUsers();
        ArrayNode return_node_list = mapper.createArrayNode();
        ((ObjectNode)return_node).put("return", return_node_list);
        for (User return_list_element : ((Iterable<User>)return_list)) {
            return_node_list.add(InstanceDatabase.addObject(return_list_element));
        }
        return return_node;
    }

    @Transactional
    @PostMapping("/UserServiceImplService/{proxy_id}/isUserValid")
    public JsonNode isUserValid(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        String username = node.get("username").asText();
        String password = node.get("password").asText();
        boolean return_boolean = userserviceimpl.isUserValid(username, password);
        ((ObjectNode)return_node).put("return", return_boolean);
        return return_node;
    }

    @GetMapping("/UserServiceImplService/{proxy_id}/toString")
    public JsonNode toString(@PathVariable
    int proxy_id) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        String return_string = userserviceimpl.toString();
        ((ObjectNode)return_node).put("return", return_string);
        return return_node;
    }

    @Transactional
    @PostMapping("/UserServiceImplService/{proxy_id}/getUserByName")
    public JsonNode getUserByName(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode return_node = mapper.createObjectNode();
        UserServiceImpl userserviceimpl = (UserServiceImpl)InstanceDatabase.getObject(proxy_id);
        String username = node.get("username").asText();
        User return_user = userserviceimpl.getUserByName(username);
        ((ObjectNode)return_node).put("return", InstanceDatabase.addObject(return_user));
        return return_node;
    }
}