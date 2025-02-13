package com.uniparthenope.innervision.mapper;

import com.uniparthenope.innervision.dto.AcquistoDto;
import com.uniparthenope.innervision.entity.Acquisto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AcquistoMapper {

    Acquisto dtoToEntity(AcquistoDto articoloDto);

    AcquistoDto entityToDto(Acquisto articolo);

    List<AcquistoDto> toDtoList(List<Acquisto> articoli);
}
