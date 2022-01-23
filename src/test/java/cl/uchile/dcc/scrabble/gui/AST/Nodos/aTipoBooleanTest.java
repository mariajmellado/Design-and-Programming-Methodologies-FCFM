package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.aTipoBoolean;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing a la clase aTipoBoolean como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class aTipoBooleanTest {
    aTipoBoolean aboolean;

    @BeforeEach
    void setUp() {
        aboolean = new aTipoBoolean(new TipoBoolean(false));
    }
    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoATipoNumeroInt() {
        TipoBoolean esperado = new TipoBoolean(false);
        TipoBoolean esperado_2 = new TipoBoolean(true);
        assertEquals(esperado, aboolean.getValor());
        aboolean.setValor(esperado_2);
        assertEquals(esperado_2, aboolean.getValor());
    }
}