/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.modele;

import cartes.Paquet;
import util.AbstractModeleEcoutable;

/**
 *
 * @author ordinaute
 */
public class Croupier extends AbstractModeleEcoutable{
    private Paquet visible;
    private Paquet cache;
    
    public Croupier(){
        super();
        this.visible = new Paquet();
        this.cache = new Paquet();
    }
}
