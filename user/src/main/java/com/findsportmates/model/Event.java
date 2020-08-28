package com.findsportmates.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid")
    private int eventId;

    @Column(name = "hostid")
    private int hostId;

    @Column(name = "type")
    private String eventType;

    /* @Column(name = "datetime") 
    private Date eventTime;
     */
    @Column(name = "time")
    private String eventTime;

    @Column(name = "date")
    private String eventDate;

    @Column(name = "place")
    private String eventPlace;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Event_User", joinColumns = { @JoinColumn(name = "eventid") }, inverseJoinColumns = { @JoinColumn(name = "userid") })
    private Set<User> participants = new HashSet<User>();

    public Event() {
        super();
    }

    public Event(int eventId, int hostId, String eventType, String eventTime, String eventDate, String eventPlace) {
        super();
        this.eventId = eventId;
        this.hostId = hostId;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return ((((((((((("Event [eventId=" + eventId) + ", hostId=") + hostId) + ", eventType=") + eventType) + ", eventTime=") + eventTime) + ", eventDate=") + eventDate) + ", eventPlace=") + eventPlace) + "]";
    }
}