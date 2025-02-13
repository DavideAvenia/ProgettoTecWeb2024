package com.uniparthenope.innervision.controller;

import com.uniparthenope.innervision.common.RequestGestioneCarrello;
import com.uniparthenope.innervision.dto.CarrelloDto;
import com.uniparthenope.innervision.service.CarrelloService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

import static com.uniparthenope.innervision.common.DefaultStrings.*;

@RestController
@CrossOrigin
@RequestMapping("/carrello")
public class GestioneCarrelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GestioneCarrelloController.class);

    @Autowired
    private CarrelloService carrelloService;

    @PostMapping(value = "/addArticolo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Aggiunge un articolo al carrello di uno specifico utente",
            notes = "Restituisce la conferma di aggiunta")
    public ResponseEntity<Map<String, Object>> addArticolo(@RequestBody RequestGestioneCarrello requestGestioneCarrelloInInput) {
        try {
            LOGGER.info("Chiamata REST /addArticolo");

            CarrelloDto carrelloDto = carrelloService.addArticolo(requestGestioneCarrelloInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, carrelloDto);
            result.put(MESSAGGIO, "Articolo aggiunto con successo");
            result.put(OPERAZIONE, "Aggiungi articolo");

            LOGGER.info("Fine chiamata Rest /addArticolo");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @PostMapping(value = "/removeArticolo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Aggiunge un articolo al carrello di uno specifico utente",
            notes = "Restituisce la conferma di aggiunta")
    public ResponseEntity<Map<String, Object>> removeArticolo(@RequestBody RequestGestioneCarrello requestGestioneCarrelloInInput) {
        try {
            LOGGER.info("Chiamata REST /removeArticolo");

            CarrelloDto carrelloDto = carrelloService.removeArticolo(requestGestioneCarrelloInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, carrelloDto);
            result.put(MESSAGGIO, "Articolo rimosso con successo");
            result.put(OPERAZIONE, "Rimozione articolo");

            LOGGER.info("Fine chiamata Rest /removeArticolo");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @PostMapping(value = "/showCart", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Aggiunge un articolo al carrello di uno specifico utente",
            notes = "Restituisce la conferma di aggiunta")
    public ResponseEntity<Map<String, Object>> showCarrello(@RequestBody RequestGestioneCarrello requestGestioneCarrelloInInput) {
        try {
            LOGGER.info("Chiamata REST /showCarrello");

            CarrelloDto carrelloDto = carrelloService.showCarrello(requestGestioneCarrelloInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, carrelloDto);
            result.put(MESSAGGIO, "Articoli del carrello mostrati con successo");
            result.put(OPERAZIONE, "Mostra carrello");

            LOGGER.info("Fine chiamata Rest /showCarrello");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @DeleteMapping(value = "/deleteAllFromCart", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Aggiunge un articolo al carrello di uno specifico utente",
            notes = "Restituisce la conferma di aggiunta")
    public ResponseEntity<Map<String, Object>> svuotaCarrello(@RequestBody RequestGestioneCarrello requestGestioneCarrelloInInput) {
        try {
            LOGGER.info("Chiamata REST /deleteAllFromCart");

            CarrelloDto carrelloDto = carrelloService.svuotaCarrello(requestGestioneCarrelloInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, carrelloDto);
            result.put(MESSAGGIO, "Tutti gli articoli del carrello rimossi con successo");
            result.put(OPERAZIONE, "Svuota carrello");

            LOGGER.info("Fine chiamata Rest /deleteAllFromCart");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @PostMapping(value = "/acquistaArticoli", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Aggiunge un articolo al carrello di uno specifico utente",
            notes = "Restituisce la conferma di aggiunta")
    public ResponseEntity<Map<String, Object>> acquistaArticoli(@RequestBody RequestGestioneCarrello requestGestioneCarrelloInInput) {
        try {
            LOGGER.info("Chiamata REST /acquistaArticoli");

            Boolean confermaAcquisto = carrelloService.acquistaArticoli(requestGestioneCarrelloInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, confermaAcquisto);
            result.put(MESSAGGIO, "Acquisto degli articoli");
            result.put(OPERAZIONE, "Acquisto Articoli");

            LOGGER.info("Fine chiamata Rest /acquistaArticoli");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }
}
