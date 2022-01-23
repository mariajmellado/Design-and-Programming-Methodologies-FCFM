package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing a la clase FabricaTipoBinario.
 * @autor: María Jesús Mellado Tenorio.
 */
class FabricaTipoNumeroBinarioTest {
    FabricaTipoNumeroBinario FabricaBinario;

    @BeforeEach
    void setUp() {
        FabricaBinario = FabricaTipoNumeroBinario.getFabricaTipoBinario();
    }

    @Test
    void TestReciclaMemoria(){
        // Hay solo una fabrica de este tipo. La limpiamos por otros test.
        FabricaBinario.getMapa().clear();
        TipoNumeroBinario expected_binario = new TipoNumeroBinario("010101");
        assertEquals(expected_binario, FabricaBinario.crear("010101"));
        assertEquals(1, FabricaBinario.getCantidadElementos());
        assertEquals(expected_binario, FabricaBinario.crear("010101"));
        assertEquals(1, FabricaBinario.getCantidadElementos());
    }

}