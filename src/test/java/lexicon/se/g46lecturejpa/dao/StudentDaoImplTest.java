package lexicon.se.g46lecturejpa.dao;


import jakarta.transaction.Transactional;
import lexicon.se.g46lecturejpa.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
 @Rollback
public class StudentDaoImplTest {

       @Autowired
    StudentDaoImpl studentDao ;
       @Test
       public void testPersistStudent(){
           // Arrange
           Student student = new Student("John","Doe","john@test.se");
           // Act
           Student insertedStudent = studentDao.persist(student);
           // Assert
           assertNotNull(insertedStudent);
       }
      // todo: ADD MORE TESTS ...
}
