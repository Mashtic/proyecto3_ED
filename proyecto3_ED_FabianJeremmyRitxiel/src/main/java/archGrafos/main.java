package archGrafos;

import com.mycompany.proyecto3_ed_fabianjeremmyritxiel.Coordenada;
import com.mycompany.proyecto3_ed_fabianjeremmyritxiel.Posiciones;
import java.lang.Thread;
import java.util.ArrayList;

public class main{

    static grafo g = new grafo();

    public static void main(String[] args) {

        g.agregarVertice(2, 4, 3, null);
        g.agregarVertice(4, 10,5, null);
        
        Posiciones posTempF01 = new Posiciones();
        posTempF01.listaCoordenada.add(new Coordenada(2,1));
        posTempF01.listaCoordenada.add(new Coordenada(2,2));
        posTempF01.listaCoordenada.add(new Coordenada(3,1));
        posTempF01.listaCoordenada.add(new Coordenada(3,2));
        
        g.agregarVertice(2, 1,1, posTempF01);
        g.agregarVertice(8, 5, 6, null);

        g.agregarVertice(6, 3, 5, null);
        g.agregarVertice(1, 9, 5, null);
        g.agregarVertice(1, 7, 1, null);
        g.agregarVertice(12, 3, 5, null);
        g.agregarVertice(8, 1, 6, null);

        g.agregarArista(g.buscarVertice(2,4), g.buscarVertice(6,3));
        g.agregarArista(g.buscarVertice(2,4), g.buscarVertice(8,5));
        g.agregarArista(g.buscarVertice(8,5), g.buscarVertice(2,1));
        g.agregarArista(g.buscarVertice(1,7), g.buscarVertice(12,3));
        g.agregarArista(g.buscarVertice(2,1), g.buscarVertice(2,4));
        //g.agregarArista(g.buscarVertice(4,10), g.buscarVertice(2,4));
        
        g.imprimir();
        
        Posiciones pruAtaq01 = new Posiciones();
        pruAtaq01.listaCoordenada.add(new Coordenada(3,1));
        pruAtaq01.listaCoordenada.add(new Coordenada(2,2));
        pruAtaq01.listaCoordenada.add(new Coordenada(3,2));
        //pruAtaq01.listaCoordenada.add(new Coordenada(2,1));
        
        //g.ataqueEnIslas(pruAtaq01);
        System.out.println("puntos destruidos :" + g.ataqueEnIslas(pruAtaq01).toString());

        
        g.imprimir();
        
        //System.out.println("");
        //g.profundidad();
        //System.out.println("");

        //g.anchura(g.vertices.get(0));
        System.out.println("\n");
        //threadContPru01 thr01 = new threadContPru01();
        //thr01.start();

        /* 
        ArrayList<Integer> listaNum = new ArrayList<Integer>();
        listaNum.add(4);
        listaNum.add(8);
        listaNum.add(34);
        listaNum.add(6);
        listaNum.add(1);
        System.out.println("\nprueba de array :"+listaNum.get(0));
        */

        ArrayList<Vertice> tempDescon = g.encontrarDesconectados();

        System.out.println("\nvetices desconectados:");
        for (int i = 0; i < tempDescon.size(); i++)
        {
            System.out.println(tempDescon.get(i).posX + "-" + tempDescon.get(i).posY);
        }

        threadCicloGrafo thrCicloG = new threadCicloGrafo();
        thrCicloG.start();
        System.out.println("vvvvvvvvvvv");
    }

    static class threadContPru01 extends Thread{
        public void run(){
            while (true){
                System.out.println(1);
                g.imprimir();
                try {
                    Thread.sleep(2000); // Espera 2 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    static class threadCicloGrafo extends Thread{
        public void run(){
            int cont = 0;
            
            int temp01 =0;
            int temp02 =0;
            int temp03 =0;
            
            while (true){
                System.out.println("Tiempo :" + cont);
                cont++;

                g.pasarCicloEnGrafo();
                System.out.println(temp01);
                System.out.println(temp02);
                System.out.println(temp03);
                try {
                    Thread.sleep(1000); // Espera 1 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}


