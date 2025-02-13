package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.dto.diz.DizCategoriaDto;

import java.util.List;

public interface DizCategoriaService {

    List<DizCategoriaDto> findAllByAttivo();
}
