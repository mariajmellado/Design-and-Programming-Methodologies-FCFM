package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.If;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.While;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.*;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo.VisitanteIf;
import cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo.VisitanteWhile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase que hace testing a la clase If y al visitante de If, junto con junto con el visitante de Var.
 * @autor: María Jesús Mellado Tenorio.
 */
class IfTest {
    private If If_object;
    FabricaTipoNumeroInt FabricaInt;
    FabricaTipoNumeroFloat FabricaFloat;
    FabricaTipoNumeroBinario FabricaBinario;
    FabricaTipoString FabricaString;
    FabricaTipoBoolean FabricaBoolean;
    FabricaTipoNulo FabricaNulo;
    FabricaVariable FabricaVar;

    INodo AST_0;
    INodo AST_1;


    @BeforeEach
    void setUp(){
        // Creamos las fabricas de los ITipos.
        FabricaInt = FabricaTipoNumeroInt.getFabricaTipoInt();
        FabricaFloat = FabricaTipoNumeroFloat.getFabricaTipoFloat();
        FabricaBinario =  FabricaTipoNumeroBinario.getFabricaTipoBinario();
        FabricaString = FabricaTipoString.getFabricaTipoString();
        FabricaBoolean = FabricaTipoBoolean.getFabricaTipoBoolean();
        FabricaVar = FabricaVariable.getFabricaVariable();
        FabricaNulo = FabricaTipoNulo.getFabricaTipoNulo();

    }

    @Test
    void testControldeFlujoIf() {
        // Test 1
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVar.getMapa().clear();

        AST_0 = new Suma(FabricaFloat.crear(6),
                new Resta(FabricaInt.crear(5), FabricaInt.crear(1)));

        AST_1 = new Multiplicacion(FabricaFloat.crear(6), FabricaFloat.crear(6));


        Var variable = new Var("a", FabricaInt.crear(2));
        Condicion condicion = new Condicion(variable, FabricaInt.crear(2), 0);
        If_object = new If(condicion.getValor(),AST_0, AST_1);
        assertEquals(AST_0.getValor(), If_object.getValor());

        // Test 2
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVar.getMapa().clear();

        INodo AST_21 = new aTipoString(
                        new If(new aTipoBoolean(
                                FabricaVar.crear("x", FabricaBoolean.crear(true))),
                                new O(
                                        FabricaBinario.crear("101"),
                                        FabricaBinario.crear("111")
                                ),
                                new Multiplicacion(
                                        FabricaInt.crear(3),
                                        FabricaInt.crear(2))
                        ));

        TipoString int_21 = FabricaString.crear("111");
        assertEquals(int_21, AST_21.getValor());

        // Test 3
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVar.getMapa().clear();

        INodo AST_22 = new aTipoString(
                        new If(new aTipoBoolean(
                                FabricaVar.crear("x", FabricaBoolean.crear(false))),
                                new O(
                                        FabricaBinario.crear("101"),
                                        FabricaBinario.crear("111")
                                ),
                                new Multiplicacion(
                                        FabricaInt.crear(3),
                                        FabricaInt.crear(2))
                        ));

        TipoString int_22 = FabricaString.crear("6");
        assertEquals(int_22, AST_22.getValor());

    }
    @Test
    void testVisitasNoPermitidas(){
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();
        FabricaVar.getMapa().clear();

        AST_0 = new Suma(FabricaFloat.crear(6),
                new Resta(FabricaInt.crear(5), FabricaInt.crear(1)));

        AST_1 = new Multiplicacion(FabricaFloat.crear(6), FabricaFloat.crear(6));


        Var variable = new Var("a", FabricaInt.crear(2));
        Condicion condicion = new Condicion(variable, FabricaInt.crear(2), 0);
        If_object = new If(condicion.getValor(),AST_0, AST_1);


        VisitanteWhile Visitante_While = new VisitanteWhile();
        If_object.aceptar(Visitante_While);
        assertEquals(FabricaNulo.crear(),If_object.getResultado());
    }


}