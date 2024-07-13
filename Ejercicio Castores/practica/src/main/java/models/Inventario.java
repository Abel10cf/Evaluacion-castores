package models;

import jakarta.persistence.*;

@Entity
public class Inventario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long IdInventario;
    private int cantidad;

    @OneToOne
    private Producto producto;

    public Long getIdInventario() {
        return IdInventario;
    }

    public void setIdInventario(Long idInventario) {
        IdInventario = idInventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
