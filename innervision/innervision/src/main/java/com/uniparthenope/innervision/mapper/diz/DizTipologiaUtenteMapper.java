package com.uniparthenope.innervision.mapper.diz;

import com.uniparthenope.innervision.dto.diz.DizTipologiaUtenteDto;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DizTipologiaUtenteMapper {

    DizTipologiaUtenteDto entityToDto(DizTipologiaUtente dizTipologiaUtente);

    List<DizTipologiaUtenteDto> toDtoList(List<DizTipologiaUtente> dizTipologiaUtenteList);
}
