package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing de la clase TipoNumeroFloat de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
class TipoNumeroFloatTest {
    private TipoNumeroFloat n_float;

    @BeforeEach
    void setUp() {
        n_float = new TipoNumeroFloat( 1.25);
    }

    @Test
    void testMismoObjetoyValor() {
        TipoNumeroFloat expected_float = new TipoNumeroFloat(1.25);
        TipoNumeroFloat var_float = new TipoNumeroFloat(3.56);
        TipoString var_string = new TipoString("Float");
        assertEquals(expected_float, n_float, "No tienen el mismo valor");
        assertEquals(expected_float.hashCode(), var_float.hashCode(), "No son del mismo tipo");
        assertNotEquals(n_float.hashCode(), var_string.hashCode(), "No son del mismo tipo");
        assertEquals(false, var_float.equals(var_string), "No son del mismo tipo");
        assertEquals(expected_float, n_float.getValor());
    }

    @Test
    void testGetteryToString() {
        TipoNumeroFloat var_float = new TipoNumeroFloat(19.67);
        TipoNumeroFloat var_float_1 = new TipoNumeroFloat(-39.32);
        assertEquals(19.67, var_float.getArg(), "No tienen el mismo valor");
        assertEquals("-39.32", var_float_1.toString(), "No tienen el mismo valor");
    }
}