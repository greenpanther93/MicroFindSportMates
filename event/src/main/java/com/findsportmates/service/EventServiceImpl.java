package com.findsportmates.service;
import com.findsportmates.dao.EventDAO;
import com.findsportmates.model.Event;
import com.findsportmates.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
    private EventDAO eventDAO;

	public void setEventDAO(EventDAO EventDAO) {
        this.eventDAO = EventDAO;
    }

    public void addEvent(Event e) {
        this.eventDAO.addEvent(e);
    }

    public void updateEvent(Event e) {
        this.eventDAO.updateEvent(e);
    }

    public List<Event> listEvents() {
    	EventDAO test = this.eventDAO;
    	System.err.println(test == null);
        return this.eventDAO.listEvents();
    }

    public Event getEventById(int id) {
        return this.eventDAO.getEventById(id);
    }

    public void removeEvent(int id) {
        this.eventDAO.removeEvent(id);
    }

    public List<Event> listUserEvents(int id) {
        return this.eventDAO.listUserEvents(id);
    }

    public List<Event> searchEvent(String type, String date, String num_L, String num_U) {
        List<Event> list = new LinkedList<Event>();
        System.out.println(type);
        if (type.equals("unrestricted")) {
            list = this.eventDAO.SearchDateTimeRange(date, num_L, num_U);
        } else if (num_L.equals("unrestricted") & num_U.equals("unrestricted")) {
            list = this.eventDAO.SearchType(type);
        } else {
            list = this.eventDAO.SearchTypeAndDateTimeRange(type, date, num_L, num_U);
        }
        return list;
    }

    public void addParticipant(int id, User u) {
        Set<User> p = new HashSet<User>();
        Event e = getEventById(id);
        p.addAll(e.getParticipants());
        for (User user : p) {
            System.out.println("Participants List::" + u);
        }
        // Set<User> p = eventDAO.getParticipants(e.getEventId());
        p.add(u);
        e.setParticipants(p);
        updateEvent(e);
    }
}