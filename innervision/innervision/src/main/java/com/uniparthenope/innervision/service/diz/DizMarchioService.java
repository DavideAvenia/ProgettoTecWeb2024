package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.dto.diz.DizMarchioDto;
import com.uniparthenope.innervision.entity.diz.DizMarchio;

import java.util.List;

public interface DizMarchioService {

    List<DizMarchioDto> findAllByAttivo();
}
