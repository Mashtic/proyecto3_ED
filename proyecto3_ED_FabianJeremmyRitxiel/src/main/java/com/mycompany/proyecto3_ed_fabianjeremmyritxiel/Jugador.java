/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto3_ed_fabianjeremmyritxiel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fabia
 */
public class Jugador {
    public static String IP_SERVER = "localhost"; //IP del Servidor
    VentanaJugador ventPlayer; // Ventana del cliente
    //DataInputStream entrada = null;//leer comunicacion
    //DataOutputStream salida = null;//escribir comunicacion
    ObjectOutputStream salidaObject =null;
    ObjectInputStream entradaObject =null;
    
    Socket player = null;//para la comunicacion
    String nomPlayer;// nombre del user
    
    public Jugador(VentanaJugador ventana){
        this.ventPlayer=ventana;
    }
    public void conexion() throws IOException 
   {
      try {
          // se conecta con dos sockets al server, uno comunicacion otro msjes
         player = new Socket(Jugador.IP_SERVER, 5000);
         // inicializa las entradas-lectura y salidas-escritura
          System.out.println("Aquivoyyyyyyyy1");
         //entrada = new DataInputStream(player.getInputStream());
         //salida = new DataOutputStream(player.getOutputStream());
          System.out.println("ME MUEROOOOOOOOO1");
         // solicita el nombre del user
         nomPlayer = JOptionPane.showInputDialog("Introducir Nick :");
         //Lo coloca en la ventana
         ventPlayer.setTitle(nomPlayer);
         // es lo primero que envia al server
         // el thread servidor esta pendiente de leer el nombre antes de entrar
         // al while para leer opciones
          System.out.println("Auxilio1");
         salidaObject = new ObjectOutputStream(player.getOutputStream());
          System.out.println("Auxilio2S");
         entradaObject = new ObjectInputStream(player.getInputStream());
         System.out.println("Auxilio3S");
         salidaObject.writeUTF(nomPlayer);
         salidaObject.flush();
         System.out.println("1. Envia el nombre del cliente: "+nomPlayer);
         System.out.println("Aquivoyyyyyyyy2");
         
         System.out.println("ME MUEROOOOOOOOO2");
      } catch (IOException e) {
         System.out.println(e);
         System.out.println("\tEl servidor no esta levantado");
         System.out.println("\t=============================");
      }
      // solo se le pasa entrada pues es solo para leer mensajes
      // el hiloCliente lee lo que el servidor le envia, opciones y como tiene referencia
      // a la ventana gato puede colocar en la pantalla cualquier cosa, como las
      //imagenes de X o O, llamar a metodo marcar, colocar el nombre de enemigo
      // o el suyo propio
      new threadJugador(entradaObject, ventPlayer).start();
   }
   
   //GETTET AND SETTER
   public String getNombre()
   {
      return nomPlayer;
   }
}
