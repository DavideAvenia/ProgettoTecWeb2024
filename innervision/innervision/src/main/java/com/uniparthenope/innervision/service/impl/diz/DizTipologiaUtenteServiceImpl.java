package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.dto.diz.DizTipologiaUtenteDto;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import com.uniparthenope.innervision.mapper.diz.DizTipologiaUtenteMapper;
import com.uniparthenope.innervision.repository.diz.DizTipologiaUtenteRepository;
import com.uniparthenope.innervision.service.diz.DizTipologiaUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizTipologiaUtenteServiceImpl implements DizTipologiaUtenteService {

    @Autowired
    private DizTipologiaUtenteRepository dizTipologiaUtenteRepository;

    @Autowired
    private DizTipologiaUtenteMapper dizTipologiaUtenteMapper;

    @Override
    public List<DizTipologiaUtenteDto> findAllByAttivo() {
        return dizTipologiaUtenteMapper.toDtoList(dizTipologiaUtenteRepository.findAllByAttivo());
    }
}
