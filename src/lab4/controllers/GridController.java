/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import lab4.models.Grid;
import lab4.views.GridView;

/**
 *
 * @author fabien
 */
public class GridController {
    
    private Grid model;
    private GridView view;
    private boolean firstUnveiling = true;
    
    public GridController(Grid model, GridView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }
    
    /**
     * Receive a new command from user input
     */
    public void onCommand(String command) {
        String[] commandArr = command.split(" ");
        if(commandArr.length == 0) this.view.unknownInput();
        switch(commandArr[0]) {
            case "d" :
               unveilingCell(commandArr);
               break; 

            case "m" :
               markingCell(commandArr);
               break;
               
            case "q" :
               System.exit(0);
               break; 
               
            default : 
               this.view.unknownInput();
               // Statements
         }
    }
    
    /**
     * Unveiling Cell
     */
    public void unveilingCell(String[] commandArr) {
        
        /* Vérification des paramètres */
        if (commandArr.length != 3) this.view.unknownInput();
        int x = Integer.parseInt(commandArr[1]);
        int y = Integer.parseInt(commandArr[2]);
        if(x < 0 || x > model.getWidth() - 1) {
            this.view.wrongParameters();
        }
        if(y < 0 || y > model.getHeight()- 1) {
            this.view.wrongParameters();
        }

        model.getGrid().get(y).get(x).setVisible(true);

        if(firstUnveiling) {
            firstUnveiling = false;
            model.generateMines();
        }
                
        model.unveilNeighbors(model.getGrid().get(y).get(x));

        model.updateGrid();
    }
    
    /**
     * Marking Cell
     * @param commandArr 
     */
    public void markingCell(String[] commandArr) {
        
        /* Vérification des paramètres */
        if (commandArr.length != 4) this.view.unknownInput();
        int x = Integer.parseInt(commandArr[1]);
        int y = Integer.parseInt(commandArr[2]);
        if(x < 0 || x > model.getWidth() - 1) {
            this.view.wrongParameters();
        }
        if(y < 0 || y > model.getHeight()- 1) {
            this.view.wrongParameters();
        }
        
        if(commandArr[3].length() != 1) this.view.wrongParameters();
        char markChar = commandArr[3].charAt(0);
        if(markChar != 'x' && markChar != '?' && markChar != '#') this.view.wrongParameters();
        
        model.getGrid().get(y).get(x).setMarking(markChar);
        
        model.updateGrid();
    }
}
