package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.*;

import java.awt.*;

public class VueTas {
    public static final double MULTIPLIER_NUANCE = 0.5;

    private final VuePuits vuePuits;
    private final int taille;

    public VueTas(VuePuits vuePuits, int taille) {
        this.vuePuits = vuePuits;
        this.taille = taille;
    }

    public static Color nuance(Color couleur) {
        int r = (int)(couleur.getRed() * (1 - MULTIPLIER_NUANCE));
        int g = (int)(couleur.getGreen() * (1 - MULTIPLIER_NUANCE));
        int b = (int)(couleur.getBlue() * (1 - MULTIPLIER_NUANCE));
        return new Color(r, g, b);
    }

    public void afficher(Graphics2D g2D) {
        for (Element e : vuePuits.getPuits().getTas().getElements()) {
            Coordonnees c = e.getCoordonnees();
            int x = c.getAbscisse() * this.taille;
            int y = c.getOrdonnee() * this.taille;
            g2D.setColor(nuance(e.getCouleur().getCouleurPourAffichage()));
            g2D.fill3DRect(x, y, this.taille, this.taille, true);
        }
    }

    public VuePuits getVuePuits() {
        return this.vuePuits;
    }

}
