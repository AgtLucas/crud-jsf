package Dao;

import Model.Users;
import java.util.List;

/**
 *
 * @author AgtLucas
 */
public interface UsersDao {
    
    public void save(Users users);
    public Users getUsers(long id);
    public List<Users> list();
    public void delete(Users users);
    public void update(Users users);
    
}
