package edu.sanvalero.manuel.actividadaprendizaje2.shared.domain.valueobject;

import java.util.UUID;

public abstract class UuidValueObject {
    private UUID uuid;

    public UuidValueObject(UUID value) {
        this.uuid = value;
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
        UuidValueObject other = (UuidValueObject) obj;
        if (value() == null) {
            if (other.value() != null)
                return false;
        } else if (!value().equals(other.value()))
            return false;
        return true;
    }
}
