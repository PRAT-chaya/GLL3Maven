/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author 21907858
 */
public interface EcouteurModele {
    /**
     *  Notifier les ecouteurs Du Changement
     * @param L'Objet Modifié
     * @return
     */
    public EcouteurModele modeleMisAJour(Object source);
}
