/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import cartes.Paquet;
import cartes.PaquetFactory;
import vue.VuePaquetCache;
import vue.VuePaquetVisible;

/**
 *
 * @author ordinaute
 */
public class GUITest {
    public static void main(String[]args){
        int TYPEJEU = 52;
        Paquet pioche = PaquetFactory.buildPaquet(TYPEJEU);
        Paquet main = new Paquet();
        main.TYPEJEU = TYPEJEU;
        Paquet defausse = new Paquet();
        defausse.TYPEJEU = 52;
        
        VuePaquetCache piocheVue = new VuePaquetCache(pioche, "PIOCHE");
        VuePaquetVisible piocheMjVue = new VuePaquetVisible(pioche, "PIOCHE visible");
        VuePaquetVisible mainVue = new VuePaquetVisible(main, "MAIN");
        VuePaquetVisible defausseVue = new VuePaquetVisible(defausse, "DEFAUSSE");
        String joueurT = "Jeu de " + TYPEJEU + " cartes";
        JoueurFrame joueurFrame = new JoueurFrame(joueurT, 600, 720, piocheVue,
        mainVue, defausseVue);
        MJFrame mjFrame = new MJFrame("A ne pas montrer aux joueurs", 600, 200, piocheMjVue);
        
        //GUI gui = new GUI(joueurFrame, mjFrame);
        
        
    }    
}
