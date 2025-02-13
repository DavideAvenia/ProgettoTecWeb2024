package com.uniparthenope.innervision.entity;

import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CARRELLO")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CARRELLO", nullable = false)
    private Long idCarrello;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Articolo> articoli;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_STATO_CARRELLo")
    private DizStatoCarrello statoCarrello;

    public Carrello() {
    }

    public Carrello(Long idCarrello, List<Articolo> articoli, DizStatoCarrello statoCarrello) {
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
