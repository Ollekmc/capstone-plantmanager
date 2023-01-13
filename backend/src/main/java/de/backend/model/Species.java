package de.backend.model;

public record Species (
        String id,
        String name,
        int fertilizerDemand,
        int waterDemand,
        Habitat habitat,
        Soil soil
) {

}
