/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER}
 */
public class NodoAG {
    char Valor;
    NodoL Ini;
    NodoL Fin;
    
    public NodoAG(char v){
        Valor = v;
        Ini = null;
        Fin = null;
    }
    
    public boolean InsertarLiga(NodoAG Dir){
        NodoL temp= new NodoL(Dir);
        if(temp==null){
            return false;
        }
        
        if(Ini==null && Fin==null){
            Ini=Fin=temp;
            return true;
        }
        
        Fin.Sig=temp;
        temp.Ant=Fin;
        Fin=temp;
        return true;
    }
    
    public boolean EliminarLiga(NodoAG Dir){
        if(Ini==null && Fin==null){
            return false;
        }
        
        if(Ini==Fin && Ini.Direccion==Dir){
            Ini=Fin=null;
            return true;
        }
        
        if(Ini.Direccion==Dir){
            NodoL temp=Ini.Sig;
            Ini.Sig=null;
            temp.Ant=null;
            Ini=temp;
            return true;
        }
        
        if(Fin.Direccion==Dir){
            NodoL temp=Fin.Ant;
            temp.Sig=null;
            Fin.Ant=null;
            Fin=temp;
            return true;
        }
        
        NodoL temp = Ini.Sig;
        do{
            if(temp.Direccion==Dir){
                temp.Ant.Sig=temp.Sig;
                temp.Sig.Ant=temp.Ant;
                temp.Sig=null;
                temp.Ant=null;
            }
            temp=temp.Sig;
        }while(temp!=Fin);
        return false;
    }
    
    public boolean Hoja(){
        return (Ini==null && Fin==null);
    }
}
