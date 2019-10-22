/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ordinaute
 */
public class LayoutTest {

    public static void main(String[] args) {
        JFrame window = new JFrame("Test");
        window.setSize(200, 600);
        JPanel contentPane = new JPanel();
        window.setContentPane(contentPane);
        JPanel layoutPan = new JPanel();
        //layoutPan.
        //contentPane.add(layoutPan);
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.LEFT);
        layoutPan.setLayout(flow);
        layoutPan.add(new JButton("carte1"));
        layoutPan.add(new JButton("carte2"));
        layoutPan.add(new JButton("carte3"));
        layoutPan.add(new JButton("carte4"));
        layoutPan.add(new JButton("carte5"));
        layoutPan.add(new JButton("carte6"));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
