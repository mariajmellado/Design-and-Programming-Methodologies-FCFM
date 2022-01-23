package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.aTipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroBinario;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing a la clase aTipoNumeroInt como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class aTipoNumeroIntTest {
    aTipoNumeroInt aint;

    @BeforeEach
    void setUp() {
         aint = new aTipoNumeroInt(new TipoNumeroBinario("0111"));
    }
    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoATipoNumeroInt() {
        TipoNumeroInt esperado = new TipoNumeroInt(7);
        TipoNumeroInt esperado_2 = new TipoNumeroInt(3);
        assertEquals(esperado, aint.getValor());
        aint.setValor(esperado_2);
        assertEquals(esperado_2, aint.getValor());
    }
}