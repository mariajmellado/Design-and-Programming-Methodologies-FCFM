package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.IControlDeFlujo;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo.VisitanteIf;
import cl.uchile.dcc.scrabble.gui.Visitantes.Visitante;
/**
 * Clase que implementa la instrucción de control de flujo If.
 * @autor: María Jesús Mellado Tenorio.
 */
public class If implements IControlDeFlujo {
    protected ITipo resultado_1;
    protected ITipo resultado_2;
    protected ITipo resultado;
    protected TipoBoolean cond;
    /**
     * Constructor de la clase If.
     * Recibe una condicion como AST, el AST ifTrue que deja pasar si la condicion es verdadera
     * y un AST ifFalse que deja pasar si la condición es falsa.
     */
    public If(INodo condicion, INodo ifTrue, INodo ifFalse) {
        this.resultado_1 = ifTrue.getValor();
        this.resultado_2 = ifFalse.getValor();
        this.cond = (TipoBoolean) condicion.getValor(); // Siempre será un TipoBoolean, así que el cast está ok.
    }
    /**
     * Método que permite a la clase If aceptar a un visitante.
     */
    @Override
    public void aceptar(Visitante Visitante) {
        Visitante.visitaAIf(this);
    }
    /**
     * Método que permite obtener el ITipo del AST que deja pasar If.
     */
    @Override
    public ITipo getValor() {
        VisitanteIf visitanteIf = new VisitanteIf();
        this.aceptar(visitanteIf);
        return this.resultado;
    }
    /**
     * Método que permite obtener el ITipo del AST ifTrue.
     */
    public ITipo getResultado_1() {
        return this.resultado_1;
    }
    /**
     * Método que permite obtener el ITipo del AST ifFalse.
     */
    public ITipo getResultado_2() {
        return this.resultado_2;
    }
    /**
     * Método que permite obtener el argumento del TipoBoleano que entrega la condición.
     */
    public boolean getCondicion() {
        return this.cond.getArg();
    }
    /**
     * Método que permite obtener el resultado como ITipo de la condición.
     */
    public ITipo getResultado() {
        return this.resultado;
    }
    /**
     * Método que permite adjudicar un nuevo resultado a la condición.
     */
    public void setResultado(ITipo tipo){
        this.resultado = tipo;
    }
}
