package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {

    public void ingresarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("El producto es nulo");
            }
            String sql = " insert into producto (nombre,precio,codigo_fabricante)"
                    + "VALUES ('" + producto.getNombre() + "','" + producto.getPrecio() + "','" + producto.getCodigoFabricante() + "');";
            insertarModificarEliminar(sql);
            System.out.println("PRODUCTO INGRESADO CORRECTAMENTE");
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) {

        try {
            if (producto == null) {
                throw new Exception("El producto es nulo, no se puede modificar");
            }
            String sql = "update producto set"
                    + "nombre = '" + producto.getNombre() + "'"
                    + "precio = " + producto.getPrecio()
                    + "where codigo =" + producto.getCodigo() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
        }
    }

    public Collection<Producto> listarProductosNombre() throws Exception {
        try {
            String sql = "select nombre from producto;";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resul.next()) {
                producto = new Producto();
                producto.setNombre(resul.getNString("nombre"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }

    public Collection<Producto> listarProductosNombPrec() throws Exception {
        try {
            String sql = "select nombre, precio from producto;";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resul.next()) {
                producto = new Producto();
                producto.setNombre(resul.getNString("nombre"));
                producto.setPrecio(resul.getDouble("precio"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }

    public Collection<Producto> listarProdPrecio() throws Exception {
        try {
            String sql = "select * from producto where precio between 120 and 202;";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resul.next()) {
                producto = new Producto();
                producto.setCodigo(resul.getInt("codigo"));
                producto.setNombre(resul.getNString("nombre"));
                producto.setPrecio(resul.getDouble("precio"));
                producto.setCodigoFabricante(resul.getInt("codigo_fabricante"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }

    public Collection<Producto> buscarPortatiles() throws Exception {
        try {
            String sql = "select * from producto where nombre like '%portatil%';";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resul.next()) {
                producto = new Producto();
                producto.setCodigo(resul.getInt("codigo"));
                producto.setNombre(resul.getNString("nombre"));
                producto.setPrecio(resul.getDouble("precio"));
                producto.setCodigoFabricante(resul.getInt("codigo_fabricante"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }

    public Producto listarProdMasBarato() throws Exception {

        try {
            String sql = "select * from producto order by precio limit 1;";
            consultarBase(sql);

            Producto producto = null;

            while (resul.next()) {
                producto = new Producto();
                producto.setCodigo(resul.getInt("codigo"));
                producto.setNombre(resul.getNString("nombre"));
                producto.setPrecio(resul.getDouble("precio"));
                producto.setCodigoFabricante(resul.getInt("codigo_fabricante"));
            }
            desconectarBase();
            return producto;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

}
