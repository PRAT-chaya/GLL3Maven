/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Carte;
import cartes.Paquet;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author ordinaute
 */
public class JoueurGUI extends JFrame {

    private final Paquet pioche;
    private final Paquet main;
    private final Paquet defausse;

    public JoueurGUI(Paquet pioche, Paquet main, Paquet defausse) {
        this.pioche = pioche;
        this.main = main;
        this.defausse = defausse;
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        buildVue();
        this.setVisible(true);
    }

    /**
     * Construire La Vue
     */
    private void buildVue() {
        VuePaquetCache piocheVue = new VuePaquetCache(this.pioche, "PIOCHE");
        piocheVue.getDrawPioche().addMouseListener(new PiocheListener());

        VuePaquetVisible mainVue = new VuePaquetVisible(this.main, "MAIN", new CarteMainListener());
        VuePaquetVisible defausseVue = new VuePaquetVisible(this.defausse, "DEFAUSSE", new CarteDefausseListener());
        this.getContentPane().setLayout(new GridLayout(3, 1));
        this.getContentPane().add(piocheVue);
        this.getContentPane().add(mainVue);
        this.getContentPane().add(defausseVue);
    }

    class PiocheListener extends MouseAdapter {

        /**
         * Capter La Click De Souris sur la carte
         * @param arg0
         */
        @Override
        public void mouseClicked(MouseEvent arg0) {
            Carte todo = pioche.premiereCarte();
            pioche.removeCarte(todo);
            main.addCarte(todo);

            getContentPane().validate();
            getContentPane().repaint();
        }
    }

    class CarteMainListener extends MouseAdapter {

        /**
         * Capter La Click De Souris sur la carte
         * @param arg0
         */
        @Override
        public void mouseClicked(MouseEvent arg0) {
            Carte carte = ((DrawCarteVisible) arg0.getSource()).getCarte();
            main.removeCarte(carte);
            defausse.addCarte(carte);

            getContentPane().validate();
            getContentPane().repaint();
        }
    }

    class CarteDefausseListener extends MouseAdapter {

        /**
         * Capter La Click De Souris sur la carte
         * @param arg0
         */
        @Override
        public void mouseClicked(MouseEvent arg0) {
            Carte carte = ((DrawCarteVisible) arg0.getSource()).getCarte();
            defausse.removeCarte(carte);
            pioche.addCarte(carte);

            getContentPane().validate();
            getContentPane().repaint();
        }
    }
}
