package br.com.catolicapb.repository;

import br.com.catolicapb.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCpfAndIsActiveTrue(String cpf);
}
