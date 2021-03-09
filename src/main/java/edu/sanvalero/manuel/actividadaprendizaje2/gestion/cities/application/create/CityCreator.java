package edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.application.create;

import java.util.UUID;

import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.City;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityId;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityName;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityRegion;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityRepository;

public final class CityCreator {
    private CityRepository repository;

    public CityCreator(CityRepository repository) {
        this.repository = repository;
    }

    public void create(UUID id, String rawName, String rawRegion) {
        City newCity = City.create(new CityId(id), new CityName(rawName), new CityRegion(rawRegion));
        repository.save(newCity);
    }

}
