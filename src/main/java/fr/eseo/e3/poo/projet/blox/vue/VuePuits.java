package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;

public class VuePuits extends JPanel {
    public final static int TAILLE_PAR_DEFAUT = 30;

    private Puits puits;
    private int taille;
    private VuePiece vuePiece;

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        super();
        this.puits = puits;
        this.setBackground(Color.WHITE);
        this.setTaille(taille);
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        this.setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur() * this.taille));

        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof JFrame frame) {
            frame.pack();
        }
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
        setTaille(this.taille);
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g.create();
        g2D.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x <= this.puits.getLargeur(); x++) {
            g2D.drawLine(x * this.taille, 0, x * this.taille, this.puits.getProfondeur() * this.taille);
        }
        for (int y = 0; y <= this.puits.getProfondeur(); y++) {
            g2D.drawLine(0, y * this.taille, this.puits.getLargeur() * this.taille, y * this.taille);
        }

        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }

        g2D.dispose();
    }
}
