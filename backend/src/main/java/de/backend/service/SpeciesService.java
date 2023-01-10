package de.backend.service;

import de.backend.exception.NoSuchSpeciesException;
import de.backend.model.Species;
import de.backend.repo.SpeciesRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {

    private final SpeciesRepo speciesRepo;
    private final IdService idService;

    public SpeciesService(SpeciesRepo speciesRepo, IdService idService) {
        this.speciesRepo = speciesRepo;
        this.idService = idService;
    }
    public List<Species> list() {
        return speciesRepo.findAll();
    }
    public Species findById(String id) {
        Optional<Species> optionalSpecies = speciesRepo.findById(id);
        if (optionalSpecies.isPresent()) {
            return optionalSpecies.get();
        }
        throw new IllegalArgumentException("Id not found!");
    }
    public Species addSpecies(Species species) {
        return speciesRepo.save(species);
    }

    public List<Species> search(String s) {
        List<Species> searchResultList = new ArrayList<>();
        for (Species species: list()) {
            if (species.name().contains(s)){
                searchResultList.add(species);
            }
        }

        return searchResultList;
    }
    public Species updateSpecies(String id, Species editedSpecies) throws NoSuchSpeciesException {
        checkIfSpeciesExists(id);
        return speciesRepo.save(editedSpecies);
    }
    private void checkIfSpeciesExists(String id) throws NoSuchSpeciesException {
        for (Species species :
                list()) {
            if (species.id().equals(id)) {
                return;
            }
        }
        throw new NoSuchSpeciesException("Species with id"+ id+" not found ");
    }
    public void delete(String id) {
        Species species = findById(id);
        speciesRepo.delete(species);
    }
}
