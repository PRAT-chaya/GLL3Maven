/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Carte;
import cartes.Paquet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ordinaute
 */
public class Regles {

    private Map<Integer, List<Integer>> valeurMap;
    private int miseMin;
    private int miseMax;

    public Regles() {
        buildValeurMap();
    }

    public Regles(int miseMin, int miseMax) {
        this.miseMin = miseMin;
        this.miseMax = miseMax;
    }

    public int getMiseMin() {
        return miseMin;
    }

    public void setMiseMin(int miseMin) {
        this.miseMin = miseMin;
    }

    public int getMiseMax() {
        return miseMax;
    }

    public void setMiseMax(int miseMax) {
        this.miseMax = miseMax;
    }

    public Map<Integer, List<Integer>> getValeurMap() {
        return this.valeurMap;
    }

    public List<Integer> getValeur(int hauteur) {
        return this.valeurMap.get(hauteur);
    }

    public List<Integer> getValeur(String hauteur) {
        int key = 0;
        switch (hauteur) {
            case "as":
                key = 1;
                break;
            case "valet":
                key = 11;
                break;
            case "dame":
                key = 12;
                break;
            case "roi":
                key = 13;
                break;
            default:
                key = Integer.valueOf(hauteur);
                break;
        }
        return this.valeurMap.get(key);
    }

    private Map<Integer, List<Integer>> buildValeurMap() {
        this.valeurMap = new HashMap();
        this.valeurMap.put(1, Arrays.asList(1, 11));
        for (int i = 2; i < 11; i++) {
            this.valeurMap.put(i, Arrays.asList(i));
        }
        for (int i = 11; i < 14; i++) {
            this.valeurMap.put(i, Arrays.asList(10));
        }
        return this.valeurMap;
    }

    public boolean hasWon(Paquet paquetJoueur, Paquet paquetCroupier, int valeurAs) {
        int joueurSum = cartesSum(paquetJoueur.getCartes(), valeurAs);
        if (joueurSum == 21){
            if (paquetCroupier.premiereCarte().getHauteur() == 1){
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public int cartesSum(List<Carte> cartes, int valeurAs){
        int sum = 0;
        for (Carte carte : cartes) {
            if (carte.getHauteur() != 1) {
                sum += this.valeurMap.get(carte.getHauteur()).get(0);
            } else {
                sum += valeurAs;
            }
        }
        return sum;
    }

}
