package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a las operaciones entre los Tipos de Scrabble.
 * @autor: María Jesús Mellado Tenorio.
 */
class IOperacionesTest {
    private TipoNumeroInt var_int;
    private TipoNumeroFloat var_float;
    private TipoNumeroBinario var_binaria;
    private TipoBoolean var_boolean_1;
    private TipoBoolean var_boolean_2;
    private TipoString var_string;
    private TipoNulo var_nula;

    @BeforeEach
    void setUp() {
        var_int = new TipoNumeroInt(2);
        var_float = new TipoNumeroFloat(5.5);
        var_binaria = new TipoNumeroBinario("110");
        var_boolean_1 = new TipoBoolean(true);
        var_boolean_2 = new TipoBoolean(false);
        var_string = new TipoString("Hola");
        var_nula = new TipoNulo();
    }

    @Test
    void TestOperacionesEntreTipoNumeroIntyTipoNumeroFloat() {
        TipoNumeroFloat expected_var_float_1 = new TipoNumeroFloat(5.5);
        TipoNumeroFloat expected_var_float_2 = new TipoNumeroFloat(3.5);
        TipoNumeroFloat expected_var_float_3 = new TipoNumeroFloat(-3.5);
        TipoNumeroFloat expected_var_float_4 = new TipoNumeroFloat(2.0);
        TipoNumeroFloat var_float_1 = new TipoNumeroFloat(3.5);
        TipoNumeroFloat var_float_2 = new TipoNumeroFloat(2.75);
        TipoNumeroFloat var_float_3 = new TipoNumeroFloat(7);
        TipoNumeroInt var_int_1 = new TipoNumeroInt(7);
        TipoNumeroInt var_int_2 = new TipoNumeroInt(5);
        TipoNumeroInt var_int_3 = new TipoNumeroInt(10);

        // Primero probemos entre TiposInt.

        assertEquals(var_int_1, var_int_2.Suma(var_int));
        assertEquals(var_int_2, var_int_1.Resta(var_int));
        assertEquals(var_int_3, var_int_2.Multiplica(var_int));
        assertEquals(var_int_2, var_int_3.Divide(var_int));


        // Veamos entre TipoFloat.
        assertEquals(expected_var_float_1, expected_var_float_4.Suma(var_float_1));
        assertEquals(var_float_1, var_float_3.Resta(var_float_1));
        assertEquals(var_float_3, expected_var_float_4.Multiplica(var_float_1));
        assertEquals(expected_var_float_4, var_float_3.Divide(var_float_1));


        // Suma entre ambos tipos.
        assertEquals(expected_var_float_1, var_float_1.Suma(var_int));
        assertEquals(expected_var_float_1, var_int.Suma(var_float_1));
        assertEquals(expected_var_float_1.hashCode(), var_float_1.Suma(var_int).hashCode(),
                "No son del mismo tipo");
        assertEquals(expected_var_float_1.hashCode(), var_int.Suma(var_float_1).hashCode(),
                "No son del mismo tipo");

        // Resta entre ambos tipos
        assertEquals(expected_var_float_3, var_float_1.Resta(var_int_1));
        assertEquals(expected_var_float_2, var_int_1.Resta(var_float_1));

        // Multiplicacion entre ambos tipos.
        assertEquals(expected_var_float_1, var_float_2.Multiplica(var_int));
        assertEquals(expected_var_float_1, var_int.Multiplica(var_float_2));

        // Division entre ambos tipos.
        assertEquals(var_float_2, var_float.Divide(var_int));
        assertEquals(expected_var_float_4, var_int_1.Divide(var_float_1));
        }

    @Test
    void TestOperacionesparaTipoString() {
        TipoString expected_var_string_1 = new TipoString("Hola2");
        assertEquals(expected_var_string_1, var_string.Suma(var_int));
        TipoString expected_var_string_2 = new TipoString("Hola5.5");
        assertEquals(expected_var_string_2, var_string.Suma(var_float));
        TipoString expected_var_string_3 = new TipoString("Hola110");
        assertEquals(expected_var_string_3, var_string.Suma(var_binaria));
        TipoString expected_var_string_4 = new TipoString("Holatrue");
        assertEquals(expected_var_string_4, var_string.Suma(var_boolean_1));
        TipoString expected_var_string_5 = new TipoString("HolaHola");
        assertEquals(expected_var_string_5, var_string.Suma(var_string));

    }

