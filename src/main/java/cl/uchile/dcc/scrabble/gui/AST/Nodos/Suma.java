package cl.uchile.dcc.scrabble.gui.AST.Nodos;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
/**
 * Clase que representa la operacion Suma entre dos INodos, como Nodo del AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class Suma extends NodoCompuesto {
    ITipo resultado;
    /**
     * Constructor de la clase Suma.
     * Recibe dos INodos a operar. INodo1 es sumado con INodo2.
     * Guarda el resultado de la operación en su único atributo resultado.
     */
    public Suma(INodo Nodo1, INodo Nodo2) {
        this.resultado = Nodo1.getValor().Suma(Nodo2.getValor());
        setValor(resultado);
    }
}
