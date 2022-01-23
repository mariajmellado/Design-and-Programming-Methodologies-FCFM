package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la operacion Negación de un INodo, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class Negacion extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase Suma.
     * Recibe un INodo a operar (Operacion unaria).
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public Negacion(INodo Nodo) {
        this.resultado = Nodo.getValor().Negacion();
        setValor(resultado);
    }
}
