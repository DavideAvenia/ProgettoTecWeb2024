package com.uniparthenope.innervision.common;

public class RequestGestioneCarrello {

    private Long idArticolo;
    private Long idUtente;
    private Long idCarrello;

    private Long idStatoCarrello;

    private String username;

    public RequestGestioneCarrello() {
    }

    public RequestGestioneCarrello(Long idArticolo, Long idUtente, Long idCarrello) {
        this.idArticolo = idArticolo;
        this.idUtente = idUtente;
        this.idCarrello = idCarrello;
    }

    public Long getIdArticolo() {
        return idArticolo;
    }
    public Long getIdUtente() {
        return idUtente;
    }
    public Long getIdCarrello() {
        return idCarrello;
    }

    public Long getIdStatoCarrello() {
        return idStatoCarrello;
    }

    public void setIdStatoCarrello(Long idStatoCarrello) {
        this.idStatoCarrello = idStatoCarrello;
    }

    public String getUsername() {
        return username;
    }
}
