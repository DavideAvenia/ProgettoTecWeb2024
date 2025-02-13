package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.dto.diz.DizMarchioDto;
import com.uniparthenope.innervision.entity.diz.DizMarchio;
import com.uniparthenope.innervision.mapper.diz.DizMarchioMapper;
import com.uniparthenope.innervision.repository.diz.DizMarchioRepository;
import com.uniparthenope.innervision.service.diz.DizMarchioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizMarchioServiceImpl implements DizMarchioService {

    @Autowired
    private DizMarchioRepository dizMarchioRepository;

    @Autowired
    private DizMarchioMapper dizMarchioMapper;

    @Override
    public List<DizMarchioDto> findAllByAttivo() {
        return dizMarchioMapper.toDtoList(dizMarchioRepository.findAllByAttivo());
    }
}
