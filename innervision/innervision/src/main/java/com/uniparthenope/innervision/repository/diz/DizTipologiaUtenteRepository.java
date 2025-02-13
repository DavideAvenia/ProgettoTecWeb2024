package com.uniparthenope.innervision.repository.diz;

import com.uniparthenope.innervision.entity.diz.DizMarchio;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DizTipologiaUtenteRepository extends JpaRepository<DizTipologiaUtente, Long> {

    @Query(value = "Select * FROM DIZ_TIPOLOGIA_UTENTE WHERE ATTIVO = 'S'", nativeQuery = true)
    List<DizTipologiaUtente> findAllByAttivo();
}
