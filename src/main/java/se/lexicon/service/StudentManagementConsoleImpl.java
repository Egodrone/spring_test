package se.lexicon.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.gui.GuiService;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;
import java.util.List;



@Component("studentManagementService")
public class StudentManagementConsoleImpl implements StudentManagement {

    private StudentDao studentDao;
    private UserInputService userInputService;
    private GuiService guiService;



    //gui
/*    @Autowired
    public void setGuiService(GuiService guiService) {
        this.guiService = guiService;
    }*/



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
        String studentToAdd = userInputService.getString();
        Student newStudent = new Student(studentToAdd);

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
        int studentId = userInputService.getInt();
        System.out.println("!!!!!!!!!!! " + studentId);
        Student findByIdStudent = find(studentId);

        if(findByIdStudent == null) throw new IllegalArgumentException("Student id is null");
        String newStudentName = userInputService.getString();
        findByIdStudent.setName(newStudentName);
        student.setName(findByIdStudent.getName());

        return student;
    }



}
