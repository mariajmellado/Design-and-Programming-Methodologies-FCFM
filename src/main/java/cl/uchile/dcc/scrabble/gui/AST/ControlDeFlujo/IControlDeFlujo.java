package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import cl.uchile.dcc.scrabble.gui.Visitantes.Visitante;

public interface IControlDeFlujo extends INodo {
    void aceptar(Visitante Visitante);
    ITipo getValor();
}
