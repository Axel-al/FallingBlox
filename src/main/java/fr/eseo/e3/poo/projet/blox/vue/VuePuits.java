package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.*;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends JPanel implements PropertyChangeListener {
    public final static int TAILLE_PAR_DEFAUT = 30;

    private final VueTas vueTas;

    private Puits puits;
    private int taille;
    private VuePiece vuePiece;

    private final PieceDeplacement pieceDeplacement;
    private final PieceRotation pieceRotation;

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        super();
        this.puits = puits;
        this.setTaille(taille);
        this.vueTas = new VueTas(this, this.taille);
        this.setBackground(Color.WHITE);
        this.puits.addPropertyChangeListener(this);

        this.pieceDeplacement = new PieceDeplacement(this);
        this.pieceRotation = new PieceRotation(this);

        // Enregistrement des écouteurs
        this.addMouseMotionListener(this.pieceDeplacement);
        this.addMouseWheelListener(this.pieceDeplacement);
        this.addMouseListener(this.pieceDeplacement);
        this.addMouseListener(this.pieceRotation);
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        this.setPreferredSize(new Dimension(
                this.puits.getLargeur() * this.taille + 1,
                this.puits.getProfondeur() * this.taille));

        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof JFrame frame) {
            frame.pack();
        }
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits.removePropertyChangeListener(this);
        this.puits = puits;
        this.puits.addPropertyChangeListener(this);
        setTaille(this.taille);
        // Les listeners utilisent toujours getPuits(), donc pas besoin de recréer
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    public VueTas getVueTas() {
        return this.vueTas;
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

        vueTas.afficher(g2D);
        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }

        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "pieceActuelle" -> {
                this.vuePiece = new VuePiece((Piece) evt.getNewValue(), this.taille);
                this.repaint();
            }
            case "largeur", "profondeur" -> {
                this.setTaille(this.taille);
            }
        }
    }
}
