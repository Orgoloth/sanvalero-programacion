package edu.sanvalero.manuel.actividadaprendizaje2.shared.domain.valueobject;

public abstract class StringValueObject {

    protected String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
