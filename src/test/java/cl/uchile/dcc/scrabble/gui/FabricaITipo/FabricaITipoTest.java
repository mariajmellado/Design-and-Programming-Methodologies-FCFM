package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import org.junit.jupiter.api.*;
/**
 * Clase que hace testing a la todas las Fabricas en la implementacion
 * de los árboles testeados en AbstractNodoCompuestoTest y así poner a
 * prueba el ahorro de memoria.
 * @autor: María Jesús Mellado Tenorio.
 */
import static org.junit.jupiter.api.Assertions.*;

class FabricaITipoTest {
    FabricaTipoNumeroInt FabricaInt;
    FabricaTipoNumeroFloat FabricaFloat;
    FabricaTipoNumeroBinario FabricaBinario;
    FabricaTipoString FabricaString;
    FabricaTipoBoolean FabricaBoolean;
    FabricaTipoNulo FabricaNulo;
    INodo AST_0;
    INodo AST_1;
    INodo AST_2;
    INodo AST_3;
    INodo AST_4;
    INodo AST_5;

    @BeforeEach
    void setUp() {
        FabricaInt = FabricaTipoNumeroInt.getFabricaTipoInt();
        FabricaFloat = FabricaTipoNumeroFloat.getFabricaTipoFloat();
        FabricaBinario =  FabricaTipoNumeroBinario.getFabricaTipoBinario();
        FabricaString = FabricaTipoString.getFabricaTipoString();
        FabricaBoolean = FabricaTipoBoolean.getFabricaTipoBoolean();
        FabricaNulo = FabricaTipoNulo.getFabricaTipoNulo();

        //Los arboles los inicializamos en el test para poder ir limpiando lo que
        // queda en el hashmap de cada uno de ellos.
    }

    @Test
    void TestASTreciclamemoriaAST_0() {
        TipoNumeroFloat tipo_esperado_0 = new TipoNumeroFloat(2.9000000000000004);
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();

        //Usamos los mismos AST del testing en paquete AST.
        AST_0 = new Suma(FabricaFloat.crear(6.9),
                new O(FabricaBinario.crear("1000"),
                        new aTipoNumeroBinario(
                                new Resta(
                                        FabricaInt.crear(25),
                                        FabricaBinario.crear("0101")
                                )
                        )
                )
        );
        //Verificamos el mismo resultado.
        assertEquals(tipo_esperado_0, AST_0.getValor()); // 36 ms, demora menos!
        assertEquals(3, FabricaFloat.getCantidadElementos()); // Son tres porque aTipoNumeroBinario crea Int -4.
        // Creamos mismo elemento y vemos que el numero de elementos en el HashMap no cambia.
        TipoNumeroFloat var_creada_01 = FabricaFloat.crear(2.9000000000000004);
        TipoNumeroBinario var_creada_02 = FabricaBinario.crear("0101");
        assertEquals(3, FabricaFloat.getCantidadElementos());
        //System.out.println(FabricaFloat.getMapa().values());
    }
    @Test
    void TestASTreciclamemoriaAST_1() {
        TipoNulo tipo_esperado_1 = new TipoNulo();

        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();

        AST_1 = new Suma( new O(FabricaBinario.crear("1000"),
                        new aTipoNumeroBinario(
                                new Resta(
                                        FabricaInt.crear(25),
                                        FabricaBinario.crear("0101")
                                )
                        )
                )
        , FabricaFloat.crear(6.9));

        assertEquals(tipo_esperado_1, AST_1.getValor()); // 25 ms, demora menos!
        assertEquals(3, FabricaInt.getCantidadElementos());
        assertEquals(1, FabricaNulo.getCantidadElementos());
        TipoNumeroInt var_creada_11 = FabricaInt.crear(25);
        TipoNumeroBinario var_creada_12 = FabricaBinario.crear("1000");
        assertEquals(3, FabricaInt.getCantidadElementos());
    }

