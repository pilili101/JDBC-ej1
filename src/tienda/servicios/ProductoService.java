package tienda.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoService {

    public ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    public void listarProductosNombre() throws Exception {

        ArrayList<Producto> productos = new ArrayList();
        productos.addAll(dao.listarProductosNombre());
        System.out.println("Lista de productos por nombre: ");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre());
        }
    }

    public void listarProductosNombPrec() throws Exception {

        ArrayList<Producto> productos = new ArrayList();
        productos.addAll(dao.listarProductosNombPrec());
        System.out.println("Lista de productos por nombre y precio: ");
        for (Producto producto : productos) {
            System.out.print(producto.getNombre() + "---->");
            System.out.println(producto.getPrecio());
        }
    }

    public void listarProductosPrecio() throws Exception {

        ArrayList<Producto> productos = new ArrayList();
        productos.addAll(dao.listarProdPrecio());
        System.out.println("Lista de productos con precio entre 120 y 202: ");
        System.out.println("Codigo, nombre, precio y codigo de fabricante:");
        for (Producto producto : productos) {
            System.out.print(producto.getCodigo() + ") ");
            System.out.print(producto.getNombre() + "---->");
            System.out.print(producto.getPrecio() + "-----");
            System.out.println(producto.getCodigoFabricante());
        }
    }

    public void buscarPortatiles() throws Exception {
        ArrayList<Producto> productos = new ArrayList();
        productos.addAll(dao.buscarPortatiles());
        System.out.println("Lista de portatiles: ");
        System.out.println("Codigo, nombre, precio y codigo de fabricante:");
        for (Producto producto : productos) {
            System.out.print(producto.getCodigo() + ") ");
            System.out.print(producto.getNombre() + "---->");
            System.out.print(producto.getPrecio() + "-----");
            System.out.println(producto.getCodigoFabricante());
        }
    }

    
    public void listarProdMasBarato() throws Exception{
        Producto producto = dao.listarProdMasBarato();
        System.out.println("El producto mas barato es: "+producto.getNombre());
        System.out.println("Codigo: "+producto.getCodigo());
        System.out.println("Precio: "+producto.getPrecio());
        System.out.println("Codigo de fabricante: "+producto.getCodigoFabricante());
    }
    
    public void ingresarProducto(Scanner sc) throws Exception{
        Producto p = new Producto();
        System.out.println("Ingrese el nombre del producto:");
        p.setNombre(sc.next());
        System.out.println("Ingrese el precio del producto:");
        p.setPrecio(sc.nextDouble());
        System.out.println("Ingrese el codigo del fabricante:");
        p.setCodigoFabricante(sc.nextInt());
        dao.ingresarProducto(p);
    }
    
    public void modificarProducto(Scanner sc){
        Producto p = new Producto();
        System.out.println("Ingrese el codigo del producto que quiere modificar");
        p.setCodigo(sc.nextInt());
        System.out.println("Ingrese el nuevo nombre");
        p.setNombre(sc.next());
        System.out.println("Ingrese el nuevo precio");
        p.setPrecio(sc.nextDouble());
        dao.modificarProducto(p);
    }
    
}
