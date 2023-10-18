package lexicon.se.g46lecturejpa;

import lexicon.se.g46lecturejpa.dao.StudentDao;
import lexicon.se.g46lecturejpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyCommandLineRunner implements CommandLineRunner {
      @Autowired
      StudentDao studentDao ;
      public MyCommandLineRunner(StudentDao studentDao){
          this.studentDao = studentDao ;
      }

    @Override
    public void run(String... args) throws Exception {
         Student student = new Student("Test","Testsson","test@test.se");
         StudentDao.persist(student);

    }
}
