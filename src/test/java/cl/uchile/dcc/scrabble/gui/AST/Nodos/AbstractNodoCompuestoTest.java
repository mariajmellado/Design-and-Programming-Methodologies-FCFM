package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.Nodos.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que hace testing a todas las clases que son un INodo
 * para ver la correcta implementación de un AST.
 * @autor: María Jesús Mellado Tenorio.
 */
class AbstractNodoCompuestoTest {
    INodo AST_0;
    INodo AST_1;
    INodo AST_2;
    INodo AST_3;
    INodo AST_4;
    INodo AST_5;

      @BeforeEach
    void setUp() {
        //Ejemplo 1; Ejemplo del enunciado corregido (cambio de orden de operaciones iniciales).
        AST_0 = new Suma(new TipoNumeroFloat(6.9),
                new O(
                        new TipoNumeroBinario("1000"),
                        new aTipoNumeroBinario(
                        new Resta(
                                new TipoNumeroInt(25),
                                new TipoNumeroBinario("0101"))
                        )));

        //Ejemplo 2; Ejemplo del enunciado debiese retornar TipoNulo.
        AST_1 = new Suma(
                new O(
                        new TipoNumeroBinario("1000"),
                        new Resta(
                                new TipoNumeroInt(25),
                                new aTipoNumeroBinario(new TipoNumeroBinario("0101")))),
                new TipoNumeroFloat(6.9)
        );

        AST_2 = new aTipoString(
                    new Multiplicacion(
                            new Division( new TipoNumeroInt(8),
                                    new aTipoNumeroFloat(new Suma(new TipoNumeroInt(1),
                                            new aTipoNumeroInt(
                                                    new O(new TipoNumeroBinario("001"),
                                                            new TipoBoolean(false))
                                            ))))

                    , new Resta(new TipoNumeroFloat(12.5), new TipoNumeroFloat(10.5)))

        );

        AST_3 = new Negacion(
                new aTipoNumeroInt(
                        new Suma(
                                new O(
                                        new TipoNumeroBinario("101"),
                                        new TipoNumeroBinario("111")
                                ),
                                new Y(
                                        new TipoNumeroBinario("001"),
                                        new TipoNumeroBinario("010"))
                ))
        );

        AST_4 = new Negacion(new aTipoBoolean(new TipoBoolean(true)));
        AST_5 = new Suma(
                new TipoNumeroBinario("001011"),
                new aTipoNumeroInt(
                        new Resta( new aTipoNumeroInt(
                                new TipoNumeroBinario("001010")),
                                new TipoNumeroInt(8))
                ));



    }


    @Test
    void TestASTevaluado(){
        TipoNumeroFloat tipo_esperado_0 = new TipoNumeroFloat(2.9000000000000004);
        TipoNulo tipo_esperado_1 = new TipoNulo();
        TipoString tipo_esperado_2 = new TipoString("8.0");
        TipoNumeroInt tipo_esperado_3 = new TipoNumeroInt(1);
        TipoBoolean tipo_esperado_4 = new TipoBoolean(false);
        TipoNumeroBinario tipo_esperado_5 = new TipoNumeroBinario("01101");

        assertEquals(tipo_esperado_0, AST_0.getValor()); // 45 ms
        assertEquals(tipo_esperado_1, AST_1.getValor()); // 59 ms
        assertEquals(tipo_esperado_2, AST_2.getValor()); // 40 ms
        assertEquals(tipo_esperado_3, AST_3.getValor()); // 45 ms
        assertEquals(tipo_esperado_4, AST_4.getValor()); // 45 ms
        assertEquals(tipo_esperado_5, AST_5.getValor()); // 45 ms
    }
}