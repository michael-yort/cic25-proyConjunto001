package es.cic25.proyectoconjunto.proyectoConjunto.model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    // ATRIBUTOS
    public String nombre;
    public String descripcion;
    public LocalDate fechaInicio;
    public boolean estado;


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

    @Override
    public String toString() {
        return "Habito [id=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", estado=" + estado
                + ", categoria=" + categoria + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Habito other = (Habito) obj;
        if (id != other.getId())
            return false;
        return true;
    }
}
