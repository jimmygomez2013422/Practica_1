
package model;

import java.util.ArrayList;

public class Modelo {
    
    public static ArrayList<Producto> listaProducto;
    
    public Modelo() {
        this.listaProducto = new ArrayList<>();
    }
    
    public void guardarProducto(Producto producto){
        this.listaProducto.add(producto);
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public Producto obtenerProducto(String codigo){
        for (Producto pro: this.listaProducto){
            if (pro.getCodigo().equals(codigo)){
                return pro;
            }
        }
        return null;
    }
    
    
}
