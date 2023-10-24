package lexicon.se.g46lecturejpa.repository;

import lexicon.se.g46lecturejpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    // add more methods ...
}
