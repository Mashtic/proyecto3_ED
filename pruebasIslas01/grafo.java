/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package pruebasIslass01;

import java.util.ArrayList;

/**
 *
 * @author dmora
 */
public class grafo {

    ArrayList<Vertice> vertices;

    public grafo()
    {
        vertices = new ArrayList<Vertice>();
    }

    // agrega a la lista
    public void agregarVertice(int tempX, int tempY, int tipo)
    {
        vertices.add(new Vertice(tempX, tempY , tipo));
    }

    // agrega las aristas
    public void agregarArista(Vertice origen, Vertice destino)
    {
        if (origen != null && destino != null && (origen.isla.tipo == "conector" || destino.isla.tipo == "conector")){
            origen.agregarArista(destino);
            destino.agregarArista(origen);
        }
    }

    // agrega las aristas con peso
    public void agregarArista(Vertice origen, Vertice destino, int peso)
    {
        if (origen != null && destino != null)
            origen.agregarArista(destino, peso);
    }

    // busca un vertice en la lista
    public Vertice buscarVertice (int tempX, int tempY){

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).posX == tempX && vertices.get(i).posY == tempY)
                return vertices.get(i);
        }

        return null;
    }

    // imprime la lista con sus listas de adyacencia
    public void imprimir ()
    {
        for (int i = 0; i < vertices.size(); i++)
        {
            System.out.print("Vertice "+vertices.get(i).posX +"-"+ vertices.get(i).posY+":  ");
            for (int j = 0; j < vertices.get(i).aristas.size(); j++) {
                System.out.print(vertices.get(i).aristas.get(j).posX +"-"+vertices.get(i).aristas.get(j).posY+"  ");
            }
            System.out.println("");
        }
    }

    // elimina un vertice, de la lista y de las listas de adyacencia
    // imprime la lista con sus listas de adyacencia
    public void eliminar (Vertice v)
    {
        for (int i = 0; i < vertices.size(); i++)
        {
            for (int j = 0; j < vertices.get(i).aristas.size(); j++) {
                if (vertices.get(i).aristas.get(j).posX == v.posX && vertices.get(i).aristas.get(j).posX == v.posX)
                    vertices.get(i).aristas.remove(j);
            }
        }

        vertices.remove(v);
    }


    // Recorrido PROFUNDIDAD
    public void profundidad()
    {
        // recorre todos los nodos
        for (int i = 0; i < vertices.size(); i++)
        {
            if(vertices.get(i).visitado == false)
            {
                visitarAdyacentes(vertices.get(i));
            }
        }

        limpiarVisitados();// quita todos los nodos visitados

    }

    // vissita los nodos en la lista de adyacencia
    public void visitarAdyacentes(Vertice nodo)
    {
        visitarVertice(nodo);
        System.out.print(nodo.posX+"-"+nodo.posY+"  ");

        // para cada arista
        for (int i = 0; i < nodo.aristas.size(); i++)
        {
            // marca cada uno de los adyacentes
            if (visitadoVertice(nodo.aristas.get(i)) == false)
            {
                visitarAdyacentes(buscarVertice(nodo.aristas.get(i).posX,nodo.aristas.get(i).posY));
            }
        }
    }

    public void visitarVertice(Vertice nodo)
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (nodo.posX == vertices.get(i).posX && nodo.posY == vertices.get(i).posY)
                vertices.get(i).visitado = true;
        }
    }

    public boolean visitadoVertice(Vertice nodo)
    {
        for (int i = 0; i < vertices.size(); i++) {
            if (nodo.posX == vertices.get(i).posX && nodo.posY == vertices.get(i).posY)
                return vertices.get(i).visitado;
        }
        return false;// si no está
    }

    public void limpiarVisitados()
    {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice vertice = vertices.get(i);
            vertice.visitado = false;
        }
    }


    //----------------------------------------
    public void anchura(Vertice v)
    {
        System.out.print(v.posX+"-"+v.posY+"  ");
        visitarVertice(v);// marca el primer nodo
        ArrayList<Vertice> cola = new ArrayList<Vertice>();
        // mete a la cola los adyacentes del nodo inicial
        for (int i = 0; i < v.aristas.size(); i++) {
            cola.add(buscarVertice(v.aristas.get(i).posX, v.aristas.get(i).posY));// es para buscar el nodo en vertices
            visitarVertice(v.aristas.get(i));
            //System.out.println("COLA "+v.aristas.get(i).dato);
        }
        // mientras no se vacíe la cola
        while(!cola.isEmpty())
        {
            // trabaja con el primero de la cola
            Vertice actual = cola.remove(0);
            visitarVertice(actual);
            System.out.print(actual.posX+"-"+actual.posY+"  ");
            // cada arista del vertice en la cola
            for (int i = 0; i < actual.aristas.size(); i++) {

                // si no se ha visitado se mete en la cola el adyacente
                if(visitadoVertice(actual.aristas.get(i))==false)
                {
                    // si no está ya en la cola, se mete
                    visitarVertice(buscarVertice(actual.aristas.get(i).posX, actual.aristas.get(i).posY));
//                    System.out.println("METE"+ actual.aristas.get(i).dato+ "  "+actual.aristas.get(i).visitado);
                    cola.add(actual.aristas.get(i));
                }       
            }
        }
        limpiarVisitados();
    }


    void pasarCicloEnGrafo(){
        for (int i = 0; i < vertices.size(); i++) {
            Vertice vertice = vertices.get(i);
            
            if (vertice.isla.tipo == "mina"){
                vertice.isla.contTiempo++;

                if (vertice.isla.contTiempo >= 5){
                    //llama a la funcion agregar material
                    System.out.println("se recolecto material.");
                    vertice.isla.contTiempo = 0;
                }
            }

            if (vertice.isla.tipo == "templo de bruja"){
                vertice.isla.contTiempo++;

                if (vertice.isla.contTiempo >= 10){
                    //llama a la funcion agregar material
                    System.out.println("se ha anadido un comofin nuevo.");
                    vertice.isla.contTiempo = 0;
                }
            }
        }
    }


    public ArrayList<Vertice> encontrarDesconectados()
    {

        limpiarVisitados();// quita todos los nodos visitados

        ArrayList<Vertice> descon = new ArrayList<>();
        // recorre todos los nodos
        for (int i = 0; i < vertices.size(); i++)
        {
            if(vertices.get(i).visitado == false && vertices.get(i).isla.tipo == "fuenteDePoder")
            {
                visitarAdyacentes(vertices.get(i));
            }
        }

        for (int i = 0; i < vertices.size(); i++)
        {
            if(vertices.get(i).visitado == false)
            {
                descon.add(vertices.get(i));
            }
        }

        limpiarVisitados();// quita todos los nodos visitados

        return descon;
    }

}
