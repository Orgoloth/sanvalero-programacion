package edu.sanvalero.manuel.examen;

public enum Side {
    YODA('Y'), VADER('V'),

    DARTH_MAUL('D'), R2D2('R'),

    LIBRE('L'), POTION('P');

    static {
        YODA.foe = DARTH_MAUL;
        VADER.foe = R2D2;
        LIBRE.foe = LIBRE;
        POTION.foe = POTION;
    }

    private final char abbreviation;
    private Side foe;

    Side(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    public char abbreviation() {
        return this.abbreviation;
    }

    public Side foe() {
        return this.foe;
    }
}