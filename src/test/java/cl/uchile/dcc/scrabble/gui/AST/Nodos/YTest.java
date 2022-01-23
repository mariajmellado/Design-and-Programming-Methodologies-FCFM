package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.Y;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase Y como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class YTest {
    Y conjuncion;
    @BeforeEach
    void setUp() {
        conjuncion = new Y(new TipoBoolean(false), new TipoBoolean(true));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoY(){
        TipoBoolean esperado = new TipoBoolean(false);
        TipoBoolean esperado_1 = new TipoBoolean(true);
        assertEquals(esperado, conjuncion.getValor());
        conjuncion.setValor(esperado_1);
        assertEquals(esperado_1, conjuncion.getValor());
    }
}