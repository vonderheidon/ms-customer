package br.com.catolicapb.controller;

import br.com.catolicapb.dto.CustomerDTO;
import br.com.catolicapb.dto.ResponseDTO;
import br.com.catolicapb.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.catolicapb.constants.CustomerConstants.CODE_STATUS_201;
import static br.com.catolicapb.constants.CustomerConstants.CUSTOMER_MESSAGE_CREATED_201;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDTO.builder()
                        .statusCode(CODE_STATUS_201)
                        .message(CUSTOMER_MESSAGE_CREATED_201)
                        .build());
    }

    @GetMapping("/findAll")
    public Page<CustomerDTO> findAll(Pageable pageable) {
        return customerService.findAll(pageable);
    }

}
