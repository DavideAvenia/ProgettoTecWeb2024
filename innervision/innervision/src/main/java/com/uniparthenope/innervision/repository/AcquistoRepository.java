package com.uniparthenope.innervision.repository;


import com.uniparthenope.innervision.entity.Acquisto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquistoRepository extends JpaRepository<Acquisto, Long> {
}
