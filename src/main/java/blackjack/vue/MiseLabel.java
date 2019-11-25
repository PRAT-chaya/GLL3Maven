/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue;

import blackjack.modele.MiseJoueur;
import cartes.Paquet;
import javax.swing.JLabel;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class MiseLabel extends JLabel{
    private final Paquet main;
    private MiseJoueur miseJoueur;
    public MiseLabel(MiseJoueur miseJoueur, Paquet main){
        super("mise: " + String.valueOf(miseJoueur.getMise(main)));
        this.main = main;
        this.miseJoueur = miseJoueur;        
    }
}
