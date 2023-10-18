package lexicon.se.g46lecturejpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lexicon.se.g46lecturejpa.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
  @Repository
public class StudentDaoImpl  implements StudentDao{
    @PersistenceContext
     private EntityManager entityManager;

    @Override
    @Transactional
    public Student persist(Student student) {
        entityManager.persist(student); // insert into student( first_Name,last_Name,email,id)
        return student;
    }

    @Override
    public Optional<Student> findById(Student id) {
             Student foundStudent= entityManager.find(Student.class,id);
        return Optional.ofNullable(foundStudent);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
      return  entityManager.createQuery("select S from Student s where s.email =:em",Student.class)
                  .setParameter("em",email)
                  .getResultList()
                  .stream().findFirst();

    }

    @Override
    public Collection<Student> findByFirstNameContains(String firstName) {
        return null;
    }

    @Override
    public Collection<Student> findAll() {
      return   entityManager.createQuery("select  s from Student s",Student.class).getResultList();

    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);

    }

    @Override
    public void remove(String id) {
        Student foundStudent = entityManager.find(Student.class,id);
        if (foundStudent != null) entityManager.remove(foundStudent);

    }

}




