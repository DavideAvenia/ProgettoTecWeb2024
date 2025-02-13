package com.uniparthenope.innervision.repository.diz;

import com.uniparthenope.innervision.entity.diz.DizMarchio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DizMarchioRepository extends JpaRepository<DizMarchio, Long> {

    @Query(value = "Select * FROM DIZ_MARCHIO WHERE ATTIVO = 'S'", nativeQuery = true)
    List<DizMarchio> findAllByAttivo();
}
