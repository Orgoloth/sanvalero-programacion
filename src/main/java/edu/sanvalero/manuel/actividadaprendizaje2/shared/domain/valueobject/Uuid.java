package edu.sanvalero.manuel.actividadaprendizaje2.shared.domain.valueobject;

import java.util.UUID;

public abstract class Uuid {
    private UUID uuid;

    public Uuid(UUID uuid) {
        this.uuid = uuid;
    }

    public static UUID random() {
        return UUID.randomUUID();
    }

    public UUID value() {
        return uuid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value() == null) ? 0 : value().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Uuid other = (Uuid) obj;
        if (value() == null) {
            if (other.value() != null)
                return false;
        } else if (!value().equals(other.value()))
            return false;
        return true;
    }

}
