package es.cic25.proyectoconjunto.proyectoConjunto;

import org.springframework.stereotype.Service;


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
