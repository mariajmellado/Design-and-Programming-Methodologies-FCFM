package cl.uchile.dcc.scrabble.gui.TiposScrabble;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing de la clase TipoString de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
class TipoStringTest {
    private TipoString string;
    private TipoNumeroInt entero;

    @BeforeEach
    void setUp() {
        string = new TipoString("Hola");
        entero = new TipoNumeroInt(5);
    }

    @Test
    void testMismoObjetoyValor() {
        TipoString expected_string_1 = new TipoString("Hola");
        TipoString var_string = new TipoString("Como estas?");
        TipoString var_string_1 = new TipoString("No toi");
        assertEquals(expected_string_1, string, "No son el mismo valor");
        assertEquals(expected_string_1.hashCode(), string.hashCode(), "No tienen el mismo tipo");
        assertNotEquals(var_string_1, var_string);
        assertFalse(string.equals(entero));
        assertFalse(var_string_1.equals(var_string));
        assertEquals(expected_string_1, string.getValor());
    }

    @Test
    void testGetteryToString() {
        TipoString var_string = new TipoString("15sdf");
        TipoString var_string_1 = new TipoString("wasaaaaaaaaaaaauski ordenaste tu papeleo anoche");
        assertEquals("15sdf", var_string.getArg(), "No tienen el mismo valor");
        assertEquals("wasaaaaaaaaaaaauski ordenaste tu papeleo anoche", var_string_1.toString(), "No tienen el mismo valor");
    }

}