package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Categoria;
import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.service.HabitoService;

@RestController
@RequestMapping("/habito")
public class HabitoController {
    @Autowired
    private HabitoService habitoService;

    @GetMapping("/{id}")
    public Optional<Habito> get(@PathVariable long id) {

        Optional<Habito> habito = habitoService.get(id);

        return habito;

    }

    @GetMapping
    public List<Habito> get() {

        return habitoService.get();

    }

    @PostMapping
    public Habito create(@RequestBody Habito habito) {

        if (habito.getId() != 0) {

            throw new ModificacionSecurityException("Has tratado de modificar mediante creacion");
        }

        habito = habitoService.create(habito);

        return habito;
    }

    @PutMapping("/{id}")
    public Habito update(@PathVariable long id, @RequestBody Habito habito) {
        habito.setId(id); // asegura que el objeto tenga el ID correcto
        return habitoService.update(habito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {

        habitoService.delete(id);

    }
}
