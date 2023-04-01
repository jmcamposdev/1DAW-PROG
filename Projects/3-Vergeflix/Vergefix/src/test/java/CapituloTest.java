import org.junit.jupiter.api.*;
import vergeflix.Capitulo;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CapituloTest {
    private Capitulo capitulo;

    @BeforeEach
    void setUp(){
        capitulo = new Capitulo("Título del capítulo", LocalDate.of(2022, 1, 1));
        capitulo.meGusta(true);
        capitulo.meGusta(true);
        capitulo.meGusta(false);
    }

    @Nested
    @DisplayName("Constructor")
    class ConstructorTest {

        @Test
        @DisplayName("Debería lanzar una excepción si el título está vacío")
        void deberiaLanzarExcepcionSiTituloEstaVacio() {
            assertThrows(IllegalArgumentException.class, () -> new Capitulo("", LocalDate.now()));
        }

        @Test
        @DisplayName("Debería lanzar una excepción si el título contiene solo espacios")
        void deberiaLanzarExcepcionSiTituloContieneSoloEspacios() {
            assertThrows(IllegalArgumentException.class, () -> new Capitulo("   ", LocalDate.now()));
        }

        @Test
        @DisplayName("Debería construir un objeto Capitulo si los argumentos son válidos")
        void deberiaConstruirObjetoCapituloSiArgumentosSonValidos() {
            Capitulo capitulo = new Capitulo("Título", LocalDate.now());
            assertNotNull(capitulo);
        }
    }


    @Nested
    @DisplayName("Constructor Copia")
    class ConstructorCopiaTest {

        @Test
        @DisplayName("Debería copiar correctamente todos los atributos")
        void deberiaCopiarCorrectamenteTodosLosAtributos() {
            Capitulo original = new Capitulo("Título", LocalDate.now());
            Capitulo copia = new Capitulo(original);
            assertAll("Copia debería ser igual al original",
                    () -> assertEquals(original.getTitulo(), copia.getTitulo()),
                    () -> assertEquals(original.getFechaEmision(), copia.getFechaEmision()),
                    () -> assertEquals(original.getVotosPositivos(), copia.getVotosPositivos()),
                    () -> assertEquals(original.getVotosNegativos(), copia.getVotosNegativos())
            );
        }
    }


    @Nested
    @DisplayName("Tests de los getters")
    class GettersTests {

        @BeforeEach
        void setUp() throws Exception {
            capitulo = new Capitulo("Título del capítulo", LocalDate.of(2022, 1, 1));
            capitulo.meGusta(true);
            capitulo.meGusta(true);
            capitulo.meGusta(false);
        }

        @Test
        @DisplayName("Debería devolver el número de votos positivos")
        void deberiaDevolverElNumeroDeVotosPositivos() {
            assertEquals(2, capitulo.getVotosPositivos());
        }

        @Test
        @DisplayName("Debería devolver el número de votos negativos")
        void deberiaDevolverElNumeroDeVotosNegativos() {
            assertEquals(1, capitulo.getVotosNegativos());
        }

        @Test
        @DisplayName("Debería devolver el título del capítulo")
        void deberiaDevolverElTituloDelCapitulo() {
            assertEquals("Título del capítulo", capitulo.getTitulo());
        }

        @Test
        @DisplayName("Debería devolver la fecha de emisión del capítulo")
        void deberiaDevolverLaFechaDeEmisionDelCapitulo() {
            assertEquals(LocalDate.of(2022, 1, 1), capitulo.getFechaEmision());
        }
    }

    @Nested
    @DisplayName("Tests para los setters")
    class SetterTest {

        @Nested
        @DisplayName("Tests para el setter de fecha de emisión")
        class FechaEmisionTest {

            @Test
            @DisplayName("debería cambiar la fecha de emisión")
            public void deberiaCambiarFechaEmision() {
                LocalDate newDate = LocalDate.of(2023, 3, 11);
                capitulo.setFechaEmision(newDate);
                assertEquals(newDate, capitulo.getFechaEmision());
            }
        }

        @Nested
        @DisplayName("Tests para setTitulo()")
        class SetTituloTest {

            @Test
            @DisplayName("Debería cambiar el título si no está vacío")
            void deberiaCambiarTituloSiNoEstaVacio() {
                String nuevoTitulo = "Nuevo Título";
                capitulo.setTitulo(nuevoTitulo);
                assertEquals(nuevoTitulo, capitulo.getTitulo());
            }

            @Test
            @DisplayName("Debería no cambiar el título si está vacío")
            void deberiaNoCambiarTituloSiEstaVacio() {
                String nuevoTitulo = "";
                capitulo.setTitulo(nuevoTitulo);
                assertEquals("Título del capítulo", capitulo.getTitulo());
            }

            @Test
            @DisplayName("Debería no cambiar el título si contiene solo espacios")
            void deberiaNoCambiarTituloSiContieneSoloEspacios() {
                String nuevoTitulo = "    ";
                capitulo.setTitulo(nuevoTitulo);
                assertEquals("Título del capítulo", capitulo.getTitulo());
            }
        }
    }

    @Nested
    @DisplayName("Tests para el método meGusta")
    class MeGustaTest {
        @Test
        @DisplayName("Debería incrementar los votos positivos cuando es true")
        public void meGusta_DeberiaIncrementarLosVotosPositivos_CuandoEsTrue() {
            capitulo.meGusta(true);
            assertEquals(3, capitulo.getVotosPositivos());
        }

        @Test
        @DisplayName("No debería incrementar los votos positivos cuando es false")
        public void meGusta_NoDeberiaIncrementarLosVotosPositivos_CuandoEsFalse() {
            capitulo.meGusta(false);
            assertEquals(2, capitulo.getVotosPositivos());
        }

        @Test
        @DisplayName("Debería incrementar los votos negativos cuando es false")
        public void meGusta_DeberiaIncrementarLosVotosNegativos_CuandoEsFalse() {
            capitulo.meGusta(false);
            assertEquals(2, capitulo.getVotosNegativos());
        }

        @Test
        @DisplayName("No debería incrementar los votos negativos cuando es true")
        public void meGusta_NoDeberiaIncrementarLosVotosNegativos_CuandoEsTrue() {
            capitulo.meGusta(true);
            assertEquals(1, capitulo.getVotosNegativos());
        }
    }
}
