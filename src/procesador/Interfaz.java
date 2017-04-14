/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author INTEL-COREi7
 */
public class Interfaz extends JFrame implements ActionListener {

    public Interfaz() {
        JLabel l1 = new JLabel("Timedoff Version 1.1", JLabel.CENTER);
        l1.setBackground(Color.red);
        l1.setForeground(Color.yellow);
        JLabel l2 = new JLabel("subject:");
        JTextField b = new JTextField("subject", 15);
        JLabel l3 = new JLabel("Body:");
        JTextArea a1 = new JTextArea("boby", 10, 20);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        add(l1, gbc);
        gbc.gridy++;
        add(l2, gbc);
        gbc.gridy++;
        add(b, gbc);
        gbc.gridy++;
        add(l3, gbc);
        gbc.gridy++;
        add(a1, gbc);

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(l1);
        frame.add(l2);
        frame.add(b);
        frame.add(l3);
        frame.add(a1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
