package edu.sanvalero.manuel.actividadaprendizaje2.shared.domain.valueobject;

public abstract class IntValueObject {
    protected int value;

    public IntValueObject(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isBiggerThan(IntValueObject other) {
        return value() > other.value();
    }
}
