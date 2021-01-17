/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER}
 */
public class NodoL {
    NodoAG Direccion;
    NodoL Sig;
    NodoL Ant;
    
    public NodoL(NodoAG d){
        Direccion = d;
        Sig = null;
        Ant = null;
    }
}
