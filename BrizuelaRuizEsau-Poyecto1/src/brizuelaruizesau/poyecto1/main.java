/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brizuelaruizesau.poyecto1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author esau brizueka
 * 
 * Este proyecto se elabora usando una LinkedList que contiene String.
 *  La implementacion se hace una simulacion de STACK o PILA haciendo uso de LIFO
 *  No se usan todos metodos que tiene la coleccion predeterminada, para el agregar, eliminar,mostrar los objetos que contiene
 *  la coleccion.
 *  Tampoco se hace de forma direca el uso de los metodos de STACK que permite usarse en las LinkedList
 */
public class main {

   
    public static void main(String[] args) {
       LinkedList <String> lista;
        lista = new LinkedList<String>();

        char op2 = 0;
       
        int opcion = 0;
        int p = 0;

        try{
           do{
                System.out.flush();
                opcion = OpcionMenu();
                Scanner entrada = new Scanner(System.in);  
                
                switch(opcion){
                    
                    case 1:
                        
                            String nombre = null;  
                            System.out.println("Digite por favor un Nombre\n");
                            nombre = entrada.nextLine();
                             
                          
                             AgregaItem(lista,nombre);
                             
                           

                        break;
                        
                    case 2:
                        ExtraeItem(lista);
                        
                        break;
                        
                    case 3:
                        ObtieneItem(lista, 0);                   
                        
                        break;
                        
                    case 4:
                         p = lista.size() -1;
                        ObtieneItem(lista,p);                   
                        break;
                        
                    case 5:
                       
                        System.out.println("Elementos Posibles:  " + lista.size()+"  Indique la posicion del elemento que desea mostrar: " );
                        p = entrada.nextInt();
                        ObtieneItem(lista,p-1);
                        break;
                        
                    case 6:
                        
                        
                        System.out.println((lista.isEmpty())?"\nSI":"\nNO");
                        break;
                        
                    case 7:
                         if(lista.isEmpty()){
                            
                            System.out.println("La lista no contiene Objetos, por favor realice otra accion");
                        } else{
                        
                              System.out.println("El numero de elementos de la pila es: " + lista.size());                            
                         }
                        break;
                        
                        
                    case 8:
                        
                        if(lista.isEmpty()){
                            
                            System.out.println("La lista no contiene Objetos, por favor realice otra accion");
                        } else{
                        
                            System.out.println("Lista de Elementos Contenidos en la PILA\n");
                            int cont=1;
                            for(String str : lista){
                                System.out.println(cont +"--"+ str + "\n");  
                                cont++;
                            }
                        }
                        
                        break;
                        
                    case 9:
                        lista.clear();
                        
                        System.out.println((lista.isEmpty())? "\nSe Ejecuto la limpieza de forma satisfactoria":"Error no se logro ejecutar lo solicitado")   ;                    
                      
                        
                        break;
                        
                    case 10:
                        
                        System.exit(0);
                        
                        default:
                            System.out.println("LA OPCION DIGITADA NO ES VALIDA");
                            break;
                }
                  System.out.println("Desea realizar otra operacion? (S/N)\n");
                                 op2 = entrada.next().charAt(0);
                                 
                             
                                 
                            
               
              }  while(Character.toUpperCase(op2)=='S');
           

        }catch(Exception e){
          
          System.out.println(e.getLocalizedMessage());
                  
         }   
        
        
    }
    
    
    //Menu de opciones
    
    public static int OpcionMenu(){
        int resultado ;
        Scanner entrada = new Scanner(System.in);
        
        try {
            
        
        
        
            String menu= "Sistema de Manejo de PILAS usando LinkedList \n\n";
        
            menu+= "1 - Insertar elemento a la PILA \n";
            menu+= "2 - Extraer elemento de la PILA\n";
            menu+= "3 - Obtener el primer elemento de la PILA\n";
            menu+= "4 - Obtener el ultimo elemento de la PILA\n";
            menu+= "5 - Digite la posicion del elemento que quiere visualizar \n";
            menu+= "6 - Valide si la PILA esta vacia \n";
            menu+= "7 - Imprime cantidad de elementos que contiene la PILA\n";
            menu+= "8 - Imprima todos los elementos de que contiene la PILA \n";
            menu+= "9 - Vacia la PILA \n";
            menu+= "10 - Salir";
        
                System.out.println(menu);

            
       } catch (Exception e){
           
            System.out.println(e.getMessage());
        }
       resultado = entrada.nextInt();
        return resultado ;

    }
    
    //Agrega los items siempre a la primer posicion, esto para mantener el concepto de PILA..
    //No se hace uso del metodo addFirst() de la lista enlazada, si no que se maneja por indice
    public static void AgregaItem(LinkedList <String> obj, String str){
       
        try{
            
            if(obj.isEmpty()){
                
                obj.add(str);
                                
            } else {
                
                obj.add(0,str);
             
                }
            
        }catch(Exception e){
          
          System.out.println(e.getLocalizedMessage());
                  
       }
       
    }
    
    //Extrae el primer elemento y lo elimina de la PILA,esto mediante el manejo del indice
     public static void ExtraeItem(LinkedList <String> obj){

        try{
            
            System.out.println("Se va a extraer el elemento"+ obj.get(0));
            obj.remove(0);

      }catch(Exception e){
          
          System.out.println(e.getLocalizedMessage());
                  
                  }
       
    }
     
     /*
        Este metodo va a manejar las opciones
        3 - Obtener el primer elemento de la PILA
        4 - Obtener el ultimo elemento de la PILA
        5 - Digite la posicion del elemento que quiere visualizar
         Su funcionalidad es obtener el objeto que se le indique mediante las opciones antes mencionadas*/
     public static void ObtieneItem(LinkedList<String> obj, int pos){

        try{
       
            if(obj.isEmpty()){
                
                 System.out.println("La Pila se encuentra vacia, por favor revise su solicitud");
          
                                
            } else if(pos==0) {
                
                   System.out.println("El primer elemento de la PILA es "+ obj.get(pos).toString());
                   
                    
                } else if(pos==obj.size()-1){
                    
                    System.out.println("El ultimo elemento de la PILA es  "+ obj.get(pos).toString());
                } else{
                    
                     System.out.println("El elemento solicitado de la PILA es  "+ obj.get(pos).toString());
                }
           

      }catch(Exception e){
          
          System.out.println(e.getLocalizedMessage());
                  
                  }
       
    }
     

    
}
