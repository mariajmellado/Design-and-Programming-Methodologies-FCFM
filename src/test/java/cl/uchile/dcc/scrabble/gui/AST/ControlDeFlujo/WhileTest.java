package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.While;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.*;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo.VisitanteIf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase While y, al visitante de While junto con el visitante de Var.
 * Dado que la clase condición se usa principalmente para el While, al final también se
 * testean las no comparaciones posibles entre tipos, esto es, del método CompararCon que
 * usa cada ITipo, así no dejamos dispersos los testing atingentes al control de flujo.
 * @autor: María Jesús Mellado Tenorio.
 */
class WhileTest {
    FabricaTipoNumeroInt FabricaInt;
    FabricaTipoNumeroFloat FabricaFloat;
    FabricaTipoNumeroBinario FabricaBinario;
    FabricaTipoString FabricaString;
    FabricaTipoBoolean FabricaBoolean;
    FabricaTipoNulo FabricaNulo;
    FabricaVariable FabricaVariable;
    INodo AST;


    @BeforeEach
    void setUp() {
        // Creamos las fabricas de los ITipos.
        FabricaInt = FabricaTipoNumeroInt.getFabricaTipoInt();
        FabricaFloat = FabricaTipoNumeroFloat.getFabricaTipoFloat();
        FabricaBinario = FabricaTipoNumeroBinario.getFabricaTipoBinario();
        FabricaString = FabricaTipoString.getFabricaTipoString();
        FabricaBoolean = FabricaTipoBoolean.getFabricaTipoBoolean();
        FabricaNulo = FabricaTipoNulo.getFabricaTipoNulo();
        FabricaVariable = FabricaVariable.getFabricaVariable();

        AST = new aTipoString(
                new Multiplicacion(
                        new Division( new TipoNumeroInt(8),
                                new aTipoNumeroFloat(new Suma(new TipoNumeroInt(1),
                                        new aTipoNumeroInt(
                                                new O(new TipoNumeroBinario("001"),
                                                        new TipoBoolean(false))
                                        ))))

                        , new Resta(new TipoNumeroFloat(12.5), new TipoNumeroFloat(10.5)))

        );

    }



