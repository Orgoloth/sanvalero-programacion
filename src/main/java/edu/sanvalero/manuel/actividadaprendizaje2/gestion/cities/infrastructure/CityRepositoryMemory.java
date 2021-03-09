package edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.infrastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.City;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityId;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityNotFound;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityRepository;

public class CityRepositoryMemory implements CityRepository {
    private Map<CityId, City> cities = new HashMap<>();

    @Override
    public void save(City city) {
        cities.put(city.id(), city);
    }

    @Override
    public City search(CityId id) {
        checkCityExists(id);
        return cities.get(id);
    }

    @Override
    public Collection<City> list() {
        return cities.values();
    }

    private void checkCityExists(CityId id) {
        if (!cities.containsKey(id)) {
            throw new CityNotFound(id);
        }
    }

}
