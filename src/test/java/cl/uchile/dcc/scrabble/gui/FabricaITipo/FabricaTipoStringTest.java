package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNulo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase FabricaTipoString.
 * @autor: María Jesús Mellado Tenorio.
 */
class FabricaTipoStringTest {
    FabricaTipoString FabricaString;

    @BeforeEach
    void setUp() {
        FabricaString = FabricaTipoString.getFabricaTipoString();
    }

    @Test
    void TestReciclaMemoria(){
        // Hay solo una fabrica de este tipo. La limpiamos por otros test.
        FabricaString.getMapa().clear();
        TipoString expected_string = new TipoString("XD");
        assertEquals(expected_string, FabricaString.crear("XD"));
        assertEquals(1, FabricaString.getCantidadElementos());
        assertEquals(expected_string, FabricaString.crear("XD"));
        assertEquals(1, FabricaString.getCantidadElementos());
    }
}