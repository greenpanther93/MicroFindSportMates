package wrapper;
import java.util.List;
public interface IUserServiceImpl {
    public IUser getUserById(int id);

    public void addUser(IUser u);

    public void updateUser(IUser u);

    public void removeUser(int id);

    public List<IUser> listUsers();

    public boolean isUserValid(String username, String password);

    public String toString();

    public IUser getUserByName(String username);
}