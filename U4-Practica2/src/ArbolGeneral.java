/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER}
 */
public class ArbolGeneral {
    private NodoAG Raiz;
    
    public ArbolGeneral(){
        Raiz=null;
    }
    
    public boolean InsertarNodoGeneral(String camino, char valor){
        if(camino.isEmpty()){
            if(Raiz==null){
                Raiz=new NodoAG(valor);
                return true;
            }
            return false;
        }
        
        NodoAG padre= BuscarNodo(camino);
        if(padre==null){
            return false;
        }
        
        NodoAG existehijo=BuscarNodo(camino+"/"+valor);
        if(existehijo!=null){
            return false;
        }
        
        NodoAG hijo=new NodoAG(valor);
        if(hijo==null){
            return false;
        }
        
        return padre.InsertarLiga(hijo);
    }
    
    public boolean EliminarNodoGeneral(String camino){
        NodoAG hijo=BuscarNodo(camino);
        if(hijo==null){
            return false;
        }
        
        if(hijo==Raiz){
            if(Raiz.Hoja()){
                Raiz=null;
                return true;
            }
            return false;
        }
        String caminopadre= CaminoPadre(camino);
        NodoAG padre=BuscarNodo(caminopadre);
        if(padre==null){
            return false;
        }
        if(hijo.Hoja()){
            return padre.EliminarLiga(hijo);
        }
        return false;
    }
    
    private String CaminoPadre(String c){
        int UltimaD=c.lastIndexOf("/")-1;
        return c.substring(0, UltimaD+1);
    }
    
    private NodoAG BuscarNodo(String camino){
        if(camino.isEmpty()){
            return null;
        }
        camino=camino.substring(1);
        String[] vector=camino.split("/");
        if(Raiz.Valor==vector[0].charAt(0)){
            if(vector.length==1){
                return Raiz;
            }
            for(NodoL temp=Raiz.Ini; temp!=null; temp=temp.Sig){
                if(temp.Direccion.Valor==vector[1].charAt(0)){
                    if(vector.length==2){
                        return temp.Direccion;
                    }
                    BuscarNodo(temp.Direccion, camino.substring(3));  
                }
            }
        }
        return null;
    }
    
    private NodoAG BuscarNodo(NodoAG nodoencontrado, String camino){
        if(camino.isBlank()){
            return nodoencontrado;
        }
        if(camino.length()!=1){
            camino=camino.substring(1);
        }
        String[] vector;
        if(camino.length()==1){
            vector= new String[1];
            vector[0]=camino;
        }else{
            vector=camino.split("/");
        }
        if(nodoencontrado.Valor==vector[0].charAt(0)){
            BuscarNodo(nodoencontrado, "");
        }
        for(NodoL temp=nodoencontrado.Ini; temp!=null; temp=temp.Sig){
                if(temp.Direccion.Valor==vector[0].charAt(0)){
                    if(camino.length()==1){
                         BuscarNodo(temp.Direccion, "");
                    }
                    BuscarNodo(temp.Direccion, camino.substring(1));
                }
            }
        return null;
    }
    //Para obtener el valor de raiz
    public String getRaiz(){
        if(Raiz==null){
            return "No hay raiz";
        }
        return ""+Raiz.Valor;
    }
    //Para mostrar hijos de raiz
    public String MostrarHijos(){
        if(Raiz==null){
            return "No hay nodos";
        }
        if(Raiz.Ini==null){
            return "No hay nodos";
        }
        String Cadena="-";
        for(NodoL temp=Raiz.Ini; temp!=null; temp=temp.Sig){
            Cadena+=" "+temp.Direccion.Valor+" -";
        }
        return Cadena;
    }
    //Para mostrar hijos de un nodo
    public String MostrarHijos(String camino){
        NodoAG padre=BuscarNodo(camino);
        if(padre==null){
            return "No existe ese nodo";
        }
        if(padre.Ini==null){
            return padre.Valor+": No tiene hijos";
        }
        String Cadena=padre.Valor+":\n-";
        for(NodoL temp=padre.Ini; temp!=null; temp=temp.Sig){
            Cadena+=" "+temp.Direccion.Valor+" -";
        }
        return Cadena;
    }
}
