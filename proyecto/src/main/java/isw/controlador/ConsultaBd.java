package isw.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import isw.modelo.Producto;

public class ConsultaBd {

	private static Connection conexion = null;
	
	private PreparedStatement consultarProductoo = null;
	private PreparedStatement consultarProductoo2 = null;
	
	public ConsultaBd(Connection conex) {
		this.conexion = conex;
		try {
			consultarProductoo = conexion.prepareStatement(
					"SELECT id, nombre, cantidad, precio FROM producto WHERE nombre = ?");
			consultarProductoo2 = conexion.prepareStatement(
					"SELECT id, nombre, cantidad, precio FROM producto WHERE id = ?");
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	public Producto consultarProducto(String nombre) {
		ResultSet result = null;
		Producto pro = new Producto();
		try {		
			consultarProductoo.setString(1, nombre);
			result = consultarProductoo.executeQuery();
			while (result.next()) {
				pro.setId(result.getString("id"));
				pro.setNombre(result.getString("nombre"));
				pro.setCantidad("1");
				pro.setPrecio(Double.toString((result.getDouble("precio"))));
				return pro;
			}		
		} 
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return pro;
	}
	
	public Producto consultarProducto2(String id) {
		ResultSet result = null;
		Producto pro = new Producto();
		try {		
			consultarProductoo2.setString(1, id);
			result = consultarProductoo2.executeQuery();
			while (result.next()) {
				pro.setId(result.getString("id"));
				pro.setNombre(result.getString("nombre"));
				pro.setCantidad("1");
				pro.setPrecio(Double.toString((result.getDouble("precio"))));
				return pro;
			}		
		} 
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return pro;
	}
	
	public void close() {
		try {
			conexion.close();
		} 
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} 
	}
}
