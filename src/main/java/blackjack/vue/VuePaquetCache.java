/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue;

import vue.*;
import cartes.Carte;
import cartes.Paquet;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class VuePaquetCache extends VuePaquet implements EcouteurModele {

    DrawPioche drawPioche;

    public VuePaquetCache(Paquet paquet, String nomPaquet) {
        super(paquet, nomPaquet, false);
        this.setSize(240, 240);
        this.buildPaquetVue();
    }

    public void buildPaquetVue() {
        this.setLayout(new BorderLayout());
        this.add(new JLabel("PIOCHE"), BorderLayout.NORTH);
        this.drawPioche = new DrawPioche(this.paquet);
        this.add(this.drawPioche, BorderLayout.CENTER);
    }

    public JLabel getDrawPioche() {
        return drawPioche;
    }
}
