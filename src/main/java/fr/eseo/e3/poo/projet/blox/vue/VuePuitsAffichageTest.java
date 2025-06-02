package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        JFrame frame = new JFrame("Puits");
        frame.setContentPane(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
        Puits puits = new Puits();
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        puits.setPieceSuivante(UsineDePiece.genererTetromino()); // 1ʳᵉ : pieceSuivante
        puits.setPieceSuivante(UsineDePiece.genererTetromino()); // 2ᵉ : devient pieceActuelle

        VuePuits vuePuits = new VuePuits(puits);
        vuePuits.setVuePiece(new VuePiece(puits.getPieceActuelle(), vuePuits.getTaille()));

        JFrame frame = new JFrame("Puits et taille avec pièce");
        frame.setContentPane(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VuePuitsAffichageTest::new);
    }
}
