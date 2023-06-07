/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class threadServer extends Thread{
    Socket jugador;
    Server server;
    int numJugador;
    ObjectOutputStream salidaObject;
    ObjectInputStream entradaObject;
    String nameJugador;
    ArrayList<threadServer> listaEnemigo=null;
    
    public threadServer(Socket jugador, Server server, int numJugador) {
        this.jugador = jugador;
        this.server = server;
        this.numJugador = numJugador;
        nameJugador="";
    }

    public String getNameJugador() {
        return nameJugador;
    }

    public void setNameJugador(String nameJugador) {
        this.nameJugador = nameJugador;
    }
    @Override
    public void run()
     {
    	try
    	{
          salidaObject= new ObjectOutputStream(jugador.getOutputStream());//Para enviar comunicacion	
          entradaObject= new ObjectInputStream(jugador.getInputStream());//Para leer comunicacion
          
          System.out.println("lee el nombre");
          String name=entradaObject.readUTF();
          System.out.println(name);
          this.setNameJugador(name);
          System.out.println("1. Leyo nombre: " + nameJugador);
          
    	}
    	catch (IOException e) {e.printStackTrace();}
    	//VARIABLES
        int opcion=0;
        int numUsers=0;
        String amigo="";
        String mencli="";
                
    	while(true)
    	{
          try
          {
              //Siempre espera leer un int que será la instruccion por hacer
             opcion=entradaObject.readInt();
             switch(opcion)
             {
                case 1://envio de coordenada
//                    try{
//                    // envia un 4 al thradCliente enemigo
////                        for (threadServidor enemigo : listaEnemigo) {
////                            enemigo.salidaObject.writeInt(1);
////                            enemigo.salidaObject.flush();
////                            // envia el mensaje al thread cliente enemigo
////                            enemigo.salidaObject.writeObject(carta);
////                            enemigo.salidaObject.flush();
////                        }
//                    }
//                    catch (/ClassNotFoundException ex) {}
                    // LEYO OPCION 1
                    // LEE LAS COORDENADAS QUE ENVIO ESTE CLIENTE
                    // Luego las pasa al enemigo para que marque su tablero
//                   int columna = entrada.readInt();//Lee coordenada
//                   int fila = entrada.readInt();//Lee coordenada fila
//                   servidor.ventana.mostrar("Recibido " + columna +","+fila);
//                   // ENVIA LA COORDENADA AL ENEMIGO
//                   enemigo.salida.writeInt(1);// Opcion 1 al hilo cliente del enemigo
//                   enemigo.salida.writeInt(columna);// envia columna
//                   enemigo.salida.writeInt(fila);// envia fila
//                   
//                   System.out.println("Op1: lee col,fil, envia al enemigo, 1, col, fila: "+columna+" , "+fila );
                    
                   break;

                case 2:// 
//                    try{
//                        /*Carta carta = (Carta)entradaObject.readObject();
//                    // envia un 4 al thradCliente enemigo
//                        for (threadServidor enemigo : listaEnemigo) {
//                            if(enemigo.equals(listaEnemigo.get(0))){
//                                enemigo.salidaObject.writeInt(2);
//                                enemigo.salidaObject.flush();
//                                enemigo.salidaObject.writeObject(carta);
//                                enemigo.salidaObject.flush();
//                            }
//                            else{
//                                enemigo.salidaObject.writeInt(1);
//                                enemigo.salidaObject.flush();
//                                // envia el mensaje al thread cliente enemigo
//                                enemigo.salidaObject.writeObject(carta);
//                                enemigo.salidaObject.flush();
//                            }
//                            
//                        }
//                        */
//                    }
//                    catch (ClassNotFoundException ex) {}
                    
                   break;
                case 3: //le envia el status, que es el numero de jugador y el nombre enemigo
//                    salida.writeInt(3);
//                    salida.writeInt(numeroDeJugador);
//                    if (enemigo != null)
//                        salida.writeUTF(enemigo.nameUser);
//                    else
//                        salida.writeUTF("");
//                    System.out.println("3. Op3: envia 3 y numeroJugador y enemigo: "+ numeroDeJugador);
                   break;
                 case 4:
                     // lee el mensaje enviado desde el jframe
                     String mensaje = entradaObject.readUTF();
                     // envia un 4 al thradCliente enemigo
                     for (threadServer enemigo : listaEnemigo) {
                         enemigo.salidaObject.writeInt(4);
                         enemigo.salidaObject.flush();
                         // envia el mensaje al thread cliente enemigo
                         enemigo.salidaObject.writeUTF(mensaje);
                         enemigo.salidaObject.flush();
                         System.out.println("Op4: envia 4 y mensaje: "+ mensaje);
                     }
                 break;
                 case 5:
//                     // lee la columna
//                     int col = entrada.readInt();
//                     // lee la fila
//                     int fil = entrada.readInt();
//                     // envia un 5 al thradCliente enemigo
//                     enemigo.salida.writeInt(5);
//                     // envia el emnsaje al thread cliente enemigo
//                     enemigo.salida.writeInt(col);
//                     enemigo.salida.writeInt(fil);
//                     System.out.println("Op5: envia columna fila para bomba ");
                 break;
             }
          }
          catch (IOException e) {
              System.out.println("El cliente termino la conexion");break;}
    	}
    	server.ventana.mostrar("Se removio un usuario");
    	
    	try
    	{
          server.ventana.mostrar("Se desconecto un usuario: "+nameJugador);
          jugador.close();
    	}	
        catch(Exception et)
        {server.ventana.mostrar("no se puede cerrar el socket");}   
     }
    
    
    
}
