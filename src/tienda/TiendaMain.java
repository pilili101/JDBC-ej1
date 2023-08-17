package tienda;

import java.util.Scanner;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;

public class TiendaMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        ProductoService ps = new ProductoService();
        FabricanteService fs = new FabricanteService();

        try {
            boolean menu = true;
            do {
                System.out.println("Que desea hacer?");
                System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto.");
                System.out.println("2) Lista los nombres y los precios de todos los productos de la tabla producto.");
                System.out.println("3) Listar aquellos productos que su precio esté entre 120 y 202.");
                System.out.println("4) Buscar y listar todos los Portátiles de la tabla producto.");
                System.out.println("5) Listar el nombre y el precio del producto más barato.");
                System.out.println("6) Ingresar un producto a la base de datos.");
                System.out.println("7) Ingresar un fabricante a la base de datos");
                System.out.println("8) Editar un producto con datos a elección.");
                System.out.println("9) SALIR");

                switch (sc.nextInt()) {
                    case 1:
                        ps.listarProductosNombre();
                        System.out.println("---------------------------------------------------");
                        break;
                    case 2:
                        ps.listarProductosNombPrec();
                        System.out.println("---------------------------------------------------");
                        break;
                    case 3:
                        ps.listarProductosPrecio();
                        System.out.println("---------------------------------------------------");
                        break;
                    case 4:
                        ps.buscarPortatiles();
                        System.out.println("----------------------------------------------------");
                        break;
                    case 5:
                        ps.listarProdMasBarato();
                        System.out.println("----------------------------------------------------");
                        break;
                    case 6:
                        ps.ingresarProducto(sc);
                        System.out.println("----------------------------------------------------");
                        break;
                    case 7:
                        fs.ingresarFabricante(sc);
                        System.out.println("----------------------------------------------------");
                        break;
                    case 8:
                        ps.modificarProducto(sc);
                        System.out.println("----------------------------------------------------");
                        break;
                    case 9:
                        System.out.println("SALIENDO DEL SISTEMA");
                        menu = false;
                        break;
                    default:
                        throw new AssertionError("Opcion invalida");
                }

            } while (menu);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
