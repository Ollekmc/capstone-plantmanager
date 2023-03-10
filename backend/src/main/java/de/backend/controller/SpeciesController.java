package de.backend.controller;

import de.backend.model.Species;
import de.backend.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/plants")
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService){
        this.speciesService = speciesService;
    }

    @GetMapping
    public List<Species> listSpecies(@RequestParam Optional<String> search) {
        if (search.isPresent()) {
            return speciesService.search(search.get());
        }
        return speciesService.list();
    }
    @GetMapping("{id}")
    public Species getSpecies(@PathVariable String id) {
        return speciesService.findById(id);
    }

    @PostMapping()
    public Species addSpecies(@RequestBody Species species) {
        return speciesService.addSpecies(species);
    }
    @DeleteMapping("{id}")
    public void deleteSpecies(@PathVariable String id){speciesService.delete(id);}

}
