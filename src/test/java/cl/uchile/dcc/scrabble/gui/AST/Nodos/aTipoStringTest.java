package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.aTipoString;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase aTipoString como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class aTipoStringTest {
    aTipoString astring;

    @BeforeEach
    void setUp() {
        astring = new aTipoString(new TipoNumeroInt(345));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoATipoNumeroInt() {
        TipoString esperado = new TipoString("345");
        TipoString esperado_2 = new TipoString("hola123");
        assertEquals(esperado, astring.getValor());
        astring.setValor(esperado_2);
        assertEquals(esperado_2, astring.getValor());
    }
}