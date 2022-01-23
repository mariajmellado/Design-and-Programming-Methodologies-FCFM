package cl.uchile.dcc.scrabble.gui.Visitantes;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.If;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones.While;
import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Var;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNulo;
/**
 * Clase que representa a un visitante inmiscuido en el control de flujo.
 * Notar que todos retornan un TipoNulo en principio, para que, en caso de
 * visitarse una clase que no puede ser visitada por tal visitante, el AST que
 * implemente el control de flujo pueda retornar un ITipo Nulo y ser consistente
 * con la implementación.
 * @autor: María Jesús Mellado Tenorio.
 */
public class Visitante implements IVisitante{
    /**
     * Metodo que sobreescribe al de IVisitante para retornar un TipoNulo.
     */
    @Override
    public void visitaAIf(If If) { If.setResultado(FabricaTipoNulo.getFabricaTipoNulo().crear()); }
    /**
     * Metodo que sobreescribe al de IVisitante para retornar un TipoNulo.
     */
    @Override
    public void visitaAWhile(While While) { While.setResultado(FabricaTipoNulo.getFabricaTipoNulo().crear()); }
    /**
     * Metodo que sobreescribe al de IVisitante para retornar un TipoNulo.
     */
    @Override
    public void visitaAVariable(Var Variable) { Variable.setResultado(FabricaTipoNulo.getFabricaTipoNulo().crear()); }


}
