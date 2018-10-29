package controladores;

import java.util.*;

public abstract class TemporizadorDeStories {

    private static LinkedList<TimerTask> tasks = new LinkedList<>();

    public static void crearAlarma(String titulo, String texto, int hora, int minutos) {
        //Date horaDespertar = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, hora);
        c.set(Calendar.MINUTE, minutos);
        c.set(Calendar.SECOND, 0);

        Timer temporizador = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Notificador.instanciar().mostrarMensaje(titulo, texto);
            }
        };
        temporizador.schedule(task, c.getTime()); //*/
        tasks.add(task);
    }

    public static void cancelarTodo() {
        tasks.forEach(timerTask -> {
            timerTask.cancel();
        });
    }
}
