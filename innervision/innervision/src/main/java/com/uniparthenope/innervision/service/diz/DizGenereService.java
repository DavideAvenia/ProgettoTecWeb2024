package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.dto.diz.DizGenereDto;
import com.uniparthenope.innervision.entity.diz.DizGenere;

import java.util.List;

public interface DizGenereService {

    List<DizGenereDto> findAllByAttivo();
}
