package br.com.catolicapb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    @NotBlank(message = "O campo mobile number é obrigatório")
    @Size(min = 14, max = 14, message = "Valor invalido para o mobile number")
    private String mobileNumber;

    private String phone;
}
