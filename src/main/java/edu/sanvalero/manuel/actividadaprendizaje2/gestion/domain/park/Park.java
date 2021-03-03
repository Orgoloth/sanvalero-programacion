package edu.sanvalero.manuel.actividadaprendizaje2.gestion.domain.park;

public class Park {
    private ParkName name;
    private ParkExtension extension;
    private ParkState state;
    private ParkCity city;

    public Park(ParkName parkName, ParkExtension parkExtension, ParkState parkState, ParkCity parkCity) {
        this.name = parkName;
        this.extension = parkExtension;
        this.state = parkState;
        this.city = parkCity;
    }

    /**
     * Named constructor
     * 
     * @param parkName
     * @param parkExtension
     * @param parkState
     * @param parkCity
     * @return
     */
    public static Park create(ParkName parkName, ParkExtension parkExtension, ParkState parkState, ParkCity parkCity) {
        return new Park(parkName, parkExtension, parkState, parkCity);
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
