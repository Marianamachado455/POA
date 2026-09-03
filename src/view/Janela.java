package view;

import control.CarroThread;
import java.awt.Color;
import java.awt.Font;
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
    private ImageIcon imgCarro1;
    private ImageIcon imgCarro2;
    private ImageIcon imgCarro3;
    private Font fontePixel;
    private JLabel titulo;
    private JPanel pista;

    // Referência estática para permitir reabilitar o botão a partir da Thread
    public static JButton btnCorridaEstatico;

    public Janela() {
        super();
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        
        this.setTitle("Corrida de Threads");

        // Carregamento da Fonte Pixel
        try {
            File fontFile = new File("./src/fontes/PressStart2P-Regular.ttf");
            fontePixel = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontePixel);
        } catch (Exception e) {
            fontePixel = new Font("Monospaced", Font.BOLD, 12);
        }

        // Instância e redimensionamento das imagens dos caramujos
        imgCarro1 = redimensionarImagem("D:/Programacao/Faculdade/Poa/Projetos/pjrCorrida/src/imagens/lesma_amarela.png", 128, 55);
        imgCarro2 = redimensionarImagem("D:/Programacao/Faculdade/Poa/Projetos/pjrCorrida/src/imagens/lesma_vermelha.png", 128, 55);
        imgCarro3 = redimensionarImagem("D:/Programacao/Faculdade/Poa/Projetos/pjrCorrida/src/imagens/lesma_azul.png", 128, 55);
        
        // Configuração dos Botões
        this.btnCorrida = new JButton("Começar Corrida");
        this.btnCancel = new JButton("Parar Corrida");
        btnCorridaEstatico = this.btnCorrida; // Vincula à variável estática

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

        // Título da janela
        this.titulo = new JLabel("Corrida DE Caramujo");
        this.titulo.setBounds(360, 20, 700, 50);
        this.titulo.setForeground(Color.WHITE);
        this.titulo.setFont(fontePixel.deriveFont(Font.BOLD, 26f));

        // Painel da Pista 
        this.pista = new JPanel();
        this.pista.setLayout(null);
        this.pista.setBounds(100, 90, 1080, 360); 
        this.pista.setBackground(Color.BLACK);
        this.pista.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        // Desenha as raias iniciais
        criarLinhaRaia(115); 
        criarLinhaRaia(235);

        // Adiciona os componentes na janela principal
        this.add(this.btnCorrida);
        this.add(this.btnCancel);
        this.add(this.titulo);
        this.add(this.pista);

        // Listeners de Ação
        this.btnCorrida.addActionListener(this);
        this.btnCancel.addActionListener(this);

        this.setVisible(true);
    }

    // Método estático para reabilitar/desabilitar o botão de corrida sem conflitos de escopo
    public static void habilitarBotaoCorrida(boolean status) {
        if (btnCorridaEstatico != null) {
            btnCorridaEstatico.setEnabled(status);
        }
    }

    // Método auxiliar para redimensionar imagens
    private ImageIcon redimensionarImagem(String caminho, int largura, int altura) {
        ImageIcon imgOriginal = new ImageIcon(caminho);
        Image imgEscalada = imgOriginal.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    // Método para instanciar e posicionar o Caramujo na pista
    public JLabel JLabelCarros(String nome, ImageIcon img, int posX, int posY) {
        CarroThread carro = new CarroThread(nome, img, posX, posY);
        carro.setBounds(posX, posY, 128, 55);
        carro.setVisible(true);
        this.pista.add(carro, 0); // Adiciona na camada frontal
        carro.iniciar();
        return carro;
    }

    // Método auxiliar para desenhar as divisórias das raias
    private void criarLinhaRaia(int posY) {
        JPanel linha = new JPanel();
        linha.setBounds(10, posY, 1060, 2); 
        linha.setBackground(Color.GRAY);    
        this.pista.add(linha);
    }

    // Efeito de Hover estilo Undertale (Coração + Texto Amarelo)
    private void aplicarEfeitoUndertale(JButton btn, String textoOriginal) {
        String nomeFonte = fontePixel.getFamily();
        String htmlNormal = "<html><body style='font-family: \"" + nomeFonte + "\", monospaced; font-size: 10px; color: white;'>" 
                        + textoOriginal + "</body></html>";
        String htmlHover = "<html><body style='font-family: \"" + nomeFonte + "\", monospaced; font-size: 10px;'>" 
                        + "<font color='red'>♥</font> <font color='yellow'>" + textoOriginal + "</font></body></html>";

        btn.setText(htmlNormal);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setText(htmlHover);
                }
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
            // Trava o botão para impedir cliques simultâneos
            Janela.habilitarBotaoCorrida(false);

            // Reseta posições e interrompe corridas passadas
            CarroThread.pararCorridaAnterior();
            CarroThread.resetarPosicao();

            // Limpa a pista para não sobrepor sprites antigas
            this.pista.removeAll();
            criarLinhaRaia(115); 
            criarLinhaRaia(235);

            // Instancia novos caramujos e inicia a corrida
            JLabelCarros("Caramujo Amarelo", imgCarro1, 10, 30);
            JLabelCarros("Caramujo Vermelho", imgCarro2, 10, 140);
            JLabelCarros("Caramujo Azul", imgCarro3, 10, 250);
            
            this.pista.revalidate();
            this.pista.repaint();
        }
        
        if (dispara.getSource() == this.btnCancel) {
            CarroThread.pararCorridaAnterior();
            System.exit(0);
        }
    }
}