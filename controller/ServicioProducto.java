package gestion_de_productos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gestion_de_productos.dominio.Producto;

public class ServicioProducto {
    private static final List<Producto> productos;
    
    // bloque inicializador
    static{
        productos = new ArrayList<>();
        productos.add(new Producto("cocacola", 3.000,10));
        productos.add(new Producto("chocorramo", 3.000,50));
        productos.add(new Producto("detodito", 5.000,70));
    }

    public static void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public static void listarProductos(){
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public static boolean buscarProductos(String nombre){
        var encontrado = false;
        try {
            for (Producto producto : productos) {
                if(producto.getNombre().equals(nombre)){
                    System.out.println(producto);
                    encontrado = true;
                }
                //else if(producto.getIdProducto() == id){
                //    System.out.println(producto);
                //    encontrado = true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al buscar producto: " +  e.getMessage());
            e.getStackTrace();
        }

        return encontrado;
    }

    public static void editarProducto(String nombre){
        var sc = new Scanner(System.in);
        for (Producto producto : productos) {
            if(producto.getNombre().equals(nombre)){
                System.out.println("Ingrese el nombre: ");
                var nuevoNombre = sc.nextLine();
                System.out.println("Ingrese el precio: ");
                var precio = sc.nextDouble();
                System.out.println("Ingrese la cantidad: ");
                var cantidad = sc.nextInt();
                producto.setNombre(nuevoNombre);
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
            }else{
                System.out.println("Producto no encontrado");
            }
        }
    }

    public static void eliminarProducto(String nombre){

        try {
            for (Producto producto : productos) {
                if(producto.getNombre().equals(nombre)){
                    productos.remove(producto);
                    System.out.println("Producto eliminado");
                }
            }
            System.out.println("Elemento no encontrado");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            e.getStackTrace();
        }

    }
}
