/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue;

import vue.*;
import cartes.Carte;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author ordinaute
 */
public class DrawCarteVisible extends JLabel {

    private String hauteur;
    private String couleur;
    private Carte carte;

    public DrawCarteVisible(Carte carte) {
        super();
        this.carte = carte;
        this.hauteur = carte.getHauteurStr();
        this.couleur = carte.getCouleur();
        this.setSize(42, 74);
    }

    public DrawCarteVisible(Carte carte, String name) {
        super(name);
        this.carte = carte;
        this.hauteur = carte.getHauteurStr();
        this.couleur = carte.getCouleur();
        this.setSize(42, 74);
    }

    public Carte getCarte() {
        return carte;
    }

    public void paintComponent(Graphics g) {
        int x1 = 5;
        int y1 = 5;
        int x2 = 48;
        int y2 = 78;
        g.setColor(Color.WHITE);
        g.fillRoundRect(x1, y1, x2, y2, 10, 10);
        if (couleur.equals(Carte.PIQUE) || couleur.equals(Carte.TREFLE)) {
            g.setColor(Color.BLACK);
        } else if (couleur.equals(Carte.COEUR) || couleur.equals(Carte.CARREAU)) {
            g.setColor(Color.RED);
        }
        g.drawRoundRect(x1, y1, x2, y2, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString(hauteur, x1 + 8, y1 + 20);
        g.drawString(couleur, x1 + 2, y1 + 40);
    }
}
