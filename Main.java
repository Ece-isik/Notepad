package com.company;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class Main implements ActionListener {
     FunctionFile functionFile = new FunctionFile(this);
     FunctionStyle functionStyle = new FunctionStyle(this);
     FunctionEdit functionEdit = new FunctionEdit(this);
     Shortcut shortcut = new Shortcut(this);
     Palette palette = new Palette(this);
     UndoManager undoManager = new UndoManager();
     JFrame window;
     JTextArea textArea;
     JScrollPane scrollPane;
     JMenuBar menuBar;
     JMenu menuFile, menuStyle, menuEdit, menuHelp, colourS, typefaceS, fontS, fontSizeS;
     JMenuItem newF, saveF, saveAsF, openF, exitF, wrapS, aboutNotepadH;
     JMenuItem fontAriel, fontCbr, fontTNR, bold, italic, plain, fontCSMS, fontSize8, fontSize12, fontSize16, fontSize20, fontSize24;
     JMenuItem colorP, colorW, colorB, paletteS;
     JMenuItem undoE, redoE;
     boolean wordWrap = false;

    public static void main(String[] args) {
     new Main();
    }

    public Main(){
        createWindow();
        createTextArea();
        createMenuBar();
        functionStyle.typefaceFunction("ariel");
        functionStyle.fontFunction(Font.PLAIN);
        functionStyle.fontSizeFunction(12);
        functionStyle.colorFunction("white");
        window.setVisible(true);
    }


    public void createMenuBar(){
        menuBar = new JMenuBar(); //Menu bar
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File"); //File menu
        menuBar.add(menuFile);

        newF = new JMenuItem("New"); //New item in File menu
        menuFile.add(newF);
        newF.addActionListener(this);
        newF.setActionCommand("new");

        saveF = new JMenuItem("Save"); //Save item in File menu
        menuFile.add(saveF);
        saveF.addActionListener(this);
        saveF.setActionCommand("save");

        saveAsF = new JMenuItem("Save As"); //Save as item in File menu
        menuFile.add(saveAsF);
        saveAsF.addActionListener(this);
        saveAsF.setActionCommand("saveAs");

        openF = new JMenuItem("Open"); //Open item in File menu
        menuFile.add(openF);
        openF.addActionListener(this);
        openF.setActionCommand("open");

        exitF = new JMenuItem("Exit"); //Exit item in File menu
        menuFile.add(exitF);
        exitF.addActionListener(this);
        exitF.setActionCommand("exit");
        //File Menu was created

        menuStyle = new JMenu("Style"); //Style menu
        menuBar.add(menuStyle);

        wrapS = new JMenuItem("Word Wrap : OFF"); // Word Wrap
        wrapS.addActionListener(this);
        wrapS.setActionCommand("wrap");
        menuStyle.add(wrapS);

        typefaceS = new JMenu("Typeface"); //Typeface menu
        menuStyle.add(typefaceS);

        fontAriel = new JMenuItem("Ariel"); //Ariel
        fontAriel.addActionListener(this);
        fontAriel.setActionCommand("ariel");
        typefaceS.add(fontAriel);

        fontCbr = new JMenuItem("Calibri"); //Calibri
        fontCbr.addActionListener(this);
        fontCbr.setActionCommand("cbr");
        typefaceS.add(fontCbr);

        fontTNR = new JMenuItem("Times New Roman"); //Times New Roman
        fontTNR.addActionListener(this);
        fontTNR.setActionCommand("tnr");
        typefaceS.add(fontTNR);

        fontCSMS = new JMenuItem("Comic Sans MS"); //Comic Sans MS
        fontCSMS.addActionListener(this);
        fontCSMS.setActionCommand("csms");
        typefaceS.add(fontCSMS);
        //Typefaces were created

        fontS = new JMenu("Font"); //Font menu
        menuStyle.add(fontS);

        bold = new JMenuItem("Bold"); //Bold
        bold.addActionListener(this);
        bold.setActionCommand("bold");
        fontS.add(bold);

        italic = new JMenuItem("Italic"); //Italic
        italic.addActionListener(this);
        italic.setActionCommand("italic");
        fontS.add(italic);

        plain = new JMenuItem("Plain"); //Plain
        plain.addActionListener(this);
        plain.setActionCommand("plain");
        fontS.add(plain);
        //Fonts were created

        fontSizeS = new JMenu("Font Size"); //Font size menu
        menuStyle.add(fontSizeS);

        fontSize8 = new JMenuItem("8"); //Size 8
        fontSize8.addActionListener(this);
        fontSize8.setActionCommand("size8");
        fontSizeS.add(fontSize8);

        fontSize12 = new JMenuItem("12"); //Size 12
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("size12");
        fontSizeS.add(fontSize12);

        fontSize16 = new JMenuItem("16"); //Size 16
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("size16");
        fontSizeS.add(fontSize16);

        fontSize20 = new JMenuItem("20"); //Size 20
        fontSize20.addActionListener(this);
        fontSize20.setActionCommand("size20");
        fontSizeS.add(fontSize20);

        fontSize24 = new JMenuItem("24"); //Size 24
        fontSize24.addActionListener(this);
        fontSize24.setActionCommand("size24");
        fontSizeS.add(fontSize24);
        //Font sizes were created

        colourS = new JMenu("Color"); //Color menu
        menuStyle.add(colourS);

        colorP = new JMenuItem("Purple"); //Purple
        colorP.addActionListener(this);
        colorP.setActionCommand("purple");
        colourS.add(colorP);

        colorW = new JMenuItem("White"); //White
        colorW.addActionListener(this);
        colorW.setActionCommand("white");
        colourS.add(colorW);

        colorB = new JMenuItem("Black"); //Black
        colorB.addActionListener(this);
        colorB.setActionCommand("black");
        colourS.add(colorB);

        paletteS = new JMenuItem("See palette...");
        paletteS.addActionListener(this);
        paletteS.setActionCommand("palette");
        colourS.add(paletteS);

        //Color Menu was created
        //Style Menu was created

        menuEdit = new JMenu("Edit"); //Edit menu
        menuBar.add(menuEdit);

        undoE = new JMenuItem("Undo"); //Undo
        undoE.addActionListener(this);
        undoE.setActionCommand("undo");
        menuEdit.add(undoE);

        redoE = new JMenuItem("Redo"); //Redo
        redoE.addActionListener(this);
        redoE.setActionCommand("redo");
        menuEdit.add(redoE);
        //Edit Menu was created

        menuHelp = new JMenu("Help"); //Help menu
        menuBar.add(menuHelp);

        aboutNotepadH = new JMenuItem("About Notepad");
        menuHelp.add(aboutNotepadH);
        aboutNotepadH.addActionListener(this);
        aboutNotepadH.setActionCommand("help");
        //Help Menu was created

    } //Menu Bar was created

    public void createTextArea() {
        textArea = new JTextArea();

        textArea.addKeyListener(shortcut); //For shortcuts

        textArea.getDocument().addUndoableEditListener( //For undo & redo functions
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        undoManager.addEdit(e.getEdit());
                    }
                }
        );
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); //The borders of the window are cancelled
        window.add(scrollPane);
    } //Text Area was created

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setVisible(true);
    } //Window was created

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch(command) { //Commands & Functions
            case "new":
                functionFile.newFunction();
                break;
            case "save":
                functionFile.saveFunction();
                break;
            case "saveAs":
                functionFile.saveAsFunction();
                break;
            case "open":
                functionFile.openFunction();
                break;
            case "exit":
                functionFile.exitFunction();
                break;
            case "help":
                functionFile.helpFunction();
                break;
            case "wrap":
                functionStyle.wordWrapFunction();
                break;
            case "ariel":
                functionStyle.typefaceFunction("ariel");
                break;
            case "cbr":
                functionStyle.typefaceFunction("cbr");
                break;
            case "tnr":
                functionStyle.typefaceFunction("tnr");
                break;
            case "csms":
                functionStyle.typefaceFunction("csms");
                break;
            case "bold":
                functionStyle.fontFunction(Font.BOLD);
                break;
            case "italic":
                functionStyle.fontFunction(Font.ITALIC);
                break;
            case "plain":
                functionStyle.fontFunction(Font.PLAIN);
                break;
            case "size8":
                functionStyle.fontSizeFunction(8);
                break;
            case "size12":
                functionStyle.fontSizeFunction(12);
                break;
            case "size16":
                functionStyle.fontSizeFunction(16);
                break;
            case "size20":
                functionStyle.fontSizeFunction(20);
                break;
            case "size24":
                functionStyle.fontSizeFunction(24);
                break;
            case "purple":
                functionStyle.colorFunction("purple");
                break;
            case "white":
                functionStyle.colorFunction("white");
                break;
            case "black":
                functionStyle.colorFunction("black");
                break;
            case "palette":
                palette.createPalette();
                break;
            case "undo":
                functionEdit.undoFunction();
                break;
            case "redo":
                functionEdit.redoFunction();
                break;
        }
    }
}
