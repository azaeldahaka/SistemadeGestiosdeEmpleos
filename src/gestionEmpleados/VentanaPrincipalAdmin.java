package gestionEmpleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipalAdmin extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empresa empresa; // Instancia de la clase Empresa para acceder a la lista de empleados

//    public VentanaPrincipalAdmin(Empresa empresa) {
//        this.empresa = empresa;
//
//        setTitle("Panel de Administrador");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        JPanel panel = new JPanel();
//        getContentPane().add(panel);
//
//        JButton botonAgregarEmpleado = new JButton("Agregar Empleado");
//        JButton botonGestionEmpleados = new JButton("Gestión de Empleados"); // Cambiado el nombre del botón
//        JButton botonListaEmpleados = new JButton("Lista de Empleados");
//
//        panel.setLayout(new GridLayout(3, 1));
//        panel.add(botonAgregarEmpleado);
//        panel.add(botonGestionEmpleados); // Botón para gestionar empleados
//        panel.add(botonListaEmpleados);
//
//        botonAgregarEmpleado.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                abrirVentanaAgregarEmpleado();
//            }
//        });
//
//        botonGestionEmpleados.addActionListener(new ActionListener() { // Acción para abrir VentanaGestionEmpleados
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                abrirVentanaGestionEmpleados();
//            }
//        });
//
//        botonListaEmpleados.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                abrirVentanaListaEmpleados();
//            }
//        });
//    }

    public VentanaPrincipalAdmin(Empresa empresa) {
	    this.empresa = empresa;
	
	    setSize(570, 450);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
    	
    	setResizable(false);
    	getContentPane().setLayout(new BorderLayout(0, 0));
    	
    	JPanel panel = new JPanel();
    	getContentPane().add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("Panel de Control");
    	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
    	lblNewLabel.setBounds(198, 47, 149, 21);
    	panel.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("Gestión de Empleados");
    	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
    	lblNewLabel_1.setBounds(10, 8, 144, 16);
    	panel.add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("Administrador");
    	lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
    	lblNewLabel_2.setBounds(447, 9, 84, 15);
    	panel.add(lblNewLabel_2);
    	
    	JButton btnAgrEmpleado = new JButton("Agregar Empleado");
    	btnAgrEmpleado.setBounds(28, 133, 166, 21);
    	panel.add(btnAgrEmpleado);
    	
    	JButton btnListaDeEmpleados = new JButton("Lista de Empleados");
    	btnListaDeEmpleados.setBounds(28, 263, 166, 21);
    	panel.add(btnListaDeEmpleados);
    	
    	JButton btnGestionEmpleados = new JButton("Gestión de Empleados");
    	btnGestionEmpleados.setBounds(28, 193, 166, 21);
    	panel.add(btnGestionEmpleados);
    	
    	JLabel lblNewLabel_3 = new JLabel("Agregar un nuevo empelado a la empresa.");
    	lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
    	lblNewLabel_3.setBounds(248, 137, 278, 13);
    	panel.add(lblNewLabel_3);
    	
    	JLabel lblNewLabel_4 = new JLabel("Gesitionar los Saldos/Aumentos/Despidos");
    	lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
    	lblNewLabel_4.setBounds(248, 197, 278, 13);
    	panel.add(lblNewLabel_4);
    	
    	JLabel lblNewLabel_5 = new JLabel("Ver la Lista de Empleados.");
    	lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
    	lblNewLabel_5.setBounds(248, 267, 243, 13);
    	panel.add(lblNewLabel_5);
    	
    	
    	btnAgrEmpleado.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              abrirVentanaAgregarEmpleado();
          }
    	});

    	btnGestionEmpleados.addActionListener(new ActionListener() { // Acción para abrir VentanaGestionEmpleados
          @Override
          public void actionPerformed(ActionEvent e) {
              abrirVentanaGestionEmpleados();
          }
    	});

    	btnListaDeEmpleados.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              abrirVentanaListaEmpleados();
          }
    	});
    	
    	

	}

	private void abrirVentanaAgregarEmpleado() {
        // Abre una nueva ventana para agregar un empleado
        VentanaAgregarEmpleado ventanaAgregarEmpleado = new VentanaAgregarEmpleado(empresa);
        ventanaAgregarEmpleado.setVisible(true);
    }
	
	private void abrirVentanaGestionEmpleados() {
        // Abre la ventana de gestión de empleados (VentanaGestionEmpleados) con la instancia de la empresa
        VentanaGestionEmpleados ventanaGestionEmpleados = new VentanaGestionEmpleados(empresa);
        ventanaGestionEmpleados.setVisible(true);
    }

    private void abrirVentanaListaEmpleados() {
        // Abre la ventana de lista de empleados (VentanaListaEmpleados) con la instancia de la empresa
        VentanaListaEmpleados ventanaListaEmpleados = new VentanaListaEmpleados(empresa);
        ventanaListaEmpleados.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Empresa empresa = new Empresa();
            VentanaPrincipalAdmin ventana = new VentanaPrincipalAdmin(empresa);
            ventana.setVisible(true);
        });
    }
}

