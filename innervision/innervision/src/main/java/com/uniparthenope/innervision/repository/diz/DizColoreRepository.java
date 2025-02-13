package com.uniparthenope.innervision.repository.diz;

import com.uniparthenope.innervision.entity.diz.DizCategoria;
import com.uniparthenope.innervision.entity.diz.DizColore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DizColoreRepository extends JpaRepository<DizColore, Long> {

    @Query(value = "Select * FROM DIZ_COLORE WHERE ATTIVO = 'S'", nativeQuery = true)
    List<DizColore> findAllByAttivo();
}
