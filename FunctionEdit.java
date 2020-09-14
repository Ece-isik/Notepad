package com.company;

public class FunctionEdit {
    Main main;

    public FunctionEdit(Main main){
        this.main = main;
    }

    public void undoFunction(){
        main.undoManager.undo();
    }

    public void redoFunction(){
        main.undoManager.redo();
    }
}
