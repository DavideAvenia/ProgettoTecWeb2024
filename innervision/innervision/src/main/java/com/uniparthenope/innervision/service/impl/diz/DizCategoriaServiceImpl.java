package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.dto.diz.DizCategoriaDto;
import com.uniparthenope.innervision.mapper.diz.DizCategoriaMapper;
import com.uniparthenope.innervision.repository.diz.DizCategoriaRepository;
import com.uniparthenope.innervision.service.diz.DizCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizCategoriaServiceImpl implements DizCategoriaService {

    @Autowired
    private DizCategoriaRepository dizCategoriaRepository;

    @Autowired
    private DizCategoriaMapper dizCategoriaMapper;

    @Override
    public List<DizCategoriaDto> findAllByAttivo() {
        return dizCategoriaMapper.toDtoList(dizCategoriaRepository.findAllByAttivo());
    }
}
