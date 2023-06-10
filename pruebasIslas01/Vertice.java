/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package grafos;

import java.util.ArrayList;

/**
 *
 * @author dmora
 */
public class Vertice {
    public int posX;
    public int posY;
    public constIsla isla;
    boolean visitado;
    ArrayList<Vertice> aristas;
    int peso;//peso

    // cosntructor
    public Vertice(int tempX, int tempY, int tipo)
    {
        aristas = new ArrayList<Vertice>();
        //añade las cordenadas de la isla
        this.posX = tempX;
        this.posY = tempY;
        //crea la isla segun el tipo introducido
        if (tipo == 1){
            this.isla = new islaFuentePoder(tempX, tempY);
        }
        else if (tipo == 2){
            //this.isla = new islaFabrica(tempX, tempY); agrega mercado
        }
        else if (tipo == 3){
            this.isla = new islaConector(tempX, tempY); //agrega conector
        }
        else if (tipo == 4){
            //this.isla = new islaFabrica(tempX, tempY); agrega armeria
        }
        else if (tipo == 5){
            this.isla = new islaMina(tempX, tempY, 1);
        }
        else if (tipo == 6){
            this.isla = new islaTemploBruja(tempX, tempY, 1);
        }
        this.visitado = false;
    }

    public Vertice(int tempX, int tempY, int tipo,int peso)
    {
        aristas = new ArrayList<Vertice>();
        //añade las cordenadas de la isla
        this.posX = tempX;
        this.posY = tempY;
        //crea la isla segun el tipo introducido
        if (tipo == 1){
            this.isla = new islaFuentePoder(tempX, tempY);
        }
        else if (tipo == 2){
            //this.isla = new islaFabrica(tempX, tempY); agrega mercado
        }
        else if (tipo == 3){
            //this.isla = new islaFabrica(tempX, tempY); agrega conector
        }
        else if (tipo == 4){
            //this.isla = new islaFabrica(tempX, tempY); agrega armeria
        }
        else if (tipo == 5){
            this.isla = new islaMina(tempX, tempY, 1);
        }
        else if (tipo == 6){
            this.isla = new islaTemploBruja(tempX, tempY, 1);
        }
        this.visitado = false;
        this.peso = peso;
    }

    public void agregarArista (Vertice arista)
    {
        // si no está la arista para no repetir
        if (buscarArista(arista) == -1)
            aristas.add(new Vertice(arista.posX , arista.posY , 0));
    }
    
    public void agregarArista (Vertice arista, int peso)
    {
        // si no está la arista para no repetir
        if (buscarArista(arista) == -1)
            aristas.add(new Vertice(arista.posX , arista.posY , 0, peso));
    }

    public int buscarArista(Vertice v)
    {
        for (int i = 0; i < aristas.size(); i++) {
            if (v.posX == aristas.get(i).posX && v.posY == aristas.get(i).posY)
                return i;
        }
        return -1;
    }
}
