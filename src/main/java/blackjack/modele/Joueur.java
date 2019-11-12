/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Carte;
import cartes.Paquet;
import util.AbstractModeleEcoutable;

/**
 *
 * @author ordinaute
 */
public class Joueur extends AbstractModeleEcoutable {

    private int mise;
    private Paquet main;
    private Paquet splitMain;
    private boolean splitted;

    public Joueur() {
        super();
        this.main = new Paquet();
        this.mise = 0;
        this.splitted = false;
    }

    public void setMise(int mise) {
        this.mise = mise;
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
    }

    public Paquet getMain() {
        return this.main;
    }

    public Carte tirerCarte(Paquet croupier) {
        Carte carte = croupier.premiereCarte();
        main.addCarte(carte);
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
        return carte;
    }

    public void rester() {
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
    }

    public Carte doublerMise(Paquet croupier) {
        this.mise *= 2;
        Carte carte = croupier.premiereCarte();
        this.main.addCarte(carte);
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
        return carte;
    }

    public void split() {
        Carte carte1 = this.main.getCarte(0);
        Carte carte2 = this.main.getCarte(1);
        if(carte1.getHauteur() == carte2.getHauteur()){
            this.splitMain = new Paquet();
            this.splitMain.addCarte(this.main.removeCarte(this.main.premiereCarte()));
            if (!ecouteurs.isEmpty()) {
                fireChangement();
            }            
        }
    }
    
    public void assurance(){
        
    }
}
