package fr.eseo.e3.poo.projet.blox.modele;

public class Element {
    private Coordonnees coordonnees;
    private Couleur couleur;

    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
        this.couleur = Couleur.getDefault();
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = Couleur.getDefault();
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = couleur;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void deplacerDe(int deltaX, int deltaY) {
        int x = coordonnees.getAbscisse() + deltaX;
        int y = coordonnees.getOrdonnee() + deltaY;
        this.coordonnees = new Coordonnees(x, y);
    }


    @Override
    public String toString() {
        return this.coordonnees.toString() + " - " + this.couleur.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;
        return getCoordonnees().equals(element.getCoordonnees()) && getCouleur() == element.getCouleur();
    }

    @Override
    public int hashCode() {
        int result = getCoordonnees().hashCode();
        result = 31 * result + getCouleur().hashCode();
        return result;
    }
}
