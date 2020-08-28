package wrapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "event-service", url = "http://localhost:8082")
@RibbonClient(name = "event-service")
public interface EventTemplate {
    @GetMapping("/EventServiceImplService1/")
    public int createEventServiceImpl1();

    @PostMapping("/EventServiceImplService/{proxy_id}/removeEvent")
    public JsonNode EventServiceImpl_removeEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventServiceImplService/{proxy_id}/listUserEvents")
    public JsonNode EventServiceImpl_listUserEvents(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/EventServiceImplService/{proxy_id}/listEvents")
    public JsonNode EventServiceImpl_listEvents(@PathVariable
    int proxy_id);

    @PostMapping("/EventServiceImplService/{proxy_id}/addEvent")
    public JsonNode EventServiceImpl_addEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventServiceImplService/{proxy_id}/getEventById")
    public JsonNode EventServiceImpl_getEventById(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventServiceImplService/{proxy_id}/updateEvent")
    public JsonNode EventServiceImpl_updateEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventServiceImplService/{proxy_id}/addParticipant")
    public JsonNode EventServiceImpl_addParticipant(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/EventServiceImplService/{proxy_id}/toString")
    public JsonNode EventServiceImpl_toString(@PathVariable
    int proxy_id);

    @PostMapping("/EventServiceImplService/{proxy_id}/searchEvent")
    public JsonNode EventServiceImpl_searchEvent(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventServiceImplService/{proxy_id}/setEventDAO")
    public JsonNode EventServiceImpl_setEventDAO(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/EventService1/")
    public int createEvent1();

    @PostMapping("/EventService2/")
    public int createEvent2(@RequestBody
    JsonNode node);

    @GetMapping("/EventService/{proxy_id}/getEventPlace")
    public JsonNode Event_getEventPlace(@PathVariable
    int proxy_id);

    @PostMapping("/EventService/{proxy_id}/setEventType")
    public JsonNode Event_setEventType(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventService/{proxy_id}/setParticipants")
    public JsonNode Event_setParticipants(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/EventService/{proxy_id}/getEventTime")
    public JsonNode Event_getEventTime(@PathVariable
    int proxy_id);

    @GetMapping("/EventService/{proxy_id}/getEventId")
    public JsonNode Event_getEventId(@PathVariable
    int proxy_id);

    @GetMapping("/EventService/{proxy_id}/getParticipants")
    public JsonNode Event_getParticipants(@PathVariable
    int proxy_id);

    @PostMapping("/EventService/{proxy_id}/setEventId")
    public JsonNode Event_setEventId(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventService/{proxy_id}/setEventTime")
    public JsonNode Event_setEventTime(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventService/{proxy_id}/setEventPlace")
    public JsonNode Event_setEventPlace(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @PostMapping("/EventService/{proxy_id}/setHostId")
    public JsonNode Event_setHostId(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);

    @GetMapping("/EventService/{proxy_id}/getEventType")
    public JsonNode Event_getEventType(@PathVariable
    int proxy_id);

    @GetMapping("/EventService/{proxy_id}/getEventDate")
    public JsonNode Event_getEventDate(@PathVariable
    int proxy_id);

    @GetMapping("/EventService/{proxy_id}/getHostId")
    public JsonNode Event_getHostId(@PathVariable
    int proxy_id);

    @GetMapping("/EventService/{proxy_id}/toString")
    public JsonNode Event_toString(@PathVariable
    int proxy_id);

    @PostMapping("/EventService/{proxy_id}/setEventDate")
    public JsonNode Event_setEventDate(@PathVariable
    int proxy_id, @RequestBody
    JsonNode node);
}