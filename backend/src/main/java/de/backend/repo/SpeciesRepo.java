package de.backend.repo;

import de.backend.model.Species;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepo extends MongoRepository<Species, String> {
}
