/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import cartes.Carte;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import vue.VuePaquet;

/**
 *
 * @author ordinaute
 */
public class CartePanel extends JPanel {

    private VuePaquet vuePaquet;
    public CartePanel(VuePaquet vuePaquet) {
        super();
        this.vuePaquet = vuePaquet;
    }

    public void buildPanel() {
        FlowLayout carteLayout = new FlowLayout();
        carteLayout.setAlignment(FlowLayout.LEFT);
        this.setLayout(carteLayout);
        if(!vuePaquet.getPaquet().getCartes().isEmpty()){
            for (Carte carte : vuePaquet.getPaquet().getCartes()) {
                //CarteButton carteButton = new CarteButton(carte);
                this.add(new CarteButton(carte));
            }            
        }
    }
}
