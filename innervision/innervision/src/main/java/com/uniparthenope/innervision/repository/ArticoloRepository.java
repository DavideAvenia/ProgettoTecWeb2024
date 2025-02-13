package com.uniparthenope.innervision.repository;

import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.diz.DizCategoria;
import com.uniparthenope.innervision.entity.diz.DizMarchio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Long> {

    @Query(value = "SELECT * FROM Articolo WHERE nome LIKE %:nome%",nativeQuery = true)
    List<Articolo> findArticoloByNome(@Param("nome") String nome);

    Articolo getArticoloByIdArticolo(Long idArticolo);

    @Query(value = "SELECT * FROM Articolo a WHERE id_diz_categoria = :idCategoria",
            nativeQuery = true)
    List<Articolo> findArticoliByCategoria(Long idCategoria);

    @Query(value = "SELECT * FROM Articolo WHERE id_diz_marchio = :idMarchio",
            nativeQuery = true)
    List<Articolo> findArticoliByMarchio(Long idMarchio);
}
