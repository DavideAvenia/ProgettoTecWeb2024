package com.uniparthenope.innervision.dto;

import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;

import java.util.List;

public class CarrelloDto {

    private Long idCarrello;

    private List<Articolo> articoli;

    private DizStatoCarrello statoCarrello;

    public CarrelloDto() {
    }

    public CarrelloDto(Long idCarrello, List<Articolo> articoli, DizStatoCarrello statoCarrello) {
        this.idCarrello = idCarrello;
        this.articoli = articoli;
        this.statoCarrello = statoCarrello;
    }

    public Long getIdCarrello() {
        return idCarrello;
    }

    public void setIdCarrello(Long idCarrello) {
        this.idCarrello = idCarrello;
    }

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(List<Articolo> articoli) {
        this.articoli = articoli;
    }

    public DizStatoCarrello getStatoCarrello() {
        return statoCarrello;
    }

    public void setStatoCarrello(DizStatoCarrello statoCarrello) {
        this.statoCarrello = statoCarrello;
    }
}
