package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase FabricaVariable.
 * @autor: María Jesús Mellado Tenorio.
 */
class FabricaVariableTest {
    FabricaVariable FabricaVariable;
    FabricaTipoNumeroInt FabricaInt;

    @BeforeEach
    void setUp() {
        FabricaVariable = FabricaVariable.getFabricaVariable();
        FabricaInt = FabricaTipoNumeroInt.getFabricaTipoInt();
    }

    @Test
    void TestReciclaMemoria(){
        // Hay solo una fabrica de este tipo. La limpiamos por otros test.
        FabricaVariable.getMapa().clear();
        Var expected_variable = new Var("x",FabricaInt.crear(5) );
        assertEquals(expected_variable, FabricaVariable.crear("x", FabricaInt.crear(5)));
        assertEquals(1, FabricaVariable.getCantidadElementos());
        assertEquals(expected_variable, FabricaVariable.crear("x", FabricaInt.crear(5)));
        assertEquals(1, FabricaVariable.getCantidadElementos());
    }

}