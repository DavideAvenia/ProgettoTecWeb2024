package com.uniparthenope.innervision.repository;

import com.uniparthenope.innervision.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Utente findByUsername(String username);

    @Query(value = "SELECT * FROM UTENTE WHERE ID_UTENTE = :idUtente",
            nativeQuery = true)
    Utente getUtenteByIdUtente(Long idUtente);

    @Query(value = "SELECT * FROM UTENTE WHERE USERNAME = :username",
            nativeQuery = true)
    Utente getUtenteByUsername(String username);
}
