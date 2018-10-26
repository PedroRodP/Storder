package controladores;

import java.awt.*;

public class Notificador {

    private TrayIcon trayIcon;
    private SystemTray tray;

    public Notificador() throws AWTException {
        tray = SystemTray.getSystemTray();

        //Image image = Toolkit.getDefaultToolkit().createImage("/resources/icon/icon.png");
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/icon/icon.png"));

        trayIcon = new TrayIcon(image, "Tray Icon");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set nombre del icono for the tray icon
        trayIcon.setToolTip("STORDER");
        tray.add(trayIcon);

        trayIcon.displayMessage("Storder", "Ejecutando STORDER", TrayIcon.MessageType.INFO);
    }

    public void apagar() {
        tray.remove(trayIcon);
    }
}
