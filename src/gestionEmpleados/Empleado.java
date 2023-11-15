package gestionEmpleados;

import java.util.Date;

//import java.util.Date; // Para manejar fechas

public class Empleado {
    // Atributos
    private String nombre;
    private String numeroIdentificacion;
    private String fechaNacimiento;
    private String direccion;
    private String correoElectronico;
    private String numeroTelefono;

    // Constructor
    public Empleado(String nombre, String numeroIdentificacion, String fechaNacimiento2, String direccion, String correoElectronico, String numeroTelefono) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fechaNacimiento = fechaNacimiento2;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }

    public Empleado(String nombre2, String numeroIdentificacion2, Date fechaNacimiento2, String direccion2,
			String correoElectronico2, String numeroTelefono2) {
		// TODO Auto-generated constructor stub
    	// SI NO FUNCIONA EL CODIGO, SACAR ESTE CONSTRUCTOR Y CAMBIAR
	}

	// Getters y setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    // Otros métodos de la clase Empleado
    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de Identificación: " + numeroIdentificacion);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Dirección: " + direccion);
        System.out.println("Correo Electrónico: " + correoElectronico);
        System.out.println("Número de Teléfono: " + numeroTelefono);
    }

	public void setFechaNacimiento(Date fechaNacimiento2) {
		// TODO Auto-generated method stub
		// SI NO FUNCIONA FormularioEditarEmpleado.java BORRAR ESTA LINEA
	}
}
