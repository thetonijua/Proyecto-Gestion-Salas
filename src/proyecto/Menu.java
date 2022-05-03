

//---------------------------------------------------------------
//              MENU ES UNA CLASE INTERFAZ
//---------------------------------------------------------------

// Avance de interfaz grafica para entregas futuras

package proyecto;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *
 * @author J_Hor
 */
public class Menu extends JFrame implements ActionListener,ChangeListener{
    
    //Map<String, Curso> colegio;
    //Map<String, Integer> cursoXId;
    
    private int option;
    private JLabel label1;
    private JButton boton1;
    private JRadioButton radio1,radio2;
    private ButtonGroup bg;
    private Colegio c;
    
    

//    private JComboBox combo1;

    
    public Menu(Colegio c){
        super("Gestion Salas (test version)");//TITULO VENTANA
        this.c=c;
        //colegio = new HashMap<>();
        
        //ELEMENTOS VENTANA
        
        label1= new JLabel("Seleccione una opción");
        boton1= new JButton("Siguiente");
        radio1= new JRadioButton("Importar Archivo CSV");
        radio2= new JRadioButton("Crear Colegio");
        bg= new ButtonGroup();
       

    }
    
 
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==boton1){
            this.setVisible(false);
            if(option==1){
                JOptionPane.showMessageDialog(null,"Todavia no implementado en menu");
                this.setVisible(true);
            }
            if(option==2){
                
                c.configVentana();
            }
        }    
    }
    
    public  void getFrameColegio(){
        c.configVentana();
    }
    
//    @Override
//    public void itemStateChanged(ItemEvent e){
//            if(e.getSource()==combo1){
//                String selec= combo1.getSelectedItem().toString();
//                if(selec.equals("")){
//                    
//                }
//            }
//    }
    
    @Override
    public void stateChanged(ChangeEvent e){
       option=0;
       
       if(radio1.isSelected()==true){
           option=1;
           boton1.setEnabled(true);
           //setSize(800,600);
       }
       if(radio2.isSelected()==true){
           option=2;
           boton1.setEnabled(true);
           
       }
//       if(radio3.isSelected()==true){
//           option=3;
//       }
//       if(radio4.isSelected()==true){
//           option=4;
//       }
//       if(radio5.isSelected()==true){
//           option=5;
//       }
//       if(radio6.isSelected()==true){
//           option=6;
//       }
//       if(radio7.isSelected()==true){
//           option=7;
//       }
//       if(radio8.isSelected()==true){
//           option=8;
//       }
//       if(radio9.isSelected()==true){
//           option=9;
//       }
      
    }

    
    public void configVentana(){
        setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(label1);
        boton1.setEnabled(false);
        add(boton1);
        boton1.addActionListener(this);
        
        label1.setBounds(20,20,150,100);
        boton1.setBounds(190,205,100,25);
        
        radio1.setBounds(200,50,150,30);
        radio1.addChangeListener(this);
        add(radio1);
        bg.add(radio1);
        radio2.setBounds(200,80,150,30);
        radio2.addChangeListener(this);
        add(radio2);
        bg.add(radio2);
//        radio3.setBounds(200,110,150,30);
//        radio3.addChangeListener(this);
//        add(radio3);
//        bg.add(radio3);
//        radio4.setBounds(200,140,150,30);
//        radio4.addChangeListener(this);
//        add(radio4);
//        radio5.setBounds(200,170,150,30);
//        radio5.addChangeListener(this);
//        add(radio5);
//        radio6.setBounds(200,200,150,30);
//        radio6.addChangeListener(this);
//        add(radio6);
//        radio7.setBounds(200,230,150,30);
//        radio7.addChangeListener(this);
//        add(radio7);
//        radio8.setBounds(200,260,150,30);
//        radio8.addChangeListener(this);
//        add(radio8);
//        radio9.setBounds(200,290,150,30);
//        radio9.addChangeListener(this);
//        add(radio9);
        
        
        
        this.setBounds(0, 0, 500,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }


    
}
