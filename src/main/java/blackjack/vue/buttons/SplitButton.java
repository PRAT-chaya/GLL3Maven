/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue.buttons;

import blackjack.modele.Joueur;
import cartes.Paquet;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ordinaute
 */
public class SplitButton extends JButton{
    private Joueur joueur;
    public SplitButton(ActionListener al, Joueur joueur){
        super("SPLIT");
        this.addActionListener(al);
        this.joueur = joueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
