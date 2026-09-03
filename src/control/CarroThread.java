package control;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CarroThread extends JLabel implements Runnable {
    private Thread carroThread = null;
    private int posX;
    private int posY;
    private final ImageIcon imagem;
    private static int pos = 0;
    private final String nome;

    // CONSTRUTOR DEFAULT
    public CarroThread() {
        this.imagem = null;
        this.nome = "";
    }

    // CONSTRUTOR SOBRECARREGADO
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

    public void iniciar() {
        if (carroThread == null || !carroThread.isAlive()) {
            carroThread = new Thread(this, nome);
            carroThread.start();
        }
    }

    // M�TODO RUN() DA INTERFACE RUNNABLE
    @Override
    public void run() {
        while (carroThread != null && carroThread == Thread.currentThread()) {
            posX += new Random().nextInt(3) * 10 + 5;
            this.setLocation(posX, posY);
            this.repaint();

            if (posX >= 950) {
                pos++;
                JOptionPane.showMessageDialog(null, pos + "º Lugar: " + nome);
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