package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shortcut implements KeyListener {

    Main main;

    public Shortcut(Main main){
        this.main = main;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

       if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){ //Ctrl+S = save
            main.functionFile.saveFunction();
        }
        if(e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){ //Shift+S = save as
            main.functionFile.saveAsFunction();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_W){ //Ctrl+W = close
            main.functionFile.exitFunction();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z){ //Ctrl+Z = undo
            main.functionEdit.undoFunction();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y){ //Ctrl+Y = redo
            main.functionEdit.redoFunction();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_F){ //Ctrl+F = open file menu
            main.menuFile.doClick();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N){ //Ctrl+N = open new file
            main.functionFile.newFunction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
