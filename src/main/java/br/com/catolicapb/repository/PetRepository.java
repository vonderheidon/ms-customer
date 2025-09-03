package br.com.catolicapb.repository;

import br.com.catolicapb.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("""
            select case when count(c) > 0 then true else false end
            from Pet p join p.customers c
            where c.id = :id and p.name in :petsName
            """)
    Boolean existPetToCustomer(Long id, Set<String> petsName);
}
