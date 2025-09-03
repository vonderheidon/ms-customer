package br.com.catolicapb.mapper;

import br.com.catolicapb.domain.Contact;
import br.com.catolicapb.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact dtoToEntity(ContactDTO contactDTO);

    ContactDTO entityToDTOy(Contact contact);
}
