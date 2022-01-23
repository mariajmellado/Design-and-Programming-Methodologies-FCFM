package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroBinario;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Clase que hace testing de la clase TipoNumeroBinario de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
class TipoNumeroBinarioTest {
    private TipoNumeroBinario var_binaria;
    private TipoNumeroBinario var_binaria2;


    @BeforeEach
    void setUp(){
        var_binaria = new TipoNumeroBinario("01110");
        var_binaria2 = new TipoNumeroBinario("101110");
    }

    @Test
    void testMismoObjetoyValor() {
        TipoNumeroBinario expected_binario = new TipoNumeroBinario("101110");
        TipoString var_string = new TipoString("false");
        assertNotEquals(expected_binario, var_binaria, "No tienen el mismo valor");
        assertEquals(expected_binario.hashCode(), var_binaria.hashCode(), "No son del mismo tipo");
        assertNotEquals(var_binaria.hashCode(), var_string.hashCode(), "No son del mismo tipo");
        assertEquals(false, var_binaria.equals(var_string), "No son del mismo tipo");
        assertEquals(expected_binario, var_binaria2.getValor());
    }

    @Test
    void testGetteryToString() {
        TipoNumeroBinario var_binaria_1= new TipoNumeroBinario("10101");
        TipoNumeroBinario var_binaria_2 = new TipoNumeroBinario("01111");
        assertEquals("10101", var_binaria_1.getArg(), "No tienen el mismo valor");
        assertEquals("01111", var_binaria_2.toString(), "No tienen el mismo valor");

    }

}