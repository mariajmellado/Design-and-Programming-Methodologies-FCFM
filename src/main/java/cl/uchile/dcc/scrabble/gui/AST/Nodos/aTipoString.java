package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la transformación  de un INodo a TipoString, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class aTipoString extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase aTipoString.
     * Recibe un unico INodo a transformar a TipoString.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public aTipoString(INodo Nodo) {
        this.resultado = Nodo.getValor().aTipoString();
        setValor(resultado);
    }
}
