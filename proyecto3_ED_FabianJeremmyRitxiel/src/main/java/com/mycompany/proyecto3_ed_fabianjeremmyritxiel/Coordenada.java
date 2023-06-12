/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto3_ed_fabianjeremmyritxiel;

/**
 *
 * @author fabia
 */
public class Coordenada {
    private int x;
    private int y;
    private boolean acerto;
    private int tipoEstructura;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
        this.acerto=false;
        this.tipoEstructura=0;
        
    }

    public int getTipoEstructura() {
        return tipoEstructura;
    }

    public void setTipoEstructura(int tipoEstructura) {
        this.tipoEstructura = tipoEstructura;
    }

    public boolean isAcerto() {
        return acerto;
    }

    public void setAcerto(boolean acerto) {
        this.acerto = acerto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordenada (" + "x=" + x + ", y=" + y + ')';
    }
    
}
