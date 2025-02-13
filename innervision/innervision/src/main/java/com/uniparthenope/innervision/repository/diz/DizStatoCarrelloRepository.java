package com.uniparthenope.innervision.repository.diz;

import com.uniparthenope.innervision.entity.diz.DizMarchio;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DizStatoCarrelloRepository extends JpaRepository<DizStatoCarrello, Long> {

    @Query(value = "Select * FROM DIZ_STATO_CARRELLO WHERE ATTIVO = 'S'", nativeQuery = true)
    List<DizStatoCarrello> findAllByAttivo();
}
