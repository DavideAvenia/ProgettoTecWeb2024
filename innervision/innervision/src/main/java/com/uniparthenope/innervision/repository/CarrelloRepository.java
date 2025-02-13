package com.uniparthenope.innervision.repository;

import com.uniparthenope.innervision.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
    Carrello getCarrelloByIdCarrello(Long idCarrello);
}
