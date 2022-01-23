package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la operacion Resta entre dos INodos, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class Resta extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase Resta.
     * Recibe dos INodos a operar.INodo1 es restado por INodo2.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public Resta(INodo Nodo1, INodo Nodo2) {
        this.resultado = Nodo1.getValor().Resta(Nodo2.getValor());
        setValor(resultado);
    }

}
