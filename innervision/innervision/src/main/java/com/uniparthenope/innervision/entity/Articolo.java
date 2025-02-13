package com.uniparthenope.innervision.entity;

import com.uniparthenope.innervision.entity.diz.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ARTICOLO")
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ARTICOLO", nullable = false)
    private Long idArticolo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name ="RECENSIONI", length = 1)
    private Integer recensioni;

    @Column(name="PREZZO", nullable = false)
    private Double prezzo;

    @Column(name ="FOTO")
    private String foto;

    @Column(name ="DESCRIZIONE")
    private String descrizione;

    @Column(name ="quantita_disponibile")
    private Integer quantitaDisponibile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_MARCHIO")
    private DizMarchio marchio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_GENERE")
    private DizGenere genere;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_COLORE_MONTATURA")
    private DizColore coloreMontatura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_COLORE_LENTE")
    private DizColore coloreLente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_CATEGORIA")
    private DizCategoria categoria;

    public Articolo() {
    }

    public Articolo(Long idArticolo, String nome, Integer recensioni, String foto, Double prezzo,
                    String descrizione, Integer quantitaDisponibile,
                    DizMarchio marchio, DizGenere genere, DizColore coloreMontatura,
                    DizColore coloreLente, DizCategoria categoria) {
        this.idArticolo = idArticolo;
        this.nome = nome;
        this.recensioni = recensioni;
        this.foto = foto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantitaDisponibile = quantitaDisponibile;
        this.marchio = marchio;
        this.genere = genere;
        this.coloreMontatura = coloreMontatura;
        this.coloreLente = coloreLente;
        this.categoria = categoria;
    }

    public Long getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(Long idArticolo) {
        this.idArticolo = idArticolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(Integer recensioni) {
        this.recensioni = recensioni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public void setQuantitaDisponibile(Integer quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public DizMarchio getMarchio() {
        return marchio;
    }

    public void setMarchio(DizMarchio marchio) {
        this.marchio = marchio;
    }

    public DizGenere getGenere() {
        return genere;
    }

    public void setGenere(DizGenere genere) {
        this.genere = genere;
    }

    public DizColore getColoreMontatura() {
        return coloreMontatura;
    }

    public void setColoreMontatura(DizColore coloreMontatura) {
        this.coloreMontatura = coloreMontatura;
    }

    public DizColore getColoreLente() {
        return coloreLente;
    }

    public void setColoreLente(DizColore coloreLente) {
        this.coloreLente = coloreLente;
    }

    public DizCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(DizCategoria categoria) {
        this.categoria = categoria;
    }
}
