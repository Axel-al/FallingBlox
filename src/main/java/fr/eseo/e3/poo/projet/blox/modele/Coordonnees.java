package fr.eseo.e3.poo.projet.blox.modele;

public class Coordonnees {
    private int abscisse;
    private int ordonnee;

    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    @Override
    public String toString() {
        return "(" + abscisse + ", " + ordonnee + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordonnees that = (Coordonnees) o;
        return getAbscisse() == that.getAbscisse() && getOrdonnee() == that.getOrdonnee();
    }

    @Override
    public int hashCode() {
        int result = getAbscisse();
        result = 31 * result + getOrdonnee();
        return result;
    }
}
