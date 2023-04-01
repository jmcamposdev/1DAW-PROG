package poo.EjerciciosLibro.CuentaCorriente;

/*
    Implementa la clase CuentaCorriente. Cada cuenta corriente tiene un número de cuenta de 10 dígitos.
    Para simplificar, el número de cuenta se genera de forma aleatoria cuando se crea una cuenta nueva.
    La cuenta se puede crear con un saldo inicial; en caso de no especificar saldo, se pondrá a cero inicialmente.
    En una cuenta se pueden hacer ingresos y gastos. También es posible hacer una transferencia entre una cuenta
    y otra. Se permite el saldo negativo.
    En el siguiente capítulo se propone un ejercicio como mejora de éste,
    en el que se pide llevar un registro de los movimientos realizados.
 */

public class CuentaCorriente {
    private final long numeroCuenta;
    private double saldo;

    // Constructor Simple
    public CuentaCorriente(){
        this.saldo = 0;
        this.numeroCuenta = generarCodigo();
    }
    //Constructor Inicializando Saldo
    public CuentaCorriente(double saldo){
        if (!validarSaldo(saldo)){
            throw new IllegalArgumentException("El saldo debe de ser positivo");
        }
        this.saldo = saldo;
        this.numeroCuenta = generarCodigo();
    }

    public void ingreso(double dinero){
        if (!validarSaldo(dinero)){
            throw new IllegalArgumentException("El saldo debe de ser positivo");
        }
        this.saldo += dinero;
    }

    public void cargo(double dinero){
        validarRetirada(dinero);

        this.saldo -= dinero;
    }

    public void transferencia(CuentaCorriente cueta, double dinero){
        validarRetirada(dinero);

        cueta.saldo += dinero;
        this.saldo -= dinero;
    }



    private long generarCodigo(){
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

    }

    private boolean validarSaldo(double valor){
        return valor>0;
    }
    private void validarRetirada(double valor){
        if (!validarSaldo(valor)){
            throw new IllegalArgumentException("El saldo debe de ser positivo");
        }
        if (valor > this.saldo){
            throw new IllegalArgumentException("No es posible retirar mas dinero del que la cuenta posee");
        }
    }

    @Override
    public String toString() {
        return "Numero de cta: "+this.numeroCuenta+" Saldo: "+this.saldo+" €";
    }
}

