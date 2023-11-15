
package gestionEmpleados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class VentanaInicioSesion extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField campoUsuario;
    private JPasswordField campoContraseña;
    private JButton botonIniciarSesion;
    private boolean autenticado = false; // Variable para controlar el estado de autenticación


    public VentanaInicioSesion() {
    	setResizable(false);
        setTitle("Inicio de Sesión del Administrador");
        setSize(376, 337);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel etiquetaUsuario = new JLabel("Usuario:");
        etiquetaUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        etiquetaUsuario.setBounds(73, 82, 56, 13);
        campoUsuario = new JTextField(15);
        campoUsuario.setBounds(73, 105, 200, 19);
        
        JLabel etiquetaContraseña = new JLabel("Contraseña:");
        etiquetaContraseña.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        etiquetaContraseña.setBounds(73, 145, 76, 13);
        campoContraseña = new JPasswordField(15);
        campoContraseña.setBounds(73, 168, 200, 19);
       
        botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        botonIniciarSesion.setBounds(73, 226, 200, 21);
        panel.setLayout(null);

        panel.add(etiquetaUsuario);
        panel.add(campoUsuario);
        panel.add(etiquetaContraseña);
        panel.add(campoContraseña);
        panel.add(botonIniciarSesion);
        
        JLabel lblNewLabel = new JLabel("Gestión de Empleados");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblNewLabel.setBounds(90, 20, 168, 33);
        panel.add(lblNewLabel);

        
        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                char[] contraseña = campoContraseña.getPassword();

                if (usuario.equals("admin") && String.valueOf(contraseña).equals("contraseña")) {
                    dispose(); // Cierra la ventana de inicio de sesión
                    Empresa empresa = new Empresa(); // Crea una instancia de Empresa
                    // Iniciar la ventana principal del administrador con la instancia de Empresa
                    VentanaPrincipalAdmin ventanaPrincipal = new VentanaPrincipalAdmin(empresa);
                    ventanaPrincipal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtelo de nuevo.");
                }

            }
        });
        
        campoContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        }); 

    }  
    
 // Agrega un método separado para el inicio de sesión para que puedas reutilizarlo
    private void iniciarSesion() {
        String usuario = campoUsuario.getText();
        char[] contraseña = campoContraseña.getPassword();

        if (usuario.equals("admin") && String.valueOf(contraseña).equals("contraseña")) {
            dispose(); // Cierra la ventana de inicio de sesión
            Empresa empresa = new Empresa(); // Crea una instancia de Empresa
            // Iniciar la ventana principal del administrador con la instancia de Empresa
            VentanaPrincipalAdmin ventanaPrincipal = new VentanaPrincipalAdmin(empresa);
            ventanaPrincipal.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtelo de nuevo.");
        }
    }
    
    public boolean isAutenticado() {
        return autenticado;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicioSesion ventana = new VentanaInicioSesion();
            ventana.setVisible(true);
        });
    }

}

