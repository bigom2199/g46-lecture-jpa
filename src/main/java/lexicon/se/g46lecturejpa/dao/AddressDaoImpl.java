package lexicon.se.g46lecturejpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lexicon.se.g46lecturejpa.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
   @Repository
public class AddressDaoImpl implements AddressDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address persist(Address address) {
        entityManager. persist(address);
        return address;
    }

    @Override
    public Optional<Address> findById(Long id) {
        Address foundAddress = entityManager.find(Address.class,id);
        return Optional.ofNullable(foundAddress);
    }

    @Override
    public Collection<Address> findAll() {
     return    entityManager.createQuery("select  a from Address a",Address.class).getResultList();

    }

    @Override
    public void update(Address address) {
  entityManager.merge(address);
    }

    @Override
    public void remove(Long id) {
   Address foundAddress = entityManager.find(Address.class,id);
   if (foundAddress == null){

   }
         entityManager.remove(foundAddress);
    }
}
