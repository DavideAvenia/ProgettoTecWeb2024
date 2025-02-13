package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.dto.diz.DizStatoCarrelloDto;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;

import java.util.List;

public interface DizStatoCarrelloService {

    List<DizStatoCarrelloDto> findAllByAttivo();
}
