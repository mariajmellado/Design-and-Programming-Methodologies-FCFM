package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;

/**
 * Clase abstracta que unifica métodos que son utilizados
 * por sus clases hijas que representan los nodos del AST,
 * esto es, las clases operaciones e interfaz * ITipo.
 * @autor: María Jesús Mellado Tenorio.
 */
public abstract class NodoCompuesto implements INodo{
    ITipo resultado;
    /**
     * Método que permite otorgar el atributo resultado de esta clase.
     */
    public void setValor(ITipo tipo) {
        this.resultado = tipo;
    }
    /**
     * Método que sobreescribe al de INodo y que retorna el único atributo
     * que tienen las clases hijas.
     */
    @Override
    public ITipo getValor() {
        return this.resultado;
    }

}

