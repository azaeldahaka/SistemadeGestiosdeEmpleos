package gestionEmpleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioEditarEmpleado extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empleado empleado; // Empleado que se va a editar
    private JTextField campoNombre;
    private JTextField campoNumeroIdentificacion;
    private JTextField campoFechaNacimiento;
    private JTextField campoDireccion;
    private JTextField campoCorreoElectronico;
    private JTextField campoNumeroTelefono;
    private JButton botonEditar;

    public FormularioEditarEmpleado(Frame parent, Empleado empleado) {
        super(parent, "Editar Empleado", true);
        this.empleado = empleado;

        campoNombre = new JTextField(20);
        campoNumeroIdentificacion = new JTextField(20);
        campoFechaNacimiento = new JTextField(20);
        campoDireccion = new JTextField(20);
        campoCorreoElectronico = new JTextField(20);
        campoNumeroTelefono = new JTextField(20);

        botonEditar = new JButton("Guardar Cambios");

        // Rellenar los campos con los datos actuales del empleado
        campoNombre.setText(empleado.getNombre());
        campoNumeroIdentificacion.setText(empleado.getNumeroIdentificacion());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        campoFechaNacimiento.setText(dateFormat.format(empleado.getFechaNacimiento()));
        campoDireccion.setText(empleado.getDireccion());
        campoCorreoElectronico.setText(empleado.getCorreoElectronico());
        campoNumeroTelefono.setText(empleado.getNumeroTelefono());

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(new JLabel("Número de Identificación:"));
        panel.add(campoNumeroIdentificacion);
        panel.add(new JLabel("Fecha de Nacimiento (dd/mm/yyyy):"));
        panel.add(campoFechaNacimiento);
        panel.add(new JLabel("Dirección:"));
        panel.add(campoDireccion);
        panel.add(new JLabel("Correo Electrónico:"));
        panel.add(campoCorreoElectronico);
        panel.add(new JLabel("Número de Teléfono:"));
        panel.add(campoNumeroTelefono);
        panel.add(botonEditar);

        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarEmpleado();
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    private void editarEmpleado() {
        String nombre = campoNombre.getText();
        String numeroIdentificacion = campoNumeroIdentificacion.getText();
        String fechaNacimientoString = campoFechaNacimiento.getText();
        String direccion = campoDireccion.getText();
        String correoElectronico = campoCorreoElectronico.getText();
        String numeroTelefono = campoNumeroTelefono.getText();

        // Intentar convertir la fecha de nacimiento a un objeto Date
        Date fechaNacimiento = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            fechaNacimiento = dateFormat.parse(fechaNacimientoString);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no válida. Utilice el formato dd/mm/yyyy.");
            return;
        }

        // Actualizar los datos del empleado con los valores ingresados
        empleado.setNombre(nombre);
        empleado.setNumeroIdentificacion(numeroIdentificacion);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setDireccion(direccion);
        empleado.setCorreoElectronico(correoElectronico);
        empleado.setNumeroTelefono(numeroTelefono);

        // Cierra el formulario después de editar al empleado
        dispose();

        // Muestra un mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Empleado editado con éxito.");
    }
}
