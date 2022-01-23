package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a las transformaciones entre los Tipos de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
class ITransformacionesTest {
    private TipoNumeroInt var_int;
    private TipoNumeroFloat var_float;
    private TipoNumeroBinario var_binario;
    private TipoBoolean var_boolean;
    private TipoString var_string;
    private TipoNulo var_nula;


    @BeforeEach
    void setUp() {
        var_int = new TipoNumeroInt(5);
        var_float = new TipoNumeroFloat(5.5);
        var_binario = new TipoNumeroBinario("101010");
        var_boolean = new TipoBoolean(false);
        var_string = new TipoString("Hola");
        var_nula = new TipoNulo();
    }
    @Test
    void testMismoObjetoyValorenTransformacionaString(){
        TipoString expected_var_int = new TipoString("5");
        TipoString expected_var_float = new TipoString("5.5");
        TipoString expected_var_binario = new TipoString("101010");
        TipoString expected_var_boolean = new TipoString("false");
        TipoString expected_var_string = new TipoString("Hola");

        assertTrue(expected_var_int.equals(var_int.aTipoString()));
        assertTrue(expected_var_float.equals(var_float.aTipoString()));
        assertTrue(expected_var_binario.equals(var_binario.aTipoString()));
        assertTrue(expected_var_boolean.equals(var_boolean.aTipoString()));
        assertTrue(expected_var_string.equals(var_string.aTipoString()));
    }

    @Test
    void testMismoObjetoyValorenTransformacionaBoolean(){
        TipoBoolean expected_boolean = new TipoBoolean(false);
        assertEquals(expected_boolean, var_boolean.aTipoBoolean());
    }

    @Test
    void testMismoObjetoyValorenTransformacionaFloat() {
        TipoNumeroFloat expected_var_float = new TipoNumeroFloat(5);
        TipoNumeroFloat expected_var_float_0 = new TipoNumeroFloat(5.5);
        TipoNumeroFloat expected_var_float_1 = new TipoNumeroFloat(125);
        TipoNumeroFloat expected_var_float_2 = new TipoNumeroFloat(-67);
        TipoNumeroBinario var_binaria = new TipoNumeroBinario("0101");
        TipoNumeroBinario var_binaria_1 = new TipoNumeroBinario("01111101");
        TipoNumeroBinario var_binaria_2 = new TipoNumeroBinario("10111101");

        assertTrue(expected_var_float.equals(var_int.aTipoNumeroFloat()));
        assertTrue(expected_var_float.equals(var_binaria.aTipoNumeroFloat()));
        assertTrue(expected_var_float_0.equals(var_float.aTipoNumeroFloat()));
        assertTrue(expected_var_float_1.equals( var_binaria_1.aTipoNumeroFloat()));
        assertTrue(expected_var_float_2.equals(var_binaria_2.aTipoNumeroFloat()));
    }

    @Test
    void testMismoObjetoyValorenTransformacionaInt() {
        TipoNumeroInt expected_var_int = new TipoNumeroInt(-2);
        TipoNumeroInt expected_var_int_0 = new TipoNumeroInt(5);
        TipoNumeroInt expected_var_int_1 = new TipoNumeroInt(-38);
        TipoNumeroInt expected_var_int_2 = new TipoNumeroInt(49);
        TipoNumeroBinario var_binario = new TipoNumeroBinario("110");
        TipoNumeroBinario var_binario_1 = new TipoNumeroBinario("1011010");
        TipoNumeroBinario var_binario_2 = new TipoNumeroBinario("0110001");

        assertTrue(expected_var_int_0.equals(var_int.aTipoNumeroInt()));
        assertTrue(expected_var_int.equals(var_binario.aTipoNumeroInt()));
        assertTrue(expected_var_int.equals(var_binario.aTipoNumeroInt()));
        assertTrue(expected_var_int_1.equals(var_binario_1.aTipoNumeroInt()));
        assertTrue(expected_var_int_2.equals(var_binario_2.aTipoNumeroInt()));
    }


    @Test
    void testMismoObjetoyValorenTransformacionaBinario() {
        TipoNumeroBinario expected_var_binario_0 = new TipoNumeroBinario("101010");
        TipoNumeroBinario expected_var_binario_1 = new TipoNumeroBinario("0101");
        TipoNumeroBinario expected_var_binario_2 = new TipoNumeroBinario("1011");
        TipoNumeroInt var_int_1  = new TipoNumeroInt(-5);
        assertTrue(expected_var_binario_0.equals(var_binario.aTipoNumeroBinario()));
        assertTrue(expected_var_binario_1.equals(var_int.aTipoNumeroBinario()));
        assertTrue(expected_var_binario_2.equals(var_int_1.aTipoNumeroBinario()));
    }

    @Test
    void testTransformacionesNoPermitidas(){
        TipoNulo expected = new TipoNulo();
        //Transformaciones no permitidas para TipoString.
        assertEquals(expected, var_string.aTipoBoolean());
        assertEquals(expected, var_string.aTipoNumeroFloat());
        assertEquals(expected, var_string.aTipoNumeroInt());
        assertEquals(expected, var_string.aTipoNumeroBinario());

        //Transformaciones no permitidas para TipoBoolean.
        assertEquals(expected, var_boolean.aTipoNumeroFloat());
        assertEquals(expected, var_boolean.aTipoNumeroInt());
        assertEquals(expected, var_boolean.aTipoNumeroBinario());

        //Transformaciones no permitidas para TipoNumeroInt.
        assertEquals(expected, var_int.aTipoBoolean());

        //Transformaciones no permitidas para TipoNumeroBinario.
        assertEquals(expected, var_binario.aTipoBoolean());

        //Transformaciones no permitidas para TipoNumeroFloat.
        assertEquals(expected, var_float.aTipoBoolean());
        assertEquals(expected, var_float.aTipoNumeroInt());
        assertEquals(expected, var_float.aTipoNumeroBinario());

        //Transformaciones no permitidas para TipoNulo.
        assertEquals(expected, var_nula.aTipoBoolean());
        assertEquals(expected, var_nula.aTipoNumeroInt());
        assertEquals(expected, var_nula.aTipoNumeroBinario());
        assertEquals(expected, var_nula.aTipoBoolean());
        assertEquals(expected, var_nula.aTipoString());

    }
}