/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Paquet;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class MJGUI extends JFrame implements EcouteurModele{

    private final Paquet pioche;

    public MJGUI(Paquet pioche) {
        this.pioche = pioche;
        this.pioche.ajouterEcouteur(this);
        this.setSize(600, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        buildVue();
        this.setVisible(true);
    }

    /**
     * Construire La Vue
     */
    private void buildVue() {
        VuePaquetVisible piocheVue = new VuePaquetVisible(this.pioche, "PIOCHE visible");
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(piocheVue, BorderLayout.CENTER);
    }

    /**
     *  Notifier les ecouteurs Du Changement
     * @param L'Objet Modifié
     * @return
     */
    @Override
    public EcouteurModele modeleMisAJour(Object source) {
        this.getContentPane().validate();
        this.getContentPane().repaint();
        System.out.println("Modele màj");
        return this;
    }
}
