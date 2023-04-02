package conjunto;

import java.util.Arrays;

public class ConjuntoOrdenadoEnteros {

    private int[] conjunto;
    private int elementos;

    public ConjuntoOrdenadoEnteros() {
        this(100);      
    }

    public ConjuntoOrdenadoEnteros(int capacidad) {
        this.conjunto = new int[capacidad];
        this.elementos = 0;

    }

    public ConjuntoOrdenadoEnteros(ConjuntoOrdenadoEnteros c) {
        this(c.elementos);
        this.elementos = c.elementos;

        for (int i = 0; i < this.elementos; i++) {
            this.conjunto[i] = c.conjunto[i];
        }
    }

    public void add(int valor) {
        addWithCapacity(valor, 10);

    }

    public void add(ConjuntoOrdenadoEnteros c) {

        for(int i=0;i<c.elementos;i++){
            addWithCapacity(c.conjunto[i],1);
            
        }

    }

    public int search(int valor) {
        boolean encontrado = false;
        int indice = 0, posicion = -1;

        while (!encontrado && indice < this.elementos) {
            if (this.conjunto[indice] == valor) {
                encontrado = true;
                posicion = indice;
            }
            indice++;
        }
        return posicion;
    }

    public int del(int posicion) {
        if (posicion >= this.elementos) {
            throw new IllegalArgumentException("El elemento no existe");
        }
        int valor = this.conjunto[posicion];
        //compactar
        for (int i = posicion; i < this.elementos - 1; i++) {
            this.conjunto[i] = this.conjunto[i + 1];
        }
        this.conjunto[elementos - 1] = 0;
        this.elementos--;

        return valor;
    }

    public ConjuntoOrdenadoEnteros subconjunto(int indiceInicial, int indiceFinal) {
        int elementosSubconjunto = indiceFinal - indiceInicial;

        if (elementosSubconjunto <= 0 || indiceInicial > this.elementos - 1 || indiceFinal > this.elementos) {
            throw new IllegalArgumentException("Los índices del subconjunto no son válidos");
        }

        ConjuntoOrdenadoEnteros subconjunto = new ConjuntoOrdenadoEnteros(elementosSubconjunto);
        subconjunto.elementos = elementosSubconjunto;
        for (int i = 0; i < subconjunto.elementos; i++) {
            subconjunto.conjunto[i] = this.conjunto[indiceInicial+i];
        }

        return subconjunto;

    }
    
    @Override
    public String toString(){
        StringBuilder cadena = new StringBuilder("Contenido Conjunto Ordenado\n-----------------------\n");
        cadena.append("Capacidad: "+this.conjunto.length+"\n");
        cadena.append("Nº elementos: "+this.elementos+"\n");
        cadena.append("Conjunto: "+Arrays.toString(this.conjunto)+"\n");
        return cadena.toString();
    }

    private int posicionInsercion(int valor){
        boolean encontrado = false;
        int indice = 0, posicion = -1;

        while (!encontrado && indice < this.elementos) {
            if (this.conjunto[indice] < valor) {
                indice++;
            } else if (this.conjunto[indice] == valor){
                encontrado = true;
            } else {
                posicion = indice;
                encontrado = true;
            }
            
        }
        if(indice==this.elementos){
            posicion = this.elementos;
        }
        return posicion;
    }

    private void aumentarCapacidad(int aumento) {
        this.conjunto = Arrays.copyOf(this.conjunto, this.conjunto.length+aumento);
    }
    
    private void addWithCapacity(int valor, int aumento){
        int posicion = posicionInsercion(valor);
        //System.out.println("posicion: "+posicion);
        if(posicion!=-1){
            if(this.elementos==this.conjunto.length){
                //añadir capacidad
                aumentarCapacidad(aumento);
            }
            //desplazamos a la derecha para hacer hueco
            for(int i=this.elementos-1;i>=posicion;i--){
                this.conjunto[i+1]= this.conjunto[i];
            }
            
           this.conjunto[posicion] = valor;
           this.elementos++;
            
        }        
  
    }
    
}
