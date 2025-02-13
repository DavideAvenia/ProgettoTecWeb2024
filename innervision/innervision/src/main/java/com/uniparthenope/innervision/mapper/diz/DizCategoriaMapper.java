package com.uniparthenope.innervision.mapper.diz;

import com.uniparthenope.innervision.dto.diz.DizCategoriaDto;
import com.uniparthenope.innervision.entity.diz.DizCategoria;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DizCategoriaMapper {

    DizCategoriaDto entityToDto(DizCategoria dizCategoria);

    List<DizCategoriaDto> toDtoList(List<DizCategoria> dizCategoriaList);
}
