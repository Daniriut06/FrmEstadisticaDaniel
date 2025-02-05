import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class FrmEstadistica extends JFrame{


    public FrmEstadistica (){    
        setSize (600,300);
        setTitle("Estadistica");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblDato=new JLabel("Dato");
        lblDato.setBounds(20,10,100,25);
        getContentPane().add(lblDato);
        
        JTextField txtDato=new JTextField();
        txtDato.setBounds(110,10,100,25);
        getContentPane().add(txtDato);

        JLabel lblDatos=new JLabel("Muestra");
        lblDatos.setBounds(385,10,100,25);
        getContentPane().add(lblDatos);

        JButton btnAgregar=new JButton("Agregar");
        btnAgregar.setBounds(110, 50,100,25);
        getContentPane().add(btnAgregar);

        JButton btnQuitar=new JButton("Quitar");
        btnQuitar.setBounds(110, 80,100,25);
        getContentPane().add(btnQuitar);

        JList lstMuesta=new JList();
        lstMuesta.setBounds(360,40,100,150);
        getContentPane().add(lstMuesta);

        btnAgregar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                agregarDato();

            }


        });

        btnQuitar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                quitarDato();

            }


        });

        

    }
    private void agregarDato(){
        JOptionPane.showMessageDialog(null, "hizo click en agregar");

    }

    private void quitarDato(){
        JOptionPane.showMessageDialog(null,"hizo click en quitar");

    }



}
