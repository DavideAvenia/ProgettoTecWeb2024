package com.uniparthenope.innervision.controller;

import static com.uniparthenope.innervision.common.DefaultStrings.*;

import com.uniparthenope.innervision.dto.ArticoloDto;
import com.uniparthenope.innervision.service.ArticoloService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articoli")
public class VisualizzaArticoliController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisualizzaArticoliController.class);

    @Autowired
    private ArticoloService articoloService;

    @GetMapping(value = "/getAllArticoli", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni tutti gli articoli",
            notes = "Restituisce una lista di categorie disponibili.")
    public ResponseEntity<Map<String, Object>> getAllArticoli(){
        try{
            LOGGER.info("Chiamata REST /getAllArticoli");

            List<ArticoloDto> dto = articoloService.findAllArticoli();

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista degli articoli");
            result.put(OPERAZIONE, "Info Articoli");

            LOGGER.info("Fine chiamata Rest /getAllArticoli");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);

        }
    }

    @PostMapping(value = "/getReccomendArticoli", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni tutti gli articoli",
            notes = "Restituisce una lista di categorie disponibili.")
    public ResponseEntity<Map<String, Object>> getReccomendArticoli(@RequestBody Long idUtente){
        try{
            LOGGER.info("Chiamata REST /getReccomendArticoli");

            List<ArticoloDto> dto = articoloService.findArticoliByReccomend(idUtente);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista degli articoli raccomandati");
            result.put(OPERAZIONE, "Info Articoli raccomandati");

            LOGGER.info("Fine chiamata Rest /getReccomendArticoli");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);

        }
    }

    @GetMapping(value = "/getArticoloById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni un articolo tramite un id",
            notes = "Restituisce un articolo tramite un id.")
    public ResponseEntity<Map<String, Object>> getArticoloById(@RequestParam Long id){
        try{
            LOGGER.info("Chiamata REST /getArticoloById");

            ArticoloDto dto = articoloService.findArticoloById(id);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Articolo trovato tramite id");
            result.put(OPERAZIONE, "Info Articolo");

            LOGGER.info("Fine chiamata Rest /getArticoloById");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);

        }
    }

    @GetMapping(value = "/getArticoliByNome", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni un articolo tramite una stringa di ricerca",
            notes = "Restituisce un articolo tramite una stringa di ricerca.")
    public ResponseEntity<Map<String, Object>> getArticoliByNome(@RequestParam String nome){
        try{
            LOGGER.info("Chiamata REST /getArticoliByNome");

            List<ArticoloDto> dto = new ArrayList<>();

            if(nome == null || nome.isBlank()){
                dto = articoloService.findAllArticoli();
            }else{
                dto = articoloService.findArticoloByNome(nome);
            }

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Articoli trovati tramite nome");
            result.put(OPERAZIONE, "Info Articolo");

            LOGGER.info("Fine chiamata Rest /getArticoliByNome");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);

        }
    }

    @GetMapping(value = "/getArticoliByCategoria", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni un articolo tramite categoria",
            notes = "Restituisce un articolo tramite categoria.")
    public ResponseEntity<Map<String, Object>> getArticoliByCategoria(@RequestParam Long idCategoria){
        try{
            LOGGER.info("Chiamata REST /getArticoliByCategoria");

            List<ArticoloDto> dto = articoloService.findArticoliByCategoria(idCategoria);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Articoli trovati tramite categoria");
            result.put(OPERAZIONE, "Info Articolo");

            LOGGER.info("Fine chiamata Rest /getArticoliByCategoria");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);

        }
    }

    @GetMapping(value = "/getArticoliByMarca", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni un articolo tramite una marca",
            notes = "Restituisce un articolo tramite una marca.",
            response = ArticoloDto.class)
    public ResponseEntity<Map<String, Object>> getArticoliByMarca(@RequestParam Long idMarca){
        try{
            LOGGER.info("Chiamata REST /getArticoliByMarca");

            List<ArticoloDto> dto = articoloService.findArticoliByMarca(idMarca);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Articoli trovati tramite marca");
            result.put(OPERAZIONE, "Info Articolo");

            LOGGER.info("Fine chiamata Rest /getArticoliByMarca");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERRORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERRORE, e);

        }
    }
}
