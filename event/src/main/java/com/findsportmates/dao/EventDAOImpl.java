package com.findsportmates.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.findsportmates.model.Event;

import wrapper.EventRepository;
@Repository
public class EventDAOImpl implements EventDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventDAOImpl.class);

	//    @Autowired
	//	private SessionFactory sessionFactory;

	@Autowired
	EventRepository eventRepository;

//	public void setSessionFactory(SessionFactory sf) {
//		this.sessionFactory = sf;
//	}

	public void addEvent(Event e) {
		eventRepository.save(e);
		logger.info("Event saved successfully, Event Details=" + e);
	}

	public void updateEvent(Event e) {
		eventRepository.save(e);
		//        Session session = this.sessionFactory.getCurrentSession();
		//        session.update(e);
		logger.info("Event updated successfully, Event Details=" + e);
	}

	@SuppressWarnings("unchecked")
	public List<Event> listEvents() {
		List<Event> eventsList = new ArrayList<Event>();
		for (Event e : eventRepository.findAll()) {
			eventsList.add(e);
			logger.info("Event List::" + e);
		}
		return eventsList;
	}

	@SuppressWarnings("unchecked")
	public List<Event> listUserEvents(int id) {
		List<Event> eventsList = new ArrayList<Event>();
		for (Event e : eventRepository.findByHostId(id)) {
			eventsList.add(e);
			logger.info("Event List::" + e);
		}
		return eventsList;
	}

	public Event getEventById(int id) {
		Optional<Event> event = eventRepository.findById(id);
		logger.info("Event loaded successfully, Event details=" + event.get());
		return event.get();
	}

	public void removeEvent(int id) {
		eventRepository.deleteById(id);
		logger.info("Event deleted successfully.");
	}

	@SuppressWarnings("unchecked")
	public List<Event> SearchTypeAndDateTime(String _type, String _date, String _time) {
		// use HQL to search
		//        Session session = this.sessionFactory.getCurrentSession();
		//        String hql = (((((((((((("from Event event where event.eventType like" + "'%") + _type) + "%'") + " and ") + "event.eventDate like") + "'%") + _date) + "%'") + " and ") + "event.eventTime like ") + "'%") + _time) + "%'";
		//        Query query = session.createQuery(hql);
		List<Event> events = eventRepository.searchTypeAndDateTime(_type, _date, _time);
		return events;
	}

	@SuppressWarnings("unchecked")
	public List<Event> SearchType(String _type) {
		// use HQL to search
		//        Session session = this.sessionFactory.getCurrentSession();
		//        String hql = (("from Event event where event.eventType like" + "'%") + _type) + "%'";
		//        Query query = session.createQuery(hql);
		//        List<Event> result = query.list();
		//        return result;
		List<Event> events = eventRepository.searchType(_type);
		return events;
	}

	@SuppressWarnings("unchecked")
	public List<Event> SearchDateTime(String _date, String _time) {
		// use HQL to search
		//		Session session = this.sessionFactory.getCurrentSession();
		//		String hql = ((((((("from Event event where event.eventDate like" + "'%") + _date) + "%'") + " and ") + "event.eventTime like ") + "'%") + _time) + "%'";
		//		Query query = session.createQuery(hql);
		//		List<Event> result = query.list();
		//		return result;
		List<Event> events = eventRepository.searchDateTime(_date,_time);
		return events;
	}

	public List<Event> SearchDateTimeRange(String _date, String num_L, String num_U) {
		int Int_num_L = toIntTime(num_L);
		int Int_num_U = toIntTime(num_U);
		String time;
		List<Event> list = new LinkedList<Event>();
		for (int i = Int_num_L; i <= Int_num_U; i++) {
			time = toSTime(i);
			List<Event> result = SearchDateTime(_date, time);
			Iterator<Event> events = result.iterator();
			while (events.hasNext()) {
				Event event = ((Event) (events.next()));
				list.add(((Event) (event)));
			} 
		}
		return list;
	}

	public List<Event> SearchTypeAndDateTimeRange(String type, String date, String num_L, String num_U) {
		int Int_num_L = toIntTime(num_L);
		int Int_num_U = toIntTime(num_U);
		String time;
		List<Event> list = new LinkedList<Event>();
		for (int i = Int_num_L; i <= Int_num_U; i++) {
			time = toSTime(i);
			List<Event> result = SearchTypeAndDateTime(type, date, time);
			Iterator<Event> events = result.iterator();
			while (events.hasNext()) {
				Event event = ((Event) (events.next()));
				list.add(((Event) (event)));
			} 
		}
		return list;
	}

	public static int toIntTime(String s) {
		String[] hourMin = s.split(":");
		int hour = Integer.parseInt(hourMin[0]);
		return hour;
	}

	public static String toSTime(int _i) {
		String s1;
		String s2;
		if (_i < 10) {
			s1 = "0" + Integer.toString(_i);
		} else {
			s1 = Integer.toString(_i);
		}
		if ((_i + 2) < 10) {
			s2 = "0" + Integer.toString(_i + 2);
		} else {
			s2 = Integer.toString(_i + 2);
		}
		String s = ((s1 + ":00-") + s2) + ":00";
		return s;
	}
}