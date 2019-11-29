/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Carte;
import cartes.Paquet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class VuePaquetVisible extends VuePaquet implements EcouteurModele {

    JPanel cartePanel = new JPanel();
    List<Component> cartesVues;
    MouseListener ml;

    public VuePaquetVisible(Paquet paquet, String nomPaquet, MouseListener ml) {
        super(paquet, nomPaquet, true);
        paquet.ajouterEcouteur(this);
        this.cartesVues = new ArrayList();
        this.ml = ml;
        this.buildPaquetVue();
    }

    public VuePaquetVisible(Paquet paquet, String nomPaquet) {
        super(paquet, nomPaquet, true);
        paquet.ajouterEcouteur(this);
        this.cartesVues = new ArrayList();
        this.buildPaquetVue();
    }

    public List<Component> getCartesVues() {
        return cartesVues;
    }

    /**
     * Afficher Le Paquet Visible
     */
    private void buildPaquetVue(MouseListener ml) {
        JButton triHButton = new JButton("Tri par hauteur");
        JButton triCButton = new JButton("Tri par couleur");
        JPanel mainPanel = new JPanel();
        this.cartePanel = new JPanel();
        GridLayout layout = new GridLayout(1, 11);
        cartePanel.setLayout(layout);
        cartePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        drawCartes(this.ml);
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(triHButton);
        buttonPanel.add(triCButton);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(cartePanel, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(new JLabel(nomPaquet), BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Afficher Le Paquet Visible
     */
    private void buildPaquetVue() {
        JButton triHButton = new JButton("Tri par hauteur");
        JButton triCButton = new JButton("Tri par couleur");
        JPanel mainPanel = new JPanel();
        this.cartePanel = new JPanel();
        GridLayout layout = new GridLayout(1, 11);
        cartePanel.setLayout(layout);
        cartePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        drawCartes();
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(triHButton);
        buttonPanel.add(triCButton);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(cartePanel, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(new JLabel(nomPaquet), BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Attirer Une Carte
     * @param ml
     */
    private void drawCartes(MouseListener ml) {
        this.cartePanel.removeAll();
        List<JPanel> lines = new ArrayList();
        for (int i = 0; i < this.paquet.getNbCartes(); i += 11) {
            JPanel line = new JPanel();
            line.setLayout(new GridLayout(1,11));
            lines.add(line);
        }
        int i = 0;
        for (JPanel line : lines) {
            this.cartePanel.add(line);
            for (int j = i; j < i + 11 && j < this.paquet.getNbCartes(); j++) {
                Carte carte = paquet.getCartes().get(j);
                DrawCarteVisible carteVue = new DrawCarteVisible(carte);
                carteVue.addMouseListener(ml);
                line.setSize(carteVue.getSize());
                line.add(carteVue);
                this.cartesVues.add(carteVue);
            }
            i += 11;
        }
    }

    /**
     * Attirer Tout les Cartes
     * @param ml
     */
    private void drawCartes() {
        this.cartePanel.removeAll();
        this.cartePanel.setLayout(new BoxLayout(this.cartePanel, BoxLayout.PAGE_AXIS));

        List<JPanel> lines = new ArrayList();
        for (int i = 0; i < this.paquet.getNbCartes(); i += 11) {
            JPanel line = new JPanel();
            line.setLayout(new GridLayout(1,11));
            lines.add(line);
        }
        int i = 0;
        for (JPanel line : lines) {
            this.cartePanel.add(line);
            for (int j = i; j < i + 11 && j < this.paquet.getNbCartes(); j++) {
                Carte carte = paquet.getCartes().get(j);
                DrawCarteVisible carteVue = new DrawCarteVisible(carte);
                line.setSize(carteVue.getSize());
                line.add(carteVue);
                this.cartesVues.add(carteVue);
            }
            i += 11;
        }
    }

    @Override
    public EcouteurModele modeleMisAJour(Object source)
            throws IllegalArgumentException {
        if (source instanceof Paquet) {
            this.paquet = (Paquet) source;
            if (this.ml != null) {
                drawCartes(ml);
            } else {
                drawCartes();
            }
        }
        return this;
    }
}