    @Test
    void testControldeFlujoWhile(){
        // Probamos para TipoNumeroInt.
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();

        // Test 1
        FabricaVariable.getMapa().clear();
        Var variable_int_11 = FabricaVariable.crear("a", FabricaInt.crear(2));
        Condicion condicion_11 = new Condicion(variable_int_11, FabricaInt.crear(3), 1);
        While While_object_11 = new While(condicion_11, AST);
        assertEquals(AST.getValor(), While_object_11.getValor());

        // Test 2
        FabricaVariable.getMapa().clear();
        Var variable_int_21 = FabricaVariable.crear("b", FabricaInt.crear(2));
        Condicion condicion_21 = new Condicion(variable_int_21, FabricaInt.crear(13), 0);
        While While_object_21 = new While(condicion_21, AST);
        assertEquals(FabricaNulo.crear(), While_object_21.getValor());

        // Probamos para TipoNumeroFloat.
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVariable.getMapa().clear();

        // Test 1
        FabricaVariable.getMapa().clear();
        Var variable_float_12 = FabricaVariable.crear("a", FabricaFloat.crear(2.5));
        Condicion condicion_12 = new Condicion(variable_float_12, FabricaFloat.crear(3.5), 1);
        While While_object_12 = new While(condicion_12, AST);
        assertEquals(AST.getValor(), While_object_12.getValor());

        // Test 2
        FabricaVariable.getMapa().clear();
        Var variable_float_22 = FabricaVariable.crear("b", FabricaFloat.crear(2.5));
        Condicion condicion_22 = new Condicion(variable_float_22, FabricaFloat.crear(13.5), 0);
        While While_object_22 = new While(condicion_22, AST);
        assertEquals(FabricaNulo.crear(), While_object_22.getValor());

        // Probamos para TipoNumeroBinario.
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVariable.getMapa().clear();

        // Test 1
        FabricaVariable.getMapa().clear();
        Var variable_binario_13 = FabricaVariable.crear("a", FabricaBinario.crear("0101"));
        Condicion condicion_13 = new Condicion(variable_binario_13, FabricaBinario.crear("01010"), 1);
        While While_object_13 = new While(condicion_13, AST);
        assertEquals(AST.getValor(), While_object_13.getValor());

        // Test 2
        FabricaVariable.getMapa().clear();
        Var variable_binario_23 = FabricaVariable.crear("b", FabricaBinario.crear("0101"));
        Condicion condicion_23 = new Condicion(variable_binario_23, FabricaBinario.crear("0101000000011111000"), 0);
        While While_object_23= new While(condicion_23, AST);
        assertEquals(FabricaNulo.crear(), While_object_23.getValor());


        // Probamos para TipoBoolean.
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVariable.getMapa().clear();

        // Test 1
        FabricaVariable.getMapa().clear();
        Var variable_boolean_14 = FabricaVariable.crear("a", FabricaBoolean.crear(true));
        Condicion condicion_14 = new Condicion(variable_boolean_14, FabricaBoolean.crear(false), 0);
        While While_object_14 = new While(condicion_14, AST);
        assertEquals(AST.getValor(), While_object_14.getValor());

        // Test 1
        FabricaVariable.getMapa().clear();
        Var variable_boolean_24 = FabricaVariable.crear("b", FabricaBoolean.crear(false));
        Condicion condicion_24 = new Condicion(variable_boolean_24, FabricaBoolean.crear(true), 1);
        While While_object_24 = new While(condicion_24, AST);
        assertEquals(AST.getValor(), While_object_24.getValor());

        // Probamos para TipoString.
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVariable.getMapa().clear();

        // Test 1
        FabricaVariable.getMapa().clear();
        Var variable_string_15 = FabricaVariable.crear("a", FabricaString.crear("hola"));
        Condicion condicion_15 = new Condicion(variable_string_15, FabricaString.crear("hola1"), 1);
        While While_object_15 = new While(condicion_15, AST);
        assertEquals(AST.getValor(), While_object_15.getValor());

        // Test 2
        FabricaVariable.getMapa().clear();
        Var variable_string_25 = FabricaVariable.crear("b", FabricaString.crear("hola"));
        Condicion condicion_25 = new Condicion(variable_string_25, FabricaString.crear("holaquepasaaaaaaaaaa"), 0);
        While While_object_25= new While(condicion_25, AST);
        assertEquals(FabricaNulo.crear(), While_object_25.getValor());

    }

    @Test
    void testVisitasNoPermitidas(){
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVariable.getMapa().clear();

        Var variable_int = FabricaVariable.crear("a", FabricaInt.crear(2));
        Condicion condicion = new Condicion(variable_int, FabricaInt.crear(3), 1);
        While While_object = new While(condicion, AST);
        VisitanteIf Visitante_If = new VisitanteIf();
        While_object.aceptar(Visitante_If);
        assertEquals(FabricaNulo.crear(),While_object.getResultado());
        variable_int.aceptar(Visitante_If);
        assertEquals(FabricaNulo.crear(), variable_int.getValor());
    }

    @Test
    void testComparacionesNoPermitidas(){
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVariable.getMapa().clear();

        TipoNumeroInt var_int = FabricaInt.crear(2);
        TipoNumeroFloat var_float = FabricaFloat.crear(2.5);
        TipoNumeroBinario var_binario = FabricaBinario.crear("0101");
        TipoBoolean var_boolean = FabricaBoolean.crear(true);
        TipoString var_string = FabricaString.crear("hola");
        TipoNulo var_nulo = FabricaNulo.crear();

        assertEquals(FabricaNulo.crear(), var_int.compararCon(var_float));
        assertEquals(FabricaNulo.crear(), var_float.compararCon(var_binario));
        assertEquals(FabricaNulo.crear(), var_binario.compararCon(var_boolean));
        assertEquals(FabricaNulo.crear(), var_boolean.compararCon(var_string));
        assertEquals(FabricaNulo.crear(), var_string.compararCon(var_int));
        assertEquals(FabricaNulo.crear(), var_nulo.aceptaCambio());

    }

}
