package com.company;

import java.awt.*;

public class FunctionStyle {
    Main main;
    Font ariel, calibri, timesNewRoman, comicSansMS;
    String typeface;
    int size, font;

    public FunctionStyle(Main main){
        this.main = main;
    }

    public void wordWrapFunction(){

        if(!main.wordWrap){
            main.wordWrap = true;
            main.textArea.setLineWrap(true);
            main.textArea.setWrapStyleWord(true);
            main.wrapS.setText("World Wrap : ON");
        }else if(main.wordWrap){
            main.wordWrap = false;
            main.textArea.setLineWrap(false);
            main.textArea.setWrapStyleWord(false);
            main.wrapS.setText("World Wrap : OFF");
        }
    }
    public void fontSizeFunction(int size){

        this.size = size;
        ariel = new Font("Ariel",Font.PLAIN,this.size);
        calibri = new Font("Calibri",Font.PLAIN,this.size);
        timesNewRoman = new Font("Times New Roman",Font.PLAIN,this.size);
        comicSansMS = new Font("Comic Sans MS",Font.PLAIN,this.size);
        typefaceFunction(typeface);
    }

    public void typefaceFunction(String typeface) {
        this.typeface = typeface;
        switch (this.typeface) {
            case "ariel":
                main.textArea.setFont(ariel);
                break;
            case "cbr":
                main.textArea.setFont(calibri);
                break;
            case "tnr":
                main.textArea.setFont(timesNewRoman);
                break;
            case "csms":
                main.textArea.setFont(comicSansMS);
                break;
        }
    }
        public void fontFunction(int font){
            this.font = font;
            main.textArea.setFont(new Font(typeface,this.font,size));
        }

    public void colorFunction(String color){

        switch (color){
            case "purple":
                main.window.getContentPane().setBackground(new Color(133, 28, 189)); //I create a new color
                main.textArea.setBackground(new Color(133, 28, 189));
                main.textArea.setForeground(new Color(226,180,253));
                break;
            case "white":
                main.window.getContentPane().setBackground(Color.WHITE);
                main.textArea.setBackground(Color.WHITE);
                main.textArea.setForeground(Color.BLACK);
                break;
            case "black":
                main.window.getContentPane().setBackground(Color.BLACK);
                main.textArea.setBackground(Color.BLACK);
                main.textArea.setForeground(Color.WHITE);
                break;
        }

    }

}
