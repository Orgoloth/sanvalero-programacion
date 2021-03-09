package edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain;

import java.util.Collection;

public interface CityRepository {
    public void save(City city);

    public City search(CityId id);

    public Collection<City> list();
}
