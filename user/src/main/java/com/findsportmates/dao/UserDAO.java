package com.findsportmates.dao;
import com.findsportmates.model.User;
import java.util.List;
public interface UserDAO {
    public void addUser(User u);

    public void updateUser(User u);

    public List<User> listUsers();

    public User getUserById(int id);

    public User getUserByName(String username);

    public void removeUser(int id);
}