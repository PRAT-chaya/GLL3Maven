/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue.test;

import blackjack.modele.Croupier;
import blackjack.modele.Joueur;
import blackjack.modele.Regles;
import blackjack.modele.ReglesFr;
import cartes.Carte;
import cartes.Paquet;
import cartes.PaquetFactory;
import java.util.ArrayList;
import java.util.List;
import blackjack.vue.JoueurGUI;

/**
 *
 * @author ordinaute
 */
public class CarteGUITest {

    public static void main(String[] args) {
        Regles regles = new ReglesFr();
        
        Paquet main = new Paquet();
        main.TYPEJEU = 32;
        Paquet splitMain = new Paquet();
        splitMain.TYPEJEU = 32;
        Carte carte1 = new Carte(7, Carte.CARREAU);
        Carte carte2 = new Carte(7, Carte.COEUR);
        Paquet pioche = PaquetFactory.buildPaquet(32);
        pioche.removeCarte(carte1);
        pioche.removeCarte(carte2);
        Croupier croupier = new Croupier(regles);
        croupier.setPioche(pioche);
        Joueur joueur = new Joueur();
        joueur.getMain().addCarte(carte1);
        joueur.getMain().addCarte(carte2);
        JoueurGUI gui = new JoueurGUI(joueur, croupier);
    }

    private static Paquet buildMockPaquet() {
        List<Carte> cartes = new ArrayList();
        cartes.add(new Carte(1, Carte.TREFLE));
        cartes.add(new Carte(13, Carte.PIQUE));
        cartes.add(new Carte(12, Carte.COEUR));
        cartes.add(new Carte(11, Carte.CARREAU));
        cartes.add(new Carte(10, Carte.PIQUE));
        cartes.add(new Carte(9, Carte.COEUR));
        cartes.add(new Carte(8, Carte.TREFLE));
        cartes.add(new Carte(7, Carte.CARREAU));

        cartes.add(new Carte(1, Carte.TREFLE));
        cartes.add(new Carte(13, Carte.PIQUE));
        cartes.add(new Carte(12, Carte.COEUR));
        cartes.add(new Carte(11, Carte.CARREAU));
        cartes.add(new Carte(10, Carte.PIQUE));
        cartes.add(new Carte(9, Carte.COEUR));
        cartes.add(new Carte(8, Carte.TREFLE));
        cartes.add(new Carte(7, Carte.CARREAU));

        Paquet paquet = new Paquet();
        paquet.TYPEJEU = 32;
        paquet.setCartes(cartes);
        return paquet;
    }
}
