package com.uniparthenope.innervision.service;

import com.uniparthenope.innervision.dto.ArticoloDto;

import java.util.List;

public interface ArticoloService {
    List<ArticoloDto> findAllArticoli();

    ArticoloDto findArticoloById(Long idArticolo);

    List<ArticoloDto> findArticoloByNome(String nome);

    List<ArticoloDto> findArticoliByCategoria(Long idCategoria);

    List<ArticoloDto> findArticoliByMarca(Long idMarca);

    List<ArticoloDto> findArticoliByReccomend(Long idUtente);
}
