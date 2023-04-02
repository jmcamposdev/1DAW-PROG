
package desplazar;

import java.util.Arrays;


public class Desplazar {


    public static void main(String[] args) {
        int [] array1 = {3,4,5,6,7};
        
        rotarIzquierda(array1,4);
        System.out.println(Arrays.toString(array1));
        
        int [][] matriz = {{1,2,3},{4,5,6},{7,8,9}};
        desplazarFilas(matriz);
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    
    public static void rotarIzquierda(int [] elementos, int n){
        if(n<0){
            throw new IllegalArgumentException("El valor de n debe ser mayor o igual que 0");
        }
        int aux = n%elementos.length;
        
        //IMPLEMENTACIÓN ROTANDO 1 N VECES
//        for(int i=0;i<aux;i++){
//            rotarIzquierda1(elementos);
//        }
        int [] elementosAMover = Arrays.copyOfRange(elementos, 0, n);
        //System.out.println(Arrays.toString(elementosAMover));
        System.arraycopy(elementos, n, elementos, 0, elementos.length-n);
        //System.out.println(Arrays.toString(elementos));
        System.arraycopy(elementosAMover, 0, elementos, elementos.length-n, n);
    }
    
    public static void desplazarFilas(int [][] matriz){
        if(matriz.length!=matriz[0].length){
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }
        
        for(int i=1;i<matriz.length;i++){
            rotarIzquierda(matriz[i],i);
        } 
    }

    private static void rotarIzquierda1(int[] elementos) {
        int primerElemento = elementos[0];
        for(int i=0;i<elementos.length-1;i++){
            elementos[i]=elementos[i+1];
        }
        elementos[elementos.length-1]=primerElemento;   
    }
}
