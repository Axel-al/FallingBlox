package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TypePieceTest {

    @Test
    public void testInstanceCreationParDefaut() {
        for (TypePiece type : TypePiece.values()) {
            var piece = type.creerInstance(new Coordonnees(0, 0));
            assertNotNull(piece);
            assertEquals(type.getCouleurParDefaut(), piece.getCouleur());
        }
    }

    @Test
    public void testInstanceCreationAvecCouleurPersonnalisee() {
        for (TypePiece type : TypePiece.values()) {
            var piece = type.creerInstance(new Coordonnees(1, 2), Couleur.VIOLET);
            assertNotNull(piece);
            assertEquals(Couleur.VIOLET, piece.getCouleur());
        }
    }

    @Test
    public void testGetClasseCorrespondance() {
        for (TypePiece type : TypePiece.values()) {
            assertNotNull(type.getClasse());
            var instance = type.creerInstance(new Coordonnees(0, 0));
            assertEquals(instance.getClass(), type.getClasse());
        }
    }

    @Test
    public void testClassificationTetrominoEtPentomino() {
        for (TypePiece type : TypePiece.values()) {
            if (type.name().length() == 1) {
                assertTrue(type.estTetromino());
                assertFalse(type.estPentomino());
            } else {
                assertFalse(type.estTetromino());
                assertTrue(type.estPentomino());
            }
        }
    }

    @Test
    public void testGetTetrominosEtPentominos() {
        Set<TypePiece> all = new HashSet<>(List.of(TypePiece.values()));
        Set<TypePiece> tetros = Set.of(TypePiece.getTetrominos());
        Set<TypePiece> pentos = Set.of(TypePiece.getPentominos());

        // Tous les éléments doivent être soit un tétrimino, soit un pentomino
        assertTrue(tetros.stream().allMatch(TypePiece::estTetromino));
        assertTrue(pentos.stream().allMatch(TypePiece::estPentomino));

        // Pas d’intersection
        assertTrue(Collections.disjoint(tetros, pentos));

        // La réunion doit être égale à la totalité des TypePiece
        Set<TypePiece> reunion = new HashSet<>();
        reunion.addAll(tetros);
        reunion.addAll(pentos);

        assertEquals(all, reunion);
    }

}
