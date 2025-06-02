package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;

public class GraviteTest {

    public GraviteTest() {
        creerFenetreTest();
    }

    private void creerFenetreTest() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 40);

        // Prépare deux pièces, la deuxième deviendra pièceActuelle au bon moment
        puits.setPieceSuivante(UsineDePiece.genererTetromino(puits));
        puits.setPieceSuivante(UsineDePiece.genererPentomino(puits));

        // Démarre la gravité automatique (toutes les 700ms)
        new Gravite(vuePuits, 700);

        JFrame frame = new JFrame("Test Gravité Automatique");
        frame.setContentPane(vuePuits);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraviteTest::new);
    }
}
