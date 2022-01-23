package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.Nodos.Negacion;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase Negacion como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class NegacionTest {
    Negacion negacion;

    @BeforeEach
    void setUp() {
        negacion = new Negacion(new Negacion(new TipoBoolean(true)));
    }
    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoNegacion(){
        TipoBoolean esperado = new TipoBoolean(true);
        TipoBoolean esperado_2 = new TipoBoolean(false);
        assertEquals(esperado, negacion.getValor());
        negacion.setValor(esperado_2);
        assertEquals(esperado_2, negacion.getValor());
    }
}