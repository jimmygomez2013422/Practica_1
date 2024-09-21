package practica_1;

import controller.Controlador;
import model.Modelo;
import view.VentanaProducto;

/**** @author Jimmy*/
public class Practica_1 {

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        VentanaProducto ventana = new VentanaProducto();
        Controlador controler = new Controlador(modelo, ventana);
        ventana.setVisible(true);
    }
    
}
