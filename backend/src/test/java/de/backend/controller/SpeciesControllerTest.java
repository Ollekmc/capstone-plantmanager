package de.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.backend.model.Habitat;
import de.backend.model.Soil;
import de.backend.model.Species;
import de.backend.repo.SpeciesRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class SpeciesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    SpeciesRepo speciesRepo;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DirtiesContext
    void shouldAddSpecies() throws Exception {
        MvcResult response = mockMvc.perform(post("/api/plants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        """
{
"name": "TestName"
}
"""
                ))
                .andExpect(status().isOk())
                .andReturn();

        String content = response.getResponse().getContentAsString();
        Species result = objectMapper.readValue(content, Species.class);
        Species expected = new Species (result.id(), result.name(), result.waterDemand(), result.fertilizerDemand(), result.habitat(),result.soil());

        assertEquals(result,expected);
    }
    @Test
    @DirtiesContext
    void shouldReturnSpeciesList () throws Exception {
    mockMvc.perform(get("/api/plants"))
             .andExpect(status().isOk())
             .andExpect(content().json("[]"))
             .andReturn();
    }
    @Test
    void shouldDeleteSpeciesById() throws Exception {
        Species species = new Species("1","TestName",5,5, Habitat.SEMISHADED, Soil.HUMIC);
        speciesRepo.save(species);
       mockMvc.perform(delete("/api/plants/{id}", "1"))
               .andExpect(status().isOk());
    }
    @Test
    void shouldGetSpeciesById() throws Exception {
        Species species = new Species("1","TestName",5,5, Habitat.SEMISHADED, Soil.HUMIC);
        speciesRepo.save(species);
        mockMvc.perform(get("/api/plants/{id}","1"))
                .andExpect(status().isOk());
    }

}