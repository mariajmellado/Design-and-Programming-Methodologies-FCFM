package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.IControlDeFlujo;
import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.Visitantes.Visitante;

import java.util.Objects;
/**
 * Clase que representa una variable como Nodo del AST.
 * Se deja en el paquete de ControlDeFlujo para poder diferenciar lo implementado
 * en esta tarea en comparación con las anteriores pero notar que es un Nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class Var extends NodoCompuesto implements IControlDeFlujo{
    public String id;
    public ITipo resultado;
    /**
     * Constructor de la clase Var.
     * Recibe una identificación y un ITipo que almacenará.
     */
    public Var(String id, ITipo Tipo) {
        this.id = id;
        this.resultado = Tipo;
    }
    /**
     * Metodo que permite obtener la identificacion de la variable.
     */
    public String getId() {
        return id;
    }
    /**
     * Metodo que permite obtener el ITipo que almacena la variable.
     */
    @Override
    public ITipo getValor() {
        return this.resultado;
    }
    /**
     * Metodo que sobreescribe el de Object para obtener el hascode de Var.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Var.class);
    }
    /**
     * Metodo que sobreescribe el de Object para poder comparar dos Var.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Var) {
            var variable = (Var) obj;
            return variable.getId() == this.getId() && variable.getValor().equals(this.getValor());
        } return false; }
    /**
     * Metodo que permite cambiar el ITipo que almacena la variable.
     */
    public void setResultado(ITipo tipo) {
        this.resultado = tipo;
    }
    /**
     * Metodo que permite a la Var un visitante.
     * Funcional específicamente para recibir un VisitanteVariable.
     */
    public void aceptar(Visitante Visitante) {
        Visitante.visitaAVariable(this);}
}

