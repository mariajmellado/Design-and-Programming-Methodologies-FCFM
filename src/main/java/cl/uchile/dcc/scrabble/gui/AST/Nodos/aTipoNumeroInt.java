package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la transformación de un INodo a TipoNumeroInt, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class aTipoNumeroInt extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase aTipoNumeroInt.
     * Recibe un unico INodo a transformar a TipoNumeroInt.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public aTipoNumeroInt(INodo Nodo) {
        this.resultado = Nodo.getValor().aTipoNumeroInt();
        setValor(resultado);
    }
}
