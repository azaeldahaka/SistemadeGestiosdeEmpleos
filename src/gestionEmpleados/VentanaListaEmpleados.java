package gestionEmpleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaListaEmpleados extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empresa empresa; // Instancia de la clase Empresa para acceder a la lista de empleados
    private JList<String> listaEmpleados;
    private DefaultListModel<String> modeloLista;

    public VentanaListaEmpleados(Empresa empresa) {
    	setResizable(false);
        this.empresa = empresa;

        setTitle("Lista de Empleados");
        setSize(457, 430);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 49, 422, 285);
        getContentPane().add(panel);

        modeloLista = new DefaultListModel<>();

        panel.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);
        listaEmpleados = new JList<>(modeloLista);
        scrollPane.setViewportView(listaEmpleados);
        JButton botonEliminarEmpleado = new JButton("Eliminar Empleado");
        botonEliminarEmpleado.setBounds(298, 351, 134, 21);
        getContentPane().add(botonEliminarEmpleado);
        JButton botonEditarEmpleado = new JButton("Editar Empleado");
        botonEditarEmpleado.setBounds(10, 351, 134, 21);
        getContentPane().add(botonEditarEmpleado);
        
                JButton botonVerDetalles = new JButton("Ver Detalles");
                botonVerDetalles.setBounds(154, 351, 134, 21);
                getContentPane().add(botonVerDetalles);
                
                JLabel lblNewLabel = new JLabel("Lista de Empleados");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
                lblNewLabel.setBounds(143, 10, 156, 29);
                getContentPane().add(lblNewLabel);
                
                        // Acción para ver detalles de un empleado seleccionado
                        botonVerDetalles.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                verDetallesEmpleado();
                            }
                        });
        
                // Acción para editar un empleado seleccionado
                botonEditarEmpleado.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        editarEmpleado();
                    }
                });
        
                // Acción para eliminar un empleado seleccionado
                botonEliminarEmpleado.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eliminarEmpleado();
                    }
                });

        // Llena la lista de empleados con los nombres
        actualizarListaEmpleados();
    }

    private void actualizarListaEmpleados() {
        modeloLista.clear();
        for (Empleado empleado : empresa.obtenerListaEmpleados()) {
            modeloLista.addElement(empleado.getNombre());
        }
    }

    private void verDetallesEmpleado() {
        int indiceSeleccionado = listaEmpleados.getSelectedIndex();
        if (indiceSeleccionado >= 0) {
            Empleado empleado = empresa.obtenerListaEmpleados().get(indiceSeleccionado);
            // Aquí puedes mostrar los detalles del empleado en una nueva ventana o cuadro de diálogo
            JOptionPane.showMessageDialog(null, "Detalles del empleado:\n" + empleado.toString());
        }
    }

    private void editarEmpleado() {
        int indiceSeleccionado = listaEmpleados.getSelectedIndex();
        if (indiceSeleccionado >= 0) {
            // Abre una ventana para editar los detalles del empleado seleccionado
            Empleado empleado = empresa.obtenerListaEmpleados().get(indiceSeleccionado);
            // Debes implementar la lógica para editar al empleado y actualizar la lista después de la edición.
            // Por ejemplo, abrir una ventana de edición similar a la de agregar empleado.
            // Luego, actualizar la lista de empleados después de la edición.
        }
    }

    private void eliminarEmpleado() {
        int indiceSeleccionado = listaEmpleados.getSelectedIndex();
        if (indiceSeleccionado >= 0) {
            Empleado empleado = empresa.obtenerListaEmpleados().get(indiceSeleccionado);
            empresa.eliminarEmpleado(empleado);
            actualizarListaEmpleados();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Debes pasar una instancia de la clase Empresa al crear la ventana de lista de empleados.
            Empresa empresa = new Empresa();
            VentanaListaEmpleados ventana = new VentanaListaEmpleados(empresa);
            ventana.setVisible(true);
        });
    }
}


