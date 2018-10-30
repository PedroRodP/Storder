package controladores;

import javafx.application.Platform;
import javafx.stage.Stage;
import vista.StageAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notificador extends Thread {

    private static Notificador notificador;
    private TrayIcon trayIcon;
    private SystemTray tray;

    private Notificador() {
        tray = SystemTray.getSystemTray();
        notificador = this;
    }

    @Override
    public void run() {
        inicializarIcono();
    }

    public static Notificador instanciar() {
        if (notificador == null) {
            notificador = new Notificador();
        }
        return notificador;
    }

    public void mostrarMensaje(String titulo, String texto) {
        trayIcon.displayMessage(titulo, texto, TrayIcon.MessageType.INFO);
    }

    private void inicializarIcono() {
        try {
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

            //Doble clic en trayIcon abre el stage
            trayIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //runLater() para Threads de JavaFX dentro de Threads de AWT
                    Platform.runLater(() -> {
                        new StageAdmin().run();
                    });
                }
            });

        } catch (AWTException e) {
            System.err.println("No se puede cargar el icono de la bandeja. " +
                                "El programa no puede ejecutarse...");
            System.exit(-1);
        }
    }

    public void limpiarBandeja() {
        tray.remove(trayIcon);
    }
}
