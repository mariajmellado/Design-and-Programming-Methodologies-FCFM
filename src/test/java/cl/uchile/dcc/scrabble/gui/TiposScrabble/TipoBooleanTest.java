package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing de la clase TipoBoolean de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
public class TipoBooleanTest {
    private TipoBoolean bool;

    @BeforeEach
    void setUp(){
        bool = new TipoBoolean(true);
    }

    @Test
    void testMismoObjetoyValor() {
        TipoBoolean expected_bool = new TipoBoolean(true);
        TipoBoolean bool_1 = new TipoBoolean(false);
        TipoString var_string = new TipoString("false");
        assertEquals(expected_bool, bool, "No tienen el mismo valor");
        assertEquals(expected_bool.hashCode(), bool.hashCode(), "No son del mismo tipo");
        assertNotEquals(bool.hashCode(), var_string.hashCode(), "No son del mismo tipo");
        assertEquals(false, bool_1.equals(bool), "No son del mismo tipo");
        assertEquals(expected_bool, bool.getValor());
        assertFalse(bool.equals(var_string));

    }

    @Test
    void testGetteryToString() {
        TipoBoolean var_boolean_1 = new TipoBoolean(true);
        TipoBoolean var_boolean_2 = new TipoBoolean(false);
        assertEquals(true, var_boolean_1.getArg(), "No tienen el mismo valor");
        assertEquals("false", var_boolean_2.toString(), "No tienen el mismo valor");
    }
}


