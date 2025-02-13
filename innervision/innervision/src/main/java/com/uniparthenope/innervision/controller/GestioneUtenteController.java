package com.uniparthenope.innervision.controller;

import static com.uniparthenope.innervision.common.DefaultStrings.*;

import com.uniparthenope.innervision.common.RequestLogin;
import com.uniparthenope.innervision.dto.UtenteDto;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.service.CarrelloService;
import com.uniparthenope.innervision.service.UtenteService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class GestioneUtenteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GestioneUtenteController.class);

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private CarrelloService carrelloService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Effettua la registrazione di un utente",
            notes = "Restituisce l'utente registrato.",
            response = UtenteDto.class)
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody Utente utenteInInput) {
        try {
            LOGGER.info("Chiamata REST /register");

            Long idUtenteRegistrato = utenteService.registrazione(utenteInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, idUtenteRegistrato);
            result.put(MESSAGGIO, "Registrazione avvenuta con successo");
            result.put(OPERAZIONE, "Registrazione Utente");

            LOGGER.info("Fine chiamata Rest /register");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, -1);
            result.put(MESSAGGIO, "Registrazione fallita");
            result.put(OPERAZIONE, "Registrazione Utente");

            LOGGER.info("Errore nella chiamata Rest /register");
            LOGGER.error(MESSAGGIO_ERRORE, e);

            return ResponseEntity.ok().body(result);
        }
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Effettua la registrazione di un utente",
            notes = "Restituisce l'utente registrato.",
            response = UtenteDto.class)
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody RequestLogin requestLogin) {
        try {
            LOGGER.info("Chiamata REST /login");

            String tokenLogin = utenteService.login(requestLogin);

            Map<String, Object> result = new HashMap<>();
            result.put(CARRELLO, carrelloService.getCarrelloByUsername(requestLogin.getUsername()));
            result.put(UTENTE_LOGGATO, utenteService.getInfoUtente(requestLogin.getUsername()));
            result.put(TOKEN, tokenLogin);
            result.put(MESSAGGIO, "Login avvenuta con successo");
            result.put(OPERAZIONE, "Login Utente");

            LOGGER.info("Token inviato: " + tokenLogin);
            LOGGER.info("Fine chiamata Rest /Login");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            Map<String, Object> result = new HashMap<>();
            result.put(TOKEN, -1);
            result.put(MESSAGGIO, "Login fallito");
            result.put(OPERAZIONE, "Login Utente");

            LOGGER.info("Errore nella chiamata Rest /Login");
            LOGGER.error(MESSAGGIO_ERRORE, e);

            return ResponseEntity.ok().body(result);
        }
    }

    @PostMapping(value = "/getInfoUtente", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Effettua la registrazione di un utente",
            notes = "Restituisce l'utente registrato.",
            response = UtenteDto.class)
    public ResponseEntity<Map<String, Object>> getInfoUtente(@RequestBody String usernameLoggato) {
        try {
            LOGGER.info("Chiamata REST /getInfoUtente");

            UtenteDto utenteDto = utenteService.getUtenteByUsername(usernameLoggato);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, utenteDto);
            result.put(MESSAGGIO, "Informazioni utente ottenute");
            result.put(OPERAZIONE, "Info Utente");

            LOGGER.info("Fine chiamata Rest /getInfoUtente");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            Map<String, Object> result = new HashMap<>();
            result.put(TOKEN, -1);
            result.put(MESSAGGIO, "Login fallito");
            result.put(OPERAZIONE, "Login Utente");

            LOGGER.info("Errore nella chiamata Rest /Login");
            LOGGER.error(MESSAGGIO_ERRORE, e);

            return ResponseEntity.ok().body(result);
        }
    }
}
