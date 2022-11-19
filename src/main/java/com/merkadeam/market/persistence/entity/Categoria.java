package com.merkadeam.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
