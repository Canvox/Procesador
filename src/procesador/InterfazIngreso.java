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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    JButton b1,b2;

    MemoriaPrincipalTest memoriap = new MemoriaPrincipalTest();
    MemoriaTest memoria;

    public InterfazIngreso() {

        frame = new JFrame();

        t1 = new JTextField(10);
        t1.setBorder(BorderFactory.createTitledBorder(t1.getBorder(), "Cop", TitledBorder.CENTER, ICONIFIED));
        t2 = new JTextField(10);
        t2.setBorder(BorderFactory.createTitledBorder(t2.getBorder(), "Dato", TitledBorder.CENTER, ICONIFIED));

        b1 = new JButton("Añadir");
        b2 = new JButton("Stop");

        frame.add(t1);
        frame.add(t2);

        frame.add(b1);
        b1.addActionListener(this);
        
        frame.add(b2);
        b2.addActionListener(this);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setTitle("Instruccion");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Añadir")) {

            Pattern pat = Pattern.compile("[A-F0-9]{4}");
             
            memoria = new MemoriaTest();

            memoria.setDireccion(memoriap.generar());
           
            Matcher mat = pat.matcher(t2.getText());

            //instruccion.instruccionUsuario();
            if ((t1.getText().equals("LOAD") || t1.getText().equals("ADD") || t1.getText().equals("JUMP" )) && mat.matches()){
                memoria.instruccion.setCop(t1.getText());
                memoria.instruccion.setDato(t2.getText());
                memoria.instruccion.valor(memoria.instruccion.cop);
                memoria.instruccion.data = memoria.instruccion.cop.concat(memoria.instruccion.dato);
                memoriap.listaMemoria.add(memoria);
                JOptionPane.showMessageDialog(frame, "Instruccion agregada exitosamente");
                memoriap.cargar();
                
            } else {
                JOptionPane.showMessageDialog(frame, "Ingreso invalido!", "Error", JOptionPane.ERROR_MESSAGE);
                t1.setText("");
                t2.setText("");
            }
            //Siempre se esta sobrescribiendo el file
            t1.setText("");
            t2.setText("");
        }
        
         if (e.getActionCommand().equals("Stop")) {
             memoriap.listaMemoria.clear();
         }
    }
}
