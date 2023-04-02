
package cribaeratostenes;

import java.util.Arrays;


public class CribaEratostenes {


    public static void main(String[] args) {

        int n = 100;
        
        boolean [] criba = cribaEratostenes(n);
        int [] numerosPrimos = nPrimosEratostenes(criba);
        
        System.out.println(Arrays.toString(numerosPrimos));
    }
    
    public static boolean [] cribaEratostenes(int n){
        if(n<3){
            throw new IllegalArgumentException("n debe ser al menos 3");
        }
        
        boolean criba[] = new boolean[n];
        Arrays.fill(criba, true);
        criba[0]=false;
        criba[1]=false;
        
        for(int i=2;i*i <= n; i++){
            if(criba[i]){
                for(int j=i*2;j<criba.length;j+=i){
                    criba[j]=false;
                } 
            }
        }
        
        return criba; 
    }
    
    public static int[] nPrimosEratostenes(boolean [] criba){
        int cantidadPrimos=0;
        
        for(boolean esPrimo:criba){
            if(esPrimo){
                cantidadPrimos++;
            }
        }
        
        int [] primos = new int[cantidadPrimos];
        int posicionPrimo=0;
        for(int i=0;i<criba.length;i++){
            if(criba[i]){
                primos[posicionPrimo]=i;
                posicionPrimo++;
            }
        }
        
        return primos;
    }
    
}
