/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archGrafos;

/**
 *
 * @author Llermy
 */
public class islaMercado extends constIsla{
    
    public int cordX;
    public int cordY;

    islaMercado(int tempX,int tempY){
        this.cordX = tempX;
        this.cordY = tempY;
        this.tipo = "mercado";
    }
}
