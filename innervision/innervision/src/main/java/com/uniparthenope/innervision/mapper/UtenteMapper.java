package com.uniparthenope.innervision.mapper;

import com.uniparthenope.innervision.dto.UtenteDto;
import com.uniparthenope.innervision.entity.Utente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    Utente dtoToEntity(UtenteDto utenteDto);

    UtenteDto entityToDto(Utente utente);
}
