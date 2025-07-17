package es.cic25.proyectoconjunto.proyectoConjunto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.repository.IHabitoRepository;


@Service
public class HabitoService {

    @Autowired
    private IHabitoRepository iHabitoRepository;
    
    private long contador;

    public Habito create(Habito habito) {
        
        iHabitoRepository.save(habito);

        return habito;
        
    }

    public long getContador(){
        return this.contador;
    }
}
