package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_COLORE")
public class DizColore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_COLORE", nullable = false)
    private Long idColore;

    @Column(name = "DESC_COLORE", nullable = false)
    private String descColore;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

    public Long getIdColore() {
        return idColore;
    }

    public void setIdColore(Long idColore) {
        this.idColore = idColore;
    }

    public String getDescColore() {
        return descColore;
    }

    public void setDescColore(String descColore) {
        this.descColore = descColore;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }
}
