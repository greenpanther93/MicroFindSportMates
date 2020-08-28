package com.findsportmates.dao;
import com.findsportmates.model.User;

import wrapper.UserRepository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

//    private SessionFactory sessionFactory;
    
    @Autowired
    UserRepository userRepository;

//    public void setSessionFactory(SessionFactory sf) {
//        this.sessionFactory = sf;
//    }

    public void addUser(User u) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.persist(u);
        userRepository.save(u);
        logger.info("User saved successfully, User Details=" + u);
    }

    public void updateUser(User u) {
//        Session session = this.sessionFactory.getCurrentSession();
//        session.update(u);
    	userRepository.save(u);
        logger.info("Event updated successfully, Event Details=" + u);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
//        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = new ArrayList<>();
        for (User u : userRepository.findAll()) {
            logger.info("User List::" + u);
            usersList.add(u);
        }
        return usersList;
    }

    public User getUserById(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        User u = ((User) (session.load(User.class, new Integer(id))));
//        logger.info("User loaded successfully, User details=" + u);
        return userRepository.findById(id).get();
    }

    public void removeUser(int id) {
    	userRepository.deleteById(id);
//        Session session = this.sessionFactory.getCurrentSession();
//        User u = ((User) (session.load(User.class, new Integer(id))));
//        if (null != u) {
//            session.delete(u);
//        }
        logger.info("User deleted successfully, User details=");
    }

    @SuppressWarnings("unchecked")
    public User getUserByName(String username) {
    	return userRepository.findByUsername(username).get();
//        Session session = this.sessionFactory.getCurrentSession();
//        List<User> usersList = session.createQuery(("from User user where user.username='" + username) + "'").list();
//        logger.info("User loaded successfully, User details=" + usersList.get(0));
//        return usersList.get(0);
    }
}