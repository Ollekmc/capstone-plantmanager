package de.backend.model;

import java.util.Date;

public record Plant(
        String id,
        String name,
        Species species,
        Date plantDate,
        double height
) {
}
