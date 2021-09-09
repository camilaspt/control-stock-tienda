package tienda.Servicios;

import java.util.List;
import java.util.Scanner;

import tienda.Entidades.Producto;

import tienda.persistencia.ProductoDAO;

public class consultasTienda {

    private final ProductoDAO productoDAO = new ProductoDAO();
    private final Scanner read = new Scanner(System.in).useDelimiter("\n");

    public void mostrarTodosLosDatos() throws Exception {
        List<Producto> lista = productoDAO.listAll();
        for (Producto producto : lista) {
            System.out.println(producto.toString());
        }
    }

    public void mostrarNombreyPrecio() throws Exception {
        List<Producto> lista = productoDAO.listPrecioNombre();
        for (Producto producto : lista) {
            System.out.println("Nombre: " + producto.getNombre() + " Precio: " + producto.getPrecio());
        }
    }

    public void mostrarProductoPrecioEntre120y202() throws Exception {
        List<Producto> lista = productoDAO.listPrecioEntre120y202();
        for (Producto producto : lista) {
            System.out.println(producto);
        }
    }

    public void mostrarPortatiles() throws Exception {
        List<Producto> lista = productoDAO.listPortatiles();
        for (Producto producto : lista) {
            System.out.println(producto);
        }
    }

    public void mostrarMasBarato() throws Exception {
        Producto producto = productoDAO.productoMasBarato();
        System.out.println("Producto mas barato: " + producto);
    }

    public void mostrarMasCaro() throws Exception {
        Producto producto = productoDAO.productoMasCaro();
        System.out.println("Producto mas caro: " + producto);
    }

    public void menu() {
        System.out.println("         /////MENU//////   \n1) Lista de todos los productos\n2) Lista de los nombres y los precios de todos los productos\n3) Listar aquellos productos que su precio esté entre 120 y 202\n4) Buscar y listar todos los Portátiles\n5) Listar el nombre y el precio del producto más barato\n6) Listar el nombre y el precio del producto más caro\n7) Ingresar un producto\n8) Ingresar un fabricante\n9) Salir ");
    }

    public void ejecutar() {

        int op = 1;

        while (op != 9) {

            menu();
            System.out.println("Ingrese la opcion que desea ejecutar ");
            op = read.nextInt();

            switch (op) {

                case 1:

                    try {
                        mostrarTodosLosDatos();
                    } catch (Exception ex) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 1");
                    }
                    break;

                case 2:

                    try {
                        mostrarNombreyPrecio();
                    } catch (Exception ex) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 2");
                    }

                    break;

                case 3:
                    try {
                        mostrarProductoPrecioEntre120y202();
                    } catch (Exception ex) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 3");
                    }
                    break;

                case 4:
                    try {
                        mostrarPortatiles();
                    } catch (Exception ex) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 4");
                    }
                    break;

                case 5:
                    try {
                        mostrarMasBarato();
                    } catch (Exception ex) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 5");
                    }
                    break;

                case 6:
                    try {
                        mostrarMasCaro();
                    } catch (Exception ex) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 6");
                    }
                    break;

                case 7:
                    try {
                        System.out.println("Datos del producto:");
                        productoDAO.agregarProducto();
                    } catch (Exception e) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 7");
                    }
                    break;

                case 8:
                    try {
                        System.out.println("Datos del fabricante:");
                        productoDAO.agregarFabricante();
                    } catch (Exception e) {
                        System.out.println("Ocurrio un error al ejecutar la opcion 8");
                    }
                    break;

                case 9:
                    System.out.println("Esta seguro que desea salir? S/N");
                    String exit = read.next().substring(0);
                    if (exit.toUpperCase().equals("S")) {
                        op = 9;
                    } else {
                        break;
                    }
                    break;
            }

        }

    }
}
