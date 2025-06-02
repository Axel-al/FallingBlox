package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;

public class PieceRotationTest {

    public PieceRotationTest() {
        creerFenetreTest();
    }

    private void creerFenetreTest() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 40);

        // Génère une pièce de test visible
        puits.setPieceSuivante(UsineDePiece.genererTetromino(puits));
        puits.setPieceSuivante(UsineDePiece.genererTetromino(puits));

        JFrame frame = new JFrame("Test rotation souris");
        frame.setContentPane(vuePuits);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PieceRotationTest::new);
    }
}
