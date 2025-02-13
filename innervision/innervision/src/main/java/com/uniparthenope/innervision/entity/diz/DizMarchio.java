package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "DIZ_MARCHIO")
public class DizMarchio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_MARCHIO", nullable = false)
    private Long idMarchio;

    @Column(name = "DESC_MARCHIO", nullable = false)
    private String descMarchio;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

    public Long getIdMarchio() {
        return idMarchio;
    }

    public void setIdMarchio(Long idMarchio) {
        this.idMarchio = idMarchio;
    }

    public String getDescMarchio() {
        return descMarchio;
    }

    public void setDescMarchio(String descMarchio) {
        this.descMarchio = descMarchio;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DizMarchio other = (DizMarchio) o;
        return Objects.equals(idMarchio, other.idMarchio) && Objects.equals(descMarchio, other.descMarchio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarchio, descMarchio);
    }
}
