package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CondicionTest {
    Condicion condicion_1;
    Condicion condicion_2;

    @BeforeEach
    void setUp() {
        condicion_1 = new Condicion(new Var("x", new TipoString("Hola")),
                                    new TipoString("Hola1"),
                                        -1);
        condicion_2 = new Condicion(new Var("x", new TipoString("Hola")),
                new TipoString("Hola1"),
                0);
    }

    @Test
    void testGetterySetter() {
        Var variable = new Var("x", new TipoString("Hola"));
        TipoBoolean var_bool_1 = new TipoBoolean(true);
        TipoBoolean var_bool_2 = new TipoBoolean(false);
        TipoNumeroInt var_int = new TipoNumeroInt(0);
        assertEquals(variable, condicion_1.getVariable());
        assertEquals(var_bool_1, condicion_1.getValor());
        assertEquals(var_bool_2, condicion_2.getValor());
        condicion_1.setResultado_inicial(var_int);
        condicion_2.setVariable(variable);
        assertEquals(var_int, condicion_1.getResultado_inicial());
        assertEquals(variable, condicion_2.getVariable());

    }

}