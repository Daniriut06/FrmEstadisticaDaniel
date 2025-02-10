import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;


public class FrmEstadistica extends JFrame{

    JTextField txtDato;
    JList lstMuestra;
    JTextField txtEstadistica;
    JComboBox cmbEstadistica;

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
        JScrollPane spMuestra=new JScrollPane(lstMuestra);
        spMuestra.setBounds(360,40,100,150);
        getContentPane().add(spMuestra);

        JButton btnEstadistica=new JButton("Calcular");
        btnEstadistica.setBounds(85,205,100,25);
        getContentPane().add(btnEstadistica);

        cmbEstadistica=new JComboBox();
        String[] opciones=new String[]{"Sumatoria", "Promedio", "Desviacion", "Maximo", "Minimo", "Moda"}; 
        DefaultComboBoxModel mdlEstadistica=new DefaultComboBoxModel(opciones);
        cmbEstadistica.setModel(mdlEstadistica);
        cmbEstadistica.setBounds(190,205,100,25);
        getContentPane().add(cmbEstadistica);

        txtEstadistica=new JTextField();
        txtEstadistica.setBounds(300,205,100,25);
        getContentPane().add(txtEstadistica);


        //Eventos de la GUI

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

        btnEstadistica.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                calcularEstadistica();

            }


        });
        

        

    }

    private double[] muestra=new double[1000];
    private int totalDatos = -1;


    private void agregarDato(){
        try{

        
        double dato=Double.parseDouble(txtDato.getText());
        totalDatos++;
        muestra[totalDatos] = dato;
        txtDato.setText("");
        mostrarMuestra();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "debe especificar un valor numerico");
            txtDato.setText("");
        }

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
        //obtener la posicion escogida
        int posicion=lstMuestra.getSelectedIndex();
        //retirar la posicion del vector

        if (posicion >= 0){
            for (int i=posicion;i<totalDatos;i++){
                muestra[i]=muestra[i+1];
    
            }
            totalDatos--;
            mostrarMuestra();
        }else{
            JOptionPane.showMessageDialog(null, "debe seleccionar una posicion");
        }
        
        

    }

    private double sumatoria(){
        double suma=0;
        for (int i = 0; i<= totalDatos; i++){
            suma += muestra[i];
        }
        return suma;


    }

    private void calcularEstadistica(){
        switch (cmbEstadistica.getSelectedIndex()) {
            case 0:
                txtEstadistica.setText(String.valueOf(sumatoria()));
                break;
        
            default:
                break;
        }
    }


}
