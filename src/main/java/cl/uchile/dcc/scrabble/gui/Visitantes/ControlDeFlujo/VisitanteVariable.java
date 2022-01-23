package cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Var;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaVariable;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import cl.uchile.dcc.scrabble.gui.Visitantes.Visitante;
import java.util.HashMap;
/**
 * Clase que permite a un VisitanteVariable visitar a una variable Var
 * para actualizar su valor.
 * @autor: María Jesús Mellado Tenorio.
 */
public class VisitanteVariable extends Visitante {
    /**
     * Método que sobreescribe al de Visitante para poder permitir
     * a un VisitanteVariable determinar la actualización de una Var.
     */
    public void visitaAVariable(Var variable) {
        HashMap<String, Var> Mapa = FabricaVariable.getFabricaVariable().getMapa();
        ITipo TipoNuevo = Mapa.get(variable.getId()).getValor().aceptaCambio();
        Mapa.get(variable.getId()).setResultado(TipoNuevo);
        Mapa.put(variable.getId(), variable);
    }

}
