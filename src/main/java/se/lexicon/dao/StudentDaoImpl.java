package se.lexicon.dao;



import se.lexicon.dao.sequencer.Sequencer;
import se.lexicon.model.Student;
import java.util.ArrayList;
import java.util.List;



public class StudentDaoImpl implements StudentDao {
    private List<Student> StudentsReg = new ArrayList<>();

    @Override
    public Student save(Student student) {
        Student p1 = new Student();

        if(student != null) {
            //p1.setId(Sequencer.nextStudentUserId());
            p1.setId(student.getId());
            p1.setName(student.getName());
            StudentsReg.add(student);
        }

        return p1;
    }



    @Override
    public Student find(int id) {

        if(id == 0) {
            throw  new IllegalArgumentException("Id should not be null");
        }

        return StudentsReg.stream().filter(p1->p1.getId() == id).findFirst().orElse(null);
    }



    @Override
    public List<Student> findAll() {

        return StudentsReg;
    }



    @Override
    public void delete(int id) {
        StudentsReg.removeIf(p -> p.getId() == id);
    }



}
