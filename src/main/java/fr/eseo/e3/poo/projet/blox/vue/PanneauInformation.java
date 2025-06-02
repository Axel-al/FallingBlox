package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

    private static final int TAILLE_VUE_PIECE = 20;
    private VuePiece vuePiece;
    private int score = 0;

    public PanneauInformation(Puits puits) {
        super();
        puits.addPropertyChangeListener(this);
        this.setPreferredSize(new Dimension(140, 70));
        this.setBackground(Color.WHITE);
    }

    public void ajouterScore(int points) {
        this.score += points;
        this.repaint();
    }

    public int getScore() {
        return score;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("pieceSuivante".equals(evt.getPropertyName())) {
            Piece pieceSuivante = (Piece) evt.getNewValue();
            this.vuePiece = new VuePiece(pieceSuivante, TAILLE_VUE_PIECE);
            this.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (vuePiece != null) {
            Graphics2D g2D = (Graphics2D) g.create();
            vuePiece.afficherPiece(g2D);
            g2D.setColor(Color.BLACK);
            g2D.drawString("Score: " + score, 5, 120);
            g2D.dispose();
        }
    }
}
