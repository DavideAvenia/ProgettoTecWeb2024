package com.uniparthenope.innervision.dto.diz;

import lombok.Getter;
import lombok.Setter;

public class DizStatoCarrelloDto {

    private Long idStatoCarrello;

    private String descStatoCarrello;

    private String attivo;

    public Long getIdMarchio() {
        return idStatoCarrello;
    }

    public void setIdMarchio(Long idMarchio) {
        this.idStatoCarrello = idMarchio;
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
