package br.com.catolicapb.mapper;

import br.com.catolicapb.domain.Customer;
import br.com.catolicapb.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final PetMapper petMapper;
    private final ContactMapper contactMapper;

    public Customer dtoToEntity(CustomerDTO customerDTO) {
        var customer = new Customer();
        customer.setCpf(customerDTO.getCpf());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setIsActive(true);
        customer.setContact(contactMapper.dtoToEntity(customerDTO.getContactDTO()));
        customer.setPets(petMapper.dtoToEntity(customerDTO.getPetsDTO()));
        return customer;
    }
}
