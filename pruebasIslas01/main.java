import java.lang.Thread;
import java.util.ArrayList;

public class main{

    static grafo g = new grafo();

    public static void main(String[] args) {
        System.out.println("jj");

        /* 
        grafo graf01 = new grafo(5);
        graf01.agregarArista(0, 2);
        graf01.agregarArista(1, 2);
        graf01.agregarArista(3, 0);
        graf01.agregarArista(0, 1);
        graf01.agregarArista(0, 4);

        graf01.borrarVertice(4);

        graf01.imprimirGrafo();
        */

        //grafo g = new grafo();
        
        /* 
        g.agregarVertice(0);
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);
        
        g.agregarArista(g.buscarVertice(0), g.buscarVertice(2));
        g.agregarArista(g.buscarVertice(2), g.buscarVertice(0));
        g.agregarArista(g.buscarVertice(0), g.buscarVertice(7));
        g.agregarArista(g.buscarVertice(7), g.buscarVertice(0));
        g.agregarArista(g.buscarVertice(0), g.buscarVertice(5));
        g.agregarArista(g.buscarVertice(5), g.buscarVertice(0));
        g.agregarArista(g.buscarVertice(1), g.buscarVertice(7));
        g.agregarArista(g.buscarVertice(7), g.buscarVertice(1));
        g.agregarArista(g.buscarVertice(2), g.buscarVertice(6));
        g.agregarArista(g.buscarVertice(6), g.buscarVertice(2));
        g.agregarArista(g.buscarVertice(3), g.buscarVertice(4));
        g.agregarArista(g.buscarVertice(4), g.buscarVertice(3));
        g.agregarArista(g.buscarVertice(3), g.buscarVertice(5));
        g.agregarArista(g.buscarVertice(5), g.buscarVertice(3));
        g.agregarArista(g.buscarVertice(4), g.buscarVertice(7));
        g.agregarArista(g.buscarVertice(7), g.buscarVertice(4));
        g.agregarArista(g.buscarVertice(4), g.buscarVertice(6));
        g.agregarArista(g.buscarVertice(6), g.buscarVertice(4));
        g.agregarArista(g.buscarVertice(4), g.buscarVertice(5));
        g.agregarArista(g.buscarVertice(5), g.buscarVertice(4));
        */

        g.agregarVertice(2, 4, 3);
        g.agregarVertice(4, 10,5);
        g.agregarVertice(2, 1,1);
        g.agregarVertice(8, 5, 6);

        g.agregarVertice(6, 3, 5);
        g.agregarVertice(1, 9, 5);
        g.agregarVertice(1, 7, 1);
        g.agregarVertice(12, 3, 5);
        g.agregarVertice(8, 1, 6);

        g.agregarArista(g.buscarVertice(2,4), g.buscarVertice(6,3));
        g.agregarArista(g.buscarVertice(2,4), g.buscarVertice(8,5));
        g.agregarArista(g.buscarVertice(8,5), g.buscarVertice(2,1));
        g.agregarArista(g.buscarVertice(1,7), g.buscarVertice(12,3));
        g.agregarArista(g.buscarVertice(2,1), g.buscarVertice(2,4));
        //g.agregarArista(g.buscarVertice(4,10), g.buscarVertice(2,4));
        
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

        System.out.println("vetices desconectados:");
        for (int i = 0; i < tempDescon.size(); i++)
        {
            System.out.println(tempDescon.get(i).posX + "-" + tempDescon.get(i).posY);
        }

        threadCicloGrafo thrCicloG = new threadCicloGrafo();
        thrCicloG.start();
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
            while (true){
                System.out.println("Tiempo :" + cont);
                cont++;

                g.pasarCicloEnGrafo();
                try {
                    Thread.sleep(1000); // Espera 1 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}