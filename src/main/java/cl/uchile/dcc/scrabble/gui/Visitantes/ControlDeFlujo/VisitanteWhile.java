package cl.uchile.dcc.scrabble.gui.Visitantes.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Condicion;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.While;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Var;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNulo;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaVariable;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;
import cl.uchile.dcc.scrabble.gui.Visitantes.Visitante;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase que permite a un VisitanteWhile visitar a un While.
 * @autor: María Jesús Mellado Tenorio.
 */
public class VisitanteWhile extends Visitante {
    /**
     * Método que sobreescribe al de Visitante para poder permitir
     * a un VisitanteWhile determinar el control de flujo de While.
     */
    @Override
    public void visitaAWhile(While While) {
        VisitanteVariable visitanteVariable = new VisitanteVariable();
        int ciclos = 0;
        int ciclos_permitidos = While.getCiclos();
        while(!((TipoBoolean)While.getCond().getValor()).getArg() && ciclos < ciclos_permitidos) {
            While.getCond().getVariable().aceptar(visitanteVariable);
            FabricaVariable FabricaVar= FabricaVariable.getFabricaVariable();
            HashMap<String, Var> Mapa = FabricaVar.getMapa();
            Condicion condicion = new Condicion(FabricaVar.crear(
                    While.getCond().getVariable().getId(),
                    While.getCond().getVariable().getValor()),
                    While.getCond().getNodo_2(),
                    While.getCond().getEntero());
            if (((TipoBoolean) condicion.getValor()).getArg()){
                While.setCond(condicion);
                break;
            }
            ciclos++;
        }
        if(ciclos == While.getCiclos() && !((TipoBoolean) While.getCond().getValor()).getArg()){
            While.setResultado(FabricaTipoNulo.getFabricaTipoNulo().crear());
        }
    }
}
