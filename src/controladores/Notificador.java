package controladores;

import vista.ImagesOrquester;

import java.awt.*;

public class Notificador {

    private TrayIcon trayIcon;
    private SystemTray tray;

    public Notificador() throws AWTException {
        tray = SystemTray.getSystemTray();
        crearTrayIcon();
        tray.add(trayIcon);

        trayIcon.displayMessage("Storder", "Ejecutando STORDER", TrayIcon.MessageType.INFO);
    }

    private void crearTrayIcon() {
        //Image image = Toolkit.getDefaultToolkit().createImage("/resources/icon/iconInverted.png");
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/icon/iconInverted.png"));

        trayIcon = new TrayIcon(image, "Tray Icon");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set nombre del icono for the tray icon
        trayIcon.setToolTip("STORDER");
    }

    public void apagar() {
        tray.remove(trayIcon);
    }
}
