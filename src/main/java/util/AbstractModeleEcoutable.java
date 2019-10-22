/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;

/**
 *
 * @author 21907858
 */
public abstract class AbstractModeleEcoutable implements ModeleEcoutable {

    List<EcouteurModele> ecouteurs;

    @Override
    public void ajouterEcouteur(EcouteurModele e){
        ecouteurs.add(e);
    }

    @Override
    public void retraitEcouteur(EcouteurModele e){
        ecouteurs.remove(e);
    }
    
    public void fireChangement(){
        for (EcouteurModele e : ecouteurs){
            e.modeleMisAJour(this);
        }
    }
}
