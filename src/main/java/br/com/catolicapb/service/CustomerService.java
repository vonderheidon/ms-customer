package br.com.catolicapb.service;

import br.com.catolicapb.domain.Customer;
import br.com.catolicapb.dto.CustomerDTO;
import br.com.catolicapb.dto.PetDTO;
import br.com.catolicapb.exception.AlreadyPetToCustomerException;
import br.com.catolicapb.exception.CustomerNotFoundException;
import br.com.catolicapb.mapper.ContactMapper;
import br.com.catolicapb.mapper.CustomerMapper;
import br.com.catolicapb.mapper.PetMapper;
import br.com.catolicapb.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.catolicapb.constants.CustomerConstants.CUSTOMER_MESSAGE_NOT_FOUND_404;
import static br.com.catolicapb.constants.CustomerConstants.CUSTOMER_MESSAGE_PET_EXISTS_400;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final PetService petService;
    private final PetMapper petMapper;
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final ContactMapper contactMapper;

    public void save(CustomerDTO customerDTO) {
        var customer = customerRepository.findByCpfAndIsActiveTrue(customerDTO.getCpf());

        if (!customer.isPresent()) {
            customer = Optional.of(customerMapper.dtoToEntity(customerDTO));
        } else {
            existsPetToCustomer(customer.get(), customerDTO.getPetsDTO());
        }

        customerRepository.save(customer.get());
    }

    public void update(String cpf, CustomerDTO customerDTO) {
        var customer = customerRepository.findByCpf(cpf)
                .orElseThrow(() -> new CustomerNotFoundException(CUSTOMER_MESSAGE_NOT_FOUND_404));

        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setContact(contactMapper.dtoToEntity(customerDTO.getContactDTO()));

        if (customerDTO.getPetsDTO() != null && !customerDTO.getPetsDTO().isEmpty()) {
            existsPetToCustomer(customer, customerDTO.getPetsDTO());
        }

        customerRepository.save(customer);
    }

    public String toggleActiveStatus(String cpf) {
        var customer = customerRepository.findByCpf(cpf)
                .orElseThrow(() -> new CustomerNotFoundException(CUSTOMER_MESSAGE_NOT_FOUND_404));

        boolean newStatus = !customer.getIsActive();
        customer.setIsActive(newStatus);

        customerRepository.save(customer);

        return newStatus ? "ativado" : "desativado";
    }

    public void existsPetToCustomer(Customer customer, Set<PetDTO> petsDTO) {
        if (verifyPetsToCustomer(customer, petsDTO)) {
            log.error("m=existsPetToCustomer, pets exists to customer with cpf = {} ", customer.getCpf());
            throw new AlreadyPetToCustomerException(CUSTOMER_MESSAGE_PET_EXISTS_400);
        }
        customer.getPets().addAll(petMapper.dtoToEntity(petsDTO));
    }

    private boolean verifyPetsToCustomer(Customer customer, Set<PetDTO> petDTO) {
        var petsName = petDTO.stream().map(PetDTO::getName)
                .collect(Collectors.toSet());

        return petService.existsPetToCustomer(customer.getId(), petsName);
    }

    public Page<CustomerDTO> findAll(Pageable pageable) {
        var customer = customerRepository.findAll(pageable);

        return customer.map( c ->
                CustomerDTO.builder()
                        .name(c.getName())
                        .cpf(c.getCpf())
                        .email(c.getEmail())
                        .contactDTO(contactMapper.entityToDTOy(c.getContact()))
                        .active(c.getIsActive())
                        .petsDTO(petMapper.entityToDTO(c.getPets()))
                        .build()
        );
    }
}
