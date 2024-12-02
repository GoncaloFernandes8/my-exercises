package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JogoDoAmor {
    public static void main(String[] args) {
        // Criar o menu inicial
        JFrame menuFrame = new JFrame("Menu - Jogo do Amor");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(800, 600);
        menuFrame.setLayout(new BorderLayout());

        // Painel de fundo do menu
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(new Color(255, 182, 193)); // Rosa claro
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 200));

        // Título do menu
        JLabel titulo = new JLabel("<html>Bem-vinda ao Jogo do Amor!<br>Só paro de te amar quando clicares no botão! ❤</html>");
        titulo.setFont(new Font("Serif", Font.BOLD, 36));
        titulo.setForeground(new Color(255, 20, 147)); // Rosa forte
        menuPanel.add(titulo);

        // Botão para começar o jogo
        JButton comecarBtn = new JButton("Começar");
        comecarBtn.setFont(new Font("Arial", Font.BOLD, 24));
        comecarBtn.setBackground(new Color(255, 105, 180)); // Rosa
        comecarBtn.setForeground(Color.WHITE);
        comecarBtn.setFocusPainted(false);
        comecarBtn.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 3)); // Vermelho bordô
        menuPanel.add(comecarBtn);

        // Adiciona o painel ao menu
        menuFrame.add(menuPanel);
        menuFrame.setVisible(true);

        // Ação do botão "Começar"
        comecarBtn.addActionListener(e -> {
            menuFrame.dispose(); // Fecha o menu
            iniciarJogo();      // Chama o jogo
        });
    }

    public static void iniciarJogo() {
        // Criar o JFrame do jogo
        JFrame jogoFrame = new JFrame("Jogo do Amor para a Leonor");
        jogoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jogoFrame.setSize(800, 600);
        jogoFrame.setLayout(null);

        // Configurar fundo do jogo
        jogoFrame.getContentPane().setBackground(new Color(255, 192, 203)); // Rosa claro

        // Criação do botão
        JButton botao = new JButton("Amor, clica em mim");
        botao.setBounds(300, 200, 200, 50); // Posição inicial do botão
        botao.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        botao.setBackground(new Color(255, 105, 180)); // Rosa
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);

        // Adicionar evento para mover o botão
        botao.addMouseListener(new MouseAdapter() {
            Random random = new Random();

            @Override
            public void mouseEntered(MouseEvent e) {
                // Gera novas coordenadas dentro dos limites da janela
                int novoX = random.nextInt(jogoFrame.getWidth() - botao.getWidth());
                int novoY = random.nextInt(jogoFrame.getHeight() - botao.getHeight());

                // Move o botão para as novas coordenadas
                botao.setLocation(novoX, novoY);
            }
        });

        // Adiciona o botão ao jogo
        jogoFrame.add(botao);

        // Adiciona um ícone romântico (ex: coração)
        JLabel coracao = new JLabel("❤");
        coracao.setFont(new Font("Serif", Font.PLAIN, 72));
        coracao.setForeground(new Color(255, 20, 147)); // Rosa forte
        coracao.setBounds(350, 50, 100, 100);
        jogoFrame.add(coracao);

        // Timer para exibir a mensagem após 8 segundos
        Timer timer = new Timer(8000, e -> {
            JOptionPane.showMessageDialog(jogoFrame, "Não vou parar, mas podes continuar  :)", "Dica", JOptionPane.INFORMATION_MESSAGE);
        });
        timer.setRepeats(false); // Garante que o timer é executado apenas uma vez
        timer.start();

        // Torna o jogo visível
        jogoFrame.setVisible(true);
    }
}
