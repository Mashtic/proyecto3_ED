
public class main{
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

        grafo g = new grafo();
        
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

        g.agregarVertice(2, 4, 1);
        g.agregarVertice(4, 10, 1);
        g.agregarVertice(2, 1, 1);
        g.agregarVertice(8, 5, 1);

        g.agregarArista(g.buscarVertice(2,4), g.buscarVertice(4,10));
        g.agregarArista(g.buscarVertice(2,4), g.buscarVertice(8,5));
        g.agregarArista(g.buscarVertice(8,5), g.buscarVertice(2,1));
        g.agregarArista(g.buscarVertice(4,10), g.buscarVertice(2,4));
        
        g.imprimir();
        System.out.println("");
        g.profundidad();
        System.out.println("");

        g.anchura(g.vertices.get(0));
    }
}