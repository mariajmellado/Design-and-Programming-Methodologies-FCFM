package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.Resta;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase Resta como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class RestaTest {
    Resta resta;

    @BeforeEach
    void setUp() {
        resta = new Resta(new TipoNumeroFloat(3.5), new TipoNumeroInt(2));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoResta(){
        TipoNumeroFloat esperado = new TipoNumeroFloat(1.5);
        TipoNumeroFloat esperado_2 = new TipoNumeroFloat(-3.8);
        assertEquals(esperado, resta.getValor());
        resta.setValor(esperado_2);
        assertEquals(esperado_2, resta.getValor());

    }
}