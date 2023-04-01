import org.junit.jupiter.api.*;
import vergeflix.Capitulo;
import vergeflix.Serie;
import vergeflix.Temporada;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SerieTest {
    static Serie serie;
    @BeforeEach
    void setUp() {
        // Temporada 1
        Temporada temporada1 = new Temporada(LocalDate.of(2008, 1, 20));
        // Añadimos los Capítulos a la Temporada 1
        temporada1.añadirCapitulo(new Capitulo("Piloto", LocalDate.of(2008, 1, 20)));
        temporada1.añadirCapitulo(new Capitulo("Cat's in the Bag...", LocalDate.of(2008, 1, 27)));
        temporada1.añadirCapitulo(new Capitulo("And the Bag's in the River", LocalDate.of(2008, 2, 10)));
        // Añadimos los Me Gusta a la Temporada 1
        temporada1.meGusta("Piloto", true);
        temporada1.meGusta("Piloto", true);
        temporada1.meGusta("Cat's in the Bag...", true);
        temporada1.meGusta("And the Bag's in the River", true);
        temporada1.meGusta("And the Bag's in the River", true);
        temporada1.meGusta("And the Bag's in the River", false);

        // Temporada 2
        Temporada temporada2 = new Temporada(LocalDate.of(2009, 3, 8));
        // Añadimos los Capítulos a la Temporada 2
        temporada2.añadirCapitulo(new Capitulo("Seven Thirty-Seven", LocalDate.of(2009, 3, 8)));
        temporada2.añadirCapitulo(new Capitulo("Grilled", LocalDate.of(2009, 3, 15)));
        temporada2.añadirCapitulo(new Capitulo("Bit by a Dead Bee", LocalDate.of(2009, 3, 22)));
        // Añadimos los Me Gusta a la Temporada 2
        temporada2.meGusta("Seven Thirty-Seven", true);
        temporada2.meGusta("Grilled", true);
        temporada2.meGusta("Grilled", true);
        temporada2.meGusta("Bit by a Dead Bee", false);

        serie = new Serie("Breaking Bad", 18, LocalDate.of(2021, 1, 1), true, LocalDate.of(2008, 1, 20));
        serie.añadirTemporada(temporada1);
        serie.añadirTemporada(temporada2);
    }

    @Nested
    @DisplayName("Test para el Constructor")
    class validarConstructor {
        @Test
        @DisplayName("Crear Serie - Asignar nombre")
        void crearSerie_asignarNombre() {

            assertEquals("Breaking Bad", serie.getNombre());
        }

        @Test
        @DisplayName("Crear Serie - Asignar calificación de edad")
        void crearSerie_asignarCalificacionEdad() {
            assertEquals(18, serie.getCalificacionEdad());
        }

        @Test
        @DisplayName("Crear Serie - Asignar fecha de incorporación al catálogo")
        void crearSerie_asignarFechaIncorporacionAlCatalogo() {
            assertEquals(LocalDate.of(2021, 1, 1), serie.getFechaIncorporacionAlCatalogo());
        }

        @Test
        @DisplayName("Crear Serie - Asignar disponibilidad")
        void crearSerie_asignarDisponibilidad() {
            assertTrue(serie.isEstaDisponible());
        }

        @Test
        @DisplayName("Crear Serie - Asignar fecha de estreno")
        void crearSerie_asignarFechaEstreno() {
            assertEquals(LocalDate.of(2008, 1, 20), serie.getFechaEstreno());
        }
    }

    @Nested
    @DisplayName("Test para el Constructor Copia")
    class validarConstructorCopia {
        Serie serieCopia = new Serie(serie);

        @Test
        @DisplayName("Validar Nombre sea igual al de la Serie Copiada")
        void validarNombre() {
            assertEquals(serieCopia.getNombre(), serie.getNombre());
        }

        @Test
        @DisplayName("Validar Calificación Edad sea igual al de la Serie Copiada")
        void validarCalificacionEdad() {
            assertEquals(serieCopia.getCalificacionEdad(), serie.getCalificacionEdad());
        }

        @Test
        @DisplayName("Validar Fecha Incorporación al Catalogo sea igual al de la Serie Copiada")
        void validarFechaIncorporacionAlCatalogo() {
            assertEquals(serieCopia.getFechaIncorporacionAlCatalogo(), serie.getFechaIncorporacionAlCatalogo());
        }

        @Test
        @DisplayName("Validar Disponibilidad que sea igual al de la Serie Copiada")
        void validarDisponibilidad() {
            assertEquals(serieCopia.isEstaDisponible(), serie.isEstaDisponible());
        }

        @Test
        @DisplayName("Validar Fecha Estreno sea igual al de la Serie Copiada")
        void validarFechaEstreno() {
            assertEquals(serieCopia.getFechaEstreno(), serie.getFechaEstreno());
        }

        @Test
        @DisplayName("Validar ArrayList Temporadas sea igual al de la Serie Copiada")
        void validarTemporadas() {
            int counter = 0;
            boolean todasSonIguales = true;
            while (serie.getCopiaTemporada(counter) != null) {
                if (!serie.getCopiaTemporada(counter).getFechaEstreno().equals(serieCopia.getCopiaTemporada(counter).getFechaEstreno())) {
                    todasSonIguales = false;
                }
                counter++;
            }
            assertTrue(todasSonIguales);
        }
    }

    @Nested
    @DisplayName("Validación de Getters")
    class validarGetters {
        @Test
        @DisplayName("Validamos que retorne la fecha de estreno correctamente")
        void getFechaEstreno() {
            assertEquals(LocalDate.of(2008, 1, 20), serie.getFechaEstreno());
        }

        @Test
        @DisplayName("Validamos que obtenemos el Capítulo deseado")
        void getCapitulo() {
            System.out.println(serie.getCopiaTemporada(1));
            assertEquals(new Capitulo("Seven Thirty-Seven",LocalDate.of(2009, 3, 29)), serie.getCapitulo(1,0));
        }

        @Test
        @DisplayName("Validar que no nos pasa la referencia del Capítulo")
        void getCapituloValidarReferencia() {
            Capitulo capituloObtenido = serie.getCapitulo(1,0);
            capituloObtenido.setTitulo("Capítulo Modificado");
            assertEquals("Seven Thirty-Seven", serie.getCapitulo(1,0).getTitulo());
        }

        @Test
        @DisplayName("Debería retornar Null al pasarle una temporada Superior a las existentes")
        void getCapituloTemporadaErroneaInferior() {
            assertNull(serie.getCapitulo(-1,2));
        }

        @Test
        @DisplayName("Debería retornar Null al pasarle una temporada Superior a las existentes")
        void getCapituloTemporadaErroneaSuperior() {
            assertNull(serie.getCapitulo(2,2));
        }

        @Test
        @DisplayName("Debería retornar Null al pasarle un Capítulo Inferior (-1)")
        void getCapituloCapituloErroneoInferior() {
            assertNull(serie.getCapitulo(1,-1));
        }

        @Test
        @DisplayName("Debería retornar Null al pasarle un Capítulo Superior (13)")
        void getCapituloCapituloErroneoSuperior() {
            assertNull(serie.getCapitulo(1,13));
        }
    }

    @Nested
    @DisplayName("Validar añadirTemporada(LocalDate fechaEstreno)")
    class añadirTemporadaTestLocalDate {
        private Serie serie;

        @BeforeEach
        public void setUp() {
            serie = new Serie("Breaking Bad",18,LocalDate.of(2008, 1, 20),true, LocalDate.of(2008, 1, 20));
        }

        @Test
        @DisplayName("Añadir una temporada nueva exitosamente")
        public void testAñadirTemporadaNueva() {
            assertTrue(serie.añadirTemporada(LocalDate.of(2009, 3, 8)));
        }

        @Test
        @DisplayName("No se pueden añadir dos temporadas en un mismo mes")
        public void testNoAñadirTemporadaMismoMes() {
            serie.añadirTemporada(LocalDate.of(2009, 3, 8));
            assertFalse(serie.añadirTemporada(LocalDate.of(2009, 3, 15)));
        }

        @Test
        @DisplayName("No se puede añadir una temporada con fecha anterior al estreno de la serie")
        public void testNoAñadirTemporadaFechaAnterior() {
            assertFalse(serie.añadirTemporada(LocalDate.of(2007, 12, 15)));
        }
    }

    @Nested
    @DisplayName("Validar añadirTemporada(Temporada temporada)")
    class añadirTemporadaTestTemporada {
        private Serie serie;

        @BeforeEach
        public void setUp() {
            serie = new Serie("Breaking Bad",18,LocalDate.of(2008, 1, 20),true, LocalDate.of(2008, 1, 20));
        }

        @Test
        @DisplayName("Añadir una temporada nueva exitosamente")
        public void testAñadirTemporadaNueva() {
            Temporada nuevaTemporada = new Temporada(LocalDate.of(2009, 3, 8));
            assertTrue(serie.añadirTemporada(nuevaTemporada));
        }

        @Test
        @DisplayName("No se pueden añadir dos temporadas en un mismo mes")
        public void testNoAñadirTemporadaMismoMes() {
            Temporada nuevaTemporada = new Temporada(LocalDate.of(2009, 3, 15));
            serie.añadirTemporada(LocalDate.of(2009, 3, 8));
            assertFalse(serie.añadirTemporada(nuevaTemporada));
        }

        @Test
        @DisplayName("No se puede añadir una temporada con fecha anterior al estreno de la serie")
        public void testNoAñadirTemporadaFechaAnterior() {
            Temporada nuevaTemporada = new Temporada(LocalDate.of(2007, 12, 15));
            assertFalse(serie.añadirTemporada(nuevaTemporada));
        }
    }

    @Nested
    @DisplayName("Validar eliminarTemporada(int n)")
    class eliminarTemporada {
        @Test
        @DisplayName("Eliminar temporada existente")
        public void testEliminarTemporadaExistente() {
            // Arrange
            int posicionAEliminar = 0;

            // Act
            boolean resultado = serie.eliminarTemporada(posicionAEliminar);

            // Assert
            assertTrue(resultado);
            assertEquals(LocalDate.of(2009, 3, 8), serie.getCopiaTemporada(0).getFechaEstreno());
        }

        @Test
        @DisplayName("Eliminar temporada en posición inválida")
        public void testEliminarTemporadaPosicionInvalida() {
            // Arrange
            int posicionAEliminar = 5;

            // Act
            boolean resultado = serie.eliminarTemporada(posicionAEliminar);

            // Assert
            assertFalse(resultado);
        }

        @Test
        @DisplayName("Eliminar temporada en posición negativa")
        public void testEliminarTemporadaPosicionNegativa() {
            // Arrange
            int posicionAEliminar = -1;

            // Act
            boolean resultado = serie.eliminarTemporada(posicionAEliminar);

            // Assert
            assertFalse(resultado);
        }
    }

    @Nested
    @DisplayName("Validar añadirCapitulo(int nTemporada, Capitulo capitulo)")
    class añadirCapitulo {
        @Test
        void testAñadirCapituloValido() {
            Capitulo capituloNuevo = new Capitulo("Nuevo capítulo", LocalDate.of(2023, 3, 12));
            boolean resultado = serie.añadirCapitulo(1, capituloNuevo);
            assertTrue(resultado);
        }

        @Test
        void testAñadirCapituloMismoTitulo() {
            Capitulo capituloExistente = serie.getCopiaTemporada(1).getCapitulo(1);
            boolean resultado = serie.añadirCapitulo(1, capituloExistente);
            assertFalse(resultado);
        }

        @Test
        void testAñadirCapituloFechaInvalida() {
            Capitulo capituloNuevo = new Capitulo("Nuevo capítulo", LocalDate.of(2008, 1, 15));
            boolean resultado = serie.añadirCapitulo(1, capituloNuevo);
            assertFalse(resultado);
        }
    }

    @Nested
    @DisplayName("Validar eliminarCapitulo(int nTemporada, String titulo)")
    class elimiarCapituloNombre {
        @Test
        @DisplayName("Eliminar capítulo existente en temporada válida")
        public void eliminarCapituloTemporadaValida() {
            // Eliminar capítulo existente en temporada válida
            assertTrue(serie.eliminarCapitulo(0, "Cat's in the Bag..."));
        }

        @Test
        @DisplayName("Eliminar capítulo de temporada inválida")
        public void eliminarCapituloTemporadaInvalida() {
            // Eliminar capítulo de temporada inválida
            assertFalse(serie.eliminarCapitulo(3, "Piloto"));
        }

        @Test
        @DisplayName("No deberia Eliminar capítulo con título vacío")
        public void eliminarCapituloTituloVacio() {
            // Eliminar capítulo con título vacío
            assertFalse(serie.eliminarCapitulo(1, ""));
        }

        @Test
        @DisplayName("No deberia Eliminar capítulo con título solo de espacios")
        public void eliminarCapituloTituloEspacios() {
            // Eliminar capítulo con título solo de espacios
            assertFalse(serie.eliminarCapitulo(1, "   "));
        }
    }

    @Nested
    @DisplayName("Validar eliminarCapitulos(String expresionRegular)")
    class eliminarCapituloExpresionRegular {
        @Test
        void eliminarCapitulos_expresionRegularValida_eliminaCapitulosCorrectamente() {
            // Given
            String expresionRegular = ".* in the .*";
            int cantidadEsperada = 2;

            // When
            int cantidadEliminada = serie.eliminarCapitulos(expresionRegular);

            // Then
            assertEquals(cantidadEsperada, cantidadEliminada);
        }

        @Test
        void eliminarCapitulos_expresionRegularSoloEspacios_noEliminaCapitulos() {
            // Given
            String expresionRegular = "    ";
            int cantidadEsperada = 0;

            // When
            int cantidadEliminada = serie.eliminarCapitulos(expresionRegular);

            // Then
            assertEquals(cantidadEsperada, cantidadEliminada);
        }

    }

    @Nested
    @DisplayName("Validación de Setters")
    class validarSetters {
        @Nested
        @DisplayName("Validación setFechaEstreno de Serie")
        class setterFechaEstreno {
            @Test
            @DisplayName("Debería modificar correctamente la Fecha de Estreno de la Serie")
            void setFechaEstreno() {
                serie.setFechaEstreno(LocalDate.of(2008, 1, 19));
                assertEquals(LocalDate.of(2008, 1, 19), serie.getFechaEstreno());
            }

            @Test
            @DisplayName("No debería cambiar la Fecha de Estreno ya que es posterior a la primera Temporada")
            void setFechaEstrenoPosteriorATemporada() {
                serie.setFechaEstreno(LocalDate.of(2008, 1, 21));
                assertEquals(LocalDate.of(2008, 1, 20), serie.getFechaEstreno());
            }
        }


        @Nested
        @DisplayName("Validación setFechaEstreno de Temporada")
        class setterFechaEstrenoTemporada {
            @Test
            @DisplayName("Debería modificar correctamente la Fecha Estreno de la Temporada")
            void setFechaEstrenoTemporada() {
                serie.setFechaEstrenoTemporada(1,LocalDate.of(2009,3,7));
                assertEquals(LocalDate.of(2009,3,7), serie.getCopiaTemporada(1).getFechaEstreno());
            }

            @Test
            @DisplayName("No debería modifcar la fecha de Estreno de la Temporada ya que es posterior a la salida del Primer Capítulo")
            void setFechaEstrenoTemporadaNoValidaFechaPosteriorACapitulo() {
                serie.setFechaEstrenoTemporada(1,LocalDate.of(2009,3,9));
                assertEquals(LocalDate.of(2009,3,8), serie.getCopiaTemporada(1).getFechaEstreno());
            }

            @Test
            @DisplayName("No debería modificar ya que la posicion de Temporada no existe (Inferior)")
            void setFechaEstrenoTemporadaNoValidaTemporadaInferior() {
                serie.setFechaEstrenoTemporada(-1,LocalDate.of(2009,3,9));
                assertEquals(LocalDate.of(2009,3,8), serie.getCopiaTemporada(1).getFechaEstreno());
            }

            @Test
            @DisplayName("No debería modificar ya que la posicion de Temporada no existe (Superior)")
            void setFechaEstrenoTemporadaNoValidaTemporadaSuperior() {
                serie.setFechaEstrenoTemporada(2,LocalDate.of(2009,3,9));
                assertEquals(LocalDate.of(2009,3,8), serie.getCopiaTemporada(1).getFechaEstreno());
            }
        }

        @Nested
        @DisplayName("Validación setCapitulo(int nTemporada, int posicion, LocalDate fechaEmision, String titulo)")
        class setterCapitulo {

            @Nested
            @DisplayName("Modificaciones Válidas")
            class setterCapituloModificaconValida {
                @Test
                @DisplayName("Validamos que retorna True")
                void setCapituloValidoBoolean() {
                    boolean cambioRealizado = serie.setCapitulo(1,0,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    assertTrue(cambioRealizado);
                }

                @Test
                @DisplayName("Validamos que cambie el Título del Capítulo")
                void setCapituloValidoNombre() {
                    boolean cambioRealizado = serie.setCapitulo(1,0,"Capitulo Modificado");
                    Capitulo expectedCapitulo = new Capitulo("Capitulo Modificado", LocalDate.of(2009,3,28));
                    Capitulo actualCapitulo = serie.getCapitulo(1,0);
                    assertEquals(expectedCapitulo.getTitulo(), actualCapitulo.getTitulo());
                }

                @Test
                @DisplayName("Validamos que cambie la Fecha del Capítulo")
                void setCapituloValidoFecha() {
                    boolean cambioRealizado = serie.setCapitulo(1,0,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    Capitulo expectedCapitulo = new Capitulo("Capitulo Modificado", LocalDate.of(2009,3,28));
                    Capitulo actualCapitulo = serie.getCapitulo(1,2);
                    assertEquals(expectedCapitulo.getFechaEmision(), actualCapitulo.getFechaEmision());
                }
            }

            @Nested
            @DisplayName("Modificaciones No Válidas (Posición Temporada)")
            class setterCapituloNoModificadoTemporada {
                @Test
                @DisplayName("Validamos que retorne false al insertar la temporada (-1)")
                void setCapituloTemporadaNoValidaInferior() {
                    boolean cambioRealizado = serie.setCapitulo(-1,3,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    assertFalse(cambioRealizado);
                }
                @Test
                @DisplayName("Validamos que retorne false al insertar la temporada (2)")
                void setCapituloTemporadaNoValidaSuperior() {
                    boolean cambioRealizado = serie.setCapitulo(2,3,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    assertFalse(cambioRealizado);
                }

                @Test
                @DisplayName("Validamos que no cambie el Título del Capítulo al insertar una Temporada -1")
                void setCapituloTemporadaNoValidaInferiorNoCambioDeNombre() {
                    serie.setCapitulo(-1,3,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    Capitulo actualCapitulo = serie.getCapitulo(1,0);
                    assertEquals("Seven Thirty-Seven", actualCapitulo.getTitulo());
                }

                @Test
                @DisplayName("Validamos que no cambie la Fecha del Capítulo al insertar una Temporada 2")
                void setCapituloTemporadaNoValidaSuperiorNoCambioDeFecha() {
                    serie.setCapitulo(2,3,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    Capitulo actualCapitulo = serie.getCapitulo(1,0);
                    assertEquals(LocalDate.of(2009, 3, 8), actualCapitulo.getFechaEmision());
                }
            }

            @Nested
            @DisplayName("Modificaciones No Válidas (Posición Capítulo)")
            class setterCapituloNoModificadoPosicionCapitulo {
                @Test
                @DisplayName("Validamos que retorne false al insertar la Posición del Capítulo a (-1)")
                void setCapituloPosicionCapituloNoValidaInferior() {
                    boolean cambioRealizado = serie.setCapitulo(1,-1,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    assertFalse(cambioRealizado);
                }

                @Test
                @DisplayName("Validamos que retorne false al insertar la Posición del Capítulo a (13)")
                void setCapituloPosicionCapituloNoValidaSuperior() {
                    boolean cambioRealizado = serie.setCapitulo(1,13,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    assertFalse(cambioRealizado);
                }

                @Test
                @DisplayName("Validamos que no cambie el Título del Capítulo al insertar una Posición del Capítulo a -1")
                void setCapituloTemporadaNoValidaInferiorNoCambioDeNombre() {
                    serie.setCapitulo(1,-1,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    Capitulo actualCapitulo = serie.getCapitulo(1,0);
                    assertEquals("Seven Thirty-Seven", actualCapitulo.getTitulo());
                }

                @Test
                @DisplayName("Validamos que no cambie la Fecha del Capítulo al insertar una Temporada 2")
                void setCapituloTemporadaNoValidaSuperiorNoCambioDeFecha() {
                    serie.setCapitulo(2,13,LocalDate.of(2009,3,28),"Capitulo Modificado");
                    Capitulo actualCapitulo = serie.getCapitulo(1,0);
                    assertEquals(LocalDate.of(2009, 3, 8), actualCapitulo.getFechaEmision());
                }
            }

            @Nested
            @DisplayName("Modificaciones no Válidas (Fecha Emisión y Título)")
            class setCapituloFechaEmision {

                @Test
                @DisplayName("Validamos que devuelve false al insertar una fecha de Emisión Anterior a la Temporada")
                void setCapituloFechaEmsionNoValidaAnterior() {
                    boolean cambioRealizado = serie.setCapitulo(1,1,LocalDate.of(2009,3,7),"Capitulo Modificado");
                    assertFalse(cambioRealizado);
                }

                @Test
                @DisplayName("Validamos que devuelve false al insertar un Título ya existente")
                void setCapituloTituloNoValido() {
                    boolean cambioRealizado = serie.setCapitulo(1,1,LocalDate.of(2009,3,8),"Seven Thirty-Seven");
                    assertFalse(cambioRealizado);
                }
            }
        }

        @Nested
        @DisplayName("Validación de MeGusta (Posición, Título)")
        class validarMeGusta {
            @Nested
            @DisplayName("Validación por Posición")
            class validarMeGustaPosicion {
                @Test
                @DisplayName("Validamos que asigna el me gusta correctamente")
                void meGustaValido() {
                    serie.meGusta(1,0,true);
                    assertEquals(2, serie.getCapitulo(1,0).getVotosPositivos());
                }

                @Test
                @DisplayName("Devuelve false al insertar un temporada inferior -1")
                void meGustaNoValidoTemporadaInferior() {
                    assertFalse(serie.meGusta(-1,0,true));
                }

                @Test
                @DisplayName("Devuelve false al insertar un temporada superior 2")
                void meGustaNoValidoTemporadaSuperior() {
                    assertFalse(serie.meGusta(2,0,true));
                }

                @Test
                @DisplayName("Devuelve false al insertar un capítulo inferior -1")
                void meGustaNoValidoCapituloInferior() {
                    assertFalse(serie.meGusta(1,-1,true));
                }

                @Test
                @DisplayName("Devuelve false al insertar un capítulo superior 13")
                void meGustaNoValidoCapituloSuperior() {
                    assertFalse(serie.meGusta(1,13,true));
                }
            }

            @Nested
            @DisplayName("Validar meGusta por Título")
            class validarMeGustaTitulo {
                @Test
                @DisplayName("Validamos que asigna el me gusta correctamente")
                void meGustaValido() {
                    serie.meGusta(1,"Seven Thirty-Seven",true);
                    assertEquals(2, serie.getCapitulo(1,0).getVotosPositivos());
                }

                @Test
                @DisplayName("Devuelve false al insertar un temporada inferior -1")
                void meGustaNoValidoTemporadaInferior() {
                    assertFalse(serie.meGusta(-1,"Down",true));
                }

                @Test
                @DisplayName("Devuelve false al insertar un temporada superior 2")
                void meGustaNoValidoTemporadaSuperior() {
                    assertFalse(serie.meGusta(2,"Down",true));
                }

                @Test
                @DisplayName("Devuelve false al insertar un capítulo que no existe")
                void meGustaNoValidoCapituloNoExistente() {
                    assertFalse(serie.meGusta(1,"Paco Lucas",true));
                }

                @Test
                @DisplayName("Devuelve false al insertar un capítulo vacio")
                void meGustaNoValidoCapituloVacio() {
                    assertFalse(serie.meGusta(1,"",true));
                }

                @Test
                @DisplayName("Devuelve false al insertar un capítulo con solo espacios")
                void meGustaNoValidoCapituloSoloEspacios() {
                    assertFalse(serie.meGusta(1,"   ",true));
                }
            }
        }
    }

    @Nested
    @DisplayName("Validacion de getCopiaTemporada")
    class getCopiaTemporada {

        @Test
        void getCopiaTemporasaValida() {
            boolean copiaValida = true;
            Temporada temporadacopia = serie.getCopiaTemporada(1);
            int counter = 0;
            while (temporadacopia.getCapitulo(counter) != null) {
                if (!temporadacopia.getCapitulo(counter).equals(serie.getCapitulo(1,counter))) {
                    copiaValida = false;
                }
                counter++;
            }
            assertTrue(copiaValida);
        }
    }
}