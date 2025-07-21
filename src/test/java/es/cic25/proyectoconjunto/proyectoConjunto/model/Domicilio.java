package es.cic25.proyectoconjunto.proyectoConjunto.model;

import java.util.ArrayList;
import java.util.List;

public class Domicilio {

    private Long id;
    private String calle;
    private String ciudad;

    private List<Persona> personas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
