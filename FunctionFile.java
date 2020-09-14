package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FunctionFile {
    Main main;
    String fileName;
    String fileDirectory;
    JPanel panel;
    JLabel label;
    int response;

    public FunctionFile(Main main) {
        this.main = main;
    }

    public void newFunction() {
        messagePanel();
        if(response == 0){ //Yes
            saveFunction();
        }else if(response == 1) { //No
            main.textArea.setText("");
            main.window.setTitle("New File");
            fileName = null;
            fileDirectory = null;
        }
        panel.setVisible(true);
    }

    public void saveFunction() {
        if (fileName == null) {
            saveAsFunction();
        } else {
            try {
                FileWriter fw = new FileWriter(fileDirectory + fileName,false);
                fw.write(main.textArea.getText());
                main.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                System.out.println("File is not saved.");
            }
        }

    }

    public void saveAsFunction() {
        FileDialog fileDialog = new FileDialog(main.window, "Save File", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            fileDirectory = fileDialog.getDirectory();
            main.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileDirectory + fileName);
            fw.write(main.textArea.getText());
            fw.close();

        } catch (Exception e) {
            System.out.println("File is not saved.");
        }

    }

    public void openFunction() {
        FileDialog fileDialog = new FileDialog(main.window, "Open File", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            fileDirectory = fileDialog.getDirectory();
            main.window.setTitle(fileName);
        }
        try {
            FileReader fr = new FileReader(fileDirectory + fileName, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);
            main.textArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                main.textArea.append(line + "\n");
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File is not opened.");
        }
    }

    public void exitFunction() {
        messagePanel();
        if (response == 0) { //Yes
            saveFunction();
        } else if (response == 1) { //No
            System.exit(0);
        }
        panel.setVisible(true);
    }

    public void helpFunction() {
       JDialog help = new JDialog();
       JOptionPane.showMessageDialog(help, "Created by Ece IŞIK");

    }

    public void messagePanel() { //Sending a message which clarifies if user wants a file to be saved
        panel = new JPanel();
        panel.setSize(250, 100);
        panel.setLayout(null);

        label = new JLabel("Would you like to save that file before closing?");
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(40, 80, 280, 20);
        panel.add(label);

        UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
        response = JOptionPane.showConfirmDialog(null, panel, "Notepad",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }
}

