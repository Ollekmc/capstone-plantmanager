package de.backend.controller;

import de.backend.model.Species;
import de.backend.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/plants")
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService){
        this.speciesService = speciesService;
    }

    @PostMapping()
    public Species addSpecies(@RequestBody Species species) {
        return speciesService.addSpecies(species);
    }

}
