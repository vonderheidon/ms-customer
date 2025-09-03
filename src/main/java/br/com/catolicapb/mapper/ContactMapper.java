package br.com.catolicapb.mapper;

import br.com.catolicapb.domain.Contact;
import br.com.catolicapb.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ContactMapper {

    Contact dtoToEntity(ContactDTO contactDTO);
}
