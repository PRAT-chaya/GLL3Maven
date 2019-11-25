/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue;

import blackjack.modele.Croupier;
import blackjack.modele.Joueur;
import blackjack.vue.buttons.*;
import cartes.Carte;
import cartes.Paquet;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class JoueurGUI extends JFrame implements ActionListener, EcouteurModele {

    private final Joueur joueur;
    private final Croupier croupier;
    private final Paquet pioche;
    private JoueurPanel joueurPanel;
    private List<VuePaquetVisible> vuesMains;

    public JoueurGUI(Joueur joueur, Croupier croupier) {
        this.joueur = joueur;
        joueur.ajouterEcouteur(this);
        this.croupier = croupier;
        croupier.ajouterEcouteur(this);
        this.pioche = croupier.getPioche();
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        buildVue();
        this.setVisible(true);
    }

    private void buildVue() {
        VuePaquetCache piocheVue = new VuePaquetCache(this.pioche, "PIOCHE");
        vuesMains = new ArrayList();
        VuePaquetVisible mainVue = new VuePaquetVisible(joueur.getMain(), "MAIN", this);
        vuesMains.add(mainVue);
        if (joueur.hasSplitted()) {
            VuePaquetVisible splitMainVue = new VuePaquetVisible(joueur.getSplitMain(), "SPLIT_MAIN", this);
            vuesMains.add(splitMainVue);
        }
        joueurPanel = new JoueurPanel(vuesMains, this, joueur);
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(piocheVue);
        this.getContentPane().add(joueurPanel);
    }

    @Override
    public EcouteurModele modeleMisAJour(Object source) {
        System.out.println("update");
        if (joueur.hasSplitted()) {
            VuePaquetVisible splitMainVue = new VuePaquetVisible(joueur.getSplitMain(), "SPLIT_MAIN", this);
            vuesMains.add(splitMainVue);
            this.getContentPane().remove(joueurPanel);
            joueurPanel = new JoueurPanel(vuesMains, this, joueur);
            this.getContentPane().add(joueurPanel);
            getContentPane().validate();
            getContentPane().repaint();
        }
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() instanceof HitButton) {
            HitButton button = (HitButton) arg0.getSource();
            Carte todo = pioche.premiereCarte();
            pioche.removeCarte(todo);
            button.getPaquet().addCarte(todo);
            getContentPane().validate();
            getContentPane().repaint();
        } else if (arg0.getSource() instanceof SplitButton) {
            SplitButton button = (SplitButton) arg0.getSource();
            if (joueur.canSplit()) {
                joueur.split();
                System.out.println("split");
                getContentPane().validate();
                getContentPane().repaint();
            }
        }
    }
}
