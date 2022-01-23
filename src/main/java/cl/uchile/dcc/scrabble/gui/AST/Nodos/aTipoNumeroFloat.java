package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la transformación de un INodo a TipoNumeroFloat, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class aTipoNumeroFloat extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase aTipoNumeroFloat.
     * Recibe un unico INodo a transformar a TipoNumeroFloat.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public aTipoNumeroFloat(INodo Nodo) {
        this.resultado = Nodo.getValor().aTipoNumeroFloat();
        setValor(resultado);
    }
}
