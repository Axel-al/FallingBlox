package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {

    public static final int BLOX_COLLISION = 1;
    public static final int BLOX_SORTIE_PUITS = 2;

    private final int type;

    public BloxException(String message, int type) {
        super(message);
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
