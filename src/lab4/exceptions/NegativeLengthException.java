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
public class NegativeLengthException extends Exception{
    public NegativeLengthException(double length) {
        super("Unexpected negative length " + length + ".");
    }
}
