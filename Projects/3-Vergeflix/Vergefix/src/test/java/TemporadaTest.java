import org.junit.jupiter.api.*;
import vergeflix.Capitulo;
import vergeflix.Temporada;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TemporadaTest {

    @Nested
    @DisplayName("Constructor")
    class ConstructorTest {

        @Test
        void deberiaCrearCorrectamenteUnaTemporadaValidamosLaFecha() {
            Temporada temporada = new Temporada(LocalDate.of(2022,10,10));
            assertEquals(LocalDate.of(2022,10,10), temporada.getFechaEstreno());
        }
    }

    @Nested
    @DisplayName("Contractor Copia")
    class ConstrutorCopiaTest {
        @Test
        public void testConstructorCopiaCopiaCorrectamenteFecha() {
            Temporada temporadaOriginal = new Temporada(LocalDate.of(2022, 3, 1));
            Temporada temporadaCopia = new Temporada(temporadaOriginal);

            assertEquals(temporadaOriginal.getFechaEstreno(), temporadaCopia.getFechaEstreno());
        }

        @Test
        public void testConstructorCopiaCopiaProfundaDeCapitulos() {
            Temporada temporadaOriginal = new Temporada(LocalDate.of(2022, 3, 1));
            temporadaOriginal.añadirCapitulo(new Capitulo("Capítulo 1", LocalDate.of(2022, 3, 1)));
            temporadaOriginal.añadirCapitulo(new Capitulo("Capítulo 2", LocalDate.of(2022, 3, 1)));

            Temporada temporadaCopia = new Temporada(temporadaOriginal);

            // Verificar que la lista de capítulos no es la misma instancia que la original
            assertNotSame(temporadaOriginal.getCapitulo(0), temporadaCopia.getCapitulo(0));
        }
    }

    @Nested
    @DisplayName("Tests de Getters de Temporada")
    class TemporadaGettersTest {

        private Temporada temporada;

        @BeforeEach
        void setUp() {
            // Crear una temporada con algunos capítulos para los tests
            temporada = new Temporada(LocalDate.now());
            temporada.añadirCapitulo(new Capitulo("Capítulo 1", LocalDate.now()));
            temporada.añadirCapitulo(new Capitulo("Capítulo 2", LocalDate.now()));
            temporada.añadirCapitulo(new Capitulo("Capítulo 3", LocalDate.now()));
        }

        @Nested
        @DisplayName("Tests del getter getFechaEstreno")
        class GetFechaEstrenoTest {

            @Test
            @DisplayName("Devuelve la fecha de estreno correcta")
            void testDevuelveFechaEstrenoCorrecta() {
                LocalDate fechaEsperada = LocalDate.now();
                assertEquals(fechaEsperada, temporada.getFechaEstreno());
            }

        }

        @Nested
        @DisplayName("Tests del getter getCapitulo")
        class GetCapituloTest {

            @Test
            @DisplayName("Devuelve el capítulo en la posición correcta")
            void testDevuelveCapituloEnPosicionCorrecta() {
                Capitulo capituloEsperado = temporada.getCapitulo(0);
                assertEquals("Capítulo 1", capituloEsperado.getTitulo());
            }

            @Test
            @DisplayName("Retorna null si se especifica una posición inválida")
            void testRetornaNullEnPosicionInvalida() {
                assertNull(temporada.getCapitulo(3));
            }
        }
    }

    @Nested
    @DisplayName("Método setFechaEstreno()")
    class setFechaEstrenoTest {
        @Test
        @DisplayName("Debería actualizar la fecha de estreno cuando se llama a setFechaEstreno con una nueva fecha anterior al primer capítulo")
        void deberiaActualizarLaFechaDeEstrenoCuandoSeLlamaASetFechaEstrenoConUnaNuevaFechaAnteriorAlPrimerCapitulo() {
            LocalDate nuevaFechaEstreno = LocalDate.of(2022, 2, 28);
            Capitulo primerCapitulo = new Capitulo("Capítulo 1", LocalDate.of(2022, 3, 1));
            Capitulo segundoCapitulo = new Capitulo("Capítulo 2", LocalDate.of(2022, 3, 8));
            Temporada temporada = new Temporada(LocalDate.of(2022, 3, 1));
            temporada.añadirCapitulo(primerCapitulo);
            temporada.añadirCapitulo(segundoCapitulo);

            temporada.setFechaEstreno(nuevaFechaEstreno);
            assertEquals(nuevaFechaEstreno, temporada.getFechaEstreno());
        }

        @Test
        @DisplayName("No debería actualizar la fecha de estreno cuando se llama a setFechaEstreno con una nueva fecha posterior al primer capítulo")
        void noDeberiaActualizarLaFechaDeEstrenoCuandoSeLlamaASetFechaEstrenoConUnaNuevaFechaPosteriorAlPrimerCapitulo() {
            LocalDate nuevaFechaEstreno = LocalDate.of(2022, 3, 2);
            Capitulo primerCapitulo = new Capitulo("Capítulo 1", LocalDate.of(2022, 3, 1));
            Capitulo segundoCapitulo = new Capitulo("Capítulo 2", LocalDate.of(2022, 3, 8));
            Temporada temporada = new Temporada(LocalDate.of(2022, 3, 1));
            temporada.añadirCapitulo(primerCapitulo);
            temporada.añadirCapitulo(segundoCapitulo);

            temporada.setFechaEstreno(nuevaFechaEstreno);
            assertNotEquals(nuevaFechaEstreno, temporada.getFechaEstreno());
        }

        @Test
        @DisplayName("Debería actualizar la fecha de estreno cuando se llama a setFechaEstreno con una nueva fecha y no hay capítulos")
        void deberiaActualizarLaFechaDeEstrenoCuandoSeLlamaASetFechaEstrenoConUnaNuevaFechaYNoHayCapitulos() {
            LocalDate nuevaFechaEstreno = LocalDate.of(2022, 2, 28);
            Temporada temporada = new Temporada(LocalDate.of(2022, 3, 1));

            temporada.setFechaEstreno(nuevaFechaEstreno);
            assertEquals(nuevaFechaEstreno, temporada.getFechaEstreno());
        }

    }

    @Nested
    @DisplayName("Método añadirCapitulo (Capitulo capitulo)")
    class añadirCapitulo1 {
        @Test
        public void añadirCapitulo_DeberiaAñadirCapituloCuandoFechaEmisionEsPosteriorOIgualFechaEstrenoYTituloNoExisteEnOtroCapitulo() {
            // Arrange
            Temporada temporada = new Temporada(LocalDate.of(2022, 1, 1));
            Capitulo capitulo1 = new Capitulo("Capítulo 1", LocalDate.of(2022, 1, 1));
            Capitulo capitulo2 = new Capitulo("Capítulo 2", LocalDate.of(2022, 1, 10));

            // Act
            boolean añadido1 = temporada.añadirCapitulo(capitulo1);
            boolean añadido2 = temporada.añadirCapitulo(capitulo2);

            // Assert
            assertTrue(añadido1);
            assertTrue(añadido2);
        }

        @Test
        public void añadirCapitulo_NoDeberiaAñadirCapituloCuandoFechaEmisionEsAnteriorAFechaEstreno() {
            // Arrange
            Temporada temporada = new Temporada(LocalDate.of(2022, 1, 10));
            Capitulo capitulo = new Capitulo("Capítulo 1", LocalDate.of(2022, 1, 9));

            // Act
            boolean añadido = temporada.añadirCapitulo(capitulo);

            // Assert
            assertFalse(añadido);
        }

        @Test
        public void añadirCapitulo_NoDeberiaAñadirCapituloCuandoTituloYaExisteEnOtroCapitulo() {
            // Arrange
            Temporada temporada = new Temporada(LocalDate.of(2022, 1, 10));
            Capitulo capitulo1 = new Capitulo("Capítulo 1", LocalDate.of(2022, 1, 15));
            Capitulo capitulo2 = new Capitulo("Capítulo 1", LocalDate.of(2022, 2, 1));
            temporada.añadirCapitulo(capitulo1);

            // Act
            boolean añadido = temporada.añadirCapitulo(capitulo2);

            // Assert
            assertFalse(añadido);
        }
    }

    @Nested
    @DisplayName("Método añadirCapitulo (LocalDate fechaEmision, String titulo)")
    class añadirCapitulo2 {
        private Temporada temporada;

        @BeforeEach
        public void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
        }

        @Test
        public void añadirCapitulo_DeberiaAñadirNuevoCapitulo() {
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            assertTrue(temporada.añadirCapitulo(capitulo1));

            Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 2, 10));
            assertTrue(temporada.añadirCapitulo(capitulo2));
        }

        @Test
        public void añadirCapitulo_DeberiaRechazarCapituloConFechaPreviaAEstrenoDeTemporada() {
            Capitulo capitulo = new Capitulo("Piloto", LocalDate.of(2008, 1, 19));
            assertFalse(temporada.añadirCapitulo(capitulo));
        }

        @Test
        public void añadirCapitulo_DeberiaRechazarCapituloConTituloExistenteEnLaTemporada() {
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            assertTrue(temporada.añadirCapitulo(capitulo1));

            Capitulo capitulo2 = new Capitulo("Piloto", LocalDate.of(2008, 2, 10));
            assertFalse(temporada.añadirCapitulo(capitulo2));
        }
    }

    @Nested
    @DisplayName("Método añadirCapitulo (LocalDate fechaEmision, String titulo)")
    class añadirCapitulo3 {
        private Temporada temporada;

        @BeforeEach
        public void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
        }

        @Test
        public void deberiaAñadirCapituloEnPosicionValida() {
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Griselda", LocalDate.of(2008, 1, 27));

            // Añadir primer capítulo en la posición 0
            assertTrue(temporada.añadirCapitulo(0, capitulo1));

            // Añadir segundo capítulo en la posición 1
            assertTrue(temporada.añadirCapitulo(1, capitulo2));
        }

        @Test
        public void noDeberiaAñadirCapituloEnPosicionInvalida() {
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Griselda", LocalDate.of(2008, 1, 27));
            Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));

            // Añadir primer capítulo en la posición 0
            assertTrue(temporada.añadirCapitulo(0, capitulo1));

            // Añadir segundo capítulo en la posición 1
            assertTrue(temporada.añadirCapitulo(1, capitulo2));

            // Intentar añadir tercer capítulo en la posición 4 (inválida)
            assertFalse(temporada.añadirCapitulo(4, capitulo3));
        }

        @Test
        public void deberiaMoverCapitulosHaciaLaDerecha() {
            // Los capitulos se ordena por fecha después de la inserción
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Griselda", LocalDate.of(2008, 1, 27));
            Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));

            // Añadir primer capítulo en la posición 0
            assertTrue(temporada.añadirCapitulo(0, capitulo1));

            // Añadir segundo capítulo en la posición 1
            assertTrue(temporada.añadirCapitulo(1, capitulo2));

            // Añadir tercer capítulo en la posición 1 (mueve el segundo capítulo a la derecha)
            assertTrue(temporada.añadirCapitulo(0, capitulo3));
        }

        @Test
        public void noDeberiaAñadirCapituloConMismoTitulo() {
            // Given
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            temporada.añadirCapitulo(capitulo1);

            // When
            boolean resultado = temporada.añadirCapitulo(capitulo2);

            // Then
            assertFalse(resultado);
            assertEquals(capitulo1, temporada.getCapitulo(0));
        }
    }

    @Nested
    @DisplayName("Método añadirCapitulo(int posicion, LocalDate fechaEmision, String titulo)")
    class añadirCapitulo4 {
        private Temporada temporada;

        @BeforeEach
        public void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
        }

        @Test
        public void deberiaAñadirCapituloEnPosicionExistente() {
            temporada.añadirCapitulo(LocalDate.of(2008, 2, 10), "Capítulo 1: Piloto");
            temporada.añadirCapitulo(LocalDate.of(2008, 2, 17), "Capítulo 2: La catástrofe del gas");
            temporada.añadirCapitulo(1, LocalDate.of(2008, 2, 24), "Capítulo 3: La reina del hielo");
            assertEquals("Capítulo 3: La reina del hielo", temporada.getCapitulo(2).getTitulo());
            assertEquals(LocalDate.of(2008, 2, 24), temporada.getCapitulo(2).getFechaEmision());
            assertEquals("Capítulo 2: La catástrofe del gas", temporada.getCapitulo(1).getTitulo());
        }

        @Test
        public void deberiaAñadirCapituloEnSiguientePosicion() {
            temporada.añadirCapitulo(LocalDate.of(2008, 2, 10), "Capítulo 1: Piloto");
            temporada.añadirCapitulo(LocalDate.of(2008, 2, 17), "Capítulo 2: La catástrofe del gas");
            temporada.añadirCapitulo(2, LocalDate.of(2008, 2, 24), "Capítulo 3: La reina del hielo");
            assertEquals("Capítulo 3: La reina del hielo", temporada.getCapitulo(2).getTitulo());
            assertEquals(LocalDate.of(2008, 2, 24), temporada.getCapitulo(2).getFechaEmision());
            assertEquals("Capítulo 2: La catástrofe del gas", temporada.getCapitulo(1).getTitulo());
            assertEquals("Capítulo 1: Piloto", temporada.getCapitulo(0).getTitulo());
        }

        @Test
        public void noDeberiaAñadirCapituloEnPosicionNoValida() {
            temporada.añadirCapitulo(LocalDate.of(2008, 2, 10), "Capítulo 1: Piloto");
            temporada.añadirCapitulo(LocalDate.of(2008, 2, 17), "Capítulo 2: La catástrofe del gas");
            assertFalse(temporada.añadirCapitulo(4, LocalDate.of(2008, 2, 24), "Capítulo 3: La reina del hielo"));
        }

        @Test
        public void noDeberiaAñadirCapituloConMismoTitulo() {
            temporada.añadirCapitulo(LocalDate.of(2008, 2, 10), "Capítulo 1: Piloto");
            assertFalse(temporada.añadirCapitulo(1, LocalDate.of(2008, 2, 17), "Capítulo 1: Piloto"));
        }
    }

    @Nested
    @DisplayName("Tests para el método eliminarCapitulo")
    public class TemporadaEliminarCapituloTest {

        private Temporada temporada;

        @BeforeEach
        public void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
            Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
            temporada.añadirCapitulo(capitulo1);
            temporada.añadirCapitulo(capitulo2);
            temporada.añadirCapitulo(capitulo3);
        }

        @Test
        @DisplayName("Debería eliminar un capítulo existente y devolver true")
        public void deberiaEliminarCapitulo() {
            assertTrue(temporada.eliminarCapitulo("Piloto"));
            assertEquals("Cat's in the Bag...", temporada.getCapitulo(0).getTitulo());
        }

        @Test
        @DisplayName("Debería devolver false al intentar eliminar un capítulo inexistente")
        public void deberiaDevolverFalseAlEliminarCapituloConTituloInexistente() {
            assertFalse(temporada.eliminarCapitulo("Episodio inexistente"));
        }

        @Test
        @DisplayName("Debería devolver false al intentar eliminar un capítulo con un Título vacío")
        public void deberiaDevolverFalseAlEliminarCapituloConPosicionInvalida() {
            assertFalse(temporada.eliminarCapitulo(""));
        }
    }

    @Nested
    @DisplayName("Tests para Temporada.eliminarCapitulos()")
    class TemporadaEliminarCapitulosTest {

        private Temporada temporada;

        @BeforeEach
        public void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
            Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
            temporada.añadirCapitulo(capitulo1);
            temporada.añadirCapitulo(capitulo2);
            temporada.añadirCapitulo(capitulo3);
        }

        @Test
        @DisplayName("Eliminar capítulos con expresión regular")
        void deberiaEliminarCapitulosConExpresionRegular() {
            int cantidadEliminados = temporada.eliminarCapitulos(".*Bag.*");
            assertEquals(2, cantidadEliminados);
        }

        @Test
        @DisplayName("No eliminar capítulos con expresión regular no encontrada")
        void deberiaNoEliminarCapitulosConExpresionRegularNoEncontrada() {
            int cantidadEliminados = temporada.eliminarCapitulos(".*Sky.*");
            assertEquals(0, cantidadEliminados);
            assertNotNull(temporada.getCapitulo(0));
            assertNotNull(temporada.getCapitulo(1));
            assertNotNull(temporada.getCapitulo(2));
        }
    }

   @Nested
   @DisplayName("Pruebas para Temporada.setCapitulo()")
   class TemporadaSetCapituloTest {
       private Temporada temporada;

       @BeforeEach
       public void setUp() {
           temporada = new Temporada(LocalDate.of(2008, 1, 20));
           Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
           Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
           Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
           temporada.añadirCapitulo(capitulo1);
           temporada.añadirCapitulo(capitulo2);
           temporada.añadirCapitulo(capitulo3);
       }

       @Test
       @DisplayName("Debería modificar un capítulo existente")
       void deberiaModificarCapituloExistente() {
           boolean result = temporada.setCapitulo(1, LocalDate.of(2008, 1, 28), "Nuevo titulo");
           assertTrue(result);
           assertEquals(LocalDate.of(2008, 1, 28), temporada.getCapitulo(1).getFechaEmision());
           assertEquals("Nuevo titulo", temporada.getCapitulo(1).getTitulo());
       }

       @Test
       @DisplayName("No debería modificar un capítulo inexistente")
       void deberiaNoModificarCapituloInexistente() {
           boolean result = temporada.setCapitulo(10, LocalDate.of(2008, 1, 28), "Nuevo titulo");
           assertFalse(result);
       }

       @Test
       @DisplayName("No debería modificar un capítulo con un título existente")
       void deberiaNoModificarCapituloConTituloExistente() {
           boolean result = temporada.setCapitulo(1, LocalDate.of(2008, 1, 28), "Piloto");
           assertFalse(result);
           assertNotEquals(LocalDate.of(2008, 1, 28), temporada.getCapitulo(1).getFechaEmision());
           assertNotEquals("Piloto", temporada.getCapitulo(1).getTitulo());
       }

       @Test
       @DisplayName("No debería modificar el capítulo si la fecha de emisión es anterior a la fecha de estreno de la temporada")
       public void noDeberiaModificarCapituloConFechaAnteriorAEstreno() {
           boolean result = temporada.setCapitulo(0, LocalDate.of(2008, 1, 10), "Nuevo título");

           assertFalse(result);
       }
   }

   @Nested
    @DisplayName("Tests para Temporada.setCapitulo(posicion, fechaEmision)")
    class TemporadaSetCapituloFechaEmisionTest {
       private Temporada temporada;

       @BeforeEach
       void setUp() {
           temporada = new Temporada(LocalDate.of(2008, 1, 20));
           Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
           Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
           Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
           temporada.añadirCapitulo(capitulo1);
           temporada.añadirCapitulo(capitulo2);
           temporada.añadirCapitulo(capitulo3);
       }

       @Test
       @DisplayName("Se debe modificar capitulo existente con fechaEmision valida")
       void deberiaModificarCapituloExistenteConFechaEmisionValida() {
           boolean result = temporada.setCapitulo(1, LocalDate.of(2008, 1, 28));
           assertTrue(result);
           assertEquals(LocalDate.of(2008, 1, 28), temporada.getCapitulo(1).getFechaEmision());
       }

       @Test
       @DisplayName("No debe modificar capitulo inexistente")
       void deberiaNoModificarCapituloInexistente() {
           boolean result = temporada.setCapitulo(10, LocalDate.of(2008, 1, 28));
           assertFalse(result);
       }

       @Test
       @DisplayName("No debería modificar el capitulo con una fecha de emisión anterior a la fecha de estreno de la temporada")
       void noDeberiaModificarCapituloConFechaEmisionAnteriorAFechaEstreno() {
           LocalDate fechaEstreno = LocalDate.of(2008, 1, 20);
           LocalDate fechaEmision = LocalDate.of(2008, 1, 19);
           boolean result = temporada.setCapitulo(0, fechaEmision);
           assertFalse(result);
           assertEquals(fechaEstreno, temporada.getCapitulo(0).getFechaEmision());
       }
   }

   @Nested
    @DisplayName("Pruebas para Temporada.setCapitulo() con parámetro de título")
    class TemporadaSetCapituloConTituloTest {
       private Temporada temporada;

       @BeforeEach
       void setUp() {
           temporada = new Temporada(LocalDate.of(2008, 1, 20));
           Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
           Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
           Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
           temporada.añadirCapitulo(capitulo1);
           temporada.añadirCapitulo(capitulo2);
           temporada.añadirCapitulo(capitulo3);
       }

       @Test
       @DisplayName("Debería modificar el título de un capítulo existente")
       void deberiaModificarTituloCapituloExistente() {
           boolean result = temporada.setCapitulo(1, "Nuevo título");
           assertTrue(result);
           assertEquals("Nuevo título", temporada.getCapitulo(1).getTitulo());
       }

       @Test
       @DisplayName("No debería modificar el título de un capítulo inexistente")
       void deberiaNoModificarTituloCapituloInexistente() {
           boolean result = temporada.setCapitulo(10, "Nuevo título");
           assertFalse(result);
       }

       @Test
       @DisplayName("No debería modificar el título de un capítulo con título vacío o en blanco")
       void deberiaNoModificarTituloCapituloConTituloVacio() {
           boolean result1 = temporada.setCapitulo(1, "");
           assertFalse(result1);
       }

       @Test
       @DisplayName("No debería modificar el título de un capítulo con título en blanco")
       void deberiaNoModificarTituloCapituloConTituloConEspaciosEnBlanco() {
           boolean result2 = temporada.setCapitulo(1, "   ");
           assertFalse(result2);
       }

       @Test
       @DisplayName("No debería modificar el título de un capítulo con título existente")
       void deberiaNoModificarTituloCapituloConTituloExistente() {
           boolean result = temporada.setCapitulo(1, "Piloto");
           assertFalse(result);
           assertNotEquals("Piloto", temporada.getCapitulo(1).getTitulo());
       }
   }


   @Nested
    @DisplayName("Pruebas para Temporada.meGusta(int posicionCapitulo, boolean like)")
    class TemporadaMeGustaPorPosicionTest {
        private Temporada temporada;

        @BeforeEach
        void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
            Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
            temporada.añadirCapitulo(capitulo1);
            temporada.añadirCapitulo(capitulo2);
            temporada.añadirCapitulo(capitulo3);
        }

        @Test
        @DisplayName("Debería agregar like a un capítulo existente")
        void deberiaAñadirVotoPositivoACapituloExistente() {
            boolean result = temporada.meGusta(1, true);
            assertTrue(result);
            assertEquals(1, temporada.getCapitulo(1).getVotosPositivos());
            assertEquals(0, temporada.getCapitulo(1).getVotosNegativos());
        }

        @Test
        @DisplayName("Debería agregar dislike a un capítulo existente")
        void deberiaAñadirVotoNegativoACapituloExistente() {
            boolean result = temporada.meGusta(1, false);
            assertTrue(result);
            assertEquals(0, temporada.getCapitulo(1).getVotosPositivos());
            assertEquals(1, temporada.getCapitulo(1).getVotosNegativos());
        }

        @Test
        @DisplayName("No debería agregar like a un capítulo inexistente")
        void deberiaNoAñadirVotoPositivoACapituloInexistente() {
            boolean result = temporada.meGusta(10, true);
            assertFalse(result);
        }

        @Test
        @DisplayName("No debería agregar dislike a un capítulo inexistente")
        void deberiaNoAñadirVotoNegativoACapituloInexistente() {
            boolean result = temporada.meGusta(10, false);
            assertFalse(result);
        }
    }


    @Nested
    @DisplayName("Tests para Temporada.meGusta(String titulo, boolean like)")
    class TemporadaMeGustaPorTituloTest {

        private Temporada temporada;

        @BeforeEach
        void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
            Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
            temporada.añadirCapitulo(capitulo1);
            temporada.añadirCapitulo(capitulo2);
            temporada.añadirCapitulo(capitulo3);
        }

        @Test
        @DisplayName("Debería añadir voto positivo a capítulo existente")
        void deberiaAñadirVotoPositivoACapituloExistente() {
            boolean result = temporada.meGusta("Piloto", true);
            System.out.println(temporada);
            assertTrue(result);
            assertEquals(1, temporada.getCapitulo(0).getVotosPositivos());
            assertEquals(0, temporada.getCapitulo(0).getVotosNegativos());
        }

        @Test
        @DisplayName("Debería añadir voto negativo a capítulo existente")
        void deberiaAñadirVotoNegativoACapituloExistente() {
            boolean result = temporada.meGusta("Piloto", false);
            assertTrue(result);
            assertEquals(0, temporada.getCapitulo(0).getVotosPositivos());
            assertEquals(1, temporada.getCapitulo(0).getVotosNegativos());
        }

        @Test
        @DisplayName("No debería añadir voto positivo a capítulo inexistente")
        void noDeberiaAñadirVotoPositivoACapituloInexistente() {
            boolean result = temporada.meGusta("Capítulo Inexistente", true);
            assertFalse(result);
        }

        @Test
        @DisplayName("No debería añadir voto negativo a capítulo inexistente")
        void noDeberiaAñadirVotoNegativoACapituloInexistente() {
            boolean result = temporada.meGusta("Capítulo Inexistente", false);
            assertFalse(result);
        }

    }

    @Nested
    @DisplayName("Pruebas para Temporada.capitulosMejorValorados()")
    class TemporadaCapitulosMejorValoradosTest {
        private Temporada temporada;

        @BeforeEach
        void setUp() {
            temporada = new Temporada(LocalDate.of(2008, 1, 20));
            Capitulo capitulo1 = new Capitulo("Piloto", LocalDate.of(2008, 1, 20));
            Capitulo capitulo2 = new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27));
            Capitulo capitulo3 = new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10));
            temporada.añadirCapitulo(capitulo1);
            temporada.añadirCapitulo(capitulo2);
            temporada.añadirCapitulo(capitulo3);
            temporada.meGusta(capitulo1.getTitulo(), true);
            temporada.meGusta(capitulo1.getTitulo(), true);
            temporada.meGusta(capitulo2.getTitulo(), true);
            temporada.meGusta(capitulo3.getTitulo(), true);
            temporada.meGusta(capitulo3.getTitulo(), true);
            temporada.meGusta(capitulo3.getTitulo(), false);
        }

        @Test
        @DisplayName("Debería devolver los 2 capítulos mejor valorados")
        void deberiaDevolverLos2CapitulosMejorValorados() {
            ArrayList<Capitulo> result = temporada.capitulosMejorValorados(2);
            assertEquals(2, result.size());
            assertEquals("Piloto", result.get(0).getTitulo());
            assertEquals(2, result.get(0).getVotosPositivos());
            assertEquals(0, result.get(0).getVotosNegativos());
            assertEquals("Cat's in the Bag...", result.get(1).getTitulo());
            assertEquals(1, result.get(1).getVotosPositivos());
            assertEquals(0, result.get(1).getVotosNegativos());
        }

        @Test
        @DisplayName("Debería devolver los 3 capítulos mejor valorados")
        void deberiaDevolverLos3CapitulosMejorValorados() {
            ArrayList<Capitulo> result = temporada.capitulosMejorValorados(3);
            assertEquals(3, result.size());
            assertEquals("Piloto", result.get(0).getTitulo());
            assertEquals(2, result.get(0).getVotosPositivos());
            assertEquals(0, result.get(0).getVotosNegativos());
            assertEquals("Cat's in the Bag...", result.get(1).getTitulo());
            assertEquals(1, result.get(1).getVotosPositivos());
            assertEquals(0, result.get(1).getVotosNegativos());
            assertEquals("And the Bag's in the River", result.get(2).getTitulo());
            assertEquals(2, result.get(2).getVotosPositivos());
            assertEquals(1, result.get(2).getVotosNegativos());
        }

        @Test
        @DisplayName("Deberia lanzar excepción cuando la posición esta fuera del rango")
        void deberiaLanzarExcepcionCuandoPosicionEsInvalida() {
            assertThrows(IllegalArgumentException.class, () -> temporada.capitulosMejorValorados(0));
            assertThrows(IllegalArgumentException.class, () -> temporada.capitulosMejorValorados(-1));
            assertThrows(IllegalArgumentException.class, () -> temporada.capitulosMejorValorados(4));
            assertThrows(IllegalArgumentException.class, () -> temporada.capitulosMejorValorados(10));
        }
    }


}