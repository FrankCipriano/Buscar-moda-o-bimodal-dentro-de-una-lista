package exam8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Lista {
  private int numero,contador,c=1,moda;
  private Hashtable<Integer,Integer> tabla = new Hashtable();
  public Lista(){
    
  } 
  public Lista(int numero){
    this.numero=numero;
  }
  
  public int getNumero(){
    return numero;
  }
  
  public void setNumero(int numero){
    this.numero=numero;
  }
  
  public void ingresar(ArrayList<Lista> lista){
    System.out.println("Armando la Lista.....");
    Scanner leer = new Scanner(System.in);
    for(int i=0;i<10;i++){
      System.out.println("Ingrese cantidad:");
      Lista elemento = new Lista(leer.nextInt());
      lista.add(elemento);
    }
    ordenar_lista(lista);
  }
  //ordenamiento SHELL
  public void ordenar_lista(ArrayList<Lista> lista){
  Lista uno = new Lista(1);
  Lista dos = new Lista(2);
  Lista n = new Lista(lista.size());
   for(int i=0;i<lista.size();i++){
   Lista salto = new Lista(lista.size()+i);
   while(salto.mayor(uno)){
     salto.dividir(dos);
     Lista bandera = new Lista(1);
     while(bandera.equals(uno)){
       bandera.setNumero(0);
       i=0;
       Lista posicion = new Lista(salto.getNumero()+i);
      while(posicion.menor(n)){
      Lista actual = lista.get(i);
      Lista sgte = lista.get(salto.getNumero()+i);
      if(actual.mayor(sgte)){
        lista.set(i,sgte);
        lista.set(salto.getNumero()+i,actual);
        bandera.setNumero(1);
      }
      i++;
      posicion.setNumero(salto.getNumero()+i);
      }
     }
   }
   }
   System.out.println("Lista ordenada:\n"+lista);
  }
  
  public void buscar_moda(ArrayList<Lista> lista){
  Lista anterior = new Lista();
  Lista presente = new Lista();
  Lista adelante = new Lista();
    for(int i=0;i<lista.size()-1;i++){
    Lista actual = lista.get(i);
    presente.setNumero(actual.getNumero());
    Lista sgte = lista.get(i+1);
    adelante.setNumero(sgte.getNumero());
      if(presente.equals(adelante)){
      c++;
     }else{
     capturar_moda(presente,anterior);
     }
    }
    capturar_moda(presente,anterior);
  }
  
  public void capturar_moda(Lista presente, Lista anterior){
     if(c>1){
       if(tabla.size()>0){
         contador = tabla.get(anterior.getNumero());
         if(c>contador){
           tabla.clear();
           reiniciar_valores(presente,anterior);
         }else if(c==contador){
         reiniciar_valores(presente,anterior);
         }else{
           c=1;
         }
       }else{
       reiniciar_valores(presente,anterior);
         }
       }
  }
  
  public void reiniciar_valores(Lista presente,Lista anterior){
    tabla.put(presente.getNumero(),c);
    c=1;
    anterior.setNumero(presente.getNumero());
  }

  public void mostrar_candidatos(){
  System.out.println("Elementos capturados para la moda:");
    System.out.println(tabla);
    moda=tabla.size();
    System.out.println();
    switch(moda){
      case 1: System.out.println("La moda de la lista es: "+tabla);
      break;
      case 2: System.out.println("La lista es bimodal");
      break;
      default :System.out.println("La lista ingresada no tiene moda");
    }
  }
  
  public void aumentar(Lista uno){
    this.numero = this.numero+uno.getNumero();
  }
  
  public boolean menor(Lista n){
    if(this.numero<n.getNumero()){
      return true;
    }else{
      return false;
    }
  }
  
  public boolean equals(Lista uno){
    if(this.numero==uno.getNumero()){
      return true;
    }else{
      return false;
    }
  }
  
  public int dividir(Lista dos){
    this.numero = this.numero/dos.getNumero();
    return numero;
  }
  
  public boolean mayor(Lista uno){
    if(this.numero>uno.getNumero()){
      return true;
    }else{
      return false;
    }
  }
  
  public String toString(){
    return String.format("%s",this.numero);
  }
}
