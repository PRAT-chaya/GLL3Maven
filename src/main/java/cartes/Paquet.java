/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

import util.AbstractModeleEcoutable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 21907858
 */
public class Paquet extends AbstractModeleEcoutable {

    List<Carte> cartes;
    public int TYPEJEU;

    public Paquet() {
        this.cartes = new ArrayList();
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }

    public List<Carte> melanger() {
        Random rand = new Random();
        List<Carte> temp = cloneCartes();

        int nbCartes = this.cartes.size();
        for (int i = 0; i < nbCartes; i++) {
            int rint = rand.nextInt(temp.size());
            Carte carte = temp.get(rint);
            this.cartes.set(i, carte);
            temp.remove(carte);
        }
        return this.cartes;
    }

    public List<Carte> couper() {
        Random rand = new Random();
        int nbCartes = this.cartes.size();
        int rint = rand.nextInt(nbCartes);
        return Paquet.couper(rint, this.cartes);
    }

    public static List<Carte> couper(int cut, List<Carte> cartes) {
        List<Carte> temp = Paquet.cloneCartes(cartes);
        int nbCartes = cartes.size();
        for (int i = 0; i < nbCartes; i++) {
            if (i < cut) {
                cartes.set(i, temp.get(cut + i));
            } else {
                cartes.set(i, temp.get(i-cut));
            }
        }
        return cartes;
    }

    public Carte premiereCarte() {
        return this.cartes.get(0);
    }

    private static List<Carte> cloneCartes(List<Carte> cartes) {
        List<Carte> newCartes = new ArrayList();
        for (int i = 0; i < cartes.size(); i++) {
            newCartes.add(cartes.get(i));
        }
        return newCartes;
    }

    private List<Carte> cloneCartes() {
        return Paquet.cloneCartes(this.cartes);
    }
}
