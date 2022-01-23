module scrabble.main {
  exports cl.uchile.dcc.scrabble.gui;
    exports cl.uchile.dcc.scrabble.gui.TiposScrabble;
  exports cl.uchile.dcc.scrabble.gui.AST;
  exports cl.uchile.dcc.scrabble.gui.AST.Nodos;
  exports cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos;
    exports cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;
    exports cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Instrucciones;

    requires javafx.controls;
  requires org.jetbrains.annotations;
}