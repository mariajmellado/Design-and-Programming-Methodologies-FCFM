package cl.uchile.dcc.scrabble.gui.TiposScrabble;

import cl.uchile.dcc.scrabble.gui.FabricaITipo.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompararConTest {
    FabricaTipoNumeroInt FabricaInt;
    FabricaTipoNumeroFloat FabricaFloat;
    FabricaTipoNumeroBinario FabricaBinario;
    FabricaTipoString FabricaString;
    FabricaTipoBoolean FabricaBoolean;
    FabricaTipoNulo FabricaNulo;
    TipoNumeroInt int_01;
    TipoNumeroInt int_02;
    TipoNumeroInt int_03;
    TipoNulo nulo;

    TipoNumeroFloat float_01;
    TipoNumeroBinario binario_01;
    TipoBoolean boolean_01;
    TipoString string_01;

    @BeforeEach
    void setUp(){
        // Creamos las fabricas de los ITipos.
        FabricaInt = FabricaTipoNumeroInt.getFabricaTipoInt();
        FabricaFloat = FabricaTipoNumeroFloat.getFabricaTipoFloat();
        FabricaBinario =  FabricaTipoNumeroBinario.getFabricaTipoBinario();
        FabricaString = FabricaTipoString.getFabricaTipoString();
        FabricaBoolean = FabricaTipoBoolean.getFabricaTipoBoolean();
        FabricaNulo = FabricaTipoNulo.getFabricaTipoNulo();
        int_01 = FabricaInt.crear(1);
        int_02 = FabricaInt.crear(0);
        int_03 = FabricaInt.crear(-1);

        float_01 = FabricaFloat.crear(3.4);
        binario_01 = FabricaBinario.crear("0101");
        boolean_01 = FabricaBoolean.crear(true);
        string_01 = FabricaString.crear("hola");
        nulo = FabricaNulo.crear();

    }

    @Test
    void testCompararconInt() {
        TipoNumeroInt int_1 = FabricaInt.crear(1);
        TipoNumeroInt int_2 = FabricaInt.crear(2);
        TipoNumeroInt int_3 = FabricaInt.crear(2);
        assertEquals(int_03, int_1.compararCon(int_2));
        assertEquals(int_02, int_2.compararCon(int_3));
        assertEquals(int_01, int_2.compararCon(int_1));
    }

    @Test
    void testCompararconFloat() {
        TipoNumeroFloat float_1 = FabricaFloat.crear(1.5);
        TipoNumeroFloat float_2 = FabricaFloat.crear(2.5);
        TipoNumeroFloat float_3 = FabricaFloat.crear(2.5);
        assertEquals(int_03, float_1.compararCon(float_2));
        assertEquals(int_02,float_2.compararCon(float_3));
        assertEquals(int_01, float_2.compararCon(float_1));
    }

    @Test
    void testCompararconBinario() {
        TipoNumeroBinario binario_1 = FabricaBinario.crear("0101");
        TipoNumeroBinario binario_2 = FabricaBinario.crear("010101");
        TipoNumeroBinario binario_3 = FabricaBinario.crear("010101");
        assertEquals(int_03, binario_1.compararCon(binario_2));
        assertEquals(int_02, binario_2.compararCon(binario_3));
        assertEquals(int_01, binario_2.compararCon(binario_1));
    }


    @Test
    void testCompararconBool() {
        TipoBoolean boolean_1 = FabricaBoolean.crear(true);
        TipoBoolean boolean_2 = FabricaBoolean.crear(false);
        TipoBoolean boolean_3 = FabricaBoolean.crear(false);
        assertEquals(int_03, boolean_1.compararCon(boolean_2));
        assertEquals(int_02, boolean_2.compararCon(boolean_3));
        assertEquals(int_01, boolean_2.compararCon(boolean_1));
    }


    @Test
    void testCompararconString() {
        TipoString string_1 = FabricaString.crear("hola");
        TipoString string_2 = FabricaString.crear("quepasopadrino");
        TipoString string_3 = FabricaString.crear("quepasopadrino");
        assertEquals(int_03, string_1.compararCon(string_2));
        assertEquals(int_02, string_2.compararCon(string_3));
        assertEquals(int_01, string_2.compararCon(string_1));
    }

    @Test
    void testCompararconTipoNoPermitido() {
        assertEquals(nulo, int_01.compararCon(float_01));
        assertEquals(nulo, float_01.compararCon(binario_01));
        assertEquals(nulo, binario_01.compararCon(string_01));
        assertEquals(nulo, string_01.compararCon(boolean_01));
        assertEquals(nulo, boolean_01.compararCon(int_01));

    }

}
