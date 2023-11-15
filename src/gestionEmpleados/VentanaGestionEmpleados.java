package gestionEmpleados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionEmpleados extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Empresa empresa; // Instancia de la clase Empresa para gestionar empleados

    private JButton botonAumentarSueldo;
    private JButton botonDisminuirSueldo;
    private JButton botonDespedir;
    private JTextArea historialText;

    public VentanaGestionEmpleados(Empresa empresa) {
    	setResizable(false);
        this.empresa = empresa;

        setTitle("Gestión de Empleados");
        setSize(800, 600); // Cambia las dimensiones según tus necesidades
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        botonAumentarSueldo = new JButton("Aumentar Sueldo");
        botonDisminuirSueldo = new JButton("Disminuir Sueldo");
        botonDespedir = new JButton("Despedir Empleado");
        historialText = new JTextArea(10, 30);
        historialText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historialText);

        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setAutoCreateGaps(true);
        gl_panel.setAutoCreateContainerGaps(true);

        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup()
                .addGroup(gl_panel.createSequentialGroup()
                    .addComponent(botonAumentarSueldo)
                    .addComponent(botonDisminuirSueldo)
                    .addComponent(botonDespedir))
                .addComponent(scrollPane)
        );

        gl_panel.setVerticalGroup(
            gl_panel.createSequentialGroup()
                .addGroup(gl_panel.createParallelGroup()
                    .addComponent(botonAumentarSueldo)
                    .addComponent(botonDisminuirSueldo)
                    .addComponent(botonDespedir))
                .addComponent(scrollPane)
        );

        panel.setLayout(gl_panel);


        botonAumentarSueldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para aumentar el sueldo de un empleado o todos los empleados.
                // Actualiza el historialText con la información apropiada.
            }
        });

        botonDisminuirSueldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para disminuir el sueldo de un empleado o todos los empleados.
                // Actualiza el historialText con la información apropiada.
            }
        });

        botonDespedir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para despedir un empleado.
                // Actualiza el historialText con la información apropiada.
            }
        });


        pack();
    }
        
}

