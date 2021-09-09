/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Entidades;

/**
 *
 * @author camil
 */
public class Producto {

    public double precio;
    public int codigo, codigo_fabricante;
    public String nombre;

    public Producto() {
    }

    public Producto(double precio, int codigo, String nombre, int codigo_fabricante) {
        this.precio = precio;
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigo_fabricante = codigo_fabricante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "   Nombre: " + nombre + "   Precio: $" + precio + "   Codigo fabricante: " + codigo_fabricante;
    }

}
