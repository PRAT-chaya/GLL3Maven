/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Paquet;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class VuePaquetVisible extends VuePaquet implements EcouteurModele{
    public VuePaquetVisible(Paquet paquet, String nomPaquet) {
        super(paquet, nomPaquet, true);
    }
}
