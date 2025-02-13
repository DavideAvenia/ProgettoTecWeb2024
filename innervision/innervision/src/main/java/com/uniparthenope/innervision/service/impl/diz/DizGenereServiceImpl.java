package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.dto.diz.DizGenereDto;
import com.uniparthenope.innervision.entity.diz.DizGenere;
import com.uniparthenope.innervision.mapper.diz.DizGenereMapper;
import com.uniparthenope.innervision.repository.diz.DizGenereRepository;
import com.uniparthenope.innervision.service.diz.DizGenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizGenereServiceImpl implements DizGenereService {

    @Autowired
    private DizGenereRepository dizGenereRepository;

    @Autowired
    private DizGenereMapper dizGenereMapper;

    @Override
    public List<DizGenereDto> findAllByAttivo() {
        return dizGenereMapper.toDtoList(dizGenereRepository.findAllByAttivo());
    }
}
