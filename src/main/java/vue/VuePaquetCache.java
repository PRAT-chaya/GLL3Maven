/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Paquet;
import javax.swing.JPanel;
import java.awt.Graphics;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class VuePaquetCache extends VuePaquet implements EcouteurModele{
    public VuePaquetCache(Paquet paquet, String nomPaquet) {
        super(paquet, nomPaquet, false);
    }
    
    public JPanel buildPaquetVue(){
        JPanel pan = new JPanel();
        
        return pan;
    }
}
