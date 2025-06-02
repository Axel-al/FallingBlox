package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PuitsTest {

    @Test
    public void testConstructeurParDefaut() {
        Puits puits = new Puits();
        assertEquals(Puits.LARGEUR_PAR_DEFAUT, puits.getLargeur());
        assertEquals(Puits.PROFONDEUR_PAR_DEFAUT, puits.getProfondeur());
        assertNull(puits.getPieceActuelle());
        assertNull(puits.getPieceSuivante());
    }

    @Test
    public void testConstructeurParametre() {
        Puits puits = new Puits(12, 20);
        assertEquals(12, puits.getLargeur());
        assertEquals(20, puits.getProfondeur());
    }

    @Test
    public void testSetLargeurEtProfondeur() {
        Puits puits = new Puits();
        puits.setLargeur(15);
        puits.setProfondeur(25);
        assertEquals(15, puits.getLargeur());
        assertEquals(25, puits.getProfondeur());
    }

    @Test
    public void testSetPieceSuivanteAvecInitialisation() {
        Puits puits = new Puits();

        // 1ère pièce : aucune pieceActuelle ne doit encore être définie
        Piece premiere = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        puits.setPieceSuivante(premiere);
        assertNull(puits.getPieceActuelle());
        assertEquals(premiere, puits.getPieceSuivante());

        // 2ème pièce : la première devient pièce actuelle
        Piece deuxieme = new OTetromino(new Coordonnees(0, 0), Couleur.CYAN);
        puits.setPieceSuivante(deuxieme);
        assertEquals(premiere, puits.getPieceActuelle());
        assertEquals(deuxieme, puits.getPieceSuivante());

        // Vérifie que la pièce actuelle est bien repositionnée
        assertEquals(new Coordonnees(puits.getLargeur() / 2, -4), premiere.getPosition());
    }

    @Test
    public void testToStringSansPieces() {
        Puits puits = new Puits(10, 18);
        assertEquals("Puits : Dimension 10 x 18\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>", puits.toString());
    }

    @Test
    public void testToStringAvecPieces() {
        Puits puits = new Puits();
        Piece p1 = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        Piece p2 = new OTetromino(new Coordonnees(0, 0), Couleur.CYAN);
        puits.setPieceSuivante(p1);
        puits.setPieceSuivante(p2);

        String expected = "Puits : Dimension " + Puits.LARGEUR_PAR_DEFAUT + " x " + Puits.PROFONDEUR_PAR_DEFAUT + "\nPiece Actuelle : " + p1 + "\nPiece Suivante : " + p2;
        assertEquals(expected, puits.toString());
    }

    @Test
    public void testConstructeurAvecTasParDefaut() {
        Puits puits = new Puits();
        assertNotNull(puits.getTas());
        assertTrue(puits.getTas().getElements().isEmpty());
    }

    @Test
    public void testConstructeurAvecTasElementsEtLignes() {
        Puits puits = new Puits(10, 18, 20, 2);
        assertNotNull(puits.getTas());
        assertEquals(20, puits.getTas().getElements().size());
    }

    @Test
    public void testSetEtGetTas() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits, 5, 1);
        puits.setTas(tas);
        assertEquals(tas, puits.getTas());
    }
}