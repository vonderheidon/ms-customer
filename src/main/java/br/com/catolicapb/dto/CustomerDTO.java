package br.com.catolicapb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;

@Data
@Builder
public class CustomerDTO {

    @NotBlank(message = "Customer name cannot be null or empty")
    @Size(min = 2, max = 60)
    private String name;

    @CPF(message = "CPF not valid")
    private String cpf;

    @Email
    private String email;

    private ContactDTO contactDTO;

    private Set<PetDTO> petsDTO;
}
