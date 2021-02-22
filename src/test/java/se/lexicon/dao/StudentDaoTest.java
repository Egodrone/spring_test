package se.lexicon.dao;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Student;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class StudentDaoTest {

    @Autowired
    StudentDao testObject;



    @Before
    public void setup() {

        int a = 0;

        while (a < 6) {
            testObject.delete(a);
            a += 1;
        }

    }



    @Test
    public void test_save_student() {
        Student expectedResult = new Student("Test", 1);
        Student actualResult = testObject.save(new Student("Test", 1));
        Assert.assertEquals(expectedResult, actualResult);
    }



    @Test
    public void test_find_student_by_id() {
        Student expectedResult = new Student("Test", 1);
        testObject.save(new Student("Sven", 1));
        testObject.save(new Student("Hanna", 2));
        Student actualResult = testObject.save(new Student("Hanna", 3));
        Student findById = testObject.find(3);
        Assert.assertEquals(findById.getName(), actualResult.getName());
    }



    @Test
    public void test_find_all_students() {
        testObject.save(new Student("Sven", 1));
        testObject.save(new Student("Hanna", 2));
        testObject.save(new Student("Hanna", 3));
        List<Student> studentList = testObject.findAll();
        Assert.assertEquals(3, studentList.size());
    }



    @Test
    public void test_delete() {
        testObject.save(new Student("Sven", 1));
        testObject.save(new Student("Hanna", 2));
        testObject.delete(1);
        List<Student> studentList = testObject.findAll();
        studentList.forEach(System.out::println);
        Assert.assertEquals(1, studentList.size());
    }

}
