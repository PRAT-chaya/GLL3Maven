/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.test;

import cartes.Carte;
import cartes.Paquet;
import cartes.PaquetFactory;
import java.util.ArrayList;
import java.util.List;
import vue.JoueurGUI;
import vue.MJGUI;

/**
 *
 * @author ordinaute
 */
public class CarteGUITest {

    public static void main(String[] args) {
        Paquet main = new Paquet();
        main.TYPEJEU = 32;
        Carte carte = new Carte(7, Carte.CARREAU);
        Paquet pioche = PaquetFactory.buildPaquet(32);
        JoueurGUI gui = new JoueurGUI(pioche, main, new Paquet());
        MJGUI mjgui = new MJGUI(pioche);
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
