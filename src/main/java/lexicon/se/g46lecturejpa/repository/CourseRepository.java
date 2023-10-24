package lexicon.se.g46lecturejpa.repository;

import lexicon.se.g46lecturejpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {


}
