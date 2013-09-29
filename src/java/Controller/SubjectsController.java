package Controller;

import Dao.SubjectsDao;
import Dao.SubjectsDaoImp;
import Model.Subjects;
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
public class SubjectsController {
    
    private Subjects subjects;
    private DataModel listSubjects;
    
    public DataModel getListSubjects() {
        List<Subjects> li = new SubjectsDaoImp().list();
        listSubjects = new ListDataModel(li);
        return listSubjects;
    }
    
    public Subjects getSubjects() {
        return subjects;
    }
    
    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
    
    public String prepareAddSubjects() {
        subjects = new Subjects();
        return "manageSubjects";
    }
    
    public String prepareAlterSubjects() {
        subjects = (Subjects)(listSubjects.getRowData());
        return "manageSubjects";
    }
    
    public String deleteSubjects() {
        Subjects subjectsTemp = (Subjects)(listSubjects.getRowData());
        SubjectsDao dao = new SubjectsDaoImp();
        dao.delete(subjectsTemp);
        return "index";
    }
    
    public String addSubjects() {
        SubjectsDao dao = new SubjectsDaoImp();
        dao.save(subjects);
        return "index";
    }
    
    public String alterSubjetcs() {
        SubjectsDao dao = new SubjectsDaoImp();
        dao.update(subjects);
        return "index";
    }
    
}
