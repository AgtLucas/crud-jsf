package Controller;

import Dao.UsersDao;
import Dao.UsersDaoImp;
import Model.Users;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author AgtLucas
 */

@ManagedBean
@SessionScoped
public class UsersController {
    
    private Users users;
    private DataModel listUsers;
    
    public DataModel getListUsers() {
        List<Users> li = new UsersDaoImp().list();
        listUsers = new ListDataModel(li);
        return listUsers;
    }
    
    public Users getUsers() {
        return users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    
    public String preparedAddUsers() {
        users = new Users();
        return "index";
    }
    
    public String preparedAlterUsers() {
        users = (Users) (listUsers.getRowData());
        return "user-dashboard";
    }
    
    public String deleteUsers() {
        Users usersTemp = (Users) (listUsers.getRowData());
        UsersDao dao = new UsersDaoImp();
        dao.delete(usersTemp);
        return "index";
    }
    
    public String addUsers() {
        UsersDao dao = new UsersDaoImp();
        dao.save(users);
        return "index";
    }
    
    public String alterUsers() {
        UsersDao dao = new UsersDaoImp();
        dao.update(users);
        return "user-dashboard";
    }
    
} 
