package archGrafos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package pruebasIslass01;

import com.mycompany.proyecto3_ed_fabianjeremmyritxiel.Posiciones;
import com.mycompany.proyecto3_ed_fabianjeremmyritxiel.VentanaJugador;
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
    public void agregarVertice(int tempX, int tempY, int tipo, Posiciones tempPosAta)
    {
        vertices.add(new Vertice(tempX, tempY , tipo, tempPosAta));
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
        System.out.println("---------------Estado del mapa---------------");
        for (int i = 0; i < vertices.size(); i++)
        {
            System.out.print("Vertice "+vertices.get(i).posX +"-"+ vertices.get(i).posY+":  ");
            for (int j = 0; j < vertices.get(i).aristas.size(); j++) {
                System.out.print(vertices.get(i).aristas.get(j).posX +"-"+vertices.get(i).aristas.get(j).posY+"  ");
                Posiciones posTemp = vertices.get(i).posAtaques;
                if (posTemp != null){
                    System.out.println("\nposiciones de la isla");
                    for (int n = 0; n < posTemp.listaCoordenada.size(); n++)
                    {
                        System.out.println(posTemp.listaCoordenada.get(n).getX() + "-" + posTemp.listaCoordenada.get(n).getY());
                        System.out.println("atacado :" + posTemp.listaCoordenada.get(n).isAcerto()); 
                    }
                }
            }
            System.out.println("");
        }
    }
    
    public String extraerTexto(){
        String textoSalida = "Vertices conectados a la fuente:\n";
        
        limpiarVisitados();

        for (int i = 0; i < vertices.size(); i++)
        {
            if(vertices.get(i).visitado == false && vertices.get(i).isla.tipo == "fuenteDePoder")
            {
                visitarAdyacentes(vertices.get(i));
            }
        }

        String desc = "\nVertices desconectados:\n";
        
        for (int i = 0; i < vertices.size(); i++)
        {
            if(vertices.get(i).visitado == false)
            {
                desc += "-> " + vertices.get(i).posX + "-" + vertices.get(i).posY + " "+vertices.get(i).isla.tipo+"\nAristas : ";
                for (int n = 0; n < vertices.get(i).aristas.size(); n++){
                    desc += vertices.get(i).aristas.get(n).posX + "-" + vertices.get(i).aristas.get(n).posY + ", ";
                }
                desc += "\n";
            }
            else{
                textoSalida += "-> " + vertices.get(i).posX + "-" + vertices.get(i).posY + " "+vertices.get(i).isla.tipo+"\nAristas : ";
                for (int n = 0; n < vertices.get(i).aristas.size(); n++){
                    textoSalida += vertices.get(i).aristas.get(n).posX + "-" + vertices.get(i).aristas.get(n).posY + ", ";
                }
                textoSalida += "\n";
            }
        }

        limpiarVisitados();
        
        return textoSalida + desc;
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


    public ArrayList<Integer> pasarCicloEnGrafo(){
        ArrayList<Integer> tempSalida = new ArrayList<Integer>();
        tempSalida.add(0);
        tempSalida.add(0);
        tempSalida.add(0);
        
        for (int i = 0; i < vertices.size(); i++) {
            Vertice vertice = vertices.get(i);
            
            if (vertice.isla.tipo == "mina"){
                vertice.isla.contTiempo++;

                if (vertice.isla.contTiempo >= 60){
                    //llama a la funcion agregar material
                    tempSalida.set(0, tempSalida.get(0) + 50);
                    System.out.println("se recolecto material.");
                    vertice.isla.contTiempo = 0;
                }
            }

            if (vertice.isla.tipo == "templo de bruja"){
                vertice.isla.contTiempo++;

                if (vertice.isla.contTiempo >= 300){
                    //llama a la funcion agregar material
                    int tipoComodin = (int) (Math.random() * 2);
                    if (tipoComodin == 0){
                        tempSalida.set(1, tempSalida.get(1) + 1);
                    }
                    else{
                        tempSalida.set(2, tempSalida.get(2) + 1);
                    }
                    System.out.println("se ha anadido un comofin nuevo.");
                    vertice.isla.contTiempo = 0;
                }
            }
        }
        return tempSalida;
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
    
    public Posiciones ataqueEnIslas(Posiciones tempPosAta){
        if (tempPosAta != null){
            for (int n = 0; n < tempPosAta.listaCoordenada.size(); n++)
            {
                //System.out.print("Vertice "+vertices.get(i).posX +"-"+ vertices.get(i).posY+":  ");
                for (int i = 0; i < vertices.size(); i++) {
                    //System.out.print(vertices.get(i).aristas.get(j).posX +"-"+vertices.get(i).aristas.get(j).posY+"  ");
                    Posiciones posTemp = vertices.get(i).posAtaques;
                    if (posTemp != null){
                        for (int j = 0; j < posTemp.listaCoordenada.size(); j++) {
                            //compara las cordenas del ataque con las del vertice
                            if (posTemp.listaCoordenada.get(j).getX() == tempPosAta.listaCoordenada.get(n).getX()){
                                if (posTemp.listaCoordenada.get(j).getY() == tempPosAta.listaCoordenada.get(n).getY()){
                                    //si las cordenadas son iguales, cambia el valor de la cordenada de las posiciones del vertice
                                    posTemp.listaCoordenada.get(j).setAcerto(true);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return revisarIslasDestr();
    }
    
    public Posiciones revisarIslasDestr(){
        Posiciones posDestr = new Posiciones();
        
        for (int i = 0; i < vertices.size(); i++) {

            Posiciones posTemp = vertices.get(i).posAtaques;
            int valAgre = 0;
            if (posTemp != null){
                for (int j = 0; j < posTemp.listaCoordenada.size(); j++) {
                    //verifica si hay una parte de la isla que no ha sido destruida
                    if (posTemp.listaCoordenada.get(j).isAcerto() == false){
                        valAgre++;
                        break;
                    }
                }
                
                //si ya todos las coordenadas de la isla estan destruidas, agrea las cordenadas a la salida
                if (valAgre == 0){
                    posDestr.listaCoordenada.addAll(posTemp.listaCoordenada);
                    
                    //falta que elimine el nodo que se agrego
                    eliminar(vertices.get(i));
                }
            }
        }
        
        return posDestr;
    }
    
    public Posiciones ataqueKracken(){
        Posiciones posAtaq = new Posiciones();
        
        int verticeAtacado = (int) (Math.random() * vertices.size());
        
        posAtaq = vertices.get(verticeAtacado).posAtaques;
        
        eliminar(vertices.get(verticeAtacado));
        
        return posAtaq;
    }
    
    public boolean verifIslas(){
        return vertices.isEmpty();
    }
}
