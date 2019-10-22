/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import vue.VuePaquetVisible;

/**
 *
 * @author ordinaute
 */
public class MJFrame extends JeuFrame {

    VuePaquetVisible piocheVue;

    public MJFrame(String t, int width, int height, VuePaquetVisible piocheVue) {
        super(t, width, height);
        this.piocheVue = piocheVue;
        JPanel mainPan = new JPanel();
        JPanel piochePan = buildCardPanel(piocheVue, "PIOCHE");
        mainPan.add(piochePan);
        this.setContentPane(mainPan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
