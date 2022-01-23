package cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.If;
import cl.uchile.dcc.scrabble.gui.Visitantes.Visitante;
/**
 * Clase que permite a un VisitanteIf visitar a un If.
 * @autor: María Jesús Mellado Tenorio.
 */
public class VisitanteIf extends Visitante {
    /**
     * Método que sobreescribe al de Visitante para poder permitir
     * a un VisitanteIf determinar el control de flujo de un If.
     */
    @Override
    public void visitaAIf(If If) {
        if(If.getCondicion()){
            If.setResultado(If.getResultado_1());
        }else{
            If.setResultado(If.getResultado_2());
        }
    }
}
