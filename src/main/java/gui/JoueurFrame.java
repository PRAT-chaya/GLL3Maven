/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import vue.VuePaquetCache;
import vue.VuePaquetVisible;

/**
 *
 * @author ordinaute
 */
public class JoueurFrame extends JeuFrame {

    private final VuePaquetCache piocheVue;
    private final VuePaquetVisible mainVue;
    private final VuePaquetVisible defausseVue;

    public JoueurFrame(String t, int width, int height, VuePaquetCache piocheVue,
            VuePaquetVisible mainVue, VuePaquetVisible defausseVue) {
        super(t, width, height);
        this.piocheVue = piocheVue;
        this.mainVue = mainVue;
        this.defausseVue = defausseVue; 
        JPanel mainPan = new JPanel();
        JPanel topPan = buildTopPanel(piocheVue);
        JPanel middlePan = buildCardPanel(mainVue, "MAIN");
        JPanel bottomPan = buildCardPanel(defausseVue, "DEFAUSSE");

        mainPan.setLayout(new GridLayout(3,1));
        mainPan.add(topPan);
        mainPan.add(middlePan);
        mainPan.add(bottomPan);
        this.setContentPane(mainPan);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private JPanel buildTopPanel(VuePaquetCache piocheVue){
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        pan.add(new JLabel("PIOCHE"), BorderLayout.NORTH);
        pan.add(new JLabel("TODO"), BorderLayout.CENTER);
        return pan;
    }
}
