/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue;

import blackjack.modele.Joueur;
import blackjack.modele.MiseJoueur;
import blackjack.vue.buttons.SplitButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ordinaute
 */
public class JoueurPanel extends JPanel {
    private List<VuePaquetVisible> mainsVues;
    private Joueur joueur;
    public JoueurPanel(List<VuePaquetVisible> mainsVues, ActionListener al, Joueur joueur){
        this.mainsVues = mainsVues;
        this.joueur = joueur;
        this.setMinimumSize(new Dimension(600, 200));
        this.setSize(new Dimension(600, 200));
        this.setBackground(Color.orange);
        buildPanel(al);
    }
    
    private void buildPanel(ActionListener al){
        this.setLayout(new BorderLayout());
        JButton splitButton = new SplitButton(al, joueur);
        JButton insuranceButton = new JButton("INSURANCE");
        JPanel buttonsPanel = new JPanel();
        JPanel mainsPanel = new JPanel();
        JPanel misesPanel = new JPanel();
        mainsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(splitButton);
        buttonsPanel.add(insuranceButton);
        for(VuePaquetVisible mainVue : mainsVues){
            mainsPanel.add(mainVue);
            misesPanel.add(new MiseLabel(joueur.getMise(), mainVue.getPaquet()));
        }
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(misesPanel, BorderLayout.NORTH);
        this.add(mainsPanel, BorderLayout.CENTER);
    }
}
