package com.uniparthenope.innervision.util;

import com.uniparthenope.innervision.dto.UtenteDto;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import com.uniparthenope.innervision.mapper.UtenteMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private final UtenteDto utenteDto;
    private final DizTipologiaUtente tipologiaUtente;


    public UserDetailsImpl(Utente utente, UtenteMapper utenteMapper, DizTipologiaUtente tipologiaUtente) {
        this.tipologiaUtente = tipologiaUtente;
        this.utenteDto = utenteMapper.entityToDto(utente);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return utenteDto.getPassword();
    }

    @Override
    public String getUsername() {
        return utenteDto.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
