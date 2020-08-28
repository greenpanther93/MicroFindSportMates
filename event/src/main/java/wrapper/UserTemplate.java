package wrapper;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "user-service")
@RibbonClient(name = "user-service")
public interface UserTemplate {
    @GetMapping("/UserService1/")
    public int createUser1();

    @PostMapping("/UserService2/")
    public int createUser2(@RequestBody
    JsonNode node);

    @PostMapping("/UserService/{proxy_id}/setFirstname")
    public JsonNode User_setFirstname(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserService/{proxy_id}/getPhone")
    public JsonNode User_getPhone(@PathVariable
    int proxy_id);

    @PostMapping("/UserService/{proxy_id}/setPassword")
    public JsonNode User_setPassword(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/UserService/{proxy_id}/setLastname")
    public JsonNode User_setLastname(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/UserService/{proxy_id}/setEvents")
    public JsonNode User_setEvents(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserService/{proxy_id}/getId")
    public JsonNode User_getId(@PathVariable
    int proxy_id);

    @GetMapping("/UserService/{proxy_id}/getUsername")
    public JsonNode User_getUsername(@PathVariable
    int proxy_id);

    @GetMapping("/UserService/{proxy_id}/getEvents")
    public JsonNode User_getEvents(@PathVariable
    int proxy_id);

    @PostMapping("/UserService/{proxy_id}/setId")
    public JsonNode User_setId(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserService/{proxy_id}/getFirstname")
    public JsonNode User_getFirstname(@PathVariable
    int proxy_id);

    @PostMapping("/UserService/{proxy_id}/setUsername")
    public JsonNode User_setUsername(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserService/{proxy_id}/getRole")
    public JsonNode User_getRole(@PathVariable
    int proxy_id);

    @PostMapping("/UserService/{proxy_id}/setPhone")
    public JsonNode User_setPhone(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserService/{proxy_id}/getPassword")
    public JsonNode User_getPassword(@PathVariable
    int proxy_id);

    @GetMapping("/UserService/{proxy_id}/getLastname")
    public JsonNode User_getLastname(@PathVariable
    int proxy_id);

    @PostMapping("/UserService/{proxy_id}/setRole")
    public JsonNode User_setRole(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserService/{proxy_id}/toString")
    public JsonNode User_toString(@PathVariable
    int proxy_id);

    @GetMapping("/UserServiceImplService1/")
    public int createUserServiceImpl1();

    @PostMapping("/UserServiceImplService/{proxy_id}/getUserById")
    public JsonNode UserServiceImpl_getUserById(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/UserServiceImplService/{proxy_id}/setuserDAO")
    public JsonNode UserServiceImpl_setuserDAO(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/UserServiceImplService/{proxy_id}/addUser")
    public JsonNode UserServiceImpl_addUser(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/UserServiceImplService/{proxy_id}/updateUser")
    public JsonNode UserServiceImpl_updateUser(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/UserServiceImplService/{proxy_id}/removeUser")
    public JsonNode UserServiceImpl_removeUser(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserServiceImplService/{proxy_id}/listUsers")
    public JsonNode UserServiceImpl_listUsers(@PathVariable
    int proxy_id);

    @PostMapping("/UserServiceImplService/{proxy_id}/isUserValid")
    public JsonNode UserServiceImpl_isUserValid(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/UserServiceImplService/{proxy_id}/toString")
    public JsonNode UserServiceImpl_toString(@PathVariable
    int proxy_id);

    @PostMapping("/UserServiceImplService/{proxy_id}/getUserByName")
    public JsonNode UserServiceImpl_getUserByName(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);
}