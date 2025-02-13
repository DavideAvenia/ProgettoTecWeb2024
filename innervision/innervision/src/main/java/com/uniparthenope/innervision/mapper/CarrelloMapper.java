package com.uniparthenope.innervision.mapper;

import com.uniparthenope.innervision.dto.CarrelloDto;
import com.uniparthenope.innervision.entity.Carrello;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrelloMapper {

    Carrello dtoToEntity(CarrelloDto carrelloDto);

    CarrelloDto entityToDto(Carrello carrello);
}
