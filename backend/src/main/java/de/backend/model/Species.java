package de.backend.model;

public class Species {
    String id;
    String name;
    int fertilizerDemand;
    int waterDemand;
    Habitat habitat;
    Soil soil;

    public Species(String id, String name, int fertilizerDemand, int waterDemand, Habitat habitat, Soil soil) {
        this.id = id;
        this.name = name;
        this.fertilizerDemand = fertilizerDemand;
        this.waterDemand = waterDemand;
        this.habitat = habitat;
        this.soil = soil;
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

    public int getFertilizerDemand() {
        return fertilizerDemand;
    }

    public void setFertilizerDemand(int fertilizerDemand) {
        this.fertilizerDemand = fertilizerDemand;
    }

    public int getWaterDemand() {
        return waterDemand;
    }

    public void setWaterDemand(int waterDemand) {
        this.waterDemand = waterDemand;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }
}
