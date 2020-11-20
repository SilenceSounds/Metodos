//Yerik Jael Morales Avalos 2771124
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {

    /**
     * @param args the command line arguments
     */
    
    static List<String> List = new ArrayList<>();
    
    public static void main(String[] args) {
        List.add("Yerik");
        List.add("Angel");
        List.add("Juan");
        List.add("Carlos");
        List.add("Merlin");
        List.add("Sayad");
        List.add("Silence");
        List.add("Prometeo");
        List.add("Avalos");
        List.add("Xantel");
        
        
        System.out.println("Lista Original:");
        List.forEach(value -> System.out.println(value));
        
        //Clase Anonima
        AnonClass AnonC = new AnonClass(){
            @Override
            public void OrdenLon(List<String> lista){
                Collections.sort(lista, (String o1, String o2) -> {
                int result;
                if (o1.length()>o2.length()){
                    result = 1;
                } else if (o1.length()<o2.length()){
                    result = -1;
                } else {
                    result = 0;
                }
                return result;
                });
            }
            @Override
            public void OrdenABC(List<String>lista){
                Collections.sort(lista, (String s1, String s2) -> 
                        s1.compareTo(s2));
            }

        };
        
        //Clase Anónima (Alfabéticamente)
        AnonC.OrdenABC(List);
        System.out.println();
        System.out.println("Por orden alfabetico: Clase Anónima");
        List.forEach(str -> System.out.println(str));
        
        //Clase Anónima (Longitud)
        AnonC.OrdenLon(List);
        System.out.println();
        System.out.println("Por Longitud: Clase Anónima");
        List.forEach(str -> System.out.println(str));

        //Alfabeticamente (Expresion Lambda)
        Collections.sort(List, (String s1, String s2) -> s1.compareTo(s2));
        System.out.println();
        System.out.println("Por orden alfabetico: Expresion Lambda");
        List.forEach(str -> System.out.println(str));
        
        //Longitud (Expresion Lambda)
        Collections.sort(List, (String o1, String o2) -> {
            int result;
            if (o1.length()>o2.length()){
                result = 1;
            } else if (o1.length()<o2.length()){
                result = -1;
            } else {
                result = 0;
            }
            return result;
        });
        
        System.out.println();
        System.out.println("Por longitud: Expresión Lambda");
        List.forEach(str -> System.out.println(str));
        
        
        //Alfabeticamente (Metodo de referencia)
        OrderList ABC = Lambda::OrdenamientoABC;
        Collections.sort(List, String::compareTo);
        System.out.println();
        System.out.println("Por orden Alfabetico: Metodo de referencia");
        List.forEach(str -> System.out.println(str));        
        
        //Longitud (Metodo de referencia)
        OrderList Long = Lambda::OrdenamientoLong;
        Long.order(List);
        System.out.println();
        System.out.println("Por Longitud: Metodo de referencia");
        List.forEach(str -> System.out.println(str));
        
        
    }
    
    
    //Metodo para ordenar por longitud por referencia
    public static void OrdenamientoLong(List<String> lista){
        Collections.sort(lista, (String o1, String o2) -> {
            int result;
            if (o1.length()>o2.length()){
                result = 1;
            } else if (o1.length()<o2.length()){
                result = -1;
            } else {
                result = 0;
            }
            return result;
        });
    }
    
    //Metodo para ordenar alfabeticamente por referencia
    public static void OrdenamientoABC(List<String>lista){
        Collections.sort(lista, (String s1, String s2) -> s1.compareTo(s2));
    }
    
    @FunctionalInterface
    interface OrderList {
        void order(List<String> lista);
    }
    
    
    interface AnonClass{
        public void OrdenLon(List<String> lista);
        public void OrdenABC(List<String>lista);
    }
    


}
    
    
 
    
    

    

