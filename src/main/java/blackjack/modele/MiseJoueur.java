/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Paquet;
import java.util.HashMap;
import java.util.Map;
import util.AbstractModeleEcoutable;

/**
 *
 * @author ordinaute
 */
public class MiseJoueur{

    private final Joueur joueur;
    Map<Paquet, Integer> mises;

    public MiseJoueur(Joueur joueur) {
        this.joueur = joueur;
        this.mises = new HashMap();
        this.mises.put(joueur.getMain(), 0);
    }

    public int getMise(Paquet main) {
        return mises.get(main);
    }

    public void setMise(int mise, Paquet main) {
        this.mises.replace(main, mise);
    }

    public void increaseMise(int mise, Paquet main) {
        int currMise = this.mises.get(main);
        this.mises.replace(main, currMise + mise);
    }
    
    public void split(Paquet main, Paquet splitMain){
        int mise = this.mises.get(main);
        this.mises.put(splitMain, mise);
    }
    
    public void doubleMise(Paquet main){
        int currMise = this.mises.get(main);
        this.mises.replace(main, currMise * 2);
    }
    
    public void addMain(Paquet main){
        this.mises.put(main, 0);
    }
}
