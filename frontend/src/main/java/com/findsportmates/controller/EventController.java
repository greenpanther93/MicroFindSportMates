package com.findsportmates.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import wrapper.IEvent;
import wrapper.Event;
import wrapper.IEventServiceImpl;
import wrapper.IEventServiceImplImpl;
import wrapper.IUser;
import wrapper.IUserServiceImpl;
import wrapper.IUserServiceImplImpl;
import wrapper.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
/* @RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
public String showUpdateTodoPage(ModelMap model,@PathVariable("eventId") int eventId){
model.addAttribute("event", this.eventService.getEventById(eventId));
return "event"; 
}

@RequestMapping("/edit/{eventId}")
public String editEvent(@PathVariable("eventId") int eventId, Model model) {
Event e = this.eventService.getEventById(eventId);
this.eventService.updateEvent(e);
return "redirect:/main-menu";
}
 */
@Controller
@SessionAttributes("userid")
public class EventController {
    private IEventServiceImpl eventService;

    private IUserServiceImpl userService;

    @Autowired(required = true)
    @Qualifier("eventService")
    public void setEventService(IEventServiceImpl es) {
        System.err.println("Event controller setter called to place event service bean "+((Proxy) es).getProxyId());
        this.eventService = es;
    }

    @Autowired(required = true)
    @Qualifier("userService")
    public void setUserService(IUserServiceImpl us) {
        System.err.println("Event controller setter called to place user service bean "+((Proxy) us).getProxyId());
        this.userService = us;
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String showMainPage(ModelMap model) {
    	System.out.println("event main page");
        List<IEvent> e = this.eventService.listEvents();
        List<String> username = new ArrayList<String>();
        for (IEvent tmpEvent : e) {
            int tmpid = tmpEvent.getHostId();
            IUser tmpuser = userService.getUserById(tmpid);
            username.add(tmpuser.getUsername());
        }
        model.addAttribute("events", e);
        model.addAttribute("hosts", username);
        return "/main-menu";
    }

    @RequestMapping(value = "/manage-event", method = RequestMethod.GET)
    public String showUserEvents(ModelMap model) {
        model.addAttribute("events", this.eventService.listUserEvents(Integer.parseInt(((String) (model.get("userid"))))));
        return "manage-event";
    }

    @RequestMapping(value = "/add-event", method = RequestMethod.GET)
    public String showAddEventPage(ModelMap model) {
        model.addAttribute("event", new Event());
        return "event";
    }

    @RequestMapping(value = "/add-event", method = RequestMethod.POST)
    public String addEvent(ModelMap model, Event event) {
        // System.out.println(event.getEventPlace() + (String)model.get("userid"));
        int userid = Integer.parseInt(((String) (model.get("userid"))));
        IUser host = userService.getUserById(userid);
        event.setHostId(userid);
        Set<IUser> p = new HashSet<IUser>();
        p.add(host);
        event.setParticipants(p);
        // System.out.println(event);
        this.eventService.addEvent(event);
        return "redirect:/event";
    }

    @RequestMapping("/remove/{eventId}")
    public String removeEvent(@PathVariable("eventId")
    int eventId) {
        this.eventService.removeEvent(eventId);
        return "redirect:/manage-event";
    }

    @RequestMapping("/join/{eventId}")
    public String joinEvent(ModelMap model, @PathVariable("eventId")
    int eventId) {
        System.out.println("join event:" + eventId);
        int userid = Integer.parseInt(((String) (model.get("userid"))));
        IUser p = userService.getUserById(userid);
        this.eventService.addParticipant(eventId, p);
        return "redirect:/event";
    }

    @RequestMapping(value = "/search-event", method = RequestMethod.GET)
    public String showSearchPage(ModelMap model) {
        model.addAttribute("event", new Event());
        return "searchevent";
    }

    @RequestMapping(value = "/search-event", method = RequestMethod.POST)
    public String searchtEvent(ModelMap model, @RequestParam("type")
    String type, @RequestParam("date")
    String date, @RequestParam("time1")
    String num_L, @RequestParam("time2")
    String num_U) {
        System.out.println((((((("test:  " + type) + "   ") + date) + "   ") + num_L) + "   ") + num_U);
        List<IEvent> result = this.eventService.searchEvent(type, date, num_L, num_U);
        Iterator<IEvent> listI = result.iterator();
        while (listI.hasNext()) {
            IEvent event = ((IEvent) (listI.next()));
            System.out.println((((event.getEventType() + event.getEventDate()) + event.getEventTime()) + event.getEventPlace()) + event.getHostId());
        } 
        List<String> username = new ArrayList<String>();
        for (IEvent tmpEvent : result) {
            int tmpid = tmpEvent.getHostId();
            IUser tmpuser = userService.getUserById(tmpid);
            username.add(tmpuser.getUsername());
            System.out.println("host:" + tmpuser.getUsername());
        }
        model.addAttribute("events", result);
        model.addAttribute("hosts", username);
        return "searchevent_result";
    }
}