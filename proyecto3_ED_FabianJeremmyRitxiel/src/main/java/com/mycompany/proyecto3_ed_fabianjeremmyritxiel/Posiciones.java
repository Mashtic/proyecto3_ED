/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto3_ed_fabianjeremmyritxiel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author fabia
 */
public class Posiciones implements Serializable{
    public ArrayList<Coordenada> listaCoordenada;

    public Posiciones() {
        this.listaCoordenada = new ArrayList<Coordenada>();
    }

    @Override
    public String toString() {
        String str="";
        str=str+"Posiciones: ";
        for (Coordenada coordenada : listaCoordenada) {
            str=str+coordenada.toString()+"\n";
        }
        return str;
    }
    
    public String toStringAtaque(){
        String str="";
        str=str+"Posiciones Atacadas: ";
        for (Coordenada coordenada : listaCoordenada) {
            if (coordenada.isAcerto()) {
                str=str+coordenada.toString()+"acertado\n";
            }
            else{
                str=str+coordenada.toString()+"fallido\n";
            }
        }
        return str;
    }
    
    
    
}
