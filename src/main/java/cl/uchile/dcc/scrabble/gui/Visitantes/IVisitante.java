package cl.uchile.dcc.scrabble.gui.Visitantes;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.If;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.While;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Var;
/**
 * Interfaz que permite a un Visitante visitar a un If.
 * @autor: María Jesús Mellado Tenorio.
 */
public interface IVisitante {
    /**
     * Metodo que permite a un Visitante visitar a un If.
     */
    void visitaAIf(If If);
    /**
     * Metodo que permite a un Visitante visitar a un While.
     */
    void visitaAWhile(While While);
    /**
     * Metodo que permite a un Visitante visitar a un Var.
     */
    void visitaAVariable(Var Variable);

}
