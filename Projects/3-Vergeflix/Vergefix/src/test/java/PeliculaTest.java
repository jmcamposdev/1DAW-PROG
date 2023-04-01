import org.junit.jupiter.api.*;
import vergeflix.Pelicula;
import vergeflix.Tematica;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PeliculaTest {
    static Pelicula pelicula;
    static Pelicula copia;


    @BeforeEach
    void beforeAll() {
        pelicula =  new Pelicula("El Padrino", 18, LocalDate.of(1972, 3, 15), true, "Francis Ford Coppola", "Marlon Brando", 175, Tematica.DRAMA);
        copia = new Pelicula(pelicula);
    }

    @Nested
    @DisplayName("Pruebas para el constructor de Pelicula")
    class ConstructorTest {

        @Test
        @DisplayName("Debería lanzar una excepción cuando el director está vacío")
        void deberiaLanzarExcepcionCuandoElDirectorEstaVacio() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("Nombre de la Pelicula", 18, LocalDate.now(), true, "", "Actor Principal", 120, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería lanzar una excepción cuando el director contiene solo espacios")
        void deberiaLanzarExcepcionCuandoElDirectorContieneSoloEspacios() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("Nombre de la Pelicula", 18, LocalDate.now(), true, "   ", "Actor Principal", 120, Tematica.COMEDIA));
        }

        @Test
        @DisplayName("Debería lanzar una excepción cuando el actor principal está vacío")
        void deberiaLanzarExcepcionCuandoElActorPrincipalEstaVacio() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("Nombre de la Pelicula", 18, LocalDate.now(), true, "Director", "", 120, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería lanzar una excepción cuando el actor principal contiene solo espacios")
        void deberiaLanzarExcepcionCuandoElActorPrincipalContieneSoloEspacios() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("Nombre de la Pelicula", 18, LocalDate.now(), true, "Director", "   ", 120, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería lanzar una excepción cuando la duración es menor que 60")
        void deberiaLanzarExcepcionCuandoLaDuracionEsMenorQue60() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("Nombre de la Pelicula", 18, LocalDate.now(), true, "Director", "Actor Principal", 59, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería lanzar una excepción cuando la duración es mayor que 240")
        void deberiaLanzarExcepcionCuandoLaDuracionEsMayorQue240() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("Nombre de la Pelicula", 18, LocalDate.now(), true, "Director", "Actor Principal", 241, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería crear una instancia de Pelicula cuando todos los valores son válidos")
        void deberiaCrearInstanciaDePeliculaCuandoTodosLosValoresSonValidos() {
            Pelicula pelicula = new Pelicula("Nombre de la Pelicula", 18, LocalDate.now(), true, "Director", "Actor Principal", 120, Tematica.DRAMA);

            assertEquals("Director", pelicula.getDirector());
            assertEquals("Actor Principal", pelicula.getActorPrincipal());
            assertEquals(120, pelicula.getDuracion());
            assertEquals(Tematica.DRAMA, pelicula.getCategoria());
        }
    }

    @Nested
    @DisplayName("Validar Constructor Copia")
    class validarConstructorCopia {

        @Test
        @DisplayName("Debería copiar el nombre correctamente")
        void deberiaCopiarNombre() {
            assertEquals(copia.getNombre(), pelicula.getNombre());
        }

        @Test
        @DisplayName("Debería copiar la calificación de edad correctamente")
        void deberiaCopiarCalificacionEdad() {
            assertEquals(pelicula.getCalificacionEdad(), copia.getCalificacionEdad());
        }

        @Test
        @DisplayName("Debería copiar la fecha de incorporación al catálogo correctamente")
        void deberiaCopiarFechaIncorporacionAlCatalogo() {
            assertEquals(pelicula.getFechaIncorporacionAlCatalogo(), copia.getFechaIncorporacionAlCatalogo());
        }

        @Test
        @DisplayName("Debería copiar el estado de disponibilidad correctamente")
        void deberiaCopiarEstadoDisponibilidad() {
            assertEquals(pelicula.isEstaDisponible(), copia.isEstaDisponible());
        }

        @Test
        @DisplayName("Debería copiar el director correctamente")
        void deberiaCopiarDirector() {
            assertEquals(pelicula.getDirector(), copia.getDirector());
        }

        @Test
        @DisplayName("Debería copiar el actor principal correctamente")
        void deberiaCopiarActorPrincipal() {
            assertEquals(pelicula.getActorPrincipal(), copia.getActorPrincipal());
        }

        @Test
        @DisplayName("Debería copiar la duración correctamente")
        void deberiaCopiarDuracion() {
            assertEquals(pelicula.getDuracion(), copia.getDuracion());
        }

        @Test
        @DisplayName("Debería copiar la temática correctamente")
        void deberiaCopiarTematica() {
            assertEquals(pelicula.getCategoria(), copia.getCategoria());
        }

    }

    @Nested
    @DisplayName("Validar Getters")
    class gettersPelicula {

        @Test
        @DisplayName("getDirector() debería devolver el valor correcto")
        void getDirector_DeberiaDevolverValorCorrecto() {
            assertEquals("Francis Ford Coppola", pelicula.getDirector());
        }

        @Test
        @DisplayName("getActorPrincipal() debería devolver el valor correcto")
        void getActorPrincipal_DeberiaDevolverValorCorrecto() {
            assertEquals("Marlon Brando", pelicula.getActorPrincipal());
        }

        @Test
        @DisplayName("getDuracion() debería devolver el valor correcto")
        void getDuracion_DeberiaDevolverValorCorrecto() {
            assertEquals(175, pelicula.getDuracion());
        }

        @Test
        @DisplayName("getCategoria() debería devolver el valor correcto")
        void getCategoria_DeberiaDevolverValorCorrecto() {
            assertEquals(Tematica.DRAMA, pelicula.getCategoria());
        }
    }

    @Nested
    @DisplayName("Setters Pelicula")
    class settersPelicula {

        @Nested
        @DisplayName("Setter Director")
        class setterDirector {
            @Test
            @DisplayName("setDirector debería actualizar el director si el valor es válido")
            void setDirector_DeberiaActualizarDirector_CuandoValorEsValido() {
                pelicula.setDirector("Steven Spielberg");
                assertEquals("Steven Spielberg", pelicula.getDirector());
            }

            @Test
            @DisplayName("setDirector no debería actualizar el director si el valor esta vacío")
            void setDirector_NoDeberiaActualizarDirector_CuandoValorEstaVacio() {
                pelicula.setDirector("");
                assertEquals("Francis Ford Coppola", pelicula.getDirector());
            }

            @Test
            @DisplayName("setDirector no debería actualizar el director si el valor es vacío o contiene solo espacios")
            void setDirector_NoDeberiaActualizarDirector_CuandoValorContieneSoloEspacios() {
                pelicula.setDirector("    ");
                assertEquals("Francis Ford Coppola", pelicula.getDirector());
            }
        }

        @Nested
        @DisplayName("Setter Actor Principal")
        class setterActorPrincipal {

            @Test
            @DisplayName("setActorPrincipal debería actualizar el actor principal si el valor es válido")
            void setActorPrincipal_DeberiaActualizarActorPrincipal_CuandoValorEsValido() {
                pelicula.setActorPrincipal("Al Pacino");
                assertEquals("Al Pacino", pelicula.getActorPrincipal());
            }

            @Test
            @DisplayName("setActorPrincipal no debería actualizar el actor principal si el valor es vacío")
            void setActorPrincipal_NoDeberiaActualizarActorPrincipal_CuandoValorEsVacio() {
                pelicula.setActorPrincipal("");
                assertEquals("Marlon Brando", pelicula.getActorPrincipal());
            }

            @Test
            @DisplayName("setActorPrincipal no debería actualizar el actor principal si el valor contiene solo espacios")
            void setActorPrincipal_NoDeberiaActualizarActorPrincipal_CuandoValorSoloContieneEspacios() {
                pelicula.setActorPrincipal("     ");
                assertEquals("Marlon Brando", pelicula.getActorPrincipal());
            }
        }

        @Nested
        @DisplayName("Setter Duración")
        class setterDuracion {

            @Test
            @DisplayName("setDuracion debería actualizar la duración si el valor está dentro del rango válido")
            void setDuracion_DeberiaActualizarDuracion_CuandoValorEsValido() {
                pelicula.setDuracion(120);
                assertEquals(120, pelicula.getDuracion());
            }

            @Test
            @DisplayName("setDuracion no debería actualizar la duración si el valor es menor que 60")
            void setDuracion_NoDeberiaActualizarDuracion_CuandoValorEsMenorASesenta() {
                pelicula.setDuracion(59);
                assertEquals(175, pelicula.getDuracion());
            }
            @Test
            @DisplayName("setDuracion no debería actualizar la duración si el valor es mayor que 240")
            void setDuracion_NoDeberiaActualizarDuracion_CuandoValorEsSuperiorADoscientosCuarentaYUno() {
                pelicula.setDuracion(241);
                assertEquals(175, pelicula.getDuracion());
            }
        }

        @Test
        @DisplayName("Setter Categoria Debe de cambiarse al indicado")
        void setCategoria() {
            pelicula.setCategoria(Tematica.TERROR);
            assertEquals(Tematica.TERROR, pelicula.getCategoria());
        }
    }

    @Nested
    @DisplayName("Método Votar (0 - 10)")
    class votar {

        @Test
        @DisplayName("Debería agregar el voto si está en el rango permitido")
        void deberiaAgregarVoto_siEstaEnRango() {
            boolean resultado = pelicula.votar(7);
            assertEquals(true, resultado);
        }

        @Test
        @DisplayName("No debería agregar el voto es inferior a 0")
        void noDeberiaAgregarVoto_siEstaInferiorACero() {
            boolean resultado = pelicula.votar(-1);
            assertEquals(false, resultado);
        }

        @Test
        @DisplayName("No debería agregar el voto es superior a 10")
        void noDeberiaAgregarVoto_siEstaSuperiorADiez() {
            boolean resultado = pelicula.votar(11);
            assertEquals(false, resultado);
        }

    }

}