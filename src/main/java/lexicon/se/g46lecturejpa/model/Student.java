package lexicon.se.g46lecturejpa.model;

import jakarta.persistence.*;
import lexicon.se.g46lecturejpa.entity.Address;
import lexicon.se.g46lecturejpa.entity.Course;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    @Entity
   public class Student{


    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id-UUIDGenerator")
     private  Integer id;
    @Setter
    @Column(nullable = false,length = 100)
     private String firstName;

    @Setter
    @Column(nullable = false,length = 100)

     private String lastName;

    @Setter
    @Column(nullable = false,unique = true)
     private String email;

     private boolean status;
     private LocalDate createDate ;
     @Setter
     @OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
     @JoinColumn(name = "address_id")
   private Address address ;

   @OneToMany(mappedBy = "Student")
     private Set<Course> courses = new HashSet<>();
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status= true;
        this.createDate = LocalDateTime.now();

    }
    public void addCourse(Course course){
        courses.add(course);
        course.setStudent(this);

    }
    public void removeCourse(Course course){
      courses.remove(course);
      course.setStudent(null);

    }
}