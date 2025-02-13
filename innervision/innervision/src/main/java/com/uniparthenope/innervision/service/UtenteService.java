package com.uniparthenope.innervision.service;

import com.uniparthenope.innervision.common.InfoUtente;
import com.uniparthenope.innervision.common.RequestLogin;
import com.uniparthenope.innervision.dto.UtenteDto;
import com.uniparthenope.innervision.entity.Utente;
import org.springframework.security.core.userdetails.UserDetails;

public interface UtenteService {

    Long registrazione(Utente utente);

    String login(RequestLogin requestLogin);

    UserDetails getInfoUtente(String username);

    UtenteDto getUtenteByUsername(String username);
}
