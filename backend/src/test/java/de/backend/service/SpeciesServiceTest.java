package de.backend.service;

import de.backend.model.Habitat;
import de.backend.model.Soil;
import de.backend.model.Species;
import de.backend.repo.SpeciesRepo;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class SpeciesServiceTest {

    private final SpeciesRepo speciesRepo = mock(SpeciesRepo.class);

    private final IdService idService = mock(IdService.class);

    @Test
    void shouldAddSpecies() {
        //GIVEN
        Species speciesToAdd = new Species("1","TestName",5,5, Habitat.SEMISHADED, Soil.HUMIC);
        when(speciesRepo.save(speciesToAdd)).thenReturn(speciesToAdd);
        SpeciesService speciesService = new SpeciesService(speciesRepo,idService);
        //WHEN
        Species result = speciesService.addSpecies(speciesToAdd);
        //THEN
        assertThat(result, is(speciesToAdd));
        verify(speciesRepo).save(speciesToAdd);
    }
}