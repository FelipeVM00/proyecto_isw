package isw.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import isw.modelo.Producto;
import isw.modelo.Usuario;

public class ConsultaBd {

	private static Connection conexion = null;
	
	private PreparedStatement consultarProductoo = null;
	private PreparedStatement consultarProductoo2 = null;
	private PreparedStatement newProducto = null;
	private PreparedStatement removeProducto = null;
	private PreparedStatement removeProducto2 = null;
	private PreparedStatement consultarUsuario = null;
	
	public ConsultaBd(Connection conex) {
		this.conexion = conex;
		try {
			consultarProductoo = conexion.prepareStatement(
					"SELECT id, nombre, cantidad, precio FROM producto WHERE nombre = ?");
			consultarProductoo2 = conexion.prepareStatement(
					"SELECT id, nombre, cantidad, precio FROM producto WHERE id = ?");
			newProducto =conexion.prepareStatement(
					"INSERT INTO producto "+"(id, nombre, precio, cantidad )"+" VALUES (?, ?, ?, ?)");
			removeProducto =conexion.prepareStatement(
					"UPDATE producto SET cantidad = (cantidad-?) WHERE id = ?"); 
			removeProducto2 =conexion.prepareStatement(
					"UPDATE producto SET cantidad = (cantidad-?) WHERE nombre = ?"); 
			consultarUsuario = conexion.prepareStatement(
					"SELECT nombre, contraseña FROM usuarios");
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
	
  public void agregarProducto (String id, String nombre, Double precio, int cantidad) {
		
		try {
			
			newProducto.setString(1, id);
			newProducto.setString(2, nombre);
			newProducto.setDouble(3, precio);
			newProducto.setInt(4, cantidad);
			newProducto.executeUpdate();	
		
		}
		
		catch(SQLException exception){
		
			exception.printStackTrace();

		}

	}
  
  public void eliminarProducto (String cantidad, String id ) {
		
		try {

			removeProducto.setString(1, cantidad);
			removeProducto.setString(2, id);
			removeProducto.executeUpdate();	
		
		}
		
		catch(SQLException exception){
		
			exception.printStackTrace();

		}

	}
  
  public void eliminarProducto2 (String cantidad, String nombre) {
		
		try {
			
			removeProducto2.setString(1, cantidad);
			removeProducto2.setString(2, nombre);
			removeProducto2.executeUpdate();	
		
		}
		
		catch(SQLException exception){
		
			exception.printStackTrace();

		}

	}
  
  public Usuario consultarUsuario (String nombre, String contraseña, Usuario user) {


		try {		

			ResultSet result = consultarUsuario.executeQuery();
			 result.next();
				user.setNombre(result.getString("nombre"));
				user.setContraseña(result.getString("contraseña"));
	
			
		} 
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return user;
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
