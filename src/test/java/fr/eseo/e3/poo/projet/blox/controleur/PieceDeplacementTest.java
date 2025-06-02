package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.*;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;

public class PieceDeplacementTest {

    public PieceDeplacementTest() {
        creerFenetreTest();
    }

    private void creerFenetreTest() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 40);

        // Ajout d'une pièce pour permettre le test
        puits.setPieceSuivante(UsineDePiece.genererTetromino());
        puits.setPieceSuivante(UsineDePiece.genererTetromino());

        for (int i = 0; i < 7; i++)
            puits.getPieceActuelle().deplacerDe(0, 1);

        JFrame frame = new JFrame("Test déplacement souris");
        frame.setContentPane(vuePuits);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PieceDeplacementTest::new);
    }
}
