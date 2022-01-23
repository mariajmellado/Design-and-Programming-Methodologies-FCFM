package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing de la clase TipoNumeroInt de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
class TipoNumeroIntTest {
    private TipoNumeroInt n_int;

    @BeforeEach
    void setUp() {
        n_int = new TipoNumeroInt(15);
    }

    @Test
    void testMismoObjetoyValor() {
        TipoNumeroInt expected_int = new TipoNumeroInt(15);
        TipoString var_string = new TipoString("false");
        TipoNumeroInt var_int = new TipoNumeroInt(11);
        assertEquals(expected_int, n_int, "No tienen el mismo valor");
        assertNotEquals(expected_int.hashCode(), var_string.hashCode(), "No son del mismo tipo");
        assertEquals(n_int.hashCode(), var_int.hashCode(), "No son del mismo tipo");
        assertEquals(false, var_int.equals(var_string));
        assertEquals(expected_int, n_int.getValor());
    }

    @Test
    void testGetteryToString() {
        TipoNumeroInt var_int = new TipoNumeroInt(15);
        TipoNumeroInt var_int_1 = new TipoNumeroInt(36);
        assertEquals(15, var_int.getArg(), "No tienen el mismo valor");
        assertEquals("36", var_int_1.toString(), "No tienen el mismo valor");
    }
}