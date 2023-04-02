
package tiradadados;

import java.util.Arrays;


public class TiradaDados {


    public static void main(String[] args) {
        int [] noValido1 = {1,2,3};
        int [] noValido2 = {1,3,4,5,6,6};
        int [] noValido3 = {1,2,3,4,0};
        int [] repoker = {1,1,1,1,1};
        int [] poker = {1,2,2,2,2};
        int [] full = {1,2,2,1,1};
        int [] trio = {1,2,2,2,3};
        int [] dobles = {1,2,2,4,4};
        int [] pareja = {1,2,2,3,6};
        int [] nada = {1,2,4,3,5};
        
        System.out.println(calcularTiradaDados(noValido1));
        System.out.println(calcularTiradaDados(noValido2));
        System.out.println(calcularTiradaDados(noValido3));
        System.out.println(calcularTiradaDados(repoker));
        System.out.println(calcularTiradaDados(poker));
        System.out.println(calcularTiradaDados(full));
        System.out.println(calcularTiradaDados(trio));
        System.out.println(calcularTiradaDados(dobles));
        System.out.println(calcularTiradaDados(pareja));
        System.out.println(calcularTiradaDados(nada));
        
        
    }
    
    public static int calcularTiradaDados(int [] tirada){
        if(!validarTirada(tirada)){
            return -1;
            
        }
        
        //Contamos cada uno de los valores de los dados
        int [] repeticiones = new int[6];
        for(int dado:tirada){
            repeticiones[dado-1]++;
        }
            
        Arrays.sort(repeticiones);
        
        //Comprobamos la tirada
        int valorTirada=0;
        if(repeticiones[5]==5){
            valorTirada=6;
        }else if(repeticiones[5]==4){
            valorTirada=5;
        }else if(repeticiones[5]==3 && repeticiones[4]==2){
            valorTirada=4;
        }else if(repeticiones[5]==3){
            valorTirada=3;
        }else if(repeticiones[5]==2 && repeticiones[4]==2){
            valorTirada=2;
        }else if(repeticiones[5]==2){
            valorTirada=1;
        }
    
        return valorTirada;
    }

    private static boolean validarTirada(int[] tirada) {
        boolean tiradaValida=true;
        if(tirada.length!=5){
            tiradaValida=false;
        }
        
        for(int i=0;i<tirada.length && tiradaValida; i++){
            if(tirada[i]<1 || tirada[i]>6){
                tiradaValida=false;
            }
        }
     
        return tiradaValida;
    }
    
}
