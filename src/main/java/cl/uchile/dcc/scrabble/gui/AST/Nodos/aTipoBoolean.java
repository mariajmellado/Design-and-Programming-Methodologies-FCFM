package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la transformación de un INodo a TipoBoolean, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class aTipoBoolean extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase aTipoBoolean.
     * Recibe un unico INodo a transformar a TipoBoolean.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public aTipoBoolean(INodo Nodo) {
        this.resultado = Nodo.getValor().aTipoBoolean();
        setValor(resultado);
    }
}
