package gestionEmpleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class VentanaAgregarEmpleado extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Empresa empresa; // Instancia de la clase Empresa para agregar empleados

    private JTextField campoNombre;
    private JTextField campoNumeroIdentificacion;
    private JTextField campoFechaNacimiento;
    private JTextField campoDireccion;
    private JTextField campoCorreoElectronico;
    private JTextField campoNumeroTelefono;
    private JButton botonAgregar;
    private JLabel lblNewLabel;

    public VentanaAgregarEmpleado(Empresa empresa) {
    	setResizable(false);
        this.empresa = empresa;

        setTitle("Agregar Empleado");
        setSize(479, 428);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel etiquetaNombre = new JLabel("Nombre y Apellido:");
        etiquetaNombre.setBounds(10, 80, 171, 32);
        campoNombre = new JTextField(20);
        campoNombre.setBounds(10, 111, 193, 32);
        JLabel etiquetaNumeroIdentificacion = new JLabel("Número de Identificación:");
        etiquetaNumeroIdentificacion.setBounds(10, 153, 193, 32);
        campoNumeroIdentificacion = new JTextField(20);
        campoNumeroIdentificacion.setBounds(10, 181, 193, 32);
        JLabel etiquetaFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        etiquetaFechaNacimiento.setBounds(10, 223, 193, 32);
        campoFechaNacimiento = new JTextField(20);
        campoFechaNacimiento.setBounds(10, 261, 193, 32);
        JLabel etiquetaDireccion = new JLabel("Dirección:");
        etiquetaDireccion.setBounds(254, 80, 108, 32);
        campoDireccion = new JTextField(20);
        campoDireccion.setBounds(254, 111, 193, 32);
        JLabel etiquetaCorreoElectronico = new JLabel("Correo Electrónico:");
        etiquetaCorreoElectronico.setBounds(254, 153, 193, 32);
        campoCorreoElectronico = new JTextField(20);
        campoCorreoElectronico.setBounds(254, 181, 193, 32);
        JLabel etiquetaNumeroTelefono = new JLabel("Número de Teléfono:");
        etiquetaNumeroTelefono.setBounds(254, 223, 193, 32);
        campoNumeroTelefono = new JTextField(20);
        campoNumeroTelefono.setBounds(254, 261, 193, 32);

        botonAgregar = new JButton("Agregar Empleado");
        botonAgregar.setBounds(137, 320, 193, 32);
        panel.setLayout(null);
        panel.add(etiquetaNombre);
        panel.add(campoNombre);
        panel.add(etiquetaNumeroIdentificacion);
        panel.add(campoNumeroIdentificacion);
        panel.add(etiquetaFechaNacimiento);
        panel.add(campoFechaNacimiento);
        panel.add(etiquetaDireccion);
        panel.add(campoDireccion);
        panel.add(etiquetaCorreoElectronico);
        panel.add(campoCorreoElectronico);
        panel.add(etiquetaNumeroTelefono);
        panel.add(campoNumeroTelefono);
        panel.add(botonAgregar);
        
        lblNewLabel = new JLabel("Agregar Empleado");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(162, 20, 152, 32);
        panel.add(lblNewLabel);

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });
    }

    private void agregarEmpleado() {
        String nombre = campoNombre.getText();
        String numeroIdentificacion = campoNumeroIdentificacion.getText();
        String fechaNacimiento = campoFechaNacimiento.getText();
        String direccion = campoDireccion.getText();
        String correoElectronico = campoCorreoElectronico.getText();
        String numeroTelefono = campoNumeroTelefono.getText();

        // Crea una instancia de Empleado con los datos ingresados
        Empleado empleado = new Empleado(nombre, numeroIdentificacion, fechaNacimiento, direccion, correoElectronico, numeroTelefono);

        // Agrega el empleado a la empresa
        empresa.agregarEmpleado(empleado);

        // Limpia los campos después de agregar al empleado
        campoNombre.setText("");
        campoNumeroIdentificacion.setText("");
        campoFechaNacimiento.setText("");
        campoDireccion.setText("");
        campoCorreoElectronico.setText("");
        campoNumeroTelefono.setText("");

        // Muestra un mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Empleado agregado con éxito.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Debes pasar una instancia de la clase Empresa al crear la ventana de agregar empleado.
            Empresa empresa = new Empresa();
            VentanaAgregarEmpleado ventana = new VentanaAgregarEmpleado(empresa);
            ventana.setVisible(true);
        });
    }
}
