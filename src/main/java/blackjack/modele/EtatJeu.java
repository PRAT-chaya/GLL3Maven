/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Paquet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.AbstractModeleEcoutable;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class EtatJeu extends AbstractModeleEcoutable implements EcouteurModele {

    private final List<Joueur> joueurs;
    private final Croupier croupier;
    private Map<Joueur, Integer> mises;
    private Map<Joueur, Paquet> paquets;
    private final Regles regles;
    private int tour;
    private Joueur joueurActif;

    public EtatJeu(List<Joueur> joueurs, Regles regles) {
        this.joueurs = joueurs;
        for (Joueur joueur : joueurs) {
            joueur.ajouterEcouteur(this);
        }
        this.regles = regles;
        this.croupier = new Croupier();
        croupier.ajouterEcouteur(this);
        this.mises = new HashMap();
    }

    /**
     *
     * @return
     */
    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public Croupier getCroupier() {
        return croupier;
    }

    /**
     *
     * @return
     */
    public Map<Joueur, Integer> getMises() {
        return mises;
    }

    public int getMise(Joueur joueur) {
        return this.mises.get(joueur);
    }

    public void setMise(Joueur joueur, int mise) throws IllegalArgumentException {
        if (this.mises.containsKey(joueur)) {
            this.mises.replace(joueur, mise);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Regles getRegles() {
        return regles;
    }

    public int getTour() {
        return tour;
    }

    public Joueur getJoueurActif() {
        return joueurActif;
    }

    @Override
    public EcouteurModele modeleMisAJour(Object source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
