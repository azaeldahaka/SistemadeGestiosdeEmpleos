package gestionEmpleados;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la empresa
        Empresa empresa = new Empresa();

        // Crear una instancia de la ventana de inicio de sesión
        VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();

        // Mostrar la ventana de inicio de sesión
        ventanaInicioSesion.setVisible(true);

        // Esperar hasta que se complete la autenticación
        while (!ventanaInicioSesion.isAutenticado()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Si la autenticación es exitosa, crear la ventana principal del administrador
        if (ventanaInicioSesion.isAutenticado()) {
            // Crear una instancia de la ventana principal del administrador
            VentanaPrincipalAdmin ventanaPrincipalAdmin = new VentanaPrincipalAdmin(empresa);

            // Mostrar la ventana principal
            ventanaPrincipalAdmin.setVisible(true);
        }
    }
}
