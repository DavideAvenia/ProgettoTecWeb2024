package com.uniparthenope.innervision.mapper.diz;

import com.uniparthenope.innervision.dto.diz.DizGenereDto;
import com.uniparthenope.innervision.entity.diz.DizGenere;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DizGenereMapper {

    DizGenereDto entityToDto(DizGenere dizGenere);

    List<DizGenereDto> toDtoList(List<DizGenere> dizGenereList);
}
