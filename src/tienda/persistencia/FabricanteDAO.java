package tienda.persistencia;

import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO {

    public void ingresarFabricante(Fabricante fabricante){
      
        try {
            
            if(fabricante==null){
                throw new Exception("El fabricante es nulo");   
            }
            String sql = "insert into fabricante values ('"+fabricante.getCodigo()+"','"+fabricante.getNombre()+"');" ;
            insertarModificarEliminar(sql);
            System.out.println("FABRICANTE INGRESADO CORRECTAMENTE");
        } catch (Exception e) {
        }
        
    }
    
    
}
