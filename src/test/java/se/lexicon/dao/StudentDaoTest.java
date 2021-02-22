package se.lexicon.dao;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Student;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class StudentDaoTest {

    @Autowired
    StudentDao testObject;



    @Test
    public void test_save_student() {
        Student expectedResult = new Student("Test", 1);
        Student actualResult = testObject.save(new Student("Test", 1));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_delete() {
        testObject.save(new Student("Test", 1));
        testObject.save(new Student("Test2", 2));
        testObject.delete(1);
        //Assert.assertEquals();
    }

}
