import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import vergeflix.*;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class MediaTest {
    private Pelicula media;

    @BeforeEach
    void beforeEach() {
        media = new Pelicula("El Padrino", 18, LocalDate.of(1972, 3, 15), true, "Francis Ford Coppola", "Marlon Brando", 175, Tematica.DRAMA);
    }

    @Nested
    @DisplayName("Constructores")
    class Constructores {

        @Test
        @DisplayName("Debería lanzar excepción al pasar un nombre vacío")
        void deberiaLanzarExcepcionAlPasarNombreVacio() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("", 18, LocalDate.now(), true, "director", "actor", 120, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería lanzar excepción al pasar un nombre con solo espacios en blanco")
        void deberiaLanzarExcepcionAlPasarNombreConSoloEspaciosEnBlanco() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("     ", 18, LocalDate.now(), true, "director", "actor", 120, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería lanzar excepción al pasar una calificación de edad menor que cero")
        void deberiaLanzarExcepcionAlPasarCalificacionEdadMenorQueCero() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("nombre", -1, LocalDate.now(), true, "director", "actor", 120, Tematica.DRAMA));
        }

        @Test
        @DisplayName("Debería lanzar excepción al pasar una calificación de edad mayor que 18")
        void deberiaLanzarExcepcionAlPasarCalificacionEdadMayorQueDieciocho() {
            assertThrows(IllegalArgumentException.class, () -> new Pelicula("nombre", 19, LocalDate.now(), true, "director", "actor", 120, Tematica.DRAMA));
        }

        @Test
        @DisplayName("debería inicializar todos los valores de Media correctamente")
        void deberiaInicializarTodosLosValoresDeMediaCorrectamente() {
            // Arrange
            String expectedNombre = "El Padrino";
            int expectedCalificacionEdad = 18;
            LocalDate expectedFechaIncorporacionAlCatalogo = LocalDate.of(1972, 3, 15);
            boolean expectedDisponibilidad= true;
            String expectedDirector = "Francis Ford Coppola";
            String expectedActorPrincipal = "Marlon Brando";
            int expectedDuracion = 175;
            Tematica expectedTematica = Tematica.DRAMA;
            Pelicula media = new Pelicula(expectedNombre, expectedCalificacionEdad, expectedFechaIncorporacionAlCatalogo,
                    expectedDisponibilidad, expectedDirector, expectedActorPrincipal, expectedDuracion, expectedTematica);

            // Assert
            assertEquals(expectedNombre, media.getNombre());
            assertEquals(expectedCalificacionEdad, media.getCalificacionEdad());
            assertEquals(expectedFechaIncorporacionAlCatalogo, media.getFechaIncorporacionAlCatalogo());
            assertEquals(expectedDisponibilidad, media.isEstaDisponible());
        }

    }

    @Nested
    @DisplayName("Pruebas de los Getters")
    class GettersTest {
        @Test
        @DisplayName("Debería devolver el nombre esperado")
        void deberiaDevolverElNombreEsperado() {
            // Arrange
            String expected = "El Padrino";

            // Act
            String actual = media.getNombre();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Debería devolver la calificación de edad esperada")
        void deberiaDevolverLaCalificacionDeEdadEsperada() {
            // Arrange
            int expected = 18;

            // Act
            int actual = media.getCalificacionEdad();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Debería devolver la fecha de incorporación al catálogo esperada")
        void deberiaDevolverLaFechaDeIncorporacionAlCatalogoEsperada() {
            // Arrange
            LocalDate expected = LocalDate.of(1972, 3, 15);

            // Act
            LocalDate actual = media.getFechaIncorporacionAlCatalogo();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Debería devolver el estado de disponibilidad esperado")
        void deberiaDevolverElEstadoDeDisponibilidadEsperado() {
            // Arrange
            boolean expected = true;

            // Act
            boolean actual = media.isEstaDisponible();

            // Assert
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Pruebas para los setters de Media")
    class MediaSettersTests {

        @Test
        @DisplayName("debería establecer un nuevo nombre cuando es válido")
        void deberiaEstablecerNuevoNombreCuandoEsValido() {
            // Arrange
            String expectedName = "El Padrino: Parte II";

            // Act
            media.setNombre(expectedName);

            // Assert
            assertEquals(expectedName, media.getNombre());
        }

        @Test
        @DisplayName("no debería establecer un nuevo nombre cuando está vacío")
        void noDeberiaEstablecerNuevoNombreCuandoEstaVacio() {
            // Arrange
            String expectedName = media.getNombre();

            // Act
            media.setNombre("");

            // Assert
            assertEquals(expectedName, media.getNombre());
        }

        @Test
        @DisplayName("no debería establecer un nuevo nombre cuando solo contiene espacios")
        void noDeberiaEstablecerNuevoNombreCuandoSoloContieneEspacios() {
            // Arrange
            String expectedName = media.getNombre();

            // Act
            media.setNombre("   ");

            // Assert
            assertEquals(expectedName, media.getNombre());
        }

        @Test
        @DisplayName("debería establecer una nueva calificación de edad cuando es válida")
        void deberiaEstablecerNuevaCalificacionEdadCuandoEsValida() {
            // Arrange
            int expectedAgeRating = 12;

            // Act
            media.setCalificacionEdad(expectedAgeRating);

            // Assert
            assertEquals(expectedAgeRating, media.getCalificacionEdad());
        }

        @Test
        @DisplayName("no debería establecer una nueva calificación de edad cuando es superior a 18")
        void noDeberiaEstablecerNuevaCalificacionEdadCuandoEsInferiorACero() {
            // Arrange
            int expectedAgeRating = media.getCalificacionEdad();

            // Act
            media.setCalificacionEdad(-1);

            // Assert
            assertEquals(expectedAgeRating, media.getCalificacionEdad());
        }

        @Test
        @DisplayName("no debería establecer una nueva calificación de edad cuando está fuera del rango válido")
        void noDeberiaEstablecerNuevaCalificacionEdadCuandoEsSuperiorADieciOcho() {
            // Arrange
            int expectedAgeRating = media.getCalificacionEdad();

            // Act
            media.setCalificacionEdad(19);

            // Assert
            assertEquals(expectedAgeRating, media.getCalificacionEdad());
        }

        @Test
        @DisplayName("debería establecer una nueva fecha de incorporación al catálogo cuando es válida")
        void deberiaEstablecerNuevaFechaIncorporacionAlCatalogoCuandoEsValida() {
            // Arrange
            LocalDate expectedDate = LocalDate.of(2022, 1, 1);

            // Act
            media.setFechaIncorporacionAlCatalogo(expectedDate);

            // Assert
            assertEquals(expectedDate, media.getFechaIncorporacionAlCatalogo());
        }

        @Test
        @DisplayName("debería establecer una nueva disponibilidad cuando es válida")
        void deberiaEstablecerNuevaDisponibilidadCuandoEsValida() {
            // Arrange
            boolean expectedAvailability = false;

            // Act
            media.setEstaDisponible(expectedAvailability);

            // Assert
            assertEquals(expectedAvailability, media.isEstaDisponible());
        }
    }


    @Nested
    @DisplayName("Tests para el método equals de la clase Media")
    class MediaEqualsTests {
        private Pelicula media;

        @BeforeEach
        void beforeEach() {
            media = new Pelicula("El Padrino", 18, LocalDate.of(1972, 3, 15), true, "Francis Ford Coppola", "Marlon Brando", 175, Tematica.DRAMA);
        }

        @Test
        @DisplayName("Debería ser igual a sí mismo")
        void deberiaSerIgualASiMismo() {
            // Assert
            assertTrue(media.equals(media));
        }

        @Test
        @DisplayName("No debería ser igual a un objeto nulo")
        void noDeberiaSerIgualAObjetoNulo() {
            // Assert
            assertFalse(media.equals(null));
        }

        @Test
        @DisplayName("No debería ser igual a un objeto de otra clase")
        void noDeberiaSerIgualAObjetoDeOtraClase() {
            // Arrange
            Object obj = new Object();

            // Assert
            assertFalse(media.equals(obj));
        }

        @Test
        @DisplayName("Debería ser igual a otra película con el mismo nombre y calificación de edad")
        void deberiaSerIgualAOtraPeliculaConElMismoNombreYCalificacionDeEdad() {
            // Arrange
            Pelicula otraPelicula = new Pelicula("El Padrino", 18, LocalDate.of(1974, 10, 16), true, "Francis Ford Coppola", "Al Pacino", 202, Tematica.DRAMA);

            // Assert
            assertTrue(media.equals(otraPelicula));
        }

        @Test
        @DisplayName("No debería ser igual a otra película con un nombre diferente")
        void noDeberiaSerIgualAOtraPeliculaConNombreDiferente() {
            // Arrange
            Pelicula otraPelicula = new Pelicula("El Padrino Parte II", 18, LocalDate.of(1974, 12, 20), true, "Francis Ford Coppola", "Al Pacino", 200, Tematica.DRAMA);

            // Assert
            assertFalse(media.equals(otraPelicula));
        }

        @Test
        @DisplayName("No debería ser igual a otra película con una calificación de edad diferente")
        void noDeberiaSerIgualAOtraPeliculaConCalificacionDeEdadDiferente() {
            // Arrange
            Pelicula otraPelicula = new Pelicula("El Padrino", 16, LocalDate.of(1974, 10, 16), true, "Francis Ford Coppola", "Al Pacino", 202, Tematica.DRAMA);

            // Assert
            assertFalse(media.equals(otraPelicula));
        }

        @Test
        @DisplayName("No debería ser igual a otra película con todos los atributos diferentes")
        void noDeberiaSerIgualAOtraPeliculaConTodosLosAtributosDiferentes() {
            // Arrange
            Pelicula otraPelicula = new Pelicula("El Padrino Parte II", 16, LocalDate.of(1974, 12, 20), false, "Francis Ford Coppola", "Robert De Niro", 220, Tematica.CIENCIA_FICCION);

            // Assert
            assertFalse(media.equals(otraPelicula));
        }
    }
}