/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fabia
 */
public class Server {
    VentanaServer ventana;
    Socket jugador;
    ArrayList<Socket> listaJugadores= new ArrayList<Socket>();
    ArrayList<threadServer> hilosServer= new ArrayList<threadServer>();
    int turno=1;

    public Server(VentanaServer ventana) {
        this.ventana = ventana;
    }
    
    public void cambiarTurno(){
        if (turno==hilosServer.size()) {
            turno=1;
        }
        else{
            turno++;
        }
    }
    
    public void runServer(){
        try {
            int cantJugadores=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Jugadores :"));
            if (cantJugadores<=4&&cantJugadores>=2){
               ServerSocket server= new ServerSocket(5000);
                ventana.mostrar("Servidor activo");
                ventana.mostrar("Esperando Conexiones...");
                while(listaJugadores.size()<=cantJugadores){
                    jugador=server.accept();
                    listaJugadores.add(jugador);
                    threadServer hiloServer= new threadServer(jugador,this,listaJugadores.size());
                    hilosServer.add(hiloServer);
                    hiloServer.start();
                }
                for (threadServer thread : hilosServer) {
                    ArrayList<threadServer> copiaHilos = new ArrayList<threadServer>();
                    for (threadServer threadComp : hilosServer){
                        if (!threadComp.equals(thread)){
                            copiaHilos.add(threadComp);
                        }
                    }
                    thread.listaEnemigo=copiaHilos;
                }
                while (true) 
                {

                }
            }
            else{
                JOptionPane.showMessageDialog(ventana, "El número de jugadores debe ser mayor o igual a 2 y menor o igual a 4", 
                        "Cantidad de jugadores incorrecta", JOptionPane.ERROR_MESSAGE);
                runServer();
            }
            
            
        } catch (IOException ex) {ventana.mostrar("ERROR ... en el servidor");}
    }
    
}
