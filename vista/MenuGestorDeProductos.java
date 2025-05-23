package gestion_de_productos.vista;

import java.util.Scanner;

import gestion_de_productos.controller.ServicioProducto;
import gestion_de_productos.dominio.Producto;

public class MenuGestorDeProductos {
    public static void menu(){
        var sc = new Scanner(System.in);
        var salir = false;
        while (!salir) {
            System.out.print("""
                1. agregar producto
                2. eliminar producto
                3. listar producto
                4. buscar producto
                5. editar producto
                6. salir
                """);
            var opt = sc.nextInt();
            switch (opt) {
                case 1 -> agregarProducto();
                case 2 -> eliminarProducto();
                case 3 -> listarProductos();
                case 4 -> buscarProducto();
                case 5 -> editarProducto();
                case 6 -> {
                    salir = true;
                }
                default-> System.out.println("opcion invalida");
            }
        }
    }

    private static void editarProducto() {

        var sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre o el id del producto a editar: ");
        var nombre = sc.nextLine();
        ServicioProducto.editarProducto(nombre);
    }

    private static void buscarProducto() {
        var sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        var nombre = sc.nextLine();
        ServicioProducto.buscarProductos(nombre);
    }

    private static void eliminarProducto() {
        var sc = new Scanner(System.in);
        System.out.println("Ingrese el elemento a eliminar: ");
        var nombre = sc.nextLine();

        ServicioProducto.eliminarProducto(nombre);
    }

    private static void listarProductos() {
        ServicioProducto.listarProductos();
    }

    private static void agregarProducto() {
        var sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        var nombre = sc.nextLine();
        System.out.println("Ingrese el precio: ");
        var precio = sc.nextDouble();
        System.out.println("Ingrese la cantidad: ");
        var cantidad = sc.nextInt();
        ServicioProducto.agregarProducto(new Producto(nombre, precio, cantidad));
        System.out.println("Producto agregado");
    }
}
