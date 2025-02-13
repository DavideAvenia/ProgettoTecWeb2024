package com.uniparthenope.innervision.repository.diz;

import com.uniparthenope.innervision.entity.diz.DizGenere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DizGenereRepository extends JpaRepository<DizGenere, Long> {

    @Query(value = "Select * FROM DIZ_GENERE WHERE ATTIVO = 'S'", nativeQuery = true)
    List<DizGenere> findAllByAttivo();
}
