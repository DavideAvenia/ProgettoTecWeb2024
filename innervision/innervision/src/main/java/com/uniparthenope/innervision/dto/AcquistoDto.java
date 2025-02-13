package com.uniparthenope.innervision.dto;

import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.entity.diz.DizMarchio;

public class AcquistoDto {

    private Long idAcquisto;

    private Utente utente;

    private Articolo articolo;

    private DizMarchio marchio;

    public AcquistoDto(){}

    public AcquistoDto(Long idAcquisto, Utente utente, Articolo articolo, DizMarchio marchio) {
        this.idAcquisto = idAcquisto;
        this.utente = utente;
        this.articolo = articolo;
        this.marchio = marchio;
    }

    public AcquistoDto(Utente utente, Articolo articolo, DizMarchio marchio) {
        this.utente = utente;
        this.articolo = articolo;
        this.marchio = marchio;
    }

    public Long getIdAcquisto() {
        return idAcquisto;
    }

    public void setIdAcquisto(Long idAcquisto) {
        this.idAcquisto = idAcquisto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }

    public DizMarchio getMarchio() {
        return marchio;
    }

    public void setMarchio(DizMarchio marchio) {
        this.marchio = marchio;
    }
}
