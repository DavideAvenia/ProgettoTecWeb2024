package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;

@Entity
@Table(name = "DIZ_STATO_CARRELLO")
public class DizStatoCarrello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_STATO_CARRELLO", nullable = false)
    private Long idStatoCarrello;

    @Column(name = "DESC_STATO_CARRELLO", nullable = false)
    private String descStatoCarrello;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

    public DizStatoCarrello() {
    }

    public DizStatoCarrello(Long idStatoCarrello, String descStatoCarrello, String attivo) {
        this.idStatoCarrello = idStatoCarrello;
        this.descStatoCarrello = descStatoCarrello;
        this.attivo = attivo;
    }

    public Long getIdStatoCarrello() {
        return idStatoCarrello;
    }

    public void setIdStatoCarrello(Long idStatoCarrello) {
        this.idStatoCarrello = idStatoCarrello;
    }

    public String getDescStatoCarrello() {
        return descStatoCarrello;
    }

    public void setDescStatoCarrello(String descStatoCarrello) {
        this.descStatoCarrello = descStatoCarrello;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }
}
