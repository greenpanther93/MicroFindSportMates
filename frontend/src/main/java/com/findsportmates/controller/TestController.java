package com.findsportmates.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wrapper.Event;
import wrapper.IEvent;
import wrapper.IEventServiceImpl;
import wrapper.IUser;
import wrapper.IUserServiceImpl;
import wrapper.Proxy;
import wrapper.User;

@Controller
public class TestController {
	
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

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testRegisterLoginCreateEvent1000(ModelMap model) {
		int nbCycles = 1000;
		List<Long> executionTimes = new ArrayList<Long>();
		for(int count = 0; count<nbCycles;count++) {
			
			// begin clock
			long startTime = System.currentTimeMillis();
			
			String username = "username"+count;
			String password = "pwd";
			
			// register call
			User user = new User(0, "username"+count, "pwd", "CU Faculty", "11122", "fn", "ln",new HashSet<IEvent>() );
			this.userService.addUser(user);
			
			// login call
			if(!userService.isUserValid(username, password)){
				model.put("errorMsg", "Invalid user");
				return "login";
			}
			model.addAttribute("userid", Integer.toString(userService.getUserByName(username).getId()));
			
			// add event
			// int eventId, int hostId, String eventType, String eventTime, String eventDate, String eventPlace
			Event event = new Event(0,0,"Volleyball", "10:00-12:00", "08/17/2020", "Volleyball Court 1");
			int userid = Integer.parseInt((String)model.get("userid"));
			IUser host = userService.getUserById(userid);
			event.setHostId(userid);
			Set<IUser> p = new HashSet<IUser>();
			p.add(host);
			event.setParticipants(p);
			//System.out.println(event);
			this.eventService.addEvent(event);
			
			// stop clock and calculate time
			long endTime = System.currentTimeMillis();
			long executionTimeInMS = endTime-startTime;
			executionTimes.add(executionTimeInMS);
		}
		executionTimes.sort(null);
		long averageTime = executionTimes.stream().reduce(0L, (a,b) -> a + b) / nbCycles;
		long minTime = executionTimes.get(0); // executionTimes.stream().mapToLong(v -> v).min().getAsLong();
		long maxTime = executionTimes.get(executionTimes.size()-1); //executionTimes.stream().mapToLong(v -> v).max().getAsLong();
		long median = 0;
		if(nbCycles % 2 == 0) {
			median = (executionTimes.get(nbCycles/2-1) + executionTimes.get(nbCycles/2)) / 2; // median for even numbered list
		}else {
			median = (executionTimes.get(nbCycles/2));
		}
		long firstQuartile = executionTimes.get(nbCycles/4);
		long thirdQuartile = executionTimes.get(3*(nbCycles/4));
		String printout = "Nb of cycles: " + nbCycles;
		printout += "\n average time of execution: " + averageTime + "ms";
		printout += "\n median time of execution: " + median + "ms";
		printout += "\n first quartile time of execution: " + firstQuartile + "ms";
		printout += "\n third quartile time of execution: " + thirdQuartile + "ms";
		printout += "\n min execution: " + minTime + "ms";
		printout += "\n max execution: " + maxTime + "ms";
		System.out.println(printout);
		return "main-menu";
	}
}
