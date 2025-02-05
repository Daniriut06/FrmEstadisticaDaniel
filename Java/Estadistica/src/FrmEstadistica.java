import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;


public class FrmEstadistica extends JFrame{

    JTextField txtDato;
    JList lstMuestra;

    public FrmEstadistica (){    
        setSize (600,300);
        setTitle("Estadistica");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblDato=new JLabel("Dato");
        lblDato.setBounds(20,10,100,25);
        getContentPane().add(lblDato);
        
        txtDato=new JTextField();
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

        lstMuestra=new JList();
        lstMuestra.setBounds(360,40,100,150);
        getContentPane().add(lstMuestra);

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

    private double[] muestra=new double[1000];
    private int totalDatos = -1;


    private void agregarDato(){
        double dato=Double.parseDouble(txtDato.getText());
        totalDatos++;
        muestra[totalDatos] = dato;
        mostrarMuestra();


    }

    private void mostrarMuestra(){
        String[] strmuestra=new String[totalDatos+1];

        lstMuestra.removeAll();
        for(int i=0; i<=totalDatos;i++){
           strmuestra[i]=(String.valueOf(muestra[i]));

        }
        lstMuestra.setListData(strmuestra);

    }

    private void quitarDato(){
        JOptionPane.showMessageDialog(null,"hizo click en quitar");

    }



}
