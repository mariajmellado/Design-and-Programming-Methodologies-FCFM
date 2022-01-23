package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la operacion DisyuncionLogica entre dos INodos, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class O extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase O.
     * Recibe dos INodos a operar. INodo1 hace "OLógico" con INodo2.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public O(INodo Nodo1, INodo Nodo2) {
        this.resultado = Nodo1.getValor().DisyuncionLogica(Nodo2.getValor());
        setValor(resultado);
    }

}
