package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.*;

public class PieceDeplacement extends MouseAdapter {

    private final VuePuits vuePuits;
    private final Puits puits;
    private int ancienneColonne = -1;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        if (puits.getPieceActuelle() == null) return;

        int colonne = event.getX() / vuePuits.getTaille();

        if (colonne < 0 || colonne >= puits.getLargeur()) return;

        if (ancienneColonne == -1) {
            ancienneColonne = colonne;
        } else if (colonne != ancienneColonne) {
            int delta = Integer.compare(colonne - ancienneColonne, 0);
            try {
                puits.getPieceActuelle().deplacerDe(delta, 0);
                ancienneColonne = colonne;
            } catch (BloxException ignore) {
                // collision ou sortie : ne rien faire
            }
            vuePuits.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ancienneColonne = -1;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (puits.getPieceActuelle() == null) return;
        if (e.getWheelRotation() > 0) {
            try {
                puits.getPieceActuelle().deplacerDe(0, 1);
                vuePuits.repaint();
            } catch (BloxException ignored) {
                // collision en bas
            }
        }
    }
}
