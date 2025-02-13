package com.uniparthenope.innervision.mapper.diz;


import com.uniparthenope.innervision.dto.diz.DizMarchioDto;
import com.uniparthenope.innervision.dto.diz.DizStatoCarrelloDto;
import com.uniparthenope.innervision.entity.diz.DizMarchio;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DizStatoCarrelloMapper {

    DizStatoCarrelloDto entityToDto(DizStatoCarrello dizStatoCarrello);

    List<DizStatoCarrelloDto> toDtoList(List<DizStatoCarrello> dizStatoCarrelloList);
}
