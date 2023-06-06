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

/**
 *
 * @author fabia
 */
public class Server {
    VentanaServer ventana;
    Socket jugador;
    ArrayList<Socket> listaJugadores= new ArrayList<Socket>();
    ArrayList<threadServer> hilosServer= new ArrayList<threadServer>();

    public Server(VentanaServer ventana) {
        this.ventana = ventana;
    }
    
    public void runServer(){
        try {
            ServerSocket server= new ServerSocket(5000);
            
            
        } catch (IOException ex) {}
    }
    
}
