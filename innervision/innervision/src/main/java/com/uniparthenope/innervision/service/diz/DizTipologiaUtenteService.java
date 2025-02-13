package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.dto.diz.DizTipologiaUtenteDto;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;

import java.util.List;

public interface DizTipologiaUtenteService {

    List<DizTipologiaUtenteDto> findAllByAttivo();
}
