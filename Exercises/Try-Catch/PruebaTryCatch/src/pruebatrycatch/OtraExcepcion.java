package pruebatrycatch;

public class OtraExcepcion extends RuntimeException{
        public OtraExcepcion() {
            super("Una excepción de tipo no Marcada ha sido lanzada");
        }
}
