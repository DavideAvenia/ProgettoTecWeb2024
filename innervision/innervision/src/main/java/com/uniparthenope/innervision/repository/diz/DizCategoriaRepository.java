package com.uniparthenope.innervision.repository.diz;

import com.uniparthenope.innervision.entity.diz.DizCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DizCategoriaRepository extends JpaRepository<DizCategoria, Long> {

    @Query(value = "Select * FROM DIZ_CATEGORIA WHERE ATTIVO = 'S'", nativeQuery = true)
    List<DizCategoria> findAllByAttivo();
}
