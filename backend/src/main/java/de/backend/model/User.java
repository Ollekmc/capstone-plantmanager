package de.backend.model;

public class User {
    String id;
    String name;
    Plant[] plants;

    public User(String id, String name, Plant[] plants) {
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

    public Plant[] getPlants() {
        return plants;
    }

    public void setPlants(Plant[] plants) {
        this.plants = plants;
    }
}
