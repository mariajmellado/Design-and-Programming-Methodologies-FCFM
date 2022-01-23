package cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo;

import cl.uchile.dcc.scrabble.gui.AST.NodoCompuesto;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoBoolean;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;
/**
 * Clase que representa una condicion como Nodo del AST.
 * Esta clase, aunque no es parte de la implementación, es muy útil para
 * poder usarla desde While.
 * Se adjunta como parte de la motivación personal para mejorar el programa.
 * Se deja en el paquete de ControlDeFlujo para poder diferenciar lo implementado
 * en esta tarea en comparación con las anteriores pero notar que es un Nodo de AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public class Condicion extends NodoCompuesto {
    protected Var variable;
    protected ITipo nodo_2;
    protected TipoNumeroInt resultado_inicial;
    protected int entero;
    /**
     * Constructor de la clase Condición.
     * Recibe una variable con la que va a comparar el ITipo y dependiendo del valor
     * que reciba en entero, podrá emitir un valor de verdad.
     */
    public Condicion(Var variable, ITipo Nodo_2, int entero) {
        this.variable =  variable;
        this.nodo_2 = Nodo_2;
        this.resultado_inicial = (TipoNumeroInt) variable.getValor().compararCon(Nodo_2.getValor());
        this.entero = entero;
    }
    /**
     * Metodo que permite obtener la variable que recibe.
     */
    public Var getVariable() {
        return this.variable;
    }
    /**
     * Metodo que permite obtener el ITipo a comparar que recibe.
     */
    public ITipo getNodo_2() {
        return this.nodo_2;
    }
    /**
     * Metodo que permite obtener el entero que permitirá comparar con el resultado
     * de hacer CompararCon entre la variable y el ITipo recibidos.
     */
    public int getEntero() {
        return this.entero;
    }
    /**
     * Metodo que permite obtener el resultado de la condicion.
     */
    @Override
    public ITipo getValor() {
        if((this.getResultado_inicial()).getArg() == this.entero){
            return FabricaTipoBoolean.getFabricaTipoBoolean().crear(true);
        }
        return FabricaTipoBoolean.getFabricaTipoBoolean().crear(false);
    }
    /**
     * Metodo que permite obtener el resultado de la condicion al momento de recibir los parámetros.
     * Este valor puede cambiar dada la acción de los visitantes.
     */
    public TipoNumeroInt getResultado_inicial() {
        return resultado_inicial;
    }
    /**
     * Metodo que permite obtener el resultado de la condicion al momento de recibir los parámetros.
     * Este valor puede cambiar dada la acción de los visitantes.
     */
    public void setVariable(Var variable) {
        this.variable = variable;
        this.setResultado_inicial( (TipoNumeroInt) this.getVariable().getValor().compararCon(this.getNodo_2().getValor()));
    }
    /**
     * Metodo que permite cambiar el resultado de la condición dado un cambio en la variable que recibe.
     */
    public void setResultado_inicial(TipoNumeroInt resultado_inicial) {
        this.resultado_inicial = resultado_inicial;
    }
}
