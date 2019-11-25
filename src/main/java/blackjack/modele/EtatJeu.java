/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Paquet;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Paquet paquetCroupier;
    private Map<Joueur, MiseJoueur> mises;
    private Map<Joueur, List<Paquet>> paquets;
    private Map<Joueur, Boolean> finishedTurn;
    private final Regles regles;
    private int tour;
    private Joueur joueurActif;

    public EtatJeu(List<Joueur> joueurs, Regles regles) {
        this.mises = new HashMap();
        this.paquets = new HashMap();
        this.finishedTurn = new HashMap();
        this.joueurs = joueurs;
        for (Joueur joueur : joueurs) {
            joueur.ajouterEcouteur(this);
            this.mises.put(joueur, joueur.getMise());
            this.paquets.put(joueur, new ArrayList());
            this.paquets.get(joueur).add(joueur.getMain());
            this.finishedTurn.put(joueur, false);
        }
        this.regles = regles;
        this.croupier = new Croupier(regles);
        croupier.ajouterEcouteur(this);
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public Croupier getCroupier() {
        return croupier;
    }

    public Map<Joueur, MiseJoueur> getMises() {
        return mises;
    }

    public MiseJoueur getMise(Joueur joueur) {
        return this.mises.get(joueur);
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

    public void joueurFinished(Joueur joueur) {
        this.finishedTurn.replace(joueur, false);
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
    }

    @Override
    public EcouteurModele modeleMisAJour(Object source) {
        if (source instanceof Joueur) {
            Joueur joueur = (Joueur) source;
            if (joueurs.contains(joueur)) {
                if (joueur.hasSplitted()) {
                    paquets.get(joueur).add(joueur.getSplitMain());
                }
                if(joueur.hasReste()){
                    finishedTurn.replace(joueur, true);
                }
            }
        }
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
        return this;
    }
}
