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
        if (student == null) throw new IllegalArgumentException(" Student is null ");
        if (student.getName() == null) throw new IllegalArgumentException(" Student name is null ");
        return studentDao.save(student);
    }



    @Override
    public Student find(int id) {
        if (id < 1) throw new IllegalArgumentException(" Student id is not valid ");

        return studentDao.find(id);
    }



    @Override
    public Student remove(int id) {
        if (id < 1) throw new IllegalArgumentException(" Student id is not valid ");
        //if student with that id exist, call function below
        Student tmpStudent = find(id);
        if(tmpStudent.getName() != null) {
            studentDao.delete(id);
        } else {
            throw new IllegalArgumentException(" There is no student with provided id ");
        }

        return tmpStudent;
    }



    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }



    @Override
    public Student edit(Student student) {
        return null;
    }



}
