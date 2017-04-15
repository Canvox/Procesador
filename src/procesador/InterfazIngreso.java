/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.awt.FlowLayout;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author INTEL-COREi7
 */
public class InterfazIngreso extends JFrame implements ActionListener {

    JFrame frame;
    JTextField t1;
    JTextField t2;

    JButton b1;

    public InterfazIngreso() {
        
        frame = new JFrame();
        
        t1 = new JTextField(10);
        t1.setBorder(BorderFactory.createTitledBorder(t1.getBorder(),"Cop", TitledBorder.CENTER, ICONIFIED));
        t2 = new JTextField(10);
        t2.setBorder(BorderFactory.createTitledBorder(t2.getBorder(),"Dato", TitledBorder.CENTER, ICONIFIED));
        
        b1 = new JButton("Añadir");

        frame.add(t1);
        frame.add(t2);

        frame.add(b1);
        b1.addActionListener(this);
        
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setTitle("Instruccion");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
