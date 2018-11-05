package isw.modelo;

public class Producto {
	
	private String nombre;
	
	private String precio;
	
	private String id;
	
	private String cantidad;
	
	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Producto(String id, String nombre, String cantidad, String precio) {
		setNombre(nombre);
		setPrecio(precio);
		setId(id);
		setCantidad(cantidad);
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}
}
