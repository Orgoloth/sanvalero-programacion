package edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain;

public final class City {
    private CityId id;
    private CityName name;
    private CityRegion region;

    public City(CityId id, CityName name, CityRegion region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public static City create(CityId id, CityName name, CityRegion region) {
        return new City(id, name, region);
    }

    public CityId id() {
        return id;
    }

    public CityName name() {
        return name;
    }

    public CityRegion region() {
        return region;
    }
}
