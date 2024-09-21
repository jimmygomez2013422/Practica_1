
package model;

public class Producto {
    
    //Atrivutos privados
    private String codigo;
    private String material;
    
    //contructores
    public Producto(String codigo, String material){
        this.codigo = codigo;
        this.material = material; 
        
    }

    //getters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
}
