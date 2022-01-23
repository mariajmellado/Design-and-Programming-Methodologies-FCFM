package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.O;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase O como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class OTest {
    O disyuncion;

    @BeforeEach
    void setUp() {
        disyuncion = new O(new TipoBoolean(false), new TipoBoolean(false));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoO(){
        TipoBoolean esperado = new TipoBoolean(false);
        TipoBoolean esperado_1 = new TipoBoolean(true);
        assertEquals(esperado, disyuncion.getValor());
        disyuncion.setValor(esperado_1);
        assertEquals(esperado_1, disyuncion.getValor());
    }
}