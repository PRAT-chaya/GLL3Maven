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

    private MiseJoueur mise;
    private Paquet main;
    private Paquet splitMain;
    private boolean splitted;
    private boolean insured;
    private boolean doubled;
    private boolean reste;
    private Regles regles;

    public Joueur() {
        super();
        this.main = new Paquet();
        this.mise = new MiseJoueur(this);
        this.splitted = false;
        this.insured = false;
        this.reste = false;
    }

    public MiseJoueur getMise() {
        return mise;
    }

    public boolean hasSplitted() {
        return splitted;
    }

    public boolean isInsured() {
        return insured;
    }

    public boolean hasDoubled() {
        return doubled;
    }

    public boolean hasReste() {
        return reste;
    }

    /**
     * Réinitialiser le statut du joueur
     */
    public void reinitStatus() {
        this.main = new Paquet();
        this.mise = new MiseJoueur(this);
        this.splitted = false;
        this.insured = false;
        this.reste = false;
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
    }

    public void setMise(int mise) {
        setMise(mise, this.main);
    }

    public void setMise(int mise, Paquet paquet) {
        this.mise.setMise(mise, paquet);
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
    }

    public Paquet getMain() {
        return this.main;
    }

    public Paquet getSplitMain() {
        return splitMain;
    }

    public Carte tirerCarte(Paquet croupier) {
        return tirerCarte(croupier, this.main);
    }

    /**
     * Ajouter la premiere carte du croupier au main paquet
     * @param croupier
     * @param main
     * @return 
     */
    public Carte tirerCarte(Paquet croupier, Paquet main) {
        Carte carte = croupier.premiereCarte();
        main.addCarte(carte);
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
        return carte;
    }

    public void rester() {
        this.reste = true;
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
    }

    /**
     * Doubler La Mise
     * @param croupier
     * @return
     * @throws IllegalArgumentException 
     */
    public Carte doublerMise(Paquet croupier) throws IllegalArgumentException {
        return doublerMise(croupier, this.main);
    }

    public Carte doublerMise(Paquet croupier, Paquet main) throws IllegalArgumentException {
        if (!this.doubled) {
            this.doubled = true;
            this.mise.doubleMise(main);
            Carte carte = croupier.premiereCarte();
            this.main.addCarte(carte);
            if (!ecouteurs.isEmpty()) {
                fireChangement();
            }
            return carte;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Déterminer si on peut diviser le paquet
     * @return 
     */
    public boolean canSplit() {
        Carte carte1 = this.main.getCarte(0);
        Carte carte2 = this.main.getCarte(1);
        if (!this.splitted && (carte1.getHauteur() == carte2.getHauteur())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Diviser le Paquet
     * @throws IllegalArgumentException 
     */
    public void split() throws IllegalArgumentException {
        if (canSplit()) {
            this.splitMain = new Paquet();
            this.splitMain.addCarte(this.main.removeCarte(this.main.premiereCarte()));
            this.splitted = true;
            this.mise.split(main, splitMain);
            if (!ecouteurs.isEmpty()) {
                fireChangement();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public boolean canInsure(int miseAssurance){
        if(!insured && !splitted && !doubled){
            int currMise = this.mise.getMise(main);
            if(miseAssurance <= currMise/2){
                return true;
            }
        }
        return false;
    }

    public void assurance(int miseAssurance) throws IllegalArgumentException {
        if (canInsure(miseAssurance)) {
            this.mise.increaseMise(miseAssurance, main);
            this.insured = true;
            if (!ecouteurs.isEmpty()) {
                fireChangement();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
