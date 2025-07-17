package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic25.proyectoconjunto.proyectoConjunto.Categoria;
import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.service.HabitoService;


@RestController
@RequestMapping("/habito")
public class HabitoController {
    @Autowired
    private HabitoService habitoService;

    @GetMapping("/{id}")
    public Habito get(@PathVariable long id){
        Habito habito1 = new Habito();

        habito1.setId(id);
        habito1.setNombre("Nuevo hábito");
        habito1.setDescripcion("Descripción de mi nuevo hábito");
        habito1.setFechaInicio(LocalDate.now());
        habito1.setEstado(true);

        habito1.setId(id);

        habito1.setCategoria(Categoria.CREATIVIDAD);

        return habito1;
    }

    @PostMapping
    public Habito create(@RequestBody Habito habito){

        habito = habitoService.create(habito);
        

        return habito;
    }

    @PutMapping
    public void update(@RequestBody Habito habito){
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        throw new UnsupportedOperationException();
    }
}
