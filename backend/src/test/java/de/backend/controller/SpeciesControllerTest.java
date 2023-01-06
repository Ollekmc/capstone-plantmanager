package de.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        Species expected = new Species (result.getId(), result.getName(), result.getWaterDemand(), result.getFertilizerDemand(), result.getHabitat(),result.getSoil());

        String resultString = result.getId()+result.getName()+result.getWaterDemand()+result.getFertilizerDemand()+result.getHabitat()+result.getSoil();
        String expectedString = expected.getId()+expected.getName()+expected.getWaterDemand()+expected.getFertilizerDemand()+expected.getHabitat()+expected.getSoil();

        assertEquals(resultString,expectedString);

    }
}