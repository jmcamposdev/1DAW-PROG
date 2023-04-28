package poo.EjerciciosLibro.Tiempo;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas,int minutos,int segundos){
        validarParametros(horas, minutos, segundos);

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void sumar(int horas,int minutos,int segundos){
        validarParametros(horas, minutos, segundos);
        int segundosTotales = segundosTotales(this.horas,this.minutos,this.segundos);
        segundosTotales += segundosTotales(horas,minutos,segundos);

        int[] desglose = desglosarSegundos(segundosTotales);
        this.horas = desglose[0];
        this.minutos = desglose[1];
        this.segundos = desglose[2];
    }

    public void restar(int horas,int minutos,int segundos){
        validarParametros(horas, minutos, segundos);
        int segundosTotales = segundosTotales(this.horas,this.minutos,this.segundos);
        segundosTotales -= segundosTotales(horas,minutos,segundos);

        if (segundosTotales>0) {
            int[] desglose = desglosarSegundos(segundosTotales);
            this.horas = desglose[0];
            this.minutos = desglose[1];
            this.segundos = desglose[2];
        }


    }


    @Override
    public String toString() {
        return this.horas+"h "+this.minutos+"m "+this.segundos+"s";
    }

    private boolean validarHoras(int horas){
        return horas >= 0 && horas <=23;
    }
    private boolean validarMinutosYSegundos(int valor){
        return valor >= 0 && valor <=59;
    }

    private void validarParametros(int horas, int minutos, int segundos) {
        if (!validarHoras(horas)){
            throw new IllegalArgumentException("El valor de las horas es erróneo");
        }
        if (!validarMinutosYSegundos(minutos)){
            throw new IllegalArgumentException("El valor de los minutos es erróneo");
        }
        if (!validarMinutosYSegundos(segundos)){
            throw new IllegalArgumentException("El valor de los segundos es erróneo");
        }
    }

    private int segundosTotales(int horas,int minutos,int segundos){
        return horas/3600 + minutos/60 + segundos;
    }

    private int[] desglosarSegundos(int segundos){
        int[] tiempoDesglosado = new int[3];
        tiempoDesglosado[0] = segundos / 3600;
        segundos %= 3600;
        tiempoDesglosado[1] = segundos / 60;
        tiempoDesglosado[2] = segundos % 60;
        return tiempoDesglosado;
    }



}
