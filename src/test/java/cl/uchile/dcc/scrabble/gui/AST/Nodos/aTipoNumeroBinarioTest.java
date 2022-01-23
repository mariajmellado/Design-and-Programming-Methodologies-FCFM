package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.aTipoNumeroBinario;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroBinario;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing a la clase aTipoNumeroBinario como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class aTipoNumeroBinarioTest {
    aTipoNumeroBinario abinario;

    @BeforeEach
    void setUp() {
        abinario = new aTipoNumeroBinario(new TipoNumeroInt(2));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoATipoNumeroBinario() {
        TipoNumeroBinario esperado = new TipoNumeroBinario("010");
        TipoNumeroBinario esperado_2 = new TipoNumeroBinario("010101");
        assertEquals(esperado, abinario.getValor());
        abinario.setValor(esperado_2);
        assertEquals(esperado_2, abinario.getValor());
    }
}