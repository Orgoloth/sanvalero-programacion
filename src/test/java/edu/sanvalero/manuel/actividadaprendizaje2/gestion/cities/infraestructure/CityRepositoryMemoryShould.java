package edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.infraestructure;

import org.junit.jupiter.api.Test;

import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.City;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityMother;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain.CityRepository;
import edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.infrastructure.CityRepositoryMemory;

public class CityRepositoryMemoryShould {
    @Test
    void save_a_city() {
        System.out.println("CityRepositoryMemoryShould.save_a_city()");
        City city = CityMother.create();
        CityRepository repository = new CityRepositoryMemory();
        repository.save(city);
    }
}
