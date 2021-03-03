package edu.sanvalero.manuel.actividadaprendizaje2.gestion.domain.park;

import edu.sanvalero.manuel.actividadaprendizaje2.shared.domain.valueobject.Uuid;

public class ParkId extends Uuid {

    public ParkId() {
        super(Uuid.random());
    }

}
