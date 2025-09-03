package br.com.catolicapb.service;

import br.com.catolicapb.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public boolean existsPetFromCustomer(Long id, Set<String> petsName) {
        return petRepository.existsPetFromCustomer(id, petsName);
    }
}
