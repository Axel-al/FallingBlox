package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PieceDeplacement implements MouseMotionListener {

    private final VuePuits vuePuits;
    private final Puits puits;
    private int ancienneColonne = -1;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        if (puits.getPieceActuelle() == null) {
            return;
        }

        int colonne = event.getX() / vuePuits.getTaille();

        if (colonne < 0 || colonne >= puits.getLargeur()) {
            return; // ignore si hors grille
        }

        if (ancienneColonne == -1) {
            ancienneColonne = colonne;
        } else if (colonne != ancienneColonne) {
            int delta = colonne - ancienneColonne;

            // Normaliser le déplacement à -1, 0, +1 (pas de saut de colonne)
            delta = Integer.compare(delta, 0);

            try {
                puits.getPieceActuelle().deplacerDe(delta, 0);
                ancienneColonne = colonne;
            } catch (IllegalArgumentException e) {
                // déplacement non permis : on ignore
            }

            vuePuits.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Rien à faire ici pour l’instant
    }
}