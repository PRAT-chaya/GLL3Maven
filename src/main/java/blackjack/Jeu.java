/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import blackjack.modele.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ordinaute
 */
public class Jeu {

    public static void main(String[] args) {
        EtatJeu etatJeu = start();
        gui(etatJeu);
        boolean fin = false;
        while (!fin) {
            fin = continueJeu(etatJeu);
        }
    }
    
    public static void gui(EtatJeu etatJeu){
        
    }

    public static EtatJeu start(List<Joueur> joueurs, Regles regles) {
        return new EtatJeu(joueurs, regles);
    }

    public static EtatJeu start() {
        List<Joueur> joueurs = new ArrayList();
        Regles regles = new Regles();
        return new EtatJeu(joueurs, regles);
    }

    public static boolean continueJeu(EtatJeu etatJeu) {
       for(Joueur joueur : etatJeu.getJoueurs()){
           joueurJoue(joueur, etatJeu);
       }
       return true;
    }
    
    public static EtatJeu joueurJoue(Joueur joueur, EtatJeu etatJeu){
        return etatJeu;
    }
}
