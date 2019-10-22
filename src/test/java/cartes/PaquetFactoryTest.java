/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ordinaute
 */
public class PaquetFactoryTest {

    /**
     * Test of assignvalueToCarte method, of class PaquetFactory.
     */
    @Test
    public void testAssignValueToCarte() {
        testAssignValueToCarte(32);
        testAssignValueToCarte(52);
    }

    private void testAssignValueToCarte(int nbCartes) {
        Carte asTrefle = new Carte(1, Carte.Couleur.TREFLE);
        Carte roiPique = new Carte(13, Carte.Couleur.PIQUE);
        Carte dameCoeur = new Carte(12, Carte.Couleur.COEUR);
        Carte valetCarreau = new Carte(11, Carte.Couleur.CARREAU);
        Carte dixPique = new Carte(10, Carte.Couleur.PIQUE);
        Carte neufCoeur = new Carte(9, Carte.Couleur.COEUR);
        Carte huitTrefle = new Carte(8, Carte.Couleur.TREFLE);
        Carte septCarreau = new Carte(7, Carte.Couleur.CARREAU);
        if (nbCartes == 32) {
            assertTrue(areSame(asTrefle, PaquetFactory.assignValueToCarte(32, 0, Carte.Couleur.TREFLE)));
            assertTrue(areSame(roiPique, PaquetFactory.assignValueToCarte(32, 7, Carte.Couleur.PIQUE)));
            assertTrue(areSame(dameCoeur, PaquetFactory.assignValueToCarte(32, 6, Carte.Couleur.COEUR)));
            assertTrue(areSame(valetCarreau, PaquetFactory.assignValueToCarte(32, 5, Carte.Couleur.CARREAU)));
            assertTrue(areSame(dixPique, PaquetFactory.assignValueToCarte(32, 4, Carte.Couleur.PIQUE)));
            assertTrue(areSame(neufCoeur, PaquetFactory.assignValueToCarte(32, 3, Carte.Couleur.COEUR)));
            assertTrue(areSame(huitTrefle, PaquetFactory.assignValueToCarte(32, 2, Carte.Couleur.TREFLE)));
            assertTrue(areSame(septCarreau, PaquetFactory.assignValueToCarte(32, 1, Carte.Couleur.CARREAU)));
        } else if (nbCartes == 52) {
            assertTrue(areSame(asTrefle, PaquetFactory.assignValueToCarte(52, 0, Carte.Couleur.TREFLE)));
            assertTrue(areSame(roiPique, PaquetFactory.assignValueToCarte(52, 12, Carte.Couleur.PIQUE)));
            assertTrue(areSame(dameCoeur, PaquetFactory.assignValueToCarte(52, 11, Carte.Couleur.COEUR)));
            assertTrue(areSame(valetCarreau, PaquetFactory.assignValueToCarte(52, 10, Carte.Couleur.CARREAU)));
            assertTrue(areSame(dixPique, PaquetFactory.assignValueToCarte(52, 9, Carte.Couleur.PIQUE)));
            assertTrue(areSame(neufCoeur, PaquetFactory.assignValueToCarte(52, 8, Carte.Couleur.COEUR)));
            assertTrue(areSame(huitTrefle, PaquetFactory.assignValueToCarte(52, 7, Carte.Couleur.TREFLE)));
            assertTrue(areSame(septCarreau, PaquetFactory.assignValueToCarte(52, 6, Carte.Couleur.CARREAU)));
        }
    }

    private static boolean areSame(Carte carte1, Carte carte2) {
        if (carte1.getHauteur() == carte2.getHauteur()
                && carte1.getCouleur() == carte2.getCouleur()) {
            return true;
        }
        return false;
    }

    /**
     * Test of buildPaquet method, of class PaquetFactory.
     */
    @Test
    public void testBuildPaquet() {
        Paquet paquet = PaquetFactory.buildPaquet(52);
        boolean allDifferent = true;
        for (int i = 0; i < paquet.TYPEJEU; i++) {
            for (int j = 0; j < paquet.TYPEJEU; j++) {
                if (paquet.getCartes().get(i) == paquet.getCartes().get(j)) {
                    if (!(i == j)) {
                        allDifferent = false;
                    }
                }
            }
        }
        assertTrue(allDifferent);
    }
}
