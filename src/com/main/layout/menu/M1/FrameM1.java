package com.main.layout.menu.M1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.main.layout.game.G1.FrameGameMain;

public class FrameM1 extends JFrame {
    public FrameM1() throws FontFormatException, IOException {
        PanelM1 panel = new PanelM1();
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel);
        File uriMainFont = new File("src\\com\\main\\media\\main_font.ttf");
        Font Mainfont = Font.createFont(Font.TRUETYPE_FONT, uriMainFont).deriveFont(34f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Mainfont);
        JButton iniciar = new JButton("Start");
        iniciar.setBounds(180, 500, 140, 40);
        iniciar.setForeground(Color.white);
        iniciar.setOpaque(true);
        iniciar.setFont(Mainfont);
        iniciar.setContentAreaFilled(false);
        iniciar.setBorderPainted(false);
        iniciar.setBorder(null);
        iniciar.setFocusable(false);
        panel.add(iniciar);
        // CAMBIAR DE JFRAME AL DEL JUEGO
        iniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FrameGameMain frame = new FrameGameMain();
                frame.setVisible(true);
            }

        });
    }
}
