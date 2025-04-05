package com.main.layout.menu.M1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.main.classes.Particle;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

public class PanelM1 extends JPanel {

    public int maxParticles = 180;
    List<Particle> ParticleList = new ArrayList<Particle>();

    public PanelM1() throws FontFormatException, IOException {
        setLayout(null);
        File uriMainFont = new File("src\\com\\main\\media\\main_font.ttf");
        Font Mainfont = Font.createFont(Font.TRUETYPE_FONT, uriMainFont).deriveFont(34f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Mainfont);
        JLabel TitleGame = new JLabel("Snake");
        TitleGame.setBounds(200, 10, 140, 39);
        TitleGame.setForeground(Color.WHITE);
        TitleGame.setFont(Mainfont);
        add(TitleGame);
        setBackground(Color.BLACK);
        // Inicializar la lista de particulas
        for (int i = 0; i < maxParticles; i++) {
            Particle p = new Particle();
            ParticleList.add(p);
        }
        new Thread(() -> {
            while (true) {
                for (Particle particle : ParticleList) {
                    particle.update();
                }
                try {
                    Thread.sleep(8);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        int i = 0;
        for (Particle particle : ParticleList) {
            i++;
            if (i % 2 == 0) {
                particle.render(g);
            }
            particle.render1(g);
        }
    }

}