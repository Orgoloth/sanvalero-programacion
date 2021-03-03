package edu.sanvalero.manuel.actividadaprendizaje2.gestion.domain.park;

public class Park {
    private ParkId id;
    private ParkName name;
    private ParkExtension extension;
    private ParkState state;
    private ParkCity city;

    public Park(ParkId parkId, ParkName parkName, ParkExtension parkExtension, ParkState parkState, ParkCity parkCity) {
        this.id = parkId;
        this.name = parkName;
        this.extension = parkExtension;
        this.state = parkState;
        this.city = parkCity;
    }

    public static Park create(ParkId parkId, ParkName parkName, ParkExtension parkExtension, ParkState parkState,
            ParkCity parkCity) {
        return new Park(parkId, parkName, parkExtension, parkState, parkCity);
    }

    public void updateName(ParkName newName) {
        name = newName;
    }

    public void updateCity(ParkCity newCity) {
        city = newCity;
    }

    public void updateState(ParkState newState) {
        state = newState;
    }

    public ParkId getId() {
        return id;
    }

    public ParkName getName() {
        return name;
    }

    public ParkExtension getExtension() {
        return extension;
    }

    public ParkState getState() {
        return state;
    }

    public ParkCity getCity() {
        return city;
    }

}