    @Test
    void TestOperacionNegacionparacadaTipoexceptoTipoString() {
        TipoNumeroInt expected_var_int_1 = new TipoNumeroInt(-2);
        TipoNumeroFloat expected_var_float_1 = new TipoNumeroFloat(-5.5);
        TipoNumeroBinario expected_var_binaria_1 = new TipoNumeroBinario("001");

        assertEquals(var_boolean_2, var_boolean_1.Negacion());
        assertEquals(var_boolean_1, var_boolean_2.Negacion());
        assertEquals(expected_var_int_1, var_int.Negacion());
        assertEquals(expected_var_float_1, var_float.Negacion());
        assertEquals(expected_var_binaria_1, var_binaria.Negacion());
    }

    @Test
    void TestOperacionDisyuncionyConjuncionLogicaEntreTipoBooleanyTipoBinario() {
        //Primero probemos para TipoBool.
        TipoNumeroBinario expected_var_binaria_1 = new TipoNumeroBinario("111111");
        TipoNumeroBinario expected_var_binaria_2 = new TipoNumeroBinario("000000");
        TipoNumeroBinario expected_var_binaria_3 = new TipoNumeroBinario("101011");
        TipoNumeroBinario expected_var_binaria_4 = new TipoNumeroBinario("100001");
        TipoNumeroBinario expected_var_binaria_5 = new TipoNumeroBinario("1111111011");
        TipoNumeroBinario expected_var_binaria_6 = new TipoNumeroBinario("0000100001");
        TipoNumeroBinario expected_var_binaria_7 = new TipoNumeroBinario("1000111101");
        TipoNumeroBinario expected_var_binaria_8 = new TipoNumeroBinario("0000010001");
        TipoNumeroBinario var_binaria_1 = new TipoNumeroBinario("100101");
        TipoNumeroBinario var_binaria_2 = new TipoNumeroBinario("100011");
        TipoNumeroBinario var_binaria_3 = new TipoNumeroBinario("101000");
        TipoNumeroBinario var_binaria_4 = new TipoNumeroBinario("1000111001");
        TipoNumeroBinario var_binaria_5 = new TipoNumeroBinario("0000111001");
        TipoNumeroBinario var_binaria_7 = new TipoNumeroBinario("0010101");


        // Probamos para TipoBoolean
        assertEquals(var_boolean_1, var_boolean_1.DisyuncionLogica(var_boolean_1));
        assertEquals(var_boolean_2, var_boolean_2.DisyuncionLogica(var_boolean_2));
        assertEquals(var_boolean_2, var_boolean_1.ConjuncionLogica(var_boolean_2));
        assertEquals(var_boolean_1, var_boolean_1.ConjuncionLogica(var_boolean_1));

        // Probamos para TipoNumeroBinario.
        assertEquals(expected_var_binaria_3, var_binaria_2.DisyuncionLogica(var_binaria_3));
        assertEquals(expected_var_binaria_4, var_binaria_1.ConjuncionLogica(var_binaria_2));
        assertEquals(expected_var_binaria_5, var_binaria_4.DisyuncionLogica(var_binaria_2));
        assertEquals(expected_var_binaria_7, var_binaria_4.DisyuncionLogica(var_binaria_7));
        assertEquals(expected_var_binaria_6, var_binaria_5.ConjuncionLogica(var_binaria_1));
        assertEquals(expected_var_binaria_8, var_binaria_5.ConjuncionLogica(var_binaria_7));

        // Probamos de TipoBoolean a TipoBinario.
        assertEquals(expected_var_binaria_1, var_boolean_1.DisyuncionLogica(var_binaria_1));
        assertEquals(var_binaria_1, var_boolean_2.DisyuncionLogica(var_binaria_1));
        assertEquals(var_binaria_2, var_boolean_1.ConjuncionLogica(var_binaria_2));
        assertEquals(expected_var_binaria_2, var_boolean_2.ConjuncionLogica(var_binaria_2));

        // Probamos de TipoBinario a TipoBool.
        assertEquals(expected_var_binaria_1, var_binaria_1.DisyuncionLogica(var_boolean_1));
        assertEquals(var_binaria_1, var_binaria_1.DisyuncionLogica(var_boolean_2));
        assertEquals(var_binaria_2, var_binaria_2.ConjuncionLogica(var_boolean_1));
        assertEquals(expected_var_binaria_2, var_binaria_2.ConjuncionLogica(var_boolean_2));

    }

