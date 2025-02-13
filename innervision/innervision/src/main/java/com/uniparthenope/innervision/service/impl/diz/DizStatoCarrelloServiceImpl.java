package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.dto.diz.DizStatoCarrelloDto;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import com.uniparthenope.innervision.mapper.diz.DizStatoCarrelloMapper;
import com.uniparthenope.innervision.repository.diz.DizStatoCarrelloRepository;
import com.uniparthenope.innervision.service.diz.DizStatoCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizStatoCarrelloServiceImpl implements DizStatoCarrelloService {

    @Autowired
    private DizStatoCarrelloRepository dizStatoCarrelloRepository;

    @Autowired
    private DizStatoCarrelloMapper dizStatoCarrelloMapper;

    @Override
    public List<DizStatoCarrelloDto> findAllByAttivo() {
        return dizStatoCarrelloMapper.toDtoList(dizStatoCarrelloRepository.findAllByAttivo());
    }
}
