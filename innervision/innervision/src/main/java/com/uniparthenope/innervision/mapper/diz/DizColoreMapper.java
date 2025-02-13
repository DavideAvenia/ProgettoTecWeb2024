package com.uniparthenope.innervision.mapper.diz;

import com.uniparthenope.innervision.dto.diz.DizColoreDto;
import com.uniparthenope.innervision.entity.diz.DizColore;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DizColoreMapper {

    DizColoreDto entityToDto(DizColore dizColore);

    List<DizColoreDto> toDtoList(List<DizColore> dizColoreList);
}
