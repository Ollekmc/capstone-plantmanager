package de.backend.service;

import de.backend.model.Habitat;
import de.backend.model.Soil;
import de.backend.model.Species;
import de.backend.repo.SpeciesRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpeciesServiceTest {

    private final SpeciesRepo speciesRepo = mock(SpeciesRepo.class);

    private final IdService idService = mock(IdService.class);

    Species species = new Species("1","Ficus",5,5, Habitat.SUNNY, Soil.HUMIC);
    Species species1 = new Species("2","Monstera", 5,5,Habitat.SHADED, Soil.HUMIC);
    Species species2 = new Species("3","Palm", 5,5, Habitat.SEMISHADED, Soil.HUMIC);

    @Test
    void shouldAddSpecies() {
        //GIVEN
        Species speciesToAdd = new Species("1","TestName",5,5, Habitat.SEMISHADED, Soil.HUMIC);
        when(speciesRepo.save(speciesToAdd)).thenReturn(speciesToAdd);
        SpeciesService speciesService = new SpeciesService(speciesRepo,idService);
        //WHEN
        Species result = speciesService.addSpecies(speciesToAdd);
        //THEN
        assertEquals(result, speciesToAdd);
    }
    @Test
    void testAddStudent() {
        //GIVEN
        Species studentToAdd = new Species("5", "Hans",5,5,Habitat.SEMISHADED,Soil.HUMIC);
        when(speciesRepo.save(studentToAdd)).thenReturn(studentToAdd);
        SpeciesService studentService = new SpeciesService(speciesRepo, idService);

        //WHEN
        Species actual = studentService.addSpecies(studentToAdd);

        //THEN
        assertThat(actual, is(studentToAdd));
        verify(speciesRepo).save(studentToAdd);
    }

    @Test
    void shouldReturnListOfSpecies() {
        //GIVEN
        when(speciesRepo.findAll()).thenReturn(
                List.of(
                        species,
                        species1,
                        species2
                )
        );
        SpeciesService plantSpeciesService = new SpeciesService(speciesRepo,idService);
        //WHEN
        List<Species> actual = plantSpeciesService.list();
        //THEN
        assertThat(actual, containsInAnyOrder(
                species2,
                species1,
                species
        ));
    }
    @Test
    void should_Return_Species_By_Id() {
        //GIVEN
        Species species = new Species("1","Ficus", 5,5, Habitat.SUNNY, Soil.HUMIC);
        when(speciesRepo.findById("1")).thenReturn(Optional.of(species));
        SpeciesService plantSpeciesService = new SpeciesService(speciesRepo,idService);


        //WHEN
        Species result = plantSpeciesService.findById("1");

        //THEN
        assertThat(result, is(species));
    }

    @Test
    void search_Should_Return_Species() {
        //GIVEN
        Species species;
        when(speciesRepo.findAll()).thenReturn(
                List.of(
                        new Species("1","Ficus", 5,5, Habitat.SHADED, Soil.HUMIC),
                        species = new Species("2","Monstera", 5,5, Habitat.SEMISHADED, Soil.HUMIC),
                        new Species("3","Palm", 5,5, Habitat.SEMISHADED, Soil.HUMIC)
                )
        );
        SpeciesService plantSpeciesService = new SpeciesService(speciesRepo, idService);
        //WHEN
        List<Species> actual = plantSpeciesService.search("Mon");
        //THEN
        assertThat(actual, containsInAnyOrder(
                species

        ));

    }
    @Test
    void should_Delete_By_Id() {
        //GIVEN
        Species species = new Species("1","Ficus", 5,5, Habitat.SEMISHADED, Soil.HUMIC);
        when(speciesRepo.findById("1")).thenReturn(Optional.of(species));
        SpeciesService plantSpeciesService = new SpeciesService(speciesRepo,idService);
        //WHEN
        plantSpeciesService.delete("1");
        //THEN
        verify(speciesRepo).delete(species);
    }
}