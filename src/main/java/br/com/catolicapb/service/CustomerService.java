package br.com.catolicapb.service;

import br.com.catolicapb.domain.Customer;
import br.com.catolicapb.dto.CustomerDTO;
import br.com.catolicapb.dto.PetDTO;
import br.com.catolicapb.exception.AlreadyExistsPetToCustomer;
import br.com.catolicapb.mapper.CustomerMapper;
import br.com.catolicapb.mapper.PetMapper;
import br.com.catolicapb.repository.CustomerRepository;
import br.com.catolicapb.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.catolicapb.constants.CustomerConstants.EXIST_PET_TO_CUSTOMER;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final PetService petService;
    private final PetMapper petMapper;

    public void save(CustomerDTO customerDTO) {
        var customer = customerRepository
                .findByCpf(customerDTO.getCpf());

        if (!customer.isPresent()) {
            customer = Optional.of(customerMapper.dtoToEntity(customerDTO));
        } else {
            existsPetsToCustomer(customer.get(), customerDTO.getPetsDTO());
        }

        customerRepository.save(customer.get());
    }

    public void existsPetsToCustomer(Customer customer, Set<PetDTO> pets) {
        if (verifyPetsOfCustomer(customer, pets)) {
            log.error("m=existsPetsToCustomer, exists pet to customer with cpf = {}", customer.getCpf());
            throw new AlreadyExistsPetToCustomer(EXIST_PET_TO_CUSTOMER);
        }
        customer.getPets().addAll(petMapper.dtoToEntity(pets));
    }

    private boolean verifyPetsOfCustomer(Customer customer, Set<PetDTO> pets) {
        var petsName = pets.stream().map(PetDTO::getName)
                .collect(Collectors.toSet());
        return petService.existsPetFromCustomer(customer.getId(), petsName);
    }
}
