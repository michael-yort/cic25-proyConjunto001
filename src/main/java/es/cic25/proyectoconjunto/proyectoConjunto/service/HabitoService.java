package es.cic25.proyectoconjunto.proyectoConjunto.service;

import org.springframework.stereotype.Service;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;


@Service
public class HabitoService {
    private long contador;

    public long create(Habito habito){
        return ++contador;
    }

    public long getContador(){
        return this.contador;
    }
}
