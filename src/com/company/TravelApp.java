package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;

public class TravelApp extends JFrame {
    private JPanel[] panels;
    private JLabel label;
    private String[] places = {" ", "Джидда", "Абха", "", "Дахране"};
    public TravelApp() throws HeadlessException {
        super("Travel");
        setLayout(new BorderLayout());
        panels = new JPanel[5];
        for (int i = 0; i < 5; i++){
            panels[i] = new JPanel();
            label = new JLabel(places[i], SwingConstants.CENTER);
            panels[i].add(label);
            if (i == 2) {
                setMouseL(i, " " + places[i]);
            } else{
                setMouseL(i, " в " + places[i]);
            }
        }
        add(panels[0], BorderLayout.CENTER);
        add(panels[1], BorderLayout.WEST);
        add(panels[2], BorderLayout.SOUTH);
        add(panels[3], BorderLayout.NORTH);
        add(panels[4], BorderLayout.EAST);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setMouseL(int i, String text){
        panels[i].addMouseListener(new MouseL() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!visited){
                    visited = true;
                    JOptionPane.showMessageDialog(null, "Добро пожаловать" + text);
                }
            }
        });
    }
}
