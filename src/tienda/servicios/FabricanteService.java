
package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteService {
    
    public FabricanteDAO dao;
    
    public FabricanteService(){
        this.dao= new FabricanteDAO();
    }
    
     public void ingresarFabricante(Scanner sc) throws Exception{
        Fabricante f = new Fabricante();
        System.out.println("Ingrese el nombre del fabricante:");
        f.setNombre(sc.next());
        System.out.println("Ingrese el codigo del fabricante:");
        f.setCodigo(sc.nextInt());
        dao.ingresarFabricante(f);
    }
    
}