    @Test
    void TestOperacionesEntreTipoNumeroBinarioyTipoNumeroIntyViceversa() {
        TipoNumeroInt expected_var_int_0 = new TipoNumeroInt(565);
        TipoNumeroInt expected_var_int_1 = new TipoNumeroInt(768);
        TipoNumeroInt expected_var_int_2 = new TipoNumeroInt(468);
        TipoNumeroInt expected_var_int_3 = new TipoNumeroInt(-2);
        TipoNumeroBinario expected_var_binaria_1 = new TipoNumeroBinario("01100001"); //97
        TipoNumeroBinario expected_var_binaria_2 = new TipoNumeroBinario("0100001"); //33
        TipoNumeroBinario expected_var_binaria_3 = new TipoNumeroBinario("0100000100000"); //2080
        TipoNumeroBinario expected_var_binaria_4 = new TipoNumeroBinario("101"); //-3
        TipoNumeroBinario expected_var_binaria_5 = new TipoNumeroBinario("010001100100110"); // 8998
        TipoNumeroBinario expected_var_binaria_6 = new TipoNumeroBinario("010000001110010"); // 8306
        TipoNumeroBinario expected_var_binaria_7 = new TipoNumeroBinario("01100000000"); // 768
        TipoNumeroBinario expected_var_binaria_8 = new TipoNumeroBinario("01100"); // 12
        TipoNumeroBinario var_binaria_1 = new TipoNumeroBinario("01000001"); //65
        TipoNumeroBinario var_binaria_2 = new TipoNumeroBinario("0100000"); // 32
        TipoNumeroBinario var_binaria_3 = new TipoNumeroBinario("10100000"); //-96
        TipoNumeroBinario var_binaria_4 = new TipoNumeroBinario("010000100110010"); //8498
        TipoNumeroInt var_int_1 = new TipoNumeroInt(500);
        TipoNumeroInt var_int_2 = new TipoNumeroInt(-8);
        TipoNumeroInt var_int_3 = new TipoNumeroInt(192);


        // Probamos entre TipoNumeroBinario
        assertEquals(expected_var_binaria_1, var_binaria_1.Suma(var_binaria_2));
        assertEquals(expected_var_binaria_2, var_binaria_1.Resta(var_binaria_2));
        assertEquals(expected_var_binaria_3, var_binaria_1.Multiplica(var_binaria_2));
        assertEquals(expected_var_binaria_4, var_binaria_3.Divide(var_binaria_2));

        // Probamos entre TipoNumeroBinario y TipoNumeroInt
        assertEquals(expected_var_int_0,var_int_1.Suma(var_binaria_1));
        assertEquals(expected_var_int_2,var_int_1.Resta(var_binaria_2));
        assertEquals(expected_var_int_1,var_int_2.Multiplica(var_binaria_3));
        assertEquals(expected_var_int_3,var_int_3.Divide(var_binaria_3));

        // Probamos entre TipoNumeroInt y TipoNumeroBinario
        assertEquals(expected_var_binaria_5,var_binaria_4.Suma(var_int_1));
        assertEquals(expected_var_binaria_6,var_binaria_4.Resta(var_int_3));
        assertEquals(expected_var_binaria_7,var_binaria_3.Multiplica(var_int_2));
        assertEquals(expected_var_binaria_8,var_binaria_3.Divide(var_int_2));
    }

    @Test
    void TestOperacionesEntreTipoNumeroFloatyTipoNumeroBinario() {
        TipoNumeroFloat expected_var_float_0 = new TipoNumeroFloat(115);
        TipoNumeroFloat expected_var_float_1 = new TipoNumeroFloat(-256);
        TipoNumeroFloat expected_var_float_2 = new TipoNumeroFloat(288);
        TipoNumeroFloat expected_var_float_3 = new TipoNumeroFloat(6);
        TipoNumeroBinario var_binaria_1 = new TipoNumeroBinario("01000001"); //65
        TipoNumeroBinario var_binaria_2 = new TipoNumeroBinario("0100000"); // 32
        TipoNumeroBinario var_binaria_3 = new TipoNumeroBinario("10100000"); //-96
        TipoNumeroFloat var_float_1 = new TipoNumeroFloat(50);
        TipoNumeroFloat var_float_2 = new TipoNumeroFloat(-8);
        TipoNumeroFloat var_float_3 = new TipoNumeroFloat(192);

        assertEquals(expected_var_float_0,var_float_1.Suma(var_binaria_1));
        assertEquals(expected_var_float_2,var_float_3.Resta(var_binaria_3));
        assertEquals(expected_var_float_1,var_float_2.Multiplica(var_binaria_2));
        assertEquals(expected_var_float_3,var_float_3.Divide(var_binaria_2));
    }

