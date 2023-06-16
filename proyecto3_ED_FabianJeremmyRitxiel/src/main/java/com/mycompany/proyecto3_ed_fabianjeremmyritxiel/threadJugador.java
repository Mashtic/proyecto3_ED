/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto3_ed_fabianjeremmyritxiel;
import java.io.*;
import java.util.Random;
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
                                 //DAÑA O ELIMINA ESTRUCTURA
                                 //coordenada.acerto=true
                                 //para todod 
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
//                         ventana.jugador.salidaObject.writeInt(opcion); 
//                         ventana.jugador.salidaObject.flush();
                     } catch (ClassNotFoundException ex) {}
                 }
                break;
                case 8:
                 {
                     try {
                         Posiciones posiAtaque=(Posiciones)entrada.readObject();
                         int numJugadorAtacando=entrada.readInt();
                         Posiciones posiCopia=new Posiciones();
                         for (Coordenada cord : posiAtaque.listaCoordenada) {
                             if(ventana.tableroLogico[cord.getX()][cord.getY()]!=0){
                                 cord.setAcerto(true);
                                 posiCopia.listaCoordenada.add(cord);
                                 for (int i = 0; i < 4; i++) {
                                    int x=(new Random()).nextInt(20);
                                    int y=(new Random()).nextInt(20);
                                    Coordenada cordN= new Coordenada(x,y);
                                    posiCopia.listaCoordenada.add(cordN);
                                 }
                                 for (Coordenada coordenada : posiCopia.listaCoordenada) {
                                    if(ventana.tableroLogico[coordenada.getX()][coordenada.getY()]!=0){
                                        coordenada.setAcerto(true);
                                    }
                                 }
                                 //DAÑA O ELIMINA ESTRUCTURA
                                 //coordenada.acerto=true
                                 //para todod 
                            }
                             else{
                                 posiCopia.listaCoordenada.add(cord);
                             }
                             ventana.marcar(cord);
                         }
                         ventana.mostrarAtaque("RECIBIDO: "+posiCopia.toStringAtaque());
                         ventana.jugador.salidaObject.writeInt(1);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeUTF("ATAQUE: "+posiCopia.toStringAtaque());
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeInt(numJugadorAtacando);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeInt(20);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeObject(posiCopia);
                         ventana.jugador.salidaObject.flush();
                         ventana.jugador.salidaObject.writeInt(numJugadorAtacando); 
                         ventana.jugador.salidaObject.flush();
//                         ventana.jugador.salidaObject.writeInt(opcion); 
//                         ventana.jugador.salidaObject.flush();
                     } catch (ClassNotFoundException ex) {}
                 }
                break;
                case 9:
                 {
                     try {
                         Posiciones posiAtaque=(Posiciones)entrada.readObject();
                         int numJugadorAtacando=entrada.readInt();
                         for (Coordenada cord : posiAtaque.listaCoordenada) {
                             if(ventana.tableroLogico[cord.getX()][cord.getY()]!=0){
                                 cord.setAcerto(true);
                                 //DAÑA O ELIMINA ESTRUCTURA
                                 //coordenada.acerto=true
                                 //para todod 
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
//                         ventana.jugador.salidaObject.writeInt(opcion); 
//                         ventana.jugador.salidaObject.flush();
                     } catch (ClassNotFoundException ex) {}
                 }
                break;
                case 10:
                 {
                     try {
                         Posiciones posiAtaque=(Posiciones)entrada.readObject();
                         int numJugadorAtacando=entrada.readInt();
                         for (Coordenada cord : posiAtaque.listaCoordenada) {
                             if(ventana.tableroLogico[cord.getX()][cord.getY()]!=0){
                                 cord.setAcerto(true);
                                 //DAÑA O ELIMINA ESTRUCTURA
                                 //coordenada.acerto=true
                                 //para todod 
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
//                         ventana.jugador.salidaObject.writeInt(opcion); 
//                         ventana.jugador.salidaObject.flush();
                     } catch (ClassNotFoundException ex) {}
                 }
                break;
                case 17:
                    ventana.mostrar("HOLIIIIIIIIIIIIIIIIIIIIIII");
                break;
                case 20:
                 {
                     try {
                         Posiciones resPosi=(Posiciones)entrada.readObject();
                         int jugadorAtacado=entrada.readInt();
//                         int tipoAtaque=entrada.readInt();
                         switch (jugadorAtacado) {
                             case 1:
                                for (Coordenada posiRes : resPosi.listaCoordenada) {
                                    if (posiRes.isAcerto()){
                                        ventana.tableroLogicoEnemigo1[posiRes.getX()][posiRes.getY()]=7;
                                    }
                                    else{
                                        ventana.tableroLogicoEnemigo1[posiRes.getX()][posiRes.getY()]=20;
                                    }
                                }
                                 ventana.pintarTableroAtaque(1);
                                 break;
                            case 2:
                                for (Coordenada posiRes : resPosi.listaCoordenada) {
                                    if (posiRes.isAcerto()){
                                        ventana.tableroLogicoEnemigo2[posiRes.getX()][posiRes.getY()]=7;
                                    }    
                                    else{
                                        ventana.tableroLogicoEnemigo2[posiRes.getX()][posiRes.getY()]=20;
                                    }
                                }
                                 ventana.pintarTableroAtaque(2);
                                 break;
                            case 3:
                                for (Coordenada posiRes : resPosi.listaCoordenada) {
                                    if (posiRes.isAcerto()){
                                        ventana.tableroLogicoEnemigo3[posiRes.getX()][posiRes.getY()]=7;
                                    }    
                                    else{
                                        ventana.tableroLogicoEnemigo3[posiRes.getX()][posiRes.getY()]=20;
                                    }
                                }
                                 ventana.pintarTableroAtaque(3);
                                 break;
                            case 4:
                                for (Coordenada posiRes : resPosi.listaCoordenada) {
                                    if (posiRes.isAcerto()){
                                        ventana.tableroLogicoEnemigo4[posiRes.getX()][posiRes.getY()]=7;
                                    }  
                                    else{
                                        ventana.tableroLogicoEnemigo4[posiRes.getX()][posiRes.getY()]=20;
                                    }
                                }
                                 ventana.pintarTableroAtaque(4);
                                 break;
                                 
                             default:
                                 throw new AssertionError();
                         }
//                         switch (tipoAtaque) {
//                             case 7:
//                                 ventana.cantCanon--;
//                                 ventana.setearLabels();
//                                 break;
//                             case 8:
//                                 ventana.cantCanonM--;
//                                 ventana.setearLabels();
//                                 break;
//                             case 9:
//                                 ventana.cantBomba--;
//                                 ventana.setearLabels();
//                                 break;
//                             case 10:
//                                 ventana.cantCanonBB--;
//                                 ventana.setearLabels();
//                                 break;
//                             case 11:
//                                 ventana.cantBarcoF--;
//                                 ventana.setearLabels();
//                                 break;
//                             case 12:
//                                 ventana.cantKraken--;
//                                 ventana.setearLabels();
//                                 break;
//                             case 13:
//                                 ventana.cantEscudo--;
//                                 ventana.setearLabels();
//                                 break;
//                             default:
//                                 throw new AssertionError();
//                         }
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
