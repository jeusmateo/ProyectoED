/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoED.Arboles.ArbolABB;

/**
 *
 * @author jorge.reyes
 */
public class ItemNotFoundException extends RuntimeException{
    
    public ItemNotFoundException(String msg){
        super(msg);
    }
}