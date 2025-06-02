package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;

public class PieceDeplacementTest {

    public PieceDeplacementTest() {
        creerFenetreTest();
    }

    private void creerFenetreTest() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 40);

        // Génère une pièce visible à l'écran
        puits.setPieceSuivante(UsineDePiece.genererPentomino(puits));
        puits.setPieceSuivante(UsineDePiece.genererTetromino(puits));

        // Fait descendre manuellement la pièce pour qu’elle soit visible
        for (int i = 0; i < 7; i++) {
            try {
                puits.getPieceActuelle().deplacerDe(0, 1);
            } catch (BloxException ignored) {
                // ignore erreurs de dépassement
            }
        }

        JFrame frame = new JFrame("Test déplacement souris + molette");
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
