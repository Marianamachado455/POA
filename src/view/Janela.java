package view;

import control.CarroThread;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblAlma;
    private ImageIcon imgCarro1;
    private ImageIcon imgCarro2;
    private ImageIcon imgCarro3;
    private Font fontePixel;
    private JPanel jPanelIntegrantes;
    // private JLabel lblIntegrantes;
    private JLabel titulo;
    private JPanel pista;

    public Janela() {
        super();
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        
        this.setTitle("Corrida de Threads");

        // Fonte Pixel
        try {
            File fontFile = new File("./src/fontes/PressStart2P-Regular.ttf");
            fontePixel = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontePixel);
        } catch (Exception e) {
            fontePixel = new Font("Monospaced", Font.BOLD, 12);
        }

        // Instância das Imagens + Redimensionamento dos Caramujos (128x55)
        imgCarro1 = redimensionarImagem("D:/Programacao/Faculdade/Poa/Projetos/pjrCorrida/src/imagens/lesma_amarela.png", 128, 55);
        imgCarro2 = redimensionarImagem("D:/Programacao/Faculdade/Poa/Projetos/pjrCorrida/src/imagens/lesma_vermelha.png", 128, 55);
        imgCarro3 = redimensionarImagem("D:/Programacao/Faculdade/Poa/Projetos/pjrCorrida/src/imagens/lesma_azul.png", 128, 55);
        
        // Botões customizados
        this.btnCorrida = new JButton("Começar Corrida");
        this.btnCancel = new JButton("Parar Corrida");
        this.btnCorrida.setFont(fontePixel.deriveFont(Font.PLAIN, 12f));
        this.btnCancel.setFont(fontePixel.deriveFont(Font.PLAIN, 12f));
        JButton[] botoes = {this.btnCorrida, this.btnCancel};
        for (JButton btn : botoes) {
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);            
            btn.setContentAreaFilled(false);        
            btn.setOpaque(true);                  
            btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); 
        }
        this.btnCorrida.setBounds(380, 500, 260, 60);
        this.btnCancel.setBounds(670, 500, 260, 60);
        aplicarEfeitoUndertale(this.btnCorrida, "Começar Corrida");
        aplicarEfeitoUndertale(this.btnCancel, "Parar Corrida");

        // Título
        this.titulo = new JLabel("Corrida DE Caramujo");
        this.titulo.setBounds(360, 20, 700, 50);
        this.titulo.setForeground(Color.WHITE);
        this.titulo.setFont(fontePixel.deriveFont(Font.BOLD, 26f));

        // Pista 
        this.pista = new JPanel();
        this.pista.setLayout(null);
        this.pista.setBounds(100, 90, 1080, 360); 
        this.pista.setBackground(Color.BLACK);
        this.pista.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        // Adicionando as linhas divisórias
        criarLinhaRaia(115); 
        criarLinhaRaia(235);

        // Adicionando tudo à Janela
        this.add(this.btnCorrida);
        this.add(this.btnCancel);
        // this.add(this.jPanelIntegrantes);
        this.add(this.titulo);
        this.add(this.pista);

        //Listeners
        this.btnCorrida.addActionListener(this);
        this.btnCancel.addActionListener(this);


        this.setVisible(true);
    }

    // Auxiliar para redimensionar as imagens dos carros
    private ImageIcon redimensionarImagem(String caminho, int largura, int altura) {
        ImageIcon imgOriginal = new ImageIcon(caminho);
        Image imgEscalada = imgOriginal.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    // Auxiliar para os Caramujos
    public JLabel JLabelCarros(String nome, ImageIcon img, int posX, int posY) {
        CarroThread carro = new CarroThread(nome, img, posX, posY);
        carro.setBounds(posX, posY, 128, 55);
        carro.setVisible(true);
        this.pista.add(carro);
        this.pista.revalidate();
        this.pista.repaint();
        carro.iniciar();
        return carro;
    }
    // Auxiliar para as linhas da pista
    private void criarLinhaRaia(int posY) {
        JPanel linha = new JPanel();
        linha.setBounds(10, posY, 1060, 2); 
        linha.setBackground(Color.GRAY);    
        this.pista.add(linha);
    }

    // Função auxiliar para aplicar o efeito Undertale nos botões
    private void aplicarEfeitoUndertale(JButton btn, String textoOriginal) {
        String nomeFonte = fontePixel.getFamily(); // Pega o nome correto registrado no sistema
        String htmlNormal = "<html><body style='font-family: \"" + nomeFonte + "\", monospaced; font-size: 10px; color: white;'>" 
                        + textoOriginal + "</body></html>";
        String htmlHover = "<html><body style='font-family: \"" + nomeFonte + "\", monospaced; font-size: 10px;'>" 
                        + "<font color='red'>♥</font> <font color='yellow'>" + textoOriginal + "</font></body></html>";

        btn.setText(htmlNormal);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setText(htmlHover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setText(htmlNormal);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            System.out.println("Carro 1 nulo? " + (imgCarro1 == null || imgCarro1.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE));
            this.pista.removeAll();
            criarLinhaRaia(115); 
            criarLinhaRaia(235);
            JLabelCarros("Caramujo1", imgCarro1, 10, 30);
            JLabelCarros("Caramujo2", imgCarro2, 10, 140);
            JLabelCarros("Caramujo3", imgCarro3, 10, 250);
            
            this.pista.revalidate();
            this.pista.repaint();
        }
        
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}