package model;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    
    private List<Producto> listaProducto;

    public Modelo() {
        this.listaProducto = new ArrayList<>();
    }
    
    public void guardarProducto(Producto producto){
        if (obtenerProducto(producto.getCodigo()) == null) {
            this.listaProducto.add(producto);
        } else {
            System.out.println("El producto con el código " + producto.getCodigo() + " ya existe.");
        }
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public Producto obtenerProducto(String codigo){
        if (codigo == null || listaProducto == null) {
            return null;
        }
        for (Producto pro: this.listaProducto){
            if (pro.getCodigo().equals(codigo)){
                return pro;
            }
        }
        return null;
    }
}
