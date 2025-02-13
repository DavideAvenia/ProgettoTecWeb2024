package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.dto.diz.DizColoreDto;
import com.uniparthenope.innervision.entity.diz.DizColore;
import com.uniparthenope.innervision.mapper.diz.DizColoreMapper;
import com.uniparthenope.innervision.repository.diz.DizColoreRepository;
import com.uniparthenope.innervision.service.diz.DizColoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizColoreServiceImpl implements DizColoreService {

    @Autowired
    private DizColoreRepository dizColoreRepository;

    @Autowired
    private DizColoreMapper dizColoreMapper;

    @Override
    public List<DizColoreDto> findAllByAttivo() {
        return dizColoreMapper.toDtoList(dizColoreRepository.findAllByAttivo());
    }
}
