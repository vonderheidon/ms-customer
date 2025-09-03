package br.com.catolicapb.mapper;

import br.com.catolicapb.domain.Pet;
import br.com.catolicapb.dto.PetDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public interface PetMapper {

    Set<Pet> dtoToEntity(Set<PetDTO> petsDTO);

    Set<PetDTO> entityToDto(Set<Pet> pets);
}
