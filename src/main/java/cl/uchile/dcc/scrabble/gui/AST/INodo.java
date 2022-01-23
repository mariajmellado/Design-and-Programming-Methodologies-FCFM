package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Interfaz que posibilita obtener el ITipo que almacena
 * un INodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public interface INodo {
        /**
         * Método que retorna el valor, que es un ITipo, que contiene un INodo.
         */
        ITipo getValor();

}
