package edu.sanvalero.manuel.actividadaprendizaje2.gestion.gardens.domain;

import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.City;

public class Garden {
    private GardenId id;
    private GardenName name;
    private GardenExtension extension;
    private City city;

    public Garden(GardenId gardenId, GardenName gardenName, GardenExtension gardenExtension, City gardenCity) {
        this.id = gardenId;
        this.name = gardenName;
        this.extension = gardenExtension;
        this.city = gardenCity;
    }

    public static Garden create(GardenId gardenId, GardenName gardenName, GardenExtension gardenExtension,
            City gardenCity) {
        return new Garden(gardenId, gardenName, gardenExtension, gardenCity);
    }

    public void updateName(GardenName newName) {
        name = newName;
    }

    public void updateCity(City newCity) {
        city = newCity;
    }

    public void updateExtension(GardenExtension newExtension) {
        extension = newExtension;
    }

    public GardenId id() {
        return id;
    }

    public GardenName name() {
        return name;
    }

    public GardenExtension extension() {
        return extension;
    }

    public City city() {
        return city;
    }
}
