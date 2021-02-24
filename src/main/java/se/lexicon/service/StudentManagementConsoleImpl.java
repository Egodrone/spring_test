package se.lexicon.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;
import java.util.List;



@Component("studentManagementService")
public class StudentManagementConsoleImpl implements StudentManagement {

    private StudentDao studentDao;
    private UserInputService userInputService;



    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }



    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }



    @Override
    public Student create() {
        Student newStudent = new Student("Sonja");

        return newStudent;
    }



    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }



    @Override
    public Student find(int id) {
        return null;
    }



    @Override
    public Student remove(int id) {
        return null;
    }



    @Override
    public List<Student> findAll() {
        return null;
    }



    @Override
    public Student edit(Student student) {
        return null;
    }



}
