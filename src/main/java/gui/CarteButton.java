/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import cartes.Carte;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author ordinaute
 */
public class CarteButton extends JButton{
    public CarteButton(Carte carte){
        super();
        String txt = carte.getHauteur() + " " + carte.getCouleurStr();
        this.setText(txt);
        Color color = Color.YELLOW;
        if(carte.getCouleur() == Carte.Couleur.TREFLE
                || carte.getCouleur() == Carte.Couleur.PIQUE){
            color = Color.BLACK;
        } else if(carte.getCouleur() == Carte.Couleur.COEUR
                || carte.getCouleur() == Carte.Couleur.CARREAU){
            color = Color.RED;
        }
        this.setBorder(BorderFactory.createLineBorder(color));
    }
}
