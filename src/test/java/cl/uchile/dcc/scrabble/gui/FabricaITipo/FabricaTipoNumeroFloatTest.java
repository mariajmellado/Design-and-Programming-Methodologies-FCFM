package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase FabricaTipoFloat.
 * @autor: María Jesús Mellado Tenorio.
 */
class FabricaTipoNumeroFloatTest {
    FabricaTipoNumeroFloat FabricaFloat;

    @BeforeEach
    void setUp() {
        FabricaFloat = FabricaTipoNumeroFloat.getFabricaTipoFloat();
    }

    @Test
    void TestReciclaMemoria(){
        // Hay solo una fabrica de este tipo. La limpiamos por otros test.
        FabricaFloat.getMapa().clear();
        TipoNumeroFloat expected_float = new TipoNumeroFloat(2.5);
        assertEquals(expected_float, FabricaFloat.crear(2.5));
        assertEquals(1, FabricaFloat.getCantidadElementos());
        assertEquals(expected_float, FabricaFloat.crear(2.5));
        assertEquals(1, FabricaFloat.getCantidadElementos());
    }
}