package br.com.catolicapb.mapper;

import br.com.catolicapb.domain.Pet;
import br.com.catolicapb.dto.PetDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public interface PetMapper {

    Set<Pet> dtoToEntity(Set<PetDTO> petDTO);

    Set<PetDTO> entityToDTO(Set<Pet> pets);
}
