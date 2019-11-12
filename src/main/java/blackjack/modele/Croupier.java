/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Paquet;
import java.util.List;
import util.AbstractModeleEcoutable;

/**
 *
 * @author ordinaute
 */
public class Croupier extends AbstractModeleEcoutable{
    private Paquet main;
    private Paquet pioche;
    
    public Croupier(){
        super();
        this.main = new Paquet();
        this.pioche = new Paquet();
    }
    
    public Paquet deal(List<Joueur> joueurs){
        
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

