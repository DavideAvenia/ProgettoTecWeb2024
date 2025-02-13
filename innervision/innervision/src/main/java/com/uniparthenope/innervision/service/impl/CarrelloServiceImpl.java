package com.uniparthenope.innervision.service.impl;

import com.uniparthenope.innervision.common.RequestGestioneCarrello;
import com.uniparthenope.innervision.dto.CarrelloDto;
import com.uniparthenope.innervision.entity.Acquisto;
import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.Carrello;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.mapper.CarrelloMapper;
import com.uniparthenope.innervision.repository.AcquistoRepository;
import com.uniparthenope.innervision.repository.ArticoloRepository;
import com.uniparthenope.innervision.repository.CarrelloRepository;
import com.uniparthenope.innervision.repository.UtenteRepository;
import com.uniparthenope.innervision.repository.diz.DizStatoCarrelloRepository;
import com.uniparthenope.innervision.service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarrelloServiceImpl implements CarrelloService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private CarrelloRepository carrelloRepository;

    @Autowired
    private ArticoloRepository articoloRepository;

    @Autowired
    private DizStatoCarrelloRepository dizStatoCarrelloRepository;

    @Autowired
    private CarrelloMapper carrelloMapper;
    @Autowired
    private AcquistoRepository acquistoRepository;

    @Override
    public CarrelloDto addArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Articolo articoloDaAggiungere = articoloRepository.getArticoloByIdArticolo(requestGestioneCarrelloInInput.getIdArticolo());
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        Utente utenteTrovato = utenteRepository.getUtenteByUsername(requestGestioneCarrelloInInput.getUsername());

        checkRequestGestioneCarrello(articoloDaAggiungere, carrelloDaAggiornare, utenteTrovato);

        carrelloDaAggiornare.getArticoli().add(articoloDaAggiungere);
        utenteTrovato.setCarrelloUtente(carrelloDaAggiornare);

        carrelloRepository.save(carrelloDaAggiornare);
        utenteRepository.save(utenteTrovato);

        return carrelloMapper.entityToDto(carrelloRepository.getCarrelloByIdCarrello(carrelloDaAggiornare.getIdCarrello()));
    }

    @Override
    public CarrelloDto removeArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Articolo articoloDaRimuovere = articoloRepository.getArticoloByIdArticolo(requestGestioneCarrelloInInput.getIdArticolo());
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        Utente utenteTrovato = utenteRepository.getUtenteByUsername(requestGestioneCarrelloInInput.getUsername());

        checkRequestGestioneCarrello(articoloDaRimuovere, carrelloDaAggiornare, utenteTrovato);
        if(carrelloDaAggiornare.getArticoli().isEmpty()){
            throw new RuntimeException("Il carrello trovato è già vuoto");
        }

        carrelloDaAggiornare.getArticoli().remove(articoloDaRimuovere);
        utenteTrovato.setCarrelloUtente(carrelloDaAggiornare);

        carrelloRepository.save(carrelloDaAggiornare);
        utenteRepository.save(utenteTrovato);
        return carrelloMapper.entityToDto(carrelloRepository.getCarrelloByIdCarrello(carrelloDaAggiornare.getIdCarrello()));
    }

    @Override
    public CarrelloDto showCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        return carrelloMapper.entityToDto(
                carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello())
        );
    }

    @Override
    public CarrelloDto svuotaCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        Utente utenteTrovato = utenteRepository.getUtenteByIdUtente(requestGestioneCarrelloInInput.getIdUtente());

        checkRequestCarrello(carrelloDaAggiornare, utenteTrovato);
        if(carrelloDaAggiornare.getStatoCarrello().getIdStatoCarrello() > 1)
            throw new RuntimeException("Il carrello non può essere svuotato");

        carrelloDaAggiornare.getArticoli().clear();
        utenteTrovato.setCarrelloUtente(carrelloDaAggiornare);

        carrelloRepository.save(carrelloDaAggiornare);
        utenteRepository.save(utenteTrovato);

        return carrelloMapper.entityToDto(carrelloRepository.getCarrelloByIdCarrello(carrelloDaAggiornare.getIdCarrello()));
    }

    @Override
    public Boolean acquistaArticoli(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        Utente utenteTrovato = utenteRepository.getUtenteByUsername(requestGestioneCarrelloInInput.getUsername());

        if(carrelloDaAggiornare == null){
            throw new RuntimeException("Carrello non trovato");
        }

        ArrayList<Acquisto> acquistiEffettuati = new ArrayList<>();
        for (Articolo articolo:carrelloDaAggiornare.getArticoli()) {
            Acquisto acquisto = new Acquisto();
            acquisto.setArticolo(articolo);
            acquisto.setUtente(utenteTrovato);
            acquisto.setMarchio(articolo.getMarchio());

            Acquisto acquistoSalvato = acquistoRepository.save(acquisto);

            acquisto.setIdAcquisto(acquistoSalvato.getIdAcquisto());

            acquistiEffettuati.add(acquisto);
        }

        carrelloDaAggiornare.getArticoli().clear();
        carrelloRepository.save(carrelloDaAggiornare);
        utenteTrovato.setAcquistiEffettuati(acquistiEffettuati);
        utenteRepository.save(utenteTrovato);
        return true;
    }

    @Override
    public CarrelloDto getCarrelloByUsername(String username) {
        Utente utenteTrovato = utenteRepository.getUtenteByUsername(username);

        Carrello toDto = carrelloRepository.getCarrelloByIdCarrello(utenteTrovato.getCarrelloUtente().getIdCarrello());
        return carrelloMapper.entityToDto(toDto);
    }

    private void checkRequestGestioneCarrello(Articolo articoloDaRimuovere, Carrello carrelloDaAggiornare, Utente utenteTrovato){
        if(articoloDaRimuovere == null){
            throw new RuntimeException("Articolo non trovato");
        }

        if(carrelloDaAggiornare == null){
            throw new RuntimeException("Carrello non trovato");
        }

        if(utenteTrovato == null){
            throw new RuntimeException("Utente non trovato");
        }
    }


    private void checkRequestCarrello(Carrello carrelloDaAggiornare, Utente utenteTrovato){
        if(carrelloDaAggiornare == null){
            throw new RuntimeException("Carrello non trovato");
        }

        if(utenteTrovato == null){
            throw new RuntimeException("Utente non trovato");
        }
    }
}
