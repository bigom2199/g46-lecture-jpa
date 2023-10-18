package lexicon.se.g46lecturejpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;


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

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status= true;
        this.createDate = LocalDateTime.now();
    }
}