package Dao;

import Model.Subjects;
import java.util.List;

/**
 *
 * @author AgtLucas
 */
public interface SubjectsDao {
    
    public void save(Subjects subjetcs);
    public Subjects getSubjects(long id);
    public List<Subjects> list();
    public void delete(Subjects subjects);
    public void update(Subjects subjects);
    
}