    @Test
    void testOperacionesNoPermitidas(){
        TipoNulo expected = new TipoNulo();
        //Operaciones no permitidas para String.
        assertEquals(expected, var_string.Suma(var_nula));

        assertEquals(expected, var_string.Resta(var_boolean_1));
        assertEquals(expected, var_string.Resta(var_string));
        assertEquals(expected, var_string.Resta(var_int));
        assertEquals(expected, var_string.Resta(var_float));
        assertEquals(expected, var_string.Resta(var_binaria));
        assertEquals(expected, var_string.Resta(var_nula));

        assertEquals(expected, var_string.Multiplica(var_boolean_1));
        assertEquals(expected, var_string.Multiplica(var_string));
        assertEquals(expected, var_string.Multiplica(var_int));
        assertEquals(expected, var_string.Multiplica(var_float));
        assertEquals(expected, var_string.Multiplica(var_binaria));
        assertEquals(expected, var_string.Multiplica(var_nula));

        assertEquals(expected, var_string.Divide(var_boolean_1));
        assertEquals(expected, var_string.Divide(var_string));
        assertEquals(expected, var_string.Divide(var_int));
        assertEquals(expected, var_string.Divide(var_float));
        assertEquals(expected, var_string.Divide(var_binaria));
        assertEquals(expected, var_string.Divide(var_nula));

        assertEquals(expected, var_string.ConjuncionLogica(var_boolean_1));
        assertEquals(expected, var_string.ConjuncionLogica(var_string));
        assertEquals(expected, var_string.ConjuncionLogica(var_int));
        assertEquals(expected, var_string.ConjuncionLogica(var_float));
        assertEquals(expected, var_string.ConjuncionLogica(var_binaria));
        assertEquals(expected, var_string.ConjuncionLogica(var_nula));

        assertEquals(expected, var_string.DisyuncionLogica(var_boolean_1));
        assertEquals(expected, var_string.DisyuncionLogica(var_string));
        assertEquals(expected, var_string.DisyuncionLogica(var_int));
        assertEquals(expected, var_string.DisyuncionLogica(var_float));
        assertEquals(expected, var_string.DisyuncionLogica(var_binaria));
        assertEquals(expected, var_string.DisyuncionLogica(var_nula));

        assertEquals(expected, var_string.Negacion());

        //Operaciones no permitidas para TipoBoolean.
        assertEquals(expected, var_boolean_1.Suma(var_string));
        assertEquals(expected, var_boolean_1.Suma(var_boolean_1));
        assertEquals(expected, var_boolean_1.Suma(var_int));
        assertEquals(expected, var_boolean_1.Suma(var_float));
        assertEquals(expected, var_boolean_1.Suma(var_binaria));
        assertEquals(expected, var_boolean_1.Suma(var_nula));

        assertEquals(expected, var_boolean_1.Resta(var_string));
        assertEquals(expected, var_boolean_1.Resta(var_boolean_1));
        assertEquals(expected, var_boolean_1.Resta(var_int));
        assertEquals(expected, var_boolean_1.Resta(var_float));
        assertEquals(expected, var_boolean_1.Resta(var_binaria));
        assertEquals(expected, var_boolean_1.Resta(var_nula));

        assertEquals(expected, var_boolean_1.Multiplica(var_string));
        assertEquals(expected, var_boolean_1.Multiplica(var_boolean_1));
        assertEquals(expected, var_boolean_1.Multiplica(var_int));
        assertEquals(expected, var_boolean_1.Multiplica(var_float));
        assertEquals(expected, var_boolean_1.Multiplica(var_binaria));
        assertEquals(expected, var_boolean_1.Multiplica(var_nula));

        assertEquals(expected, var_boolean_1.Divide(var_string));
        assertEquals(expected, var_boolean_1.Divide(var_boolean_1));
        assertEquals(expected, var_boolean_1.Divide(var_int));
        assertEquals(expected, var_boolean_1.Divide(var_float));
        assertEquals(expected, var_boolean_1.Divide(var_binaria));
        assertEquals(expected, var_boolean_1.Divide(var_nula));

        assertEquals(expected, var_boolean_1.ConjuncionLogica(var_string));
        assertEquals(expected, var_boolean_1.ConjuncionLogica(var_int));
        assertEquals(expected, var_boolean_1.ConjuncionLogica(var_float));
        assertEquals(expected, var_boolean_1.ConjuncionLogica(var_nula));

        assertEquals(expected, var_boolean_1.DisyuncionLogica(var_string));
        assertEquals(expected, var_boolean_1.DisyuncionLogica(var_int));
        assertEquals(expected, var_boolean_1.DisyuncionLogica(var_float));
        assertEquals(expected, var_boolean_1.DisyuncionLogica(var_nula));

        //Operaciones no permitidas para TipoNumeroInt.
        assertEquals(expected, var_int.Suma(var_string));
        assertEquals(expected, var_int.Suma(var_boolean_1));
        assertEquals(expected, var_int.Suma(var_nula));

        assertEquals(expected, var_int.Resta(var_string));
        assertEquals(expected, var_int.Resta(var_boolean_1));
        assertEquals(expected, var_int.Resta(var_nula));

        assertEquals(expected, var_int.Multiplica(var_string));
        assertEquals(expected, var_int.Multiplica(var_boolean_1));
        assertEquals(expected, var_int.Multiplica(var_nula));

        assertEquals(expected, var_int.Divide(var_string));
        assertEquals(expected, var_int.Divide(var_boolean_1));
        assertEquals(expected, var_int.Divide(var_nula));

        assertEquals(expected, var_int.ConjuncionLogica(var_string));
        assertEquals(expected, var_int.ConjuncionLogica(var_boolean_1));
        assertEquals(expected, var_int.ConjuncionLogica(var_int));
        assertEquals(expected, var_int.ConjuncionLogica(var_float));
        assertEquals(expected, var_int.ConjuncionLogica(var_binaria));
        assertEquals(expected, var_int.ConjuncionLogica(var_nula));

        assertEquals(expected, var_int.DisyuncionLogica(var_string));
        assertEquals(expected, var_int.DisyuncionLogica(var_boolean_1));
        assertEquals(expected, var_int.DisyuncionLogica(var_int));
        assertEquals(expected, var_int.DisyuncionLogica(var_float));
        assertEquals(expected, var_int.ConjuncionLogica(var_binaria));
        assertEquals(expected, var_int.ConjuncionLogica(var_nula));

        //Operaciones no permitidas para TipoNumeroFloat.
        assertEquals(expected, var_float.Suma(var_string));
        assertEquals(expected, var_float.Suma(var_boolean_1));
        assertEquals(expected, var_float.Suma(var_nula));

        assertEquals(expected, var_float.Resta(var_string));
        assertEquals(expected, var_float.Resta(var_boolean_1));
        assertEquals(expected, var_float.Resta(var_nula));

        assertEquals(expected, var_float.Multiplica(var_string));
        assertEquals(expected, var_float.Multiplica(var_boolean_1));
        assertEquals(expected, var_float.Multiplica(var_nula));

        assertEquals(expected, var_float.Divide(var_string));
        assertEquals(expected, var_float.Divide(var_boolean_1));
        assertEquals(expected, var_float.Divide(var_nula));

        assertEquals(expected, var_float.ConjuncionLogica(var_string));
        assertEquals(expected, var_float.ConjuncionLogica(var_boolean_1));
        assertEquals(expected, var_float.ConjuncionLogica(var_int));
        assertEquals(expected, var_float.ConjuncionLogica(var_float));
        assertEquals(expected, var_float.ConjuncionLogica(var_binaria));
        assertEquals(expected, var_float.ConjuncionLogica(var_nula));

        assertEquals(expected, var_float.DisyuncionLogica(var_string));
        assertEquals(expected, var_float.DisyuncionLogica(var_boolean_1));
        assertEquals(expected, var_float.DisyuncionLogica(var_int));
        assertEquals(expected, var_float.DisyuncionLogica(var_float));
        assertEquals(expected, var_float.ConjuncionLogica(var_binaria));
        assertEquals(expected, var_float.ConjuncionLogica(var_nula));

        //Operaciones no permitidas para TipoNumeroBinario.
        assertEquals(expected, var_binaria.Suma(var_string));
        assertEquals(expected, var_binaria.Suma(var_boolean_1));
        assertEquals(expected, var_binaria.Suma(var_float));
        assertEquals(expected, var_binaria.Suma(var_nula));

        assertEquals(expected, var_binaria.Resta(var_string));
        assertEquals(expected, var_binaria.Resta(var_boolean_1));
        assertEquals(expected, var_binaria.Resta(var_float));
        assertEquals(expected, var_binaria.Resta(var_nula));

        assertEquals(expected, var_binaria.Multiplica(var_string));
        assertEquals(expected, var_binaria.Multiplica(var_boolean_1));
        assertEquals(expected, var_binaria.Multiplica(var_float));
        assertEquals(expected, var_binaria.Multiplica(var_nula));

        assertEquals(expected, var_binaria.Divide(var_string));
        assertEquals(expected, var_binaria.Divide(var_boolean_1));
        assertEquals(expected, var_binaria.Divide(var_float));
        assertEquals(expected, var_binaria.Divide(var_nula));

        assertEquals(expected, var_binaria.ConjuncionLogica(var_string));
        assertEquals(expected, var_binaria.ConjuncionLogica(var_int));
        assertEquals(expected, var_binaria.ConjuncionLogica(var_float));
        assertEquals(expected, var_binaria.ConjuncionLogica(var_nula));

        assertEquals(expected, var_binaria.DisyuncionLogica(var_string));
        assertEquals(expected, var_binaria.DisyuncionLogica(var_int));
        assertEquals(expected, var_binaria.DisyuncionLogica(var_float));
        assertEquals(expected, var_binaria.ConjuncionLogica(var_nula));

        //Operaciones no permitidas para TipoNulo.
        assertEquals(expected, var_nula.Suma(var_string));
        assertEquals(expected, var_nula.Suma(var_boolean_1));
        assertEquals(expected, var_nula.Suma(var_nula));
        assertEquals(expected, var_nula.Suma(var_int));
        assertEquals(expected, var_nula.Suma(var_float));
        assertEquals(expected, var_nula.Suma(var_binaria));

        assertEquals(expected, var_nula.Resta(var_boolean_1));
        assertEquals(expected, var_nula.Resta(var_string));
        assertEquals(expected, var_nula.Resta(var_int));
        assertEquals(expected, var_nula.Resta(var_float));
        assertEquals(expected, var_nula.Resta(var_binaria));
        assertEquals(expected, var_nula.Resta(var_nula));

        assertEquals(expected, var_nula.Multiplica(var_boolean_1));
        assertEquals(expected, var_nula.Multiplica(var_string));
        assertEquals(expected, var_nula.Multiplica(var_int));
        assertEquals(expected, var_nula.Multiplica(var_float));
        assertEquals(expected, var_nula.Multiplica(var_binaria));
        assertEquals(expected, var_nula.Multiplica(var_nula));

        assertEquals(expected, var_nula.Divide(var_boolean_1));
        assertEquals(expected, var_nula.Divide(var_string));
        assertEquals(expected, var_nula.Divide(var_int));
        assertEquals(expected, var_nula.Divide(var_float));
        assertEquals(expected, var_nula.Divide(var_binaria));
        assertEquals(expected, var_nula.Divide(var_nula));

        assertEquals(expected, var_nula.ConjuncionLogica(var_boolean_1));
        assertEquals(expected, var_nula.ConjuncionLogica(var_string));
        assertEquals(expected, var_nula.ConjuncionLogica(var_int));
        assertEquals(expected, var_nula.ConjuncionLogica(var_float));
        assertEquals(expected, var_nula.ConjuncionLogica(var_binaria));
        assertEquals(expected, var_nula.ConjuncionLogica(var_nula));

        assertEquals(expected, var_nula.DisyuncionLogica(var_boolean_1));
        assertEquals(expected, var_nula.DisyuncionLogica(var_string));
        assertEquals(expected, var_nula.DisyuncionLogica(var_int));
        assertEquals(expected, var_nula.DisyuncionLogica(var_float));
        assertEquals(expected, var_nula.DisyuncionLogica(var_binaria));
        assertEquals(expected, var_nula.DisyuncionLogica(var_nula));

        assertEquals(expected, var_nula.Negacion());
    }

}
