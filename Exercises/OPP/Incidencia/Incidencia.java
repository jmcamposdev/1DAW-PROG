package poo.EjerciciosLibro.Incidencias;

public class Incidencia {
    private static int proximoCodigoIncidencia = 1;
    private static int incidenciasPendientes;

    private int codigoIncidencia;
    private int codigoPuesto;
    private boolean esResuelta;
    private String problemaIncidencia;
    private String solucionIncidencia;

    public Incidencia(int codigoPuesto, String problemaIncidencia){
        if (!validarCodigoPuesto(codigoPuesto)){
            throw new IllegalArgumentException("El codigo del puesto no es correcto");
        }
        if (!validarString(problemaIncidencia)){
            throw new IllegalArgumentException("No puedes aportar ningún problema");
        }

        this.codigoIncidencia = Incidencia.proximoCodigoIncidencia++;
        this.codigoPuesto = codigoPuesto;
        this.esResuelta = false;
        this.problemaIncidencia = problemaIncidencia;
        Incidencia.incidenciasPendientes++;
    }

    public void resuelve(String solucionIncidencia){
        if (!validarString(solucionIncidencia)){
            throw new IllegalArgumentException("No puedes aportar ninguna solución");
        }

        this.solucionIncidencia = solucionIncidencia;
        this.esResuelta = true;
        Incidencia.incidenciasPendientes--;
    }

    public static int getPendientes(){
        return Incidencia.incidenciasPendientes;
    }

    @Override
    public String toString() {
        String estado = esResuelta ? "Resuelta - "+this.solucionIncidencia : "Pendiente";
        return "Incidencia "+this.codigoIncidencia+" - Puesto: "+this.codigoPuesto+" - "+this.problemaIncidencia+" - "+estado;
    }

    private boolean validarCodigoPuesto(int codigoPuesto){
        return codigoPuesto>0;
    }
    private boolean validarString(String cadena){
        return !cadena.isEmpty() || !cadena.isBlank();
    }
}
