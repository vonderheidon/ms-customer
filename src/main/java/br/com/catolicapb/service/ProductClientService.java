package br.com.catolicapb.service;

import br.com.catolicapb.client.dto.ProductClient;
import br.com.catolicapb.client.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductClientService {

    private final ProductClient productClient;

    public ProductDTO findProductById(Long id) {
        return productClient.findById(id);
    }
}
