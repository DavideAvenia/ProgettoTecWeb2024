package com.uniparthenope.innervision.mapper.diz;


import com.uniparthenope.innervision.dto.diz.DizGenereDto;
import com.uniparthenope.innervision.dto.diz.DizMarchioDto;
import com.uniparthenope.innervision.entity.diz.DizGenere;
import com.uniparthenope.innervision.entity.diz.DizMarchio;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DizMarchioMapper {

    DizMarchioDto entityToDto(DizMarchio dizMarchio);

    List<DizMarchioDto> toDtoList(List<DizMarchio> dizMarchioList);
}
