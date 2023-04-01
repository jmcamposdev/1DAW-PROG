package poo.EjerciciosSencillos_2.NIF;
import java.util.Scanner;


public class NIF {
    private int numeroDNI;
    private char letra;
    private static char[] descodificarLetra = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};


    /*-----------------------
       Constructores
   -----------------------*/
    public NIF(){
        this(0);
        this.letra = ' ';
    }
    public NIF(int numeroDNI){
        if (!validarNumero(numeroDNI)){
            throw new IllegalArgumentException("El número del DNI debe de ser positivo");
        }
        this.numeroDNI = numeroDNI;
        this.letra = calcularLetra(this.numeroDNI);
    }

    /*-----------------------
       Getters and Setter
   -----------------------*/

    public int getNumeroDNI() {
        return numeroDNI;
    }
    public void setNumeroDNI(int numeroDNI) {
        if (validarNumero(numeroDNI))
            this.numeroDNI = numeroDNI;
    }

    public char getLetra() {
        return letra;
    }

    /*-----------------------
            Métodos
        -----------------------*/
    private char calcularLetra(int numeroDNI){
        int codigoLetra = numeroDNI%23;
        return descodificarLetra[codigoLetra];
    }
    public void leer(){
        Scanner sc = new Scanner(System.in);
        int numeroDNI;
        System.out.print("Ingrese el número del DNI: ");
        numeroDNI = sc.nextInt();
        if (!validarNumero(numeroDNI)){
            throw new IllegalArgumentException("El número del DNI debe de ser positivo");
        }
        this.numeroDNI = numeroDNI;
        this.letra = calcularLetra(this.numeroDNI);

    }

    /*-----------------------
        Overrides
    -----------------------*/

    @Override
    public String toString() {
        String numero = String.valueOf(this.numeroDNI);
        int longitudNumero = 8-numero.length();
        for (int i = 0; i < longitudNumero; i++) {
            numero = "0"+numero;
        }
        return numero+"-"+this.letra;
    }

    /*-----------------------
            Validación
        -----------------------*/
    private boolean validarNumero(int numeroDNI){
        return numeroDNI >= 0 && numeroDNI <= 99999999;
    }
}
