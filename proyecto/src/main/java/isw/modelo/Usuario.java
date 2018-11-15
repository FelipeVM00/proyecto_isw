package isw.modelo;

public class Usuario {

	
	private String nombre;
	
	private String contraseña;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	public Usuario(String nombre, String contraseña) {
		setNombre(nombre);
		setContraseña(contraseña);
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
}
