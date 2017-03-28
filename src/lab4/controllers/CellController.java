/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import lab4.models.Cell;
import lab4.views.GraphicalCellView;

/**
 *
 * @author fabien
 */
public class CellController extends MouseAdapter {
    
    private GridController gridController;
    private Cell model;
    private GraphicalCellView view;
    
    public CellController(GridController gridController,Cell model){
        this.gridController = gridController;
        this.model = model;
        this.view = new GraphicalCellView(gridController.getView(), model);
        view.addController(this);
        model.addObserver(view);  
    }

    @Override
    public void mouseClicked(MouseEvent e){
        /* Clique gauche */
        if(e.getButton() == 1) {
            model.setUnveil(true);
            gridController.game.model.incRound();
            if(gridController.game.model.getRound() == 1) {
                gridController.model.generateMines();
            }
            model.unveil();
            
        /* Clique droit */
        } else if(e.getButton() == 3) {
            model.mark();
        }
    }


}
