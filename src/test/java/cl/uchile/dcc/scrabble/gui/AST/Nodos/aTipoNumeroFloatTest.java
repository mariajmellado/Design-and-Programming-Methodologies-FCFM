package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.aTipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing a la clase aTipoNumeroFloat como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class aTipoNumeroFloatTest {
    aTipoNumeroFloat afloat;

    @BeforeEach
    void setUp() {
        afloat = new aTipoNumeroFloat(new TipoNumeroInt(24));
    }
    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoATipoNumeroInt() {
        TipoNumeroFloat esperado = new TipoNumeroFloat(24);
        TipoNumeroFloat esperado_2 = new TipoNumeroFloat(546.6);
        assertEquals(esperado, afloat.getValor());
        afloat.setValor(esperado_2);
        assertEquals(esperado_2, afloat.getValor());
    }
}