package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase Var como nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class VarTest {
    private Var variable;

    @BeforeEach
    void setUp() {
        variable = new Var("y", new TipoNumeroFloat(5.4));
    }

    @Test
    void testMismoObjetoyValor() {
        TipoNumeroInt var_int = new TipoNumeroInt(15);
        Var expected_variable = new Var("y", new TipoNumeroFloat(5.4));
        assertEquals(expected_variable, variable, "No tienen el mismo valor");
        assertNotEquals(var_int.hashCode(), variable.hashCode(), "No son del mismo tipo");
        assertEquals(expected_variable.hashCode(), variable.hashCode(), "No son del mismo tipo");
    }

    @Test
    void testGetterySetter() {
        TipoNumeroFloat float_arg = new TipoNumeroFloat(5.4);
        TipoNumeroFloat float_arg_nuevo = new TipoNumeroFloat(5.4);
        assertEquals("y", variable.getId());
        assertEquals(float_arg, variable.getValor());
        assertNotEquals(float_arg, variable);
        variable.setResultado(float_arg_nuevo);
        assertEquals(float_arg_nuevo, variable.getValor());

    }

}