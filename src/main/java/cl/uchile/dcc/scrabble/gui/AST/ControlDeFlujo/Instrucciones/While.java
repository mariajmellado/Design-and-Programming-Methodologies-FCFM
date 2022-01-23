package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Condicion;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.IControlDeFlujo;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo.VisitanteWhile;
import cl.uchile.dcc.scrabble.gui.Visitantes.Visitante;
/**
 * Clase que implementa la instrucción de control de flujo While.
 * @autor: María Jesús Mellado Tenorio.
 */
public class While implements IControlDeFlujo {
    protected ITipo resultado;
    protected Condicion cond;
    protected int n_ciclos;
    /**
     * Constructor de la clase While.
     * Recibe una condicion tal que permitirá con ella el flujo del AST nodo que recibe.
     * Instaura numero de ciclos, que serán el numero de veces que modificara la variable
     * de la condición para poder ver el funcionamiento del While (esto es, que no sea estático).
     */
    public While(Condicion condicion, INodo Nodo) {
        this.resultado = Nodo.getValor();
        this.cond = condicion;
        this.n_ciclos = 10;
    }
    /**
     * Método que permite a la clase While aceptar a un visitante.
     */
    @Override
    public void aceptar(Visitante Visitante) {
        Visitante.visitaAWhile(this);
    }
    /**
     * Método que permite obtener el ITipo del AST que deja pasar While.
     */
    @Override
    public ITipo getValor() {
        VisitanteWhile visitanteWhile = new VisitanteWhile();
        this.aceptar(visitanteWhile);
        return this.getResultado();
    }
    /**
     * Método que permite obtener la condición que evalúa el While.
     */
    public Condicion getCond() { return this.cond; }
    /**
     * Método que permite obtener el numero de ciclos antes mencionado.
     */
    public int getCiclos() {
        return this.n_ciclos;
    }
    /**
     * Método que permite obtener el ITipo del AST que deja pasar While.
     */
    public ITipo getResultado() {return this.resultado; }
    /**
     * Método que permite adjudicar el ITipo del AST que deja pasar While.
     */
    public void setResultado(ITipo tipo){this.resultado = tipo; }
    /**
     * Método que permite adjudicar la condición que evalúa el While.
     */
    public void setCond(Condicion cond) {
        this.cond = cond;
    }
}
