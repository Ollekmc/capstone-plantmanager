package de.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SpeciesIdentity (
        String scientificName,
        String commonName,
        double score
){
}
