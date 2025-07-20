package es.cic25.proyectoconjunto.proyectoConjunto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.service.HabitoService;

@SpringBootTest
public class HabitoServiceIntegrationTest {

    @Autowired
    private HabitoService habitoService;

    @Test
    void testCreate() {

        String nombreHabito = "habito";

        Habito habito = new Habito();
        habito.setNombre("habito");

        Habito habito2 = habitoService.create(habito);

        // habitoController.
        assertEquals(nombreHabito, habito2.getNombre());
    }

    @Test
    void testUpdate() {
        // 1. Creo un hábito inicial
        Habito habito = new Habito();
        habito.setNombre("Hábito original");
        Habito habitoCreadoEnRepo = habitoService.create(habito);

        // 2. Modifico el nombre del hábito
        habitoCreadoEnRepo.setNombre("Hábito actualizado");

        // 3. Actualizo en la base de datos
        Habito habitoActualizado = habitoService.update(habitoCreadoEnRepo);

        // 4. Recupero desde el repositorio para confirmar cambio
        Optional<Habito> recuperado = habitoService.get(habitoActualizado.getId());

        // 5. Verifico que el cambio se guardó correctamente
        assertEquals("Hábito actualizado", recuperado.get().getNombre());
    }

}
