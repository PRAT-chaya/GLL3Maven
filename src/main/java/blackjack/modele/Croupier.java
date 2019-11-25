/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Carte;
import cartes.Paquet;
import java.util.List;
import util.AbstractModeleEcoutable;

/**
 *
 * @author ordinaute
 */
public class Croupier extends AbstractModeleEcoutable {

    private Paquet main;
    private Paquet pioche;
    private Regles regles;

    public Croupier(Regles regles) {
        super();
        this.main = new Paquet();
        this.pioche = new Paquet();
        this.regles = regles;
    }
    
    

    public Paquet deal(List<Joueur> joueurs) {
        for (Joueur joueur : joueurs) {
            for (int i = 0; i < 2; i++) {
                joueur.tirerCarte(this.pioche);
            }
        }
        for (int i = 0; i < regles.NB_CARTES_CROUPIER_DISTR_INIT; i++) {
            Carte carte = this.pioche.premiereCarte();
            this.pioche.removeCarte(carte);
            this.main.addCarte(carte);
        }
        if (!ecouteurs.isEmpty()) {
            fireChangement();
        }
        return this.pioche;
    }

    public Paquet getMain() {
        return main;
    }

    public void setMain(Paquet main) {
        this.main = main;
    }

    public Paquet getPioche() {
        return pioche;
    }

    public void setPioche(Paquet pioche) {
        this.pioche = pioche;
    }

}
