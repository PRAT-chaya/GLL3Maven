/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue;

import cartes.Carte;
import cartes.Paquet;
import java.util.List;
import javax.swing.JPanel;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public abstract class VuePaquet extends JPanel implements EcouteurModele {

    protected Paquet paquet;
    protected String nomPaquet;
    protected boolean isVisible;

    protected VuePaquet(Paquet paquet, String nomPaquet, boolean isVisible) {
        super();
        this.paquet = paquet;
        this.nomPaquet = nomPaquet;
        this.isVisible = isVisible;
    }

    @Override
    public EcouteurModele modeleMisAJour(Object source)
            throws IllegalArgumentException {
        if (source instanceof Paquet) {
            this.paquet = (Paquet)source;
            displayPaquet((Paquet)source);
        } else {
            throw new IllegalArgumentException("L'écoutable n'est pas un paquet");
        }
        return this;
    }
    
    protected void displayPaquet(Paquet paquet){
        consoleDisplay(paquet.getCartes());
    }

    protected void consoleDisplay(List<Carte> cartes) {
        String output = "Paquet: ";
        for (Carte carte : cartes) {
            output += "[" + carte.getHauteur() + ", " + carte.getCouleur() + "]; ";
        }
        System.out.println(output);
    }
    
    public Paquet getPaquet(){
        return this.paquet;
    }
    
}
