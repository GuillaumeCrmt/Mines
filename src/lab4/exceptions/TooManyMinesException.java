/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.exceptions;

/**
 *
 * @author fabien
 */
public class TooManyMinesException extends Exception{
    public TooManyMinesException(double pourcentage) {
        super("The number of mines cannot exced the number of cells");
    }
}
