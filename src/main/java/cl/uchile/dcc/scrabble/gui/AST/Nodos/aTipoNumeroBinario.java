package cl.uchile.dcc.scrabble.gui.AST.Nodos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la transformación de un INodo a TipoNumeroBinario, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class aTipoNumeroBinario extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase aTipoNumeroBinario.
     * Recibe un unico INodo a transformar a TipoNumeroBinario.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public aTipoNumeroBinario(INodo Nodo) {
        this.resultado = Nodo.getValor().aTipoNumeroBinario();
        setValor(resultado);
    }
}
