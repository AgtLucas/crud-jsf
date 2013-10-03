package Dao;

import Utils.HibernateUtil;
import Model.Users;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AgtLucas
 */
public class UsersDaoImp implements UsersDao {
    
    @Override
    public void save(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(users);
        t.commit();
    }

    @Override
    public Users getUsers(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Users) session.load(Users.class, id);
    }

    @Override
    public List<Users> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List li = session.createQuery("from Users").list();
        t.commit();
        return li;
    }

    @Override
    public void delete(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(users);
        t.commit();
    }

    @Override
    public void update(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(users);
        t.commit();
    }
    
}
