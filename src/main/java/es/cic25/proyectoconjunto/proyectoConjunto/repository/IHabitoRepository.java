package es.cic25.proyectoconjunto.proyectoConjunto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;

public interface IHabitoRepository extends JpaRepository<Habito,Long>{
    
}
