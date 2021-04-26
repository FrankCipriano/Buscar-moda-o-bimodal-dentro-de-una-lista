/*8.	Escriba una función que reciba como parámetro un listado de números, la función debe retornar la moda de la lista, tomando en cuenta lo siguiente:
a)	La moda es el número que más veces se repite en la lista
b)	Si el número máximo de repeticiones lo tienen 2 números diferentes, la función tendrá que retornar que la lista es “bimodal” y los números que le corresponden
c)	Si el número máximo de repeticiones lo tienen 3 o más números diferentes, la función debe retornar que “no tiene moda” 
*/


package exam8;

import java.util.ArrayList;


public class ListaMain {

  public static void main(String[] args) {
   ArrayList<Lista> lista = new ArrayList();
   Lista Listado = new Lista();
   Listado.ingresar(lista);
   Listado.buscar_moda(lista);
   Listado.mostrar_candidatos();
  }
}
