package com.main.layout.game.G1;

import javax.swing.JFrame;

public class FrameGameMain extends JFrame {

    public FrameGameMain() {
        PanelGameMain panelgame = new PanelGameMain();
        setTitle("SNAKE");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panelgame);
    }

}