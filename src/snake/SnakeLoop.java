package snake;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SnakeLoop implements Runnable {

    private Snake snake;
    private boolean running = false;
    private long pauseSpeed;
    private SnakePanel snakePanel;
    private int modo;

    public SnakeLoop(Snake snake, long pauseSpeed, SnakePanel snakePanel, int modo) {
        this.snake = snake;
        this.pauseSpeed = pauseSpeed;
        this.snakePanel = snakePanel;
        this.modo = modo;
    }

    /**
     * Permite cambiar el tiempo de pausa que se utiliza en el bucle
     *
     * @param pauseSpeed
     */
    public void setPauseSpeed() {
        this.pauseSpeed = pauseSpeed-50;
    }

    /**
     * Ejecuta el método run como un hilo de ejecución paralelo
     */
    public void start() {
        running = true;
        //Crear un nuevo hilo de ejecución para esta clase
        Thread thread = new Thread(this);
        //Llamada automática al método run
        thread.start();
    }

    /**
     * Permite finalizar la ejecución de este proceso
     */
    public void stop() {
        running = false;
    }

    /**
     * Este método es llamado de manera automática por el método start
     */
    @Override
    public void run() {
        while (running) {
            //Mover la serpiente
            switch (snake.checkMover()) {
                case 1:
                    snake.mover();
                    break;
                case 2:
                    stop();
                    JOptionPane.showMessageDialog(snakePanel,
                            "Reinicie para empezar de nuevo",
                            "Ha chocado",
                            JOptionPane.WARNING_MESSAGE);
                    break;
                case 3:
                    if (modo==0) {
                        setPauseSpeed();
                    }
                    snake.mover();
                    snake.generarFruta();
                    break;
                default:
                    throw new AssertionError();
            }
            //Pintar el juego
            snakePanel.repaint();
            //Pausar el juego durante el tiempo establecido
            try {
                Thread.sleep(pauseSpeed);
            } catch (InterruptedException ex) {
                Logger.getLogger(SnakeLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
