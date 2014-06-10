package snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Snake {

    private char[][] tablero;
    private int tamFila;
    private int tamCol;
    private ArrayList<Point> listaPosSnake;
    private byte sentidoMov;
    private Random random = new Random();
    private int modo;

    public static final char VACIO = '.';
    public static final char CABEZA = '@';
    public static final char CUERPO = '=';
    public static final char MURO = '#';
    public static final char FRUTA = '$';

    private final int MARGEN = 2 + 1;
    //El tamaño inicial del cuerpo no puede ser mayor que el margen
    private final int TAM_INI_CUERPO = 2;

    public static final byte DERECHA = 0;
    public static final byte IZQUIERDA = 1;
    public static final byte ARRIBA = 2;
    public static final byte ABAJO = 3;

    /*
     Información contenida en el tablero:
     '.': Vacío
     '@': Cabeza
     '=': Cuerpo
     '#': Muro
     '$': Fruta
     */
    public Snake(int tamFila, int tamCol, int modo) {
        this.tamFila = tamFila;
        this.tamCol = tamCol;
        this.modo = modo;
        listaPosSnake = new ArrayList();
        sentidoMov = DERECHA;
        tablero = new char[tamFila][tamCol];
        //Inicializamos el tablero con todo vacío
        for (int f = 0; f < tamFila; f++) {
            for (int c = 0; c < tamCol; c++) {
                tablero[f][c] = VACIO;
            }
        }
        for (int c = 0; c < tamFila; c++) {
            tablero[0][c] = MURO;
        }
        for (int c = 0; c < tamFila; c++) {
            tablero[tamFila - 1][c] = MURO;
        }
        for (int c = 0; c < tamFila; c++) {
            tablero[c][0] = MURO;
        }
        for (int c = 0; c < tamFila; c++) {
            tablero[c][tamCol - 1] = MURO;
        }

        //Colocar la cabeza en posición aleatoria
        int cabezaFila = random.nextInt(tamFila - 2 * MARGEN) + MARGEN;
        int cabezaCol = random.nextInt(tamCol - 2 * MARGEN) + MARGEN;
        tablero[cabezaFila][cabezaCol] = CABEZA;
        //Guardar la cabeza en la lista de posiciones
        listaPosSnake.add(new Point(cabezaCol, cabezaFila));
        //Colocar el cuerpo
        for (int i = 1; i <= TAM_INI_CUERPO; i++) {
            tablero[cabezaFila][cabezaCol - i] = CUERPO;
            listaPosSnake.add(new Point(cabezaCol - i, cabezaFila));
        }
        //Colocar fruta
        generarFruta();
    }

    public char[][] getTablero() {
        return tablero;
    }

    public int getTamFila() {
        return tamFila;
    }

    public int getTamCol() {
        return tamCol;
    }

    public void setSentidoMov(byte sentidoMov) {
        this.sentidoMov = sentidoMov;
    }

    public byte getSentidoMov() {
        return sentidoMov;
    }

    public void generarFruta() {
        int fila;
        int col;
        do {
            fila = random.nextInt(tamFila - 2) + 1;
            col = random.nextInt(tamCol - 2) + 1;
        } while (tablero[fila][col] != VACIO);
        tablero[fila][col] = FRUTA;
    }

    @Override
    public String toString() {
        String retorno = "";
        for (int f = 0; f < tamFila; f++) {
            for (int c = 0; c < tamCol; c++) {
                retorno += tablero[f][c];
            }
            retorno += '\n';
        }
        return retorno;
    }

    public int checkMover() {
        Point antiguaCabeza = listaPosSnake.get(0);
        Point nuevaCabeza = null;
        switch (sentidoMov) {
            case DERECHA:
                nuevaCabeza = new Point(antiguaCabeza.x + 1, antiguaCabeza.y);
                break;
            case IZQUIERDA:
                nuevaCabeza = new Point(antiguaCabeza.x - 1, antiguaCabeza.y);
                break;
            case ARRIBA:
                nuevaCabeza = new Point(antiguaCabeza.x, antiguaCabeza.y - 1);
                break;
            case ABAJO:
                nuevaCabeza = new Point(antiguaCabeza.x, antiguaCabeza.y + 1);
                break;
        }
        switch (tablero[nuevaCabeza.y][nuevaCabeza.x]) {
            case VACIO:
                return 1;
            case MURO:
                return 2;
            case FRUTA:
                return 3;
            default:
                return 2;
        }
    }

    public void mover() {
        //Guardar posición actual de la cabeza
        Point antiguaCabeza = listaPosSnake.get(0);
        Point nuevaCabeza = null;

        //Borrar la cola antigua
        if (!(checkMover() == 3 && modo == 1)) {
            Point antiguaCola = listaPosSnake.get(listaPosSnake.size() - 1);
            tablero[antiguaCola.y][antiguaCola.x] = VACIO;
            listaPosSnake.remove(listaPosSnake.size() - 1);
        }
        //Mover el punto de la cabeza
        tablero[antiguaCabeza.y][antiguaCabeza.x] = CUERPO;
        switch (sentidoMov) {
            case DERECHA:
                nuevaCabeza = new Point(antiguaCabeza.x + 1, antiguaCabeza.y);
                break;
            case IZQUIERDA:
                nuevaCabeza = new Point(antiguaCabeza.x - 1, antiguaCabeza.y);
                break;
            case ARRIBA:
                nuevaCabeza = new Point(antiguaCabeza.x, antiguaCabeza.y - 1);
                break;
            case ABAJO:
                nuevaCabeza = new Point(antiguaCabeza.x, antiguaCabeza.y + 1);
                break;
        }
        tablero[nuevaCabeza.y][nuevaCabeza.x] = CABEZA;
        listaPosSnake.add(0, nuevaCabeza);

    }

}
