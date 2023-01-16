package de.backend.service;

import de.backend.model.Species;
import de.backend.repo.SpeciesRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeciesService {

    private final SpeciesRepo speciesRepo;

    public final IdService idService;

    public SpeciesService(SpeciesRepo speciesRepo, IdService idService) {
        this.speciesRepo = speciesRepo;
        this.idService = idService;
    }

    public List<Species> list() {
        return speciesRepo.findAll();
    }
    public Species findById(String id) {
        return speciesRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found!"));
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
    public void delete(String id) {
        Species species = findById(id);
        speciesRepo.delete(species);
    }
}
