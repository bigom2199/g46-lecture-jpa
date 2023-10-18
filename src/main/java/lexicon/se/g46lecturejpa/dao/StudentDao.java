package lexicon.se.g46lecturejpa.dao;

import lexicon.se.g46lecturejpa.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao {
    Student persist(Student student);
    Optional<Student> findById(Student id);
    Optional<Student> findByEmail(String email);
          Collection<Student> findByFirstNameContains(String firstName);
          Collection<Student> findAll();
          void update(Student student);
          void remove(String id);
}
