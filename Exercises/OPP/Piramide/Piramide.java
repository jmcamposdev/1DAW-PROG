package poo.EjerciciosLibro.PiramideYRectangulo;

public class Piramide {
    private static int contadorPiramides;
    private int altura;

    public Piramide(int altura){
        if (!validarAltura(altura)){
            throw new IllegalArgumentException("La altura debe de ser positiva");
        }
        this.altura = altura;
        Piramide.contadorPiramides++;
    }

    @Override
    public String toString() {
        String piramide = "";
        String baseString = "";
        int base = calcularBase(this.altura);
        int espacios = 0;
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < base; j++) {
                baseString += "*";
            }
            for (int k = 0; k < espacios; k++) {
                baseString = " "+baseString;
            }
            piramide = "\n" + baseString + piramide;
            baseString = "";
            base-=2;
            espacios+=1;
        }
        return piramide;
    }

    private int calcularBase(int altura){
        int base = 1;
        for (int i = 1; i < altura; i++) {
            base += 2;
        }
        return base;
    }

    public static int getPiramidesCreadas(){
        return Piramide.contadorPiramides;
    }
    private boolean validarAltura(int altura){
        return altura>0;
    }
}
