package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase FabricaTipoBoolean.
 * @autor: María Jesús Mellado Tenorio.
 */
class FabricaTipoBooleanTest {
    FabricaTipoBoolean FabricaBoolean;

    @BeforeEach
    void setUp() {
        FabricaBoolean = FabricaTipoBoolean.getFabricaTipoBoolean();
    }

    @Test
    void TestReciclaMemoria(){
        // Hay solo una fabrica de este tipo. La limpiamos por otros test.
        FabricaBoolean.getMapa().clear();
        TipoBoolean expected_boolean = new TipoBoolean(false);
        assertEquals(expected_boolean, FabricaBoolean.crear(false));
        assertEquals(1, FabricaBoolean.getCantidadElementos());
        assertEquals(expected_boolean, FabricaBoolean.crear(false));
        assertEquals(1, FabricaBoolean.getCantidadElementos());
    }
}