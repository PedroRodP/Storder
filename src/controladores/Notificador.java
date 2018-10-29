package controladores;

import java.awt.*;

public class Notificador {

    private static Notificador notificador;
    private TrayIcon trayIcon;
    private SystemTray tray;

    private Notificador() throws AWTException {
        tray = SystemTray.getSystemTray();
        inicializarIcono();
        notificador = this;
    }

    public static Notificador instanciar() {
        if (notificador == null) {
            try {
                notificador = new Notificador();
            }
            catch (AWTException e) {
                System.err.println("No se puede cargar el icono de la bandeja. " +
                                    "El programa no puede ejecutarse...");
                System.exit(-1);
            }
        }
        return notificador;
    }

    public void mostrarMensaje(String titulo, String texto) {
        trayIcon.displayMessage(titulo, texto, TrayIcon.MessageType.INFO);
    }

    private void inicializarIcono() throws AWTException {

        //Image image = Toolkit.getDefaultToolkit().createImage("/resources/icon/iconInverted.png");
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/icon/iconInverted.png"));

        trayIcon = new TrayIcon(image, "Tray Icon");

        //Permitir al sistema cambiar el tamano si es necesario
        trayIcon.setImageAutoSize(true);
        //Establecer nombre del icono en la bandeja
        trayIcon.setToolTip("STORDER");
        //Agregar a la bandeja de sistema
        tray.add(trayIcon);
        //Mostrar mensaje en la bandeja
        trayIcon.displayMessage("Storder", "Ejecutando STORDER", TrayIcon.MessageType.INFO);
    }

    public void apagar() {
        tray.remove(trayIcon);
    }
}
