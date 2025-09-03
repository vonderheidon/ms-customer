package br.com.catolicapb.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.br.CPF;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractPersonDTO {

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 2, max = 60, message = "O nome deve possuir entre 2 a 60 caracteres")
    private String name;

    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    @Valid
    private ContactDTO contactDTO;

    private boolean active;

}
