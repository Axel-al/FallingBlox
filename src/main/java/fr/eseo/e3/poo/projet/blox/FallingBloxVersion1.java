package fr.eseo.e3.poo.projet.blox;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.*;

public class FallingBloxVersion1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FallingBloxVersion1().lancerJeu(args));
    }

    private void lancerJeu(String[] args) {
        Puits puits = switch (args.length) {
            case 1 -> new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, Integer.parseInt(args[0]));
            case 2 -> new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT,
                    Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            default -> new Puits();
        };

        VuePuits vuePuits = new VuePuits(puits);
        PanneauInformation panneauInfo = new PanneauInformation(puits);
        Gravite gravite = new Gravite(vuePuits);

        puits.getTas().setOnLignesSupprimees(nbLignes -> {
            int points = nbLignes * 10;
            panneauInfo.ajouterScore(points);
            gravite.augmenterVitesseSiNecessaire(panneauInfo.getScore());
        });

        puits.setPieceSuivante(UsineDePiece.genererPiece(puits));
        puits.setPieceSuivante(UsineDePiece.genererPiece(puits));

        JFrame frame = new JFrame("Falling Blox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(vuePuits, BorderLayout.CENTER);
        frame.add(panneauInfo, BorderLayout.EAST);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
