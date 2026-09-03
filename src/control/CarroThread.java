package control;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CarroThread extends JLabel implements Runnable {
    private Thread carroThread = null;
    private int posX;
    private int posY;
    private final ImageIcon imagem;
    private static int pos = 0; 
    private static boolean corridaAtiva = true; 
    private final String nome;
    private static String[] p = new String[3];

    public CarroThread(String nome, ImageIcon img, int posX, int posY) {
        super(img);
        this.imagem = img;
        this.posX = posX;
        this.posY = posY;
        this.nome = nome;
        this.setSize(128, 55);
        this.setLocation(posX, posY);
        this.setVisible(true);
    }

    public static void resetarPosicao() {
        pos = 0;
        corridaAtiva = true;
        p = new String[3];
    }

    public static void pararCorridaAnterior() {
        corridaAtiva = false;
    }

    public void iniciar() {
        if (carroThread == null || !carroThread.isAlive()) {
            carroThread = new Thread(this, nome);
            carroThread.start();
        }
    }

    @Override
    public void run() {
        while (corridaAtiva && carroThread != null && carroThread == Thread.currentThread()) {
            posX += new Random().nextInt(3) * 10 + 5;
            this.setLocation(posX, posY);
            this.repaint();

            if (posX >= 950) {
                if (corridaAtiva) {
                    p[pos] = nome;
                    pos++; 
                    
                    if (pos == 3) {
                        view.Janela.mostrarPlacarNativo(p[0], p[1], p[2]);
                        view.Janela.habilitarBotaoCorrida(true);
                    }
                }
                return;
            }

            try {
                Thread.sleep(100 + new Random().nextInt(400));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}