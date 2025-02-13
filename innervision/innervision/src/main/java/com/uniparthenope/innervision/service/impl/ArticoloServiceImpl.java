package com.uniparthenope.innervision.service.impl;

import com.uniparthenope.innervision.dto.ArticoloDto;
import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.entity.diz.DizCategoria;
import com.uniparthenope.innervision.entity.diz.DizMarchio;
import com.uniparthenope.innervision.mapper.ArticoloMapper;
import com.uniparthenope.innervision.repository.ArticoloRepository;
import com.uniparthenope.innervision.repository.UtenteRepository;
import com.uniparthenope.innervision.repository.diz.DizCategoriaRepository;
import com.uniparthenope.innervision.repository.diz.DizMarchioRepository;
import com.uniparthenope.innervision.service.ArticoloService;
import com.uniparthenope.innervision.util.RecommendationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArticoloServiceImpl implements ArticoloService {

    @Autowired
    private ArticoloRepository articoloRepository;

    @Autowired
    private ArticoloMapper articoloMapper;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public List<ArticoloDto> findAllArticoli() {
        return articoloMapper.toDtoList(articoloRepository.findAll());
    }

    @Override
    public ArticoloDto findArticoloById(Long idArticolo) {
        Optional<Articolo> articoloTrovato = articoloRepository.findById(idArticolo);
        return articoloMapper.entityToDto(articoloTrovato.orElseGet(Articolo::new));
    }

    @Override
    public List<ArticoloDto> findArticoloByNome(String nome) {
        return articoloMapper.toDtoList(articoloRepository.findArticoloByNome(nome));
    }

    @Override
    public List<ArticoloDto> findArticoliByCategoria(Long idCategoria) {
        return articoloMapper.toDtoList(articoloRepository.findArticoliByCategoria(idCategoria));
    }

    @Override
    public List<ArticoloDto> findArticoliByMarca(Long idMarca) {
        return articoloMapper.toDtoList(articoloRepository.findArticoliByMarchio(idMarca));
    }

    @Override
    public List<ArticoloDto> findArticoliByReccomend(Long idUtente) {
        Utente utenteTrovato = utenteRepository.getUtenteByIdUtente(idUtente);
        Map<Long, List<Articolo>> recommendations =
                new RecommendationUtil().generateRecommendationsWithArticles(
                        utenteTrovato.getAcquistiEffettuati(), articoloRepository.findAll());
        return articoloMapper.toDtoList(recommendations.get(idUtente));
    }
}
