package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceRotation extends MouseAdapter {

    private final VuePuits vuePuits;
    private final Puits puits;

    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (puits.getPieceActuelle() == null)
            return;

        try {
            if (SwingUtilities.isLeftMouseButton(e)) {
                puits.getPieceActuelle().tourner(false); // anti-horaire
            } else if (SwingUtilities.isRightMouseButton(e)) {
                puits.getPieceActuelle().tourner(true); // horaire
            }
            vuePuits.repaint();
        } catch (BloxException ignored) {
            // Rotation invalide, on ignore
        }
    }
}
