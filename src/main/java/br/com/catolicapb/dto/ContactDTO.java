package br.com.catolicapb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {

    @NotBlank(message = "Mobile number cannot be null or empty")
    @Size(min = 11, max = 11)
    private String mobileNumber;

    private String phone;
}
