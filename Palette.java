package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Palette implements ChangeListener {
    Main main;
    JFrame paletteWindow;
    JPanel palettePanel, colorPanel;
    JColorChooser colorChooser;
    JButton button1;
    JButton button2;
    Color newColor;

    public Palette(Main main) {
        this.main = main;
    }

    public void createPalette() {
        paletteWindow = new JFrame("Palette");
        paletteWindow.setSize(700, 600);
        paletteWindow.getContentPane().setBackground(Color.black);
        paletteWindow.setLayout(null);

        palettePanel = new JPanel();
        palettePanel.setBounds(40, 50, 600, 350);
        palettePanel.setBackground(Color.black);
        paletteWindow.add(palettePanel);

        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);
        colorChooser.setPreviewPanel(new JPanel()); //to remove preview panel
        colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[4]); //to remove panes
        colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[3]);
        colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[2]);
        colorChooser.removeChooserPanel(colorChooser.getChooserPanels()[1]);
        palettePanel.add(colorChooser);

        colorPanel = new JPanel();
        colorPanel.setBounds(250, 400, 200, 50);
        colorPanel.setBackground(Color.white);
        paletteWindow.add(colorPanel);

        button1 = new JButton("Apply on background"); //to change background color
        button1.setBounds(180,500,170,40);
        paletteWindow.add(button1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                main.textArea.setBackground(newColor);
            }
        });

        button2 = new JButton("Apply on foreground"); //to change foreground color
        button2.setBounds(370,500,170,40);
        paletteWindow.add(button2);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                main.textArea.setForeground(newColor);
            }
        });

        paletteWindow.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        newColor = colorChooser.getColor();
        colorPanel.setBackground(newColor);
    }
}
