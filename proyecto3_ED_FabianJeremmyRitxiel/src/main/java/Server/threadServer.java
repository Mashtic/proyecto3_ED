/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import com.mycompany.proyecto3_ed_fabianjeremmyritxiel.Posiciones;
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
    int contadorBomba=0;
    int contadorBB=0;
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
          System.out.println("nombre "+nameJugador+numJugador);
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
                    String mensajeRespuesta=entradaObject.readUTF();
                    int numJugadorRecibidor=entradaObject.readInt();
                    threadServer jugadorRecibidor = null;
                    for (threadServer enemigo : listaEnemigo) {
                        if (enemigo.numJugador==numJugadorRecibidor){
                            jugadorRecibidor=enemigo;
                        }
                    }
                    jugadorRecibidor.salidaObject.writeInt(1);
                    jugadorRecibidor.salidaObject.flush();
                    jugadorRecibidor.salidaObject.writeUTF(mensajeRespuesta);
                    jugadorRecibidor.salidaObject.flush();
                   break;

                case 2:// 
//                    try{
//                        
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
                        if (!enemigo.equals(this)){
                            enemigo.salidaObject.writeInt(4);
                            enemigo.salidaObject.flush();
                            // envia el mensaje al thread cliente enemigo
                            enemigo.salidaObject.writeUTF(mensaje);
                            enemigo.salidaObject.flush(); 
                        }
                        
                        System.out.println("Op4: envia 4 y mensaje: "+ mensaje);
                    }
                 break;
                 case 7:
                     
                    try {
                        int numJugadorAtacado=entradaObject.readInt();
                        System.out.println("Recibi1");
                        System.out.println(numJugadorAtacado);
                        Posiciones posiAtaque=(Posiciones)entradaObject.readObject();
                        System.out.println("Recibi2");
                        System.out.println(posiAtaque.toString());
                        threadServer jugadorAtacado = null;
                        for (threadServer enemigo : listaEnemigo) {
                            if (enemigo.numJugador==numJugadorAtacado){
                                jugadorAtacado=enemigo;
                            }
                        }
                        if (numJugador==server.turno){
                            jugadorAtacado.salidaObject.writeInt(1);
                            jugadorAtacado.salidaObject.flush();
                            // envia el mensaje al thread cliente enemigo
                            jugadorAtacado.salidaObject.writeUTF(this.nameJugador+"> Está Atacando "+
                                    " en las posiciones: "+posiAtaque.toString());
                            jugadorAtacado.salidaObject.flush();
                            System.out.println("Se envió mensaje");
                            jugadorAtacado.salidaObject.writeInt(opcion);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeObject(posiAtaque);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeInt(this.numJugador);
                            jugadorAtacado.salidaObject.flush();
                            server.cambiarTurno();
                        }

                    } catch (ClassNotFoundException ex) {}
                        
                 break;
                 case 8:
                     
                    try {
                        int numJugadorAtacado=entradaObject.readInt();
                        System.out.println("Recibi1");
                        System.out.println(numJugadorAtacado);
                        Posiciones posiAtaque=(Posiciones)entradaObject.readObject();
                        System.out.println("Recibi2");
                        System.out.println(posiAtaque.toString());
                        threadServer jugadorAtacado = null;
                        for (threadServer enemigo : listaEnemigo) {
                            if (enemigo.numJugador==numJugadorAtacado){
                                jugadorAtacado=enemigo;
                            }
                        }
                        if (numJugador==server.turno){
                            jugadorAtacado.salidaObject.writeInt(1);
                            jugadorAtacado.salidaObject.flush();
                            // envia el mensaje al thread cliente enemigo
                            jugadorAtacado.salidaObject.writeUTF(this.nameJugador+"> Está Atacando "+
                                    " en las posiciones: "+posiAtaque.toString());
                            jugadorAtacado.salidaObject.flush();
                            System.out.println("Se envió mensaje");
                            jugadorAtacado.salidaObject.writeInt(opcion);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeObject(posiAtaque);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeInt(this.numJugador);
                            jugadorAtacado.salidaObject.flush();
                            server.cambiarTurno();
                        }

                    } catch (ClassNotFoundException ex) {}
                        
                 break;
                 case 9:
                     
                    try {
                        int numJugadorAtacado=entradaObject.readInt();
                        System.out.println("Recibi1");
                        System.out.println(numJugadorAtacado);
                        Posiciones posiAtaque=(Posiciones)entradaObject.readObject();
                        System.out.println("Recibi2");
                        System.out.println(posiAtaque.toString());
                        threadServer jugadorAtacado = null;
                        for (threadServer enemigo : listaEnemigo) {
                            if (enemigo.numJugador==numJugadorAtacado){
                                jugadorAtacado=enemigo;
                            }
                        }
                        if (numJugador==server.turno){
                            jugadorAtacado.salidaObject.writeInt(1);
                            jugadorAtacado.salidaObject.flush();
                            // envia el mensaje al thread cliente enemigo
                            jugadorAtacado.salidaObject.writeUTF(this.nameJugador+"> Está Atacando "+
                                    " en las posiciones: "+posiAtaque.toString());
                            jugadorAtacado.salidaObject.flush();
                            System.out.println("Se envió mensaje");
                            jugadorAtacado.salidaObject.writeInt(opcion);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeObject(posiAtaque);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeInt(this.numJugador);
                            jugadorAtacado.salidaObject.flush();
                            contadorBomba++;
                            if (contadorBomba==3){
                                server.cambiarTurno();
                                contadorBomba=0;
                            }
                            
                        }

                    } catch (ClassNotFoundException ex) {}
                        
                 break;
                 case 10:
                    try {
                        int numJugadorAtacado=entradaObject.readInt();
                        System.out.println("Recibi1");
                        System.out.println(numJugadorAtacado);
                        Posiciones posiAtaque=(Posiciones)entradaObject.readObject();
                        System.out.println("Recibi2");
                        System.out.println(posiAtaque.toString());
                        threadServer jugadorAtacado = null;
                        for (threadServer enemigo : listaEnemigo) {
                            if (enemigo.numJugador==numJugadorAtacado){
                                jugadorAtacado=enemigo;
                            }
                        }
                        if (numJugador==server.turno){
                            jugadorAtacado.salidaObject.writeInt(1);
                            jugadorAtacado.salidaObject.flush();
                            // envia el mensaje al thread cliente enemigo
                            jugadorAtacado.salidaObject.writeUTF(this.nameJugador+"> Está Atacando "+
                                    " en las posiciones: "+posiAtaque.toString());
                            jugadorAtacado.salidaObject.flush();
                            System.out.println("Se envió mensaje");
                            jugadorAtacado.salidaObject.writeInt(opcion);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeObject(posiAtaque);
                            jugadorAtacado.salidaObject.flush();
                            jugadorAtacado.salidaObject.writeInt(this.numJugador);
                            jugadorAtacado.salidaObject.flush();
                            contadorBB++;
                            if (contadorBB==10) {
                                server.cambiarTurno();
                                contadorBB=0;
                            }
                            
                        }

                    } catch (ClassNotFoundException ex) {}
                        
                 break;
                 case 20:
                 {
                     try {
                        Posiciones resPosiciones=(Posiciones)entradaObject.readObject();
                        int numJugadorAtacante=entradaObject.readInt();
                        //int tipoAtaque=entradaObject.readInt();
                        threadServer jugadorAtacante=null;
                        for (threadServer enemigo : listaEnemigo) {
                            if (enemigo.numJugador==numJugadorAtacante){
                                jugadorAtacante=enemigo;
                            }
                        }
                        jugadorAtacante.salidaObject.writeInt(20);
                        jugadorAtacante.salidaObject.flush();
                        jugadorAtacante.salidaObject.writeObject(resPosiciones);
                        jugadorAtacante.salidaObject.flush();
                        jugadorAtacante.salidaObject.writeInt(this.numJugador);
                        jugadorAtacante.salidaObject.flush(); 
//                        jugadorAtacante.salidaObject.writeInt(opcion);
//                        jugadorAtacante.salidaObject.flush();
                        
                     } catch (ClassNotFoundException ex) {}
                 }
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
