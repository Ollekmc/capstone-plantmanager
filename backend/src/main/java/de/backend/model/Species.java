package de.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Species (
        String id,
        String name,
        int fertilizerDemand,
        int waterDemand,
        Habitat habitat,
        Soil soil
) {

}
