/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

/**
 *
 * @author 21907858
 */
public class Carte {

    public enum Couleur {
        NULL,
        PIQUE,
        TREFLE,
        CARREAU,
        COEUR
    }
    
    private final int hauteur;
    private final Couleur couleur;

    public Carte(int valeur, Couleur couleur) {
        this.hauteur = valeur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        String toString = "\"" + Integer.toString(this.hauteur) + "\", \"" + this.couleur + "\"";
        return toString;
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }
    
    public String getCouleurStr(){
        switch(this.couleur){
            case PIQUE:
                return "pique";
            case TREFLE:
                return "trefle";
            case CARREAU:
                return "carreau";
            case COEUR:
                return "coeur";
        }
        return null;
    }
}
