package se.lexicon.service;



import org.springframework.stereotype.Component;
import se.lexicon.model.Student;
import java.util.List;



@Component("studentManagementDao")
public class StudentManagementConsoleImpl implements StudentManagement{

    @Override
    public Student create() {
        Student newStudent = new Student("Sonja");

        return newStudent;
    }



    @Override
    public Student save(Student student) {
        return null;
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
