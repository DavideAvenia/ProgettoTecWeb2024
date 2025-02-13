package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.Builder;

@Entity
@Table(name = "DIZ_CATEGORIA")
public class DizCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CATEGORIA", nullable = false)
    private Long idCategoria;

    @Column(name = "DESC_CATEGORIA", nullable = false)
    private String descCategoria;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }
}
