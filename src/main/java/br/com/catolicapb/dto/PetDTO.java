package br.com.catolicapb.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetDTO {

    @NotBlank(message = "Pet's name cannot be null or empty")
    private String name;

    @NotBlank(message = "Pet's specie cannot be null or empty")
    private String specie;
}
