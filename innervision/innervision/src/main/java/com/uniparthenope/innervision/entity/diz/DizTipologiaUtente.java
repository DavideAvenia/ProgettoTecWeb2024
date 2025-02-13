package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_TIPOLOGIA_UTENTE")
public class DizTipologiaUtente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_TIPOLOGIA_UTENTE", nullable = false)
    private Long idTipologiaUtente;

    @Column(name = "DESC_TIPOLOGIA_UTENTE", nullable = false)
    private String descTipologiaUtente;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

    public Long getIdTipologiaUtente() {
        return idTipologiaUtente;
    }

    public void setIdTipologiaUtente(Long idTipologiaUtente) {
        this.idTipologiaUtente = idTipologiaUtente;
    }

    public String getDescTipologiaUtente() {
        return descTipologiaUtente;
    }

    public void setDescTipologiaUtente(String descTipologiaUtente) {
        this.descTipologiaUtente = descTipologiaUtente;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }
}
