package com.uniparthenope.innervision.dto;

import com.uniparthenope.innervision.entity.Acquisto;
import com.uniparthenope.innervision.entity.Carrello;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;

import java.util.ArrayList;
import java.util.List;

public class UtenteDto {

    private Long idUtente;

    private String nome;

    private String cognome;

    private String username;

    private String email;

    private String password;

    private DizTipologiaUtente tipologiaUtente;

    private Carrello carrelloUtente;

    private List<Acquisto> acquistiEffettuati;

    public UtenteDto() {
    }

    public UtenteDto(Long idUtente, String nome, String cognome, String username,
                     String email, String password, DizTipologiaUtente tipologiaUtente,
                     Carrello carrelloUtente, ArrayList<Acquisto> acquistiEffettuati) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipologiaUtente = tipologiaUtente;
        this.carrelloUtente = carrelloUtente;
        this.acquistiEffettuati = acquistiEffettuati;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DizTipologiaUtente getTipologiaUtente() {
        return tipologiaUtente;
    }

    public void setTipologiaUtente(DizTipologiaUtente tipologiaUtente) {
        this.tipologiaUtente = tipologiaUtente;
    }

    public Carrello getCarrelloUtente() {
        return carrelloUtente;
    }

    public void setCarrelloUtente(Carrello carrelloUtente) {
        this.carrelloUtente = carrelloUtente;
    }

    public List<Acquisto> getAcquistiEffettuati() {
        return acquistiEffettuati;
    }

    public void setAcquistiEffettuati(ArrayList<Acquisto> acquistiEffettuati) {
        this.acquistiEffettuati = acquistiEffettuati;
    }
}
