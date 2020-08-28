package com.findsportmates.service;
import com.findsportmates.model.User;
import java.util.List;
public interface UserService {
    public void addUser(User u);

    public void updateUser(User u);

    public List<User> listUsers();

    public User getUserById(int id);

    public User getUserByName(String username);

    public void removeUser(int id);

    boolean isUserValid(String username, String password);
}