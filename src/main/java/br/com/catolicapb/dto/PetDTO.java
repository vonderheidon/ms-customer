package br.com.catolicapb.dto;

import br.com.catolicapb.enums.Specie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetDTO {

    @NotBlank(message = "Nome do Pet inválido")
    @Size(min = 2, max = 30, message = "O nome do Pet deve conter entre 2 e 30 caracteres")
    private String name;

    @NotBlank(message = "A especie do Pet deve ser inforamada")
    private Specie specie;
}
