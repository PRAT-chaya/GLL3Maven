/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vue.VuePaquetVisible;

/**
 *
 * @author ordinaute
 */
public abstract class JeuFrame extends JFrame {

    public JeuFrame(String t, int width, int height) {
        super(t);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
    }

    protected JPanel buildCardPanel(VuePaquetVisible paquetVue, String nomPaquet) {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        pan.add(new JLabel(nomPaquet), BorderLayout.NORTH);
        JPanel interPan = new JPanel();
        JPanel buttonsPan = new JPanel();
        CartePanel cardsPan = new CartePanel(paquetVue);
        cardsPan.buildPanel();

        buttonsPan.setLayout(new FlowLayout());
        JButton triHauteurButton = new JButton("Tri par hauteur");
        JButton triCouleurButton = new JButton("Tri par couleur");
        buttonsPan.add(triHauteurButton);
        buttonsPan.add(triCouleurButton);

        interPan.setLayout(new BorderLayout());
        interPan.add(buttonsPan, BorderLayout.NORTH);
        interPan.add(cardsPan, BorderLayout.CENTER);
        pan.add(interPan, BorderLayout.CENTER);

        return pan;
    }
}