    @Test
    void TestASTreciclamemoriaAST_2() {
        TipoString tipo_esperado_2 = new TipoString("8.0");
        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();

        AST_2 = new aTipoString(
                new Multiplicacion(
                        new Division(FabricaInt.crear(8),
                                new aTipoNumeroFloat(new Suma(new TipoNumeroInt(1),
                                        new aTipoNumeroInt(
                                                new O(FabricaBinario.crear("001"),
                                                        FabricaBoolean.crear(false))
                                        ))))
                        , new Resta(FabricaFloat.crear(12.5),
                        FabricaFloat.crear(10.5)))

        );

        assertEquals(tipo_esperado_2, AST_2.getValor()); // 20 ms, demora menos!
        assertEquals(1, FabricaBoolean.getCantidadElementos());
        TipoBoolean var_creada_21 = FabricaBoolean.crear(true);
        TipoString var_creada_22 = FabricaString.crear("8.00");
        assertEquals(2, FabricaBoolean.getCantidadElementos());
        assertEquals(2, FabricaString.getCantidadElementos());

    }

    @Test
    void TestASTreciclamemoriaAST_3() {
        TipoNumeroInt tipo_esperado_3 = new TipoNumeroInt(1);

        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();

        AST_3 = new Negacion(
                new aTipoNumeroInt(
                        new Suma(
                                new O(
                                        FabricaBinario.crear("101"),
                                        FabricaBinario.crear("111")
                                ),
                                new Y(
                                        FabricaBinario.crear("001"),
                                        FabricaBinario.crear("010"))
                        ))
        );

        assertEquals(tipo_esperado_3, AST_3.getValor()); // 29 ms, demora menos!
        assertEquals(6, FabricaBinario.getCantidadElementos());
        assertEquals(0, FabricaString.getCantidadElementos());
        TipoString var_creada_31 = FabricaString.crear("chayanne");
        TipoNumeroBinario var_creada_32 = FabricaBinario.crear("001");
        assertEquals(1, FabricaString.getCantidadElementos());
        assertEquals(6, FabricaBinario.getCantidadElementos());

    }

    @Test
    void TestASTreciclamemoriaAST_4() {
        TipoBoolean tipo_esperado_4 = new TipoBoolean(false);

        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();

        AST_4 = new Negacion(new aTipoBoolean(FabricaBoolean.crear(true)));

        assertEquals(tipo_esperado_4, AST_4.getValor()); // 24 ms
        assertEquals(2, FabricaBoolean.getCantidadElementos());
        TipoNumeroBinario var_creada_41 = FabricaBinario.crear("001");
        TipoNumeroFloat var_creada_42 = FabricaFloat.crear(56.9);
        TipoNumeroInt var_creada_43 = FabricaInt.crear(345);
        TipoBoolean var_creada_44 = FabricaBoolean.crear(false);
        assertEquals(1, FabricaBinario.getCantidadElementos());
        assertEquals(1, FabricaInt.getCantidadElementos());
        assertEquals(1, FabricaInt.getCantidadElementos());
        assertEquals(2, FabricaBoolean.getCantidadElementos());
    }

    @Test
    void TestASTreciclamemoriaAST_5() {
        TipoNumeroBinario tipo_esperado_5 = new TipoNumeroBinario("01101");

        FabricaInt.getMapa().clear();
        FabricaFloat.getMapa().clear();
        FabricaBinario.getMapa().clear();
        FabricaString.getMapa().clear();
        FabricaBoolean.getMapa().clear();

        AST_5 = new Suma(
                FabricaBinario.crear("001011"),
                new aTipoNumeroInt(
                        new Resta(new aTipoNumeroInt(
                                FabricaBinario.crear("001010")),
                                FabricaInt.crear(8))
                ));

        assertEquals(tipo_esperado_5, AST_5.getValor()); // 29 ms, demora menos!
        assertEquals(2, FabricaBinario.getCantidadElementos());
        assertEquals(4, FabricaInt.getCantidadElementos());
        TipoNumeroBinario var_creada_51 = FabricaBinario.crear("001010");
        TipoNumeroInt var_creada_52 = FabricaInt.crear(8);
        assertEquals(2, FabricaBinario.getCantidadElementos());
        assertEquals(4, FabricaInt.getCantidadElementos());
    }
}