package se.lexicon.dao;



import se.lexicon.model.Student;
import java.util.List;



public interface StudentDao {
    Student save(Student student);
    Student find(int id);
    List<Student> findAll();
    void delete(int id);
}
