package conjunto;

public class Conjunto {

    public static void main(String[] args) {

        ConjuntoOrdenadoEnteros c1 = new ConjuntoOrdenadoEnteros(5);

        System.out.println(c1);

        c1.add(2);
        c1.add(10);
        c1.add(8);
        c1.add(6);
        c1.add(3);

        System.out.println(c1);

        //Prueba de añadir un conjunto a otro;
        ConjuntoOrdenadoEnteros c2 = new ConjuntoOrdenadoEnteros(4);
        c2.add(8);
        c2.add(4);
        c2.add(1);
        c2.add(20);
        
        c1.add(c2);
        System.out.println(c1);

        //Prueba de búsqueda:
        System.out.println("Buscamos el valor 9: "+c1.search(9));
        
        //Prueba de eliminación
        int eliminado=c1.del(1);
        System.out.println("Valor eliminado:"+eliminado);
        System.out.println(c1);
        
        
        //Prueba de subconjunto
        
        ConjuntoOrdenadoEnteros c3 = c1.subconjunto(1,3);
        System.out.println("Mostramos el subconjunto");
        System.out.println(c3);
    }

}
