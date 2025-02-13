package com.uniparthenope.innervision.controller;

import com.uniparthenope.innervision.dto.diz.*;
import com.uniparthenope.innervision.service.diz.*;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.uniparthenope.innervision.common.DefaultStrings.*;

@RestController
@RequestMapping("/dizionari")
public class GestioneDizionariController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GestioneDizionariController.class);

    @Autowired
    private DizCategoriaService dizCategoriaService;

    @Autowired
    private DizColoreService dizColoreService;

    @Autowired
    private DizGenereService dizGenereService;

    @Autowired
    private DizMarchioService dizMarchioService;

    @Autowired
    private DizStatoCarrelloService dizStatoCarrelloService;

    @GetMapping(value = "/getDizCategoria", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni categorie degli occhiali",
            notes = "Restituisce una lista di categorie disponibili.",
            response = DizCategoriaDto.class)
    public ResponseEntity<Map<String, Object>> getDizCategoria(){
        try {
            LOGGER.info("Chiamata REST /getDizCategoria");

            List<DizCategoriaDto> dto = dizCategoriaService.findAllByAttivo();

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista delle categorie disponibili");
            result.put(OPERAZIONE, "Info dati categoria");

            LOGGER.info("Fine chiamata Rest /getDizCategoria");

            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @GetMapping(value = "/getDizColore", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni i colori degli occhiali",
            notes = "Restituisce una lista di colori disponibili.",
            response = DizCategoriaDto.class)
    public ResponseEntity<Map<String, Object>> getDizColore(){
        try {
            LOGGER.info("Chiamata REST /getDizColore");

            List<DizColoreDto> dto = dizColoreService.findAllByAttivo();

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista dei colori disponibili");
            result.put(OPERAZIONE, "Info dati colori");

            LOGGER.info("Fine chiamata Rest /getDizColore");

            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @GetMapping(value = "/getDizGenere", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni i generi degli occhiali",
            notes = "Restituisce una lista di generi disponibili.",
            response = DizCategoriaDto.class)
    public ResponseEntity<Map<String, Object>> getDizGenere(){
        try {
            LOGGER.info("Chiamata REST /getDizGenere");

            List<DizGenereDto> dto = dizGenereService.findAllByAttivo();

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista delle generi disponibili");
            result.put(OPERAZIONE, "Info dati generi");

            LOGGER.info("Fine chiamata Rest /getDizGenere");

            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @GetMapping(value = "/getDizMarchio", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni i marchi degli occhiali",
            notes = "Restituisce una lista di marchi disponibili.",
            response = DizCategoriaDto.class)
    public ResponseEntity<Map<String, Object>> getDizMarchio(){
        try {
            LOGGER.info("Chiamata REST /getDizMarchio");

            List<DizMarchioDto> dto = dizMarchioService.findAllByAttivo();

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista delle marchi disponibili");
            result.put(OPERAZIONE, "Info dati marchi");

            LOGGER.info("Fine chiamata Rest /getDizMarchio");

            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

    @GetMapping(value = "/getDizStatoCarrello", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni stati carrelli",
            notes = "Restituisce una lista di stati carrelli disponibili.",
            response = DizCategoriaDto.class)
    public ResponseEntity<Map<String, Object>> getDizStatoCarrello(){
        try {
            LOGGER.info("Chiamata REST /getDizStatoCarrello");

            List<DizStatoCarrelloDto> dto = dizStatoCarrelloService.findAllByAttivo();

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista degli stati del carrello disponibili");
            result.put(OPERAZIONE, "Info dati stati carrelli");

            LOGGER.info("Fine chiamata Rest /getDizStatoCarrello");

            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);
        }
    }

}
