package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.Multiplicacion;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase Multiplicacion como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class MultiplicacionTest {
    Multiplicacion multiplicacion;

    @BeforeEach
    void setUp() {
        multiplicacion = new Multiplicacion(new TipoNumeroInt(2), new TipoNumeroFloat(3.5));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoMultiplicacion() {
        TipoNumeroFloat esperado = new TipoNumeroFloat(7);
        TipoNumeroFloat esperado_2 = new TipoNumeroFloat(25.7);
        assertEquals(esperado, multiplicacion.getValor());
        multiplicacion.setValor(esperado_2);
        assertEquals(esperado_2, multiplicacion.getValor());
    }
}