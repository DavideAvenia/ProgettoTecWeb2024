package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;

@Entity
@Table(name = "DIZ_GENERE")
public class DizGenere {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_GENERE", nullable = false)
    private Long idGenere;

    @Column(name = "DESC_GENERE", nullable = false)
    private String descGenere;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

    public Long getIdGenere() {
        return idGenere;
    }

    public void setIdGenere(Long idGenere) {
        this.idGenere = idGenere;
    }

    public String getDescGenere() {
        return descGenere;
    }

    public void setDescGenere(String descGenere) {
        this.descGenere = descGenere;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }
}
