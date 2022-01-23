package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase FabricaTipoInt.
 * @autor: María Jesús Mellado Tenorio.
 */
class FabricaTipoNumeroIntTest {
    FabricaTipoNumeroInt FabricaInt;

    @BeforeEach
    void setUp() {
        FabricaInt = FabricaTipoNumeroInt.getFabricaTipoInt();
    }

    @Test
    void TestFabricaInt(){

    }
    @Test
    void TestReciclaMemoria(){
        // Hay solo una fabrica de este tipo. La limpiamos por otros test.
        FabricaInt.getMapa().clear();
        TipoNumeroInt expected_int = new TipoNumeroInt(2);
        assertEquals(expected_int, FabricaInt.crear(2));
        assertEquals(1, FabricaInt.getCantidadElementos());

        assertEquals(expected_int, FabricaInt.crear(2));
        assertEquals(1, FabricaInt.getCantidadElementos());
    }
}