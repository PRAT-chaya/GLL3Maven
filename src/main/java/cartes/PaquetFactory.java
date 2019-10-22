/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21907858
 */
public abstract class PaquetFactory {

    public static Paquet buildPaquet(int nbCartes)
            throws IllegalArgumentException {
        Paquet paquet = new Paquet();
        if (nbCartes == 32 || nbCartes == 52) {
            paquet.TYPEJEU = nbCartes;
            List<Carte> cartes = new ArrayList();
            for (int i = 0; i < nbCartes; i++) {
                Carte.Couleur couleur = Carte.Couleur.NULL;
                switch (i % 4) {
                    case 0:
                        couleur = Carte.Couleur.PIQUE;
                        break;
                    case 1:
                        couleur = Carte.Couleur.COEUR;
                        break;
                    case 2:
                        couleur = Carte.Couleur.CARREAU;
                        break;
                    case 3:
                        couleur = Carte.Couleur.TREFLE;
                        break;
                }
                if (!(couleur == Carte.Couleur.NULL)) {
                    cartes.add(PaquetFactory.assignValueToCarte(nbCartes, i, couleur));
                } else {
                    throw new IllegalArgumentException("Couleur inexistante");
                }
            }
            paquet.setCartes(cartes);
        } else {
            throw new IllegalArgumentException("Paquet impossible à construire");
        }
        return paquet;
    }

    public static Carte assignValueToCarte(int TYPEJEU, int index, Carte.Couleur couleur)
            throws IllegalArgumentException {
        if (TYPEJEU == 52) {
            return new Carte((index % 13 + 1), couleur);
        } else if (TYPEJEU == 32) {
            int mod = index % 8;
            if (mod == 0) {
                return new Carte(1, couleur);
            } else if (0 < mod) {
                return new Carte(mod + 6, couleur);
            }
        }
        throw new IllegalArgumentException();
    }
}
