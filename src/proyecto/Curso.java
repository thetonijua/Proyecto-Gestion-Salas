/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


/**
 *
 * @author BruceLee
 */
public class Curso extends JFrame implements ActionListener, ItemListener {

    //variables de instancia
    private String nombre;
    private int codigo;
    private float porceAprobacion;
    private Map<Integer, Alumno> estudiantes;
    private Map<String, Integer> nombreXId;
    private List<Integer> listaEstu;
    private Colegio c;
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in)); //usado para leer la lista
    
    private JLabel label1,label2,label3,label4;
    private JButton boton1,boton2,boton3,boton4,boton5;
    private JTextField tf1,tf2;
    private JComboBox combo1,combo2;

    //constructores
    public Curso(String name, float numero, int cod) {
        nombre = name;
        porceAprobacion = numero;
        estudiantes = new HashMap();
        nombreXId = new HashMap();
        codigo = cod;
        listaEstu = new ArrayList();
    }

    public Curso() {
        nombre = "Por asignar";
        porceAprobacion = (float) 0;
        estudiantes = new HashMap();
        nombreXId = new HashMap();
        listaEstu = new ArrayList();

    }

    public Curso(String name) {
        nombre = name;
        porceAprobacion = (float) 0;
        estudiantes = new HashMap();
        nombreXId = new HashMap();
        listaEstu = new ArrayList();
    }

    //setters y getters de las variables
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPorceAprobacion() {
        return porceAprobacion;
    }

    //dos setters para porceAprobacion por si el argumento es int o float
    public void setPorceAprobacion(int porceAprobacion) {
        this.porceAprobacion = porceAprobacion;
    }

    public void setPorceAprobacion(float porceAprobacion) {
        this.porceAprobacion = porceAprobacion;
    }

    //tres getters para alumno por si el argumento es Integer, float o String
    public Alumno getAlumno(Integer id) {

        if (!estudiantes.containsKey(id)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(id);
    }

    public Alumno getAlumno(float id) {
        int num;
        float aux = id % 1;
        aux = id - aux;
        num = (int) aux;

        if (!estudiantes.containsKey(num)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(num);
    }

    public Alumno getAlumno(String txt) {
        int num = nombreXId.get(txt);

        if (!estudiantes.containsKey(num)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(num);
    }

    //métodos de la clase
    /*dos métodos para añadir el alumno a la lista
    el primero es para una id de tipo int*/
    public void putAlumno(String name, int id) {
        Alumno aux = new Alumno(name, id);
        nombreXId.put(name, id);
        estudiantes.put(id, aux);
        listaEstu.add(id);
    }

    //el segundo es para una id de tipo String
    // Metodo ocupado en interfaz para ingresar alumno
    public void putAlumno(String name, String id) {
        int num = Integer.parseInt(id);
        Alumno aux = new Alumno(name, num);
        estudiantes.put(num, aux);
        nombreXId.put(name, num);
        listaEstu.add(num);
       
    }

    //imprime la key del estudiante en el mapa
    public void printSetKey() {
        System.out.println(estudiantes.keySet());
    }

    //pasa la lista de asistencia, preguntando si el estudiante está presente o no
    public void pasarLista() throws IOException {
        int largo = listaEstu.size();
        int cod;
        String lectura;
        String fecha;
        System.out.println("Ingrese Fecha");
        fecha = scan.readLine();

        Alumno aux;
        for (int i = 0; i < largo; i++) {
            cod = listaEstu.get(i);
            aux = estudiantes.get(cod);
            System.out.println("Esta presente " + aux.getNombre() + "? (si/no)");
            lectura = scan.readLine();
            aux.asistencia(fecha, lectura);
        }
    }

    //imprime toda la lista de estudiantes
    public void printLista() throws IOException {
        int largo = listaEstu.size();
        int cod;
        String lectura;

        Alumno aux;
        for (int i = 0; i < largo; i++) {
            cod = listaEstu.get(i);
            aux = estudiantes.get(cod);
            System.out.println(aux.getNombre());
        }
    }

    //elimina un alumno de la lista según su id
    public void eliminarAlumno(int id) {
        int i;
        if (estudiantes.remove(id) != null) {
            for (i = 0; i < listaEstu.size(); i++) {

                if (id == listaEstu.get(i)) {
                    listaEstu.remove(i);
                }

            }
        }
    }
    
    //elimina un alumno de la lista según su nombre
    public void eliminarAlumno(String name) {
        int i,id;
        id=nombreXId.get(name);
        if (estudiantes.remove(id) != null) {
            for (i = 0; i < listaEstu.size(); i++) {

                if (id == listaEstu.get(i)) {
                    listaEstu.remove(i);
                }

            }
        }
    }
    public int cantAlum(){
        return listaEstu.size();
    }
    
    public Alumno datosAlumno (int num){
           int cod = listaEstu.get(num);
           return estudiantes.get(cod);   
    }
    
    
    
    //
    //      Metodos ventana
    //
    //
    
    
    public void configVentana(Colegio c){
        setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.c=c;
        setTitle("Curso "+nombre+" (test version)");
        label1= new JLabel("Nombre");
        label2= new JLabel("Id");
        label3= new JLabel("Lista Alumnos");
        label4= new JLabel("Lista Dias");
        boton1= new JButton("Agregar alumno");
        boton2= new JButton("Eliminar");
        boton3= new JButton("Eliminar dia");
        boton4= new JButton("Pasar Lista");
        boton5= new JButton("Atras");
        tf1= new JTextField();
        tf2= new JTextField();
        combo1= new JComboBox();
        combo2= new JComboBox();
    
    
        
        add(tf1);
        add(tf2);

        add(label2);
        add(label1);
        add(label3);
        add(label4);
   
        add(boton1);
        add(boton2);
        add(boton3);
//        add(boton4);
        add(boton5);
        add(combo1);
        add(combo2);
        
        tf1.setBounds(200,60,150,17);
        tf2.setBounds(200,100,150,17);

        label1.setBounds(200,0,100,100);
        label2.setBounds(200,40,100,100);
        label3.setBounds(385,40,150,100);
        label4.setBounds(250,205,150,100);
        combo1.setBounds(385,100,150,19);
        combo2.setBounds(250,263,150,19);
       
        boton1.setBounds(20,60,150,25);
        boton2.setBounds(385,40,150,25);
        boton3.setBounds(20,260,150,25);
        boton4.setBounds(20,300,150,25);
        boton5.setBounds(20,450,100,25);
        
        
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton5.addActionListener(this);
        combo1.addItemListener(this);
        combo2.addItemListener(this);
        
        
        
        this.setBounds(0, 0, 570, 570);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==boton1){
            String texto1= tf1.getText();
            String texto2= tf2.getText();

            if((texto1.equals(""))||(texto2.equals(""))){
                JOptionPane.showMessageDialog(null, "Rellena ambos campos");
            }else{
                this.putAlumno(texto1, texto2);
                combo1.addItem(texto1);
                tf1.setText("");
                tf2.setText("");
            }
   
        }    
        
        if(e.getSource()==boton2){
            if(combo1.getSelectedItem()==null){
              JOptionPane.showMessageDialog(null, "Selecciona un alumno");  
            }else{
                String aux=combo1.getSelectedItem().toString();
                eliminarAlumno(aux);
                combo1.removeItem(aux);
            }
        }
        
        if(e.getSource()==boton3){
            if(combo1.getSelectedItem()==null||combo2.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null, "Selecciona un día y un Alumno");  
            }else{
                String aux=combo1.getSelectedItem().toString();
                Alumno a=this.getAlumno(aux);
                a.eliminarDia(combo2.getSelectedItem().toString());
            }
        }
        
        if(e.getSource()==boton5){
            this.setVisible(false);
            c.setVisible(true);
            
        }
        
    }
        
    
    @Override
    public void itemStateChanged(ItemEvent e){
            if(e.getSource()==combo1){
                String selec= combo1.getSelectedItem().toString();
                if(selec.equals("")){
                    //JOptionPane.showMessageDialog(null, "Selecciona un curso");
                }
        }
    }
    
    
    
}
