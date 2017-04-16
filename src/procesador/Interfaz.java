/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import static java.awt.Frame.ICONIFIED;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author INTEL-COREi7
 */
public class Interfaz extends JFrame implements ActionListener {

    JFrame field;
    JPanel panel1;
    JTextField tx1, tx2, tx3, tx4, tx5, tx6;
    JButton b1;

    //Procesador procesador = new Procesador();
    public Interfaz(UnidadControl u1, UnidadTratamiento u2) {
        field = new JFrame();
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));
        //panel1.setBorder(new EmptyBorder(80,80,80,80));

        tx1 = new JTextField(20);
        tx1.setBorder(BorderFactory.createTitledBorder(tx1.getBorder(), "IR", TitledBorder.CENTER, ICONIFIED));
        tx1.setText(u1.IR);

        tx2 = new JTextField(20);
        tx2.setBorder(BorderFactory.createTitledBorder(tx2.getBorder(), "AR", TitledBorder.CENTER, ICONIFIED));
        tx2.setText(u2.AR);

        tx3 = new JTextField(20);
        tx3.setBorder(BorderFactory.createTitledBorder(tx3.getBorder(), "DR", TitledBorder.CENTER, ICONIFIED));
        tx3.setText(u2.DR);

        tx4 = new JTextField(20);
        tx4.setBorder(BorderFactory.createTitledBorder(tx4.getBorder(), "RD", TitledBorder.CENTER, ICONIFIED));
        tx4.setText(u2.BufferRegistros[0]);

        tx5 = new JTextField(20);
        tx5.setBorder(BorderFactory.createTitledBorder(tx5.getBorder(), "r7", TitledBorder.CENTER, ICONIFIED));
        tx5.setText(u2.BufferRegistros[1]);

        tx6 = new JTextField(20);
        tx6.setBorder(BorderFactory.createTitledBorder(tx6.getBorder(), "PC", TitledBorder.CENTER, ICONIFIED));
        tx6.setText(u1.PC);

        /*tx1.setText(u1.IR);
        tx2.setText(u2.AR);
        tx3.setText(u2.DR);
        tx4.setText(u2.BufferRegistros[0]);
        tx5.setText(u2.BufferRegistros[1]);
        tx6.setText(u1.PC);/*

        //b1 = new JButton("Mostrar");
        //tx1.setBounds(100,100,200,40);
        /*t1 = new JTextArea(6, 15);
        t1.setBounds(200,500,250,100);
        
        
        
        t2 = new JTextArea(6, 15);
        t3 = new JTextArea(6, 15);
        t4 = new JTextArea(6, 15);
        t5 = new JTextArea(6, 15);
        t6 = new JTextArea(6, 15);
        t7 = new JTextArea(6, 15);
        t8 = new JTextArea(6, 15);*/
        //l1.setAlignment(panel1.CENTER);
        /*panel1.add(t1);
        panel1.add(t2);
        panel1.add(t3);
        panel1.add(t4);
        panel1.add(t5);
        panel1.add(t6);
        panel1.add(t7);
        panel1.add(t8);*/
        panel1.add(tx1);
        panel1.add(tx2);
        panel1.add(tx3);
        panel1.add(tx4);
        panel1.add(tx5);
        panel1.add(tx6);

        //panel1.add(b1);
        //b1.addActionListener(this);

        //panel1.add(new JTextArea(20,10));
        //panel1.add(new JTextArea(20,10));
        field.add(panel1);

        //field.setLayout(new GridLayout());
        field.setLocationRelativeTo(null);
        field.setTitle("Microprocesador");
        field.setVisible(true);
        field.setSize(500, 500);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //NO OLVIDAR panel1.add(button)   b1.addActionListener(this);
    }

    /*public void actionPerformed(ActionEvent e, UnidadControl u1, UnidadTratamiento u2) {
        if (e.getActionCommand().equals("Mostrar")) {
            tx1.setText(u1.IR);
            tx2.setText(u2.AR);
            tx3.setText(u2.DR);
            tx4.setText(u2.BufferRegistros[0]);
            tx5.setText(u2.BufferRegistros[1]);
            tx6.setText(u1.PC);
        }
    }*/

    public void actionPerformed(ActionEvent e) {

    }
}
