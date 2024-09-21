package model;

public class Producto {

    // Atributos privados
    private String codigo;
    private String material;

    // Constructor
    public Producto(String codigo, String material) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío.");
        }
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("El material no puede ser nulo o vacío.");
        }
        this.codigo = codigo;
        this.material = material; 
    }

    // Getters
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

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return codigo.equals(producto.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
