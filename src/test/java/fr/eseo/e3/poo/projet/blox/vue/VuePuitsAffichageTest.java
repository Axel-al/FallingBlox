package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits); // s’enregistre comme listener dans le constructeur

        JFrame frame = new JFrame("Puits");
        frame.setContentPane(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
        Puits puits = new Puits();
        puits.setTas(new Tas(puits, 15));
        VuePuits vuePuits = new VuePuits(puits, 40); // s’enregistre aussi comme listener ici

        // Important : VuePuits est listener AVANT ces appels
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        puits.setPieceSuivante(UsineDePiece.genererTetromino(puits));
        puits.setPieceSuivante(UsineDePiece.genererTetromino(puits));
        puits.getPieceActuelle().setPosition(4, 7);

        JFrame frame = new JFrame("Puits et pièce automatique");
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
