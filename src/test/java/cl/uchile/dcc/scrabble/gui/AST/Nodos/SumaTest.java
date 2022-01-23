package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.Suma;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase Suma como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class SumaTest {
    Suma suma;

    @BeforeEach
    void setUp() {
        suma = new Suma(new TipoNumeroInt(1), new TipoNumeroInt(4));
    }

    // Probamos todos los métodos que inmiscuyen a la clase.
    @Test
    void TestNodoSuma(){
        TipoNumeroInt esperado = new TipoNumeroInt(5);
        TipoNumeroInt esperado_2 = new TipoNumeroInt(-40);
        assertEquals(esperado, suma.getValor());
        suma.setValor(esperado_2);
        assertEquals(esperado_2, suma.getValor());
    }
}