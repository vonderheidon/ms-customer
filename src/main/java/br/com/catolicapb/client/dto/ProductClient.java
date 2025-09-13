package br.com.catolicapb.client.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-product")
public interface ProductClient {

    @GetMapping("/api/v1/product/findById/{id}")
    ProductDTO findById(@PathVariable Long id);
}
