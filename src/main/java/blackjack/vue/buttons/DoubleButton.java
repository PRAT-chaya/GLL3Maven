/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.vue.buttons;

import cartes.Paquet;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ordinaute
 */
public class DoubleButton extends JButton {

    private final Paquet paquet;

    public DoubleButton(ActionListener al, Paquet paquet) {
        super("DOUBLE");
        this.paquet = paquet;
        this.addActionListener(al);
    }

    public Paquet getPaquet() {
        return paquet;
    }

}
