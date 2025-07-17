package es.cic25.proyectoconjunto.proyectoConjunto;

import java.sql.Date;
import java.time.LocalDate;

public class Habito {

    // ATRIBUTOS
    public String nombre;
    public String descripcion;
    public LocalDate fechaInicio;
    public boolean estado;
    public long id;

    public Categoria categoria;

    public Date ultimaFechaCompletada;

    public Date[] fechasCompletadas;

    
    //Getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getUltimaFechaCompletada() {
        return ultimaFechaCompletada;
    }

    public void setUltimaFechaCompletada(Date ultimaFechaCompletada) {
        this.ultimaFechaCompletada = ultimaFechaCompletada;
    }

    public Date[] getFechasCompletadas() {
        return fechasCompletadas;
    }

    public void setFechasCompletadas(Date[] fechasCompletadas) {
        this.fechasCompletadas = fechasCompletadas;
    }
   
}
