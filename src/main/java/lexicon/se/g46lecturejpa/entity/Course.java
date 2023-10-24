package lexicon.se.g46lecturejpa.entity;

import jakarta.persistence.*;
import lexicon.se.g46lecturejpa.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Course {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(updatable = false)

private Long id;
   @Column(nullable = false,length = 100)
   private String CourseName;
   @ManyToOne
   @JoinColumn(name = "student_id")
   private Student student;
   public Course(String courseName) {
     this. CourseName = courseName;
   }
}