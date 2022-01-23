package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNulo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase FabricaTipoNulo.
 * @autor: María Jesús Mellado Tenorio.
 */
class FabricaTipoNuloTest {
    FabricaTipoNulo FabricaNulo;

    @BeforeEach
    void setUp() {
        FabricaNulo = FabricaTipoNulo.getFabricaTipoNulo();
    }
    @Test
    void TestReciclaMemoria(){
        // Hay solo una fabrica de este tipo. La limpiamos por otros test.
        FabricaNulo.getMapa().clear();
        TipoNulo expected_nulo = new TipoNulo();
        assertEquals(expected_nulo, FabricaNulo.crear());
        assertEquals(1, FabricaNulo.getCantidadElementos());
        assertEquals(expected_nulo, FabricaNulo.crear());
        assertEquals(1, FabricaNulo.getCantidadElementos());
    }
}