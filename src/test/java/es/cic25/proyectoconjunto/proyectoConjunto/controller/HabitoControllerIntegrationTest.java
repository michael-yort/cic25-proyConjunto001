package es.cic25.proyectoconjunto.proyectoConjunto.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.body;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic25.proyectoconjunto.proyectoConjunto.model.Categoria;
import es.cic25.proyectoconjunto.proyectoConjunto.model.Habito;
import es.cic25.proyectoconjunto.proyectoConjunto.repository.HabitoRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class HabitoControllerIntegrationTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Autowired
        private HabitoRepository habitoRespository;

        @Test
        void testCreate() throws Exception {

                Habito habito = new Habito();
                habito.setNombre("Meditar");
                habito.setDescripcion("Meditar cada mañana");
                habito.setEstado(true);
                habito.setCategoria(Categoria.SALUD);

                // ObjectMapper objectMapper = new ObjectMapper();
                String habitoJson = objectMapper.writeValueAsString(habito);

                mockMvc.perform(post("/habito")
                                .contentType("application/json")
                                .content(habitoJson))
                                .andExpect(status().isOk())
                                .andExpect(result -> {
                                        String respuesta = result.getResponse().getContentAsString();
                                        Habito registroCreado = objectMapper.readValue(respuesta, Habito.class);
                                        assertTrue(registroCreado.getId() > 0, "El valor debe ser mayor que 0");

                                        Optional<Habito> registroRealmenteCreado = habitoRespository
                                                        .findById(registroCreado.getId());
                                        assertTrue(registroRealmenteCreado.isPresent());

                                });

        }


        //NO ESTA COMPLETOP MIRARLO DE EL VIDEO DE CLASE.
        @Test
        void testCreateIntentandoModificacion() throws Exception {

                Habito habito = new Habito();
                habito.setId(3);
                habito.setNombre("Meditar");
                habito.setDescripcion("Meditar cada mañana");
                habito.setEstado(true);
                habito.setCategoria(Categoria.SALUD);

                // ObjectMapper objectMapper = new ObjectMapper();
                String habitoJson = objectMapper.writeValueAsString(habito);

                mockMvc.perform(post("/habito")
                                .contentType("application/json")
                                .content(habitoJson))
                                .andExpect(status().isOk())
                                .andExpect(result -> {
                                        String respuesta = result.getResponse().getContentAsString();
                                        Habito registroCreado = objectMapper.readValue(respuesta, Habito.class);
                                        assertTrue(registroCreado.getId() > 0, "El valor debe ser mayor que 0");

                                        Optional<Habito> registroRealmenteCreado = habitoRespository
                                                        .findById(registroCreado.getId());
                                        assertTrue(registroRealmenteCreado.isPresent());

                                });

        }

        @Test
        void testGet() throws Exception {

                Habito habito = new Habito();
                habito.setNombre("Meditar");
                habito.setDescripcion("Meditar cada mañana");
                habito.setEstado(true);
                habito.setCategoria(Categoria.SALUD);

                ObjectMapper objectMapper = new ObjectMapper();
                String habitoJson = objectMapper.writeValueAsString(habito);

                mockMvc.perform(post("/habito")
                                .contentType("application/json")
                                .content(habitoJson))
                                .andExpect(status().isOk());

                mockMvc.perform(get("/habito/1"))
                                .andExpect(status().isOk());

                // Optional<Habito> habito2 = habitoController.get(1);

                // assertEquals(habito.getNombre(), habito2.get().getNombre());

        }

        @Test
        void testDelete() throws Exception {

                Habito habito = new Habito();
                habito.setNombre("Meditar");
                habito.setDescripcion("Meditar cada mañana");
                habito.setEstado(true);
                habito.setCategoria(Categoria.SALUD);

                ObjectMapper objectMapper = new ObjectMapper();
                String habitoJson = objectMapper.writeValueAsString(habito);

                mockMvc.perform(post("/habito")
                                .contentType("application/json")
                                .content(habitoJson))
                                .andExpect(status().isOk());

                mockMvc.perform(get("/habito/1"))
                                .andExpect(status().isOk());

                mockMvc.perform(delete("/habito/1"))
                                .andExpect(status().isOk())
                                .andReturn();

                // Optional<Habito> habito2 = habitoController.get(1);

                // assertEquals(Optional.empty(), habito2);

        }

        @Test
        void testUpdate() throws Exception {
                // 1. Crear un hábito
                Habito habito = new Habito();
                habito.setNombre("Leer");
                habito.setDescripcion("Leer cada noche");
                habito.setEstado(true);
                habito.setCategoria(Categoria.OCIO);

                String habitoJson = objectMapper.writeValueAsString(habito);
                String respuestaCreacion = mockMvc.perform(post("/habito")
                                .contentType("application/json")
                                .content(habitoJson))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString();

                Habito habitoCreado = objectMapper.readValue(respuestaCreacion, Habito.class);
                Long idCreado = habitoCreado.getId();

                // 2. Modificar el hábito
                habitoCreado.setNombre("Leer un libro");
                habitoCreado.setDescripcion("Leer cada noche 30 minutos");

                String habitoActualizadoJson = objectMapper.writeValueAsString(habitoCreado);

                // 3. Hacer PUT con el ID en la URL
                mockMvc.perform(put("/habito/" + idCreado)
                                .contentType("application/json")
                                .content(habitoActualizadoJson))
                                .andExpect(status().isOk())
                                .andExpect(result -> {
                                        String respuesta = result.getResponse().getContentAsString();
                                        Habito actualizado = objectMapper.readValue(respuesta, Habito.class);

                                        // Verificar los cambios
                                        assertEquals("Leer un libro", actualizado.getNombre());
                                        assertEquals("Leer cada noche 30 minutos", actualizado.getDescripcion());
                                        assertEquals(idCreado, actualizado.getId());
                                });
        }

}
