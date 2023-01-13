package de.backend.model;

import java.util.List;
import java.util.Objects;

public class User {
    String id;
    String name;
    List<Plant> plants;

    public User(String id, String name, List<Plant> plants) {
        this.id = id;
        this.name = name;
        this.plants = plants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(plants, user.plants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, plants);
    }
}
