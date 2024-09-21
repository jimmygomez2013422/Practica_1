
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import model.Modelo;
import model.Producto;
import view.VentanaGenerar;
import view.VentanaHilos;
import view.VentanaProducto;

public class Controlador implements ActionListener {
    
    private Modelo modelo;
    private VentanaProducto ventana;
    private VentanaGenerar ventanagenerar;
    private VentanaHilos ventanahilos;
    private DefaultTableModel dtm = new DefaultTableModel();
    private String codigo = "";
    private int cantidad = 0;
    
    public Controlador(Modelo modelo,VentanaProducto ventana){
        this.modelo = modelo;
        this.ventana = ventana;
        this.ventanagenerar = new VentanaGenerar();
        this.ventanahilos = new VentanaHilos();
        this.ventana.btnCargar.addActionListener(this);
        this.ventana.btnActualizar.addActionListener(this);
        this.ventana.btnGenerar.addActionListener(this);
        this.ventanagenerar.btnProducir.addActionListener(this);
    }
    
    public void cargarArchivo(){
        try{
            FileReader fileR = new FileReader("C:/Users/Jimmy/Desktop/programacion/proyectos/Practica_1/Entrada/archivo.csv");
            BufferedReader bufferR = new BufferedReader(fileR);
            
            String linea;
            boolean omitirEncabezado = true;
            
            while ((linea = bufferR.readLine()) != null) {
                
                if (omitirEncabezado == true){
                    omitirEncabezado = false;
                    continue;
                }
                
                String arreglo[] = linea.split(",");
                //codigo areglo [0]
                //material areglo [1]
                Producto prod = new Producto(arreglo[0], arreglo[1]);
                this.modelo.guardarProducto(prod);
            }
        } catch (Exception e) {
            
        }
    }
    
    public void mostrarTabla(){
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        String columnas[] = {"codigo", "Material"};
        for (String columna: columnas){
            dtm.addColumn(columna);
        }
        for (Producto prod: this.modelo.getListaProducto()){
            String filas[] = {prod.getCodigo(), prod.getMaterial()};
            dtm.addRow(filas);
        }
        this.ventana.tablaPro.setModel(dtm);
    }
    
    public void producir (){
        codigo = this.ventanagenerar.campoCodigo.getText();
        cantidad = Integer.parseInt(this.ventanagenerar.campoCantidad.getText());
        this.ventanahilos.setVisible(true);
        iniciarHilo();
    }
    
    public int tiempoMaterial(String material) {
        int tiempo = 0;
        
        switch (material) {
            case "metal":{
                tiempo = 5;
            }
        }
        return tiempo;
    }
    
    public void iniciarHilo(){
        Thread hilo = new Thread(() -> {
            
            int cantidadProductos = 1;
            
            for (int i = 0; i < cantidad; i++){
                
                this.ventanahilos.lbCantidad.setText("Producto: " + cantidadProductos);
                Producto prod = this.modelo.obtenerProducto(codigo);
                String material = prod.getMaterial();
                //Tiempo del material
                int tiempoMaterial = tiempoMaterial(material);
                
                this.ventanahilos.barra1.setValue(0);
                this.ventanahilos.barra1.setMaximum(cantidad);
                for (int j = 0; j < 10; j++){
                    this.ventanahilos.barra1.setValue(j);
                    
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e) {
                        
                    }
                }
                
                //this.ventanahilos.barra1.setValue(i);
                
               /* try{
                    Thread.sleep(1000); //1 segundo
                }catch (Exception e) {
                    
                }*/
               cantidadProductos++;
            }
            this.ventanahilos.barra1.setValue(0);
            
        });
        hilo.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.ventana.btnCargar){
            cargarArchivo();
        } else if (e.getSource() == this.ventana.btnActualizar) {
            mostrarTabla();
        }else if (e.getSource() == this.ventana.btnGenerar){
            this.ventanagenerar.setVisible(true);
        }else if (e.getSource() == this.ventanagenerar){
            producir();
        }
    }
    
    
}
