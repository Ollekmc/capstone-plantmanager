package de.backend.service;

import de.backend.model.Species;
import de.backend.repo.SpeciesRepo;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService {

    private final SpeciesRepo speciesRepo;

    private final IdService idService;

    public SpeciesService(SpeciesRepo speciesRepo, IdService idService) {
        this.speciesRepo = speciesRepo;
        this.idService = idService;
    }

    public Species addSpecies(Species species) {
        species.setId(idService.generateId());
        return speciesRepo.save(species);
    }

}
