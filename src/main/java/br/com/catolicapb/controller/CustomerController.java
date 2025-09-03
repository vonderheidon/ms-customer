package br.com.catolicapb.controller;

import br.com.catolicapb.dto.CustomerDTO;
import br.com.catolicapb.dto.ResponseDTO;
import br.com.catolicapb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.catolicapb.constants.CustomerConstants.CUSTOMER_201_MESSAGE;
import static br.com.catolicapb.constants.CustomerConstants.CUSTOMER_201_STATUS;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> save(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDTO.builder()
                .message(CUSTOMER_201_MESSAGE)
                .statusHttp(CUSTOMER_201_STATUS)
                .build());
    }
}
