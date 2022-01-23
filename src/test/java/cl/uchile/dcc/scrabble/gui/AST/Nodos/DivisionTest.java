package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.Division;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase Division como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class DivisionTest {
    Division division;

    @BeforeEach
    void setUp() {
        division = new Division(new TipoNumeroInt(6), new TipoNumeroInt(3));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoDivision() {
        TipoNumeroInt esperado = new TipoNumeroInt(2);
        TipoNumeroFloat esperado_2 = new TipoNumeroFloat(-3.8);
        assertEquals(esperado, division.getValor());
        division.setValor(esperado_2);
        assertEquals(esperado_2, division.getValor());
    }
}