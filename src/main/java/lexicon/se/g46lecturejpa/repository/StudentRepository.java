package lexicon.se.g46lecturejpa.repository;

import lexicon.se.g46lecturejpa.entity.Course;
import lexicon.se.g46lecturejpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    List<Student> findByFirstName(String firstName);
    @Query("select s from Student s where s.firstName = : fn")
   List<Student> selectStudentByFirstName(@Param("fn")String firstName);

  List<Student> findByFirstNameContains(String firstName);
   List<Student> findByStatusTrue();
   Student findByEmailIgnoreCase(String email);
   @Modifying
   @Query("update Student S set s.status = true  where s.id = :id")

 void updateStudentStatusToTrue(@Param("studentId")String studentId);

    List<Student> findByCourses_Id(Long courseId);
  List<Student> findByCourses_CourseNameContains(String CourseName);

}
