package edu.sanvalero.manuel.actividadaprendizaje2.gestion.cities.domain;

public class CityNotFound extends IllegalArgumentException {
    /**
     *
     */
    private static final long serialVersionUID = -8173040227181689839L;

    private CityId id;

    public CityNotFound(CityId id) {
        super();
        this.id = id;
    }

    public String errorCode() {
        return "Ciudad no encontrada";
    }

    public String errorMessage() {
        return "La ciudad con el ID: " + id.value() + " no fue encontrada";
    }
}
