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

    public final static String 
            PIQUE = "pique",
            TREFLE = "trèfle",
            CARREAU = "carreau",
            COEUR = "coeur";
    
    private final int hauteur;
    private final String couleur;

    public Carte(int valeur, String couleur) {
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

    public String getCouleur() {
        return this.couleur;
    }
    
    public String getHauteurStr(){
        switch(this.hauteur){
            case 1:
                return "as";
            case 11:
                return "valet";
            case 12:
                return "dame";
            case 13:
                return "roi";
            default:
                return String.valueOf(hauteur);
        }
    }
}
