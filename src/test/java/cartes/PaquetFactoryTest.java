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
        Carte asTrefle = new Carte(1, Carte.TREFLE);
        Carte roiPique = new Carte(13, Carte.PIQUE);
        Carte dameCoeur = new Carte(12, Carte.COEUR);
        Carte valetCarreau = new Carte(11, Carte.CARREAU);
        Carte dixPique = new Carte(10, Carte.PIQUE);
        Carte neufCoeur = new Carte(9, Carte.COEUR);
        Carte huitTrefle = new Carte(8, Carte.TREFLE);
        Carte septCarreau = new Carte(7, Carte.CARREAU);
        if (nbCartes == 32) {
            assertTrue(areSame(asTrefle, PaquetFactory.assignValueToCarte(32, 0, Carte.TREFLE)));
            assertTrue(areSame(roiPique, PaquetFactory.assignValueToCarte(32, 7, Carte.PIQUE)));
            assertTrue(areSame(dameCoeur, PaquetFactory.assignValueToCarte(32, 6, Carte.COEUR)));
            assertTrue(areSame(valetCarreau, PaquetFactory.assignValueToCarte(32, 5, Carte.CARREAU)));
            assertTrue(areSame(dixPique, PaquetFactory.assignValueToCarte(32, 4, Carte.PIQUE)));
            assertTrue(areSame(neufCoeur, PaquetFactory.assignValueToCarte(32, 3, Carte.COEUR)));
            assertTrue(areSame(huitTrefle, PaquetFactory.assignValueToCarte(32, 2, Carte.TREFLE)));
            assertTrue(areSame(septCarreau, PaquetFactory.assignValueToCarte(32, 1, Carte.CARREAU)));
        } else if (nbCartes == 52) {
            assertTrue(areSame(asTrefle, PaquetFactory.assignValueToCarte(52, 0, Carte.TREFLE)));
            assertTrue(areSame(roiPique, PaquetFactory.assignValueToCarte(52, 12, Carte.PIQUE)));
            assertTrue(areSame(dameCoeur, PaquetFactory.assignValueToCarte(52, 11, Carte.COEUR)));
            assertTrue(areSame(valetCarreau, PaquetFactory.assignValueToCarte(52, 10, Carte.CARREAU)));
            assertTrue(areSame(dixPique, PaquetFactory.assignValueToCarte(52, 9, Carte.PIQUE)));
            assertTrue(areSame(neufCoeur, PaquetFactory.assignValueToCarte(52, 8, Carte.COEUR)));
            assertTrue(areSame(huitTrefle, PaquetFactory.assignValueToCarte(52, 7, Carte.TREFLE)));
            assertTrue(areSame(septCarreau, PaquetFactory.assignValueToCarte(52, 6, Carte.CARREAU)));
        }
    }

    private static boolean areSame(Carte carte1, Carte carte2) {
        return carte1.getHauteur() == carte2.getHauteur()
                && carte1.getCouleur().equals(carte2.getCouleur());
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
