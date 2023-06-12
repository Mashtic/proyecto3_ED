/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto3_ed_fabianjeremmyritxiel;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fabia
 */
public class threadJugador extends Thread{
    //solo de lectura
   ObjectInputStream entrada;
   VentanaJugador ventana; //referencia acliente
   public threadJugador (ObjectInputStream entrada,VentanaJugador vPlayer) throws IOException
   {
      this.entrada=entrada;
      this.ventana=vPlayer;
   }
   @Override
   public void run()
   {
       //VARIABLES
      String menser="",amigo="",mensajeAtaque="", mensajeEnviar="";
      int opcion=0;
      
      // solamente lee lo que el servidor threadServidor le envia
      while(true)
      {         
         try{
             // esta leyendo siempre la instruccion, un int
             opcion=entrada.readInt();
            
            switch(opcion)
            {
               case 1:
                   mensajeAtaque=entrada.readUTF();
                   ventana.mostrarAtaque(mensajeAtaque);
//                     try {
//                         //mensaje enviado
//                         Carta carta= (Carta)entrada.readObject();
//                         vPlayer.setIconDescarte();
//                     } catch (ClassNotFoundException ex) {}
//                  int col = entrada.readInt();//lee columna
//                  int fila = entrada.readInt();//lee fila
//                  // llama a marcar, que es lo que hace el cliente cuando
//                  // el enemigo marco la sailla
//                  vcli.marcar(col,fila);
                    System.out.println("Se escogio opcion 1");
//                  
                    break;

               case 2://se lee el nombre del user  
//                   try {
//                         //mensaje enviado
//                        Carta carta= (Carta)entrada.readObject();
//                        for (int i = 0; i <4; i++) {
//                          vPlayer.jugador.mazo.addCard(vPlayer.mazoJ.comer()); 
//                        }
//                        vPlayer.resetIconImages();
//                        vPlayer.setIconsButtons();
//                        vPlayer.setIconDescarte();
//                        } catch (ClassNotFoundException ex) {}               
                    break;
               case 3://lee el numero del jugador
//                  vcli.numeroJugador = entrada.readInt();
//                  // lee el nomnre del enemigo vuando pide el status y lo coloca
//                  // en la pantalla cliente
//                  vcli.setEnemigo(entrada.readUTF());
                    System.out.println("Se escogio opcion 3");
                  break;
                case 4:
                    // lee el mensaje
                    menser = entrada.readUTF();
                    // muestra el mensjae en pantalla.
                    ventana.mostrar(menser);
                    System.out.println("Se escogio opcion 4");
                break;
                
                case 5:
//                     // lee la columna
//                     int col1 = entrada.readInt();
//                     // lee la fila
//                     int fil1 = entrada.readInt();
//                     // hace el emtodo cliente para generar bomba
//                     vcli.bomba(col1,fil1);
//                     
                     System.out.println("Se escogio opcion 5");
                 break;
                 
                case 7:
                 {
                    
                     try {
                         Posiciones posiAtaque=(Posiciones)entrada.readObject();
                         int numJugadorAtacando=entrada.readInt();
                         for (Coordenada cord : posiAtaque.listaCoordenada) {
                             if(ventana.tableroLogico[cord.getX()][cord.getY()]!=0){
                                 cord.setAcerto(true);
                             }
                             ventana.marcar(cord);
                         }
                         ventana.mostrarAtaque("RECIBIDO: "+posiAtaque.toStringAtaque());
                         ventana.jugador.salidaObject.writeInt(1);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeUTF("ATAQUE: "+posiAtaque.toStringAtaque());
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeInt(numJugadorAtacando);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeInt(20);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeObject(posiAtaque);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeInt(numJugadorAtacando); 
                         ventana.jugador.salidaObject.flush();
                     } catch (ClassNotFoundException ex) {}
                 }
                break;
                case 20:
                 {
                     try {
                         Posiciones resPosi=(Posiciones)entrada.readObject();
                         
                     } catch (ClassNotFoundException ex) {}
                 }
                break;


                    
            }
         }
         catch (IOException e){
            System.out.println("Error en la comunicaci�n "+"Informaci�n para el usuario");
            break;
         }
      }
      System.out.println("se desconecto el servidor");
   }
}
