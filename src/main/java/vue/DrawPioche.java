/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Paquet;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import util.EcouteurModele;

/**
 *
 * @author ordinaute
 */
public class DrawPioche extends JLabel implements EcouteurModele {

    String txt;
    Paquet paquet;
    
    public DrawPioche(String txt) {
        super();
        this.txt = txt;
        this.setSize(80, 80);

    }

    public DrawPioche(Paquet paquet) {
        super();
        this.paquet = paquet;
        this.setSize(120, 120);

    }

    public void paintComponent(Graphics g) {
        int x1 = 5;
        int y1 = 5;
        int x2 = 48;
        int y2 = 78;
        int i = 0;
        g.setColor(Color.black);
        while (i < this.paquet.getNbCartes()-1) {
            //x1, y1, width, height, arcWidth, arcHeight
            g.drawRoundRect(x1 + 2 * i, y1 + 2 * i, x2, y2, 10, 10);
            i++;
        }
        g.setColor(Color.white);
        g.fillRoundRect(x1 + 2 * i + 1, y1 + 2 * i, x2, y2, 10, 10);
        g.setColor(Color.black);
        g.drawRoundRect(x1 + 2 * i + 1, y1 + 2 * i, x2, y2, 10, 10);
        if (txt != null) {
            g.drawString(txt, x1 * 3 / 2, y1 * 3 / 2);
        } else {
            //x1, y1, x2, y2
            g.drawLine(2 * x1 + 2 * i, y1 * 7 / 6 + 2 * i, (x1 + x2) * 16 / 17 + 2 * i, (y1 + y2) * 16 / 17 + 2 * i);
            g.drawLine(2 * x1 + 2 * i, (y1 + y2) * 16 / 17 + 2 * i, (x1 + x2) * 16 / 17 + 2 * i, y1 * 7 / 6 + 2 * i);
        }
    }

    @Override
    public EcouteurModele modeleMisAJour(Object source) {
        repaint();
        return this;
    }
}
