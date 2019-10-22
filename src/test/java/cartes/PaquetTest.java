/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ordinaute
 */
public class PaquetTest {

    /**
     * Test of melanger method, of class Paquet.
     */
    @Test
    public void testMelanger() {
        Paquet paquet = PaquetFactory.buildPaquet(32);
        List<Carte> befShuffle = new ArrayList();
        for (Carte carte : paquet.getCartes()) {
            befShuffle.add(carte);
        }
        int changed = 0;
        List<Carte> afShuffle = paquet.melanger();
        boolean missingCard = false;
        for (Carte carte : befShuffle) {
            if (!afShuffle.contains(carte)) {
                missingCard = true;
            }
        }
        assertFalse(missingCard);
        for (int i = 0; i < paquet.TYPEJEU; i++) {
            if (befShuffle.get(i) != afShuffle.get(i)) {
                changed++;
            }
        }
        assertTrue(changed > (paquet.TYPEJEU / 2));

    }

    /**
     * Test of couper method, of class Paquet.
     */
    @Test
    public void testCouper() {
        Paquet paquet = PaquetFactory.buildPaquet(32);
        List<Carte> befCut = new ArrayList();
        for (Carte carte : paquet.getCartes()) {
            befCut.add(carte);
        }
        List<Carte> afCut = new ArrayList();
        int cut = 16;
        afCut = Paquet.couper(cut, paquet.getCartes());
        boolean correctCut = true;
        for (int i = 0; i < paquet.TYPEJEU; i++){
            if (i<cut){
                if (befCut.get(i) != afCut.get(cut+i)) {
                    correctCut = false;
                }                
            } else {
                if (befCut.get(i) != afCut.get(i - cut)) {
                    correctCut = false;
                }  
            }
        }
        assertTrue(correctCut);
    }
}
