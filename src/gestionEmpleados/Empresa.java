package gestionEmpleados;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> listaEmpleados;

    public Empresa() {
        listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);
    }

    public List<Empleado> obtenerListaEmpleados() {
        return listaEmpleados;
    }

    public Empleado buscarEmpleadoPorIdentificacion(String numeroIdentificacion) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return empleado;
            }
        }
        return null;
    }

    // Otros métodos para la gestión de empleados en la empresa
}