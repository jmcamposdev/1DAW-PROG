package poo.EjerciciosLibro.TarjetaRegalo;

import java.util.ArrayList;

/*
    La empresa El Corte Islandés nos ha encargado una aplicación para gestionar las tarjetas regalo.
    Como primer paso para implementar la aplicación, es necesario crear la clase principal.
    Implementa la clase TarjetaRegalo. Cuando se crea una nueva tarjeta, se le da un saldo y se asigna
    de forma automática un número de 5 dígitos. Si se intenta gastar más dinero del que tiene la tarjeta,
    se debe mostrar un mensaje de error. Dos tarjetas regalo se pueden fusionar creando una nueva tarjeta
    con la suma del saldo que tenga cada una y un nuevo número aleatorio de 5 cifras. Al fusionar dos
    tarjetas en una, las dos tarjetas originales se quedarían con 0 € de saldo.
 */
public class TarjetaRegalo {
    private int codigo;
    private double saldo;

    private static final ArrayList<Integer> codigosUsados = new ArrayList<>(0);

    public TarjetaRegalo(double saldo){
        if (!validarParametros(saldo)){
            throw new IllegalArgumentException("El saldo debe de ser un valor positivo");
        }
        this.saldo = saldo;
        this.codigo = generarCodigoArray();
    }

    public void gasta(double cantidad){
        if (!validarParametros(cantidad)){
            System.out.println("El valor debe de ser positivo");
        } else if (cantidad > this.saldo){
            System.err.println("No tiene suficiente saldo para gastar "+cantidad+"€");
        } else {
            this.saldo -= cantidad;
            // Redondeamos a dos decimales
            this.saldo = Math.round(this.saldo * 100.0) / 100.0;
        }
    }

    public TarjetaRegalo fusionaCon (TarjetaRegalo tarjetaRegalo){
        TarjetaRegalo tarjetaFusionada = new TarjetaRegalo(this.saldo+ tarjetaRegalo.saldo);
        this.saldo = 0;
        tarjetaRegalo.saldo = 0;
        return tarjetaFusionada;
    }

    @Override
    public String toString() {
        String codigo = Integer.toString(this.codigo);
        for (int i = 0; i < 5-codigo.length(); i++) {
            codigo = "0"+codigo;
        }
        return "Tarjeta nº"+codigo+" - Saldo: "+this.saldo;
    }

    private int generarCodigo(){
        int codigo = (int) ((Math.random()*((99999-10000)+1))+10000);
        while (codigosUsados.contains(codigo)){
            codigo = (int) ((Math.random()*((99999-11111)+1))+11111);
        }
        codigosUsados.add(codigo);
        return codigo;
    }

    private int generarCodigoArray(){
        int[] codigo = new int[5];
        String codigoString = "";
        for (int i = 0; i < codigo.length; i++) {
            codigo[i] = (int) ((Math.random()*((9-0)+1))+0);
        }
        for (int i = 0; i < codigo.length; i++) {
            codigoString += Integer.toString(codigo[i]);
        }
        return Integer.parseInt(codigoString);
    }

    private boolean validarParametros(double valor){
        return valor>0;
    }

}
