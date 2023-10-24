package lexicon.se.g46lecturejpa.entity;

import jakarta.persistence.*;
import lexicon.se.g46lecturejpa.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String street;
    private String city;
    @Column(nullable = false,length = 6)
    private String zipCode;

    @OneToOne(mappedBy = "address")

  private Student student;
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}

