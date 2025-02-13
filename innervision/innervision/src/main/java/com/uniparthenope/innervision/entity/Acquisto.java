package com.uniparthenope.innervision.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.uniparthenope.innervision.entity.diz.DizMarchio;
import jakarta.persistence.*;

@Entity
@Table(name = "ACQUISTO")
public class Acquisto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAcquisto;
    @ManyToOne
    @JoinColumn(name = "ID_UTENTE")
    @JsonBackReference
    private Utente utente;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ARTICOLO")
    private Articolo articolo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MARCHIO")
    private DizMarchio marchio;

    public Acquisto(){}

    public Acquisto(Long idAcquisto, Utente utente, Articolo articolo, DizMarchio marchio) {
        this.idAcquisto = idAcquisto;
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
