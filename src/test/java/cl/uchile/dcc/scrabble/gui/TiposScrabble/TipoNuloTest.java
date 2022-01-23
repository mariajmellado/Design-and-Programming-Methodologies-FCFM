package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNulo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing de la clase TipoNulo de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
class TipoNuloTest {
    private TipoNulo nulo;

    @BeforeEach
    void setUp() {
        nulo = new TipoNulo();
    }

    @Test
    void testMismoObjetoyValor() {
        TipoNulo expected_nulo = new TipoNulo();
        TipoNumeroInt prueba_equals = new TipoNumeroInt(2);
        assertEquals(expected_nulo, nulo);
        assertEquals(expected_nulo.getArg(), nulo.getArg());
        assertEquals(expected_nulo.hashCode(), nulo.hashCode());
        assertEquals(expected_nulo, nulo.getValor());
        assertFalse(nulo.equals(prueba_equals));
    }

}