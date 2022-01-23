package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.AST.ControlDeFlujo.Var;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import java.util.HashMap;
/**
 * Clase que implementa una Fábrica de Var de Scrabble.
 * Existe solo una única instancia de este objeto.
 * Tiene un diccionario donde guarda todos los valores que alguna vez se han
 * creado con esta fábrica. Este diccionario es único a consecuencia de la unicidad
 * de esta fábrica.
 * @autor: María Jesús Mellado Tenorio.
 */
public class FabricaVariable{
    private static FabricaVariable FabricaVariable;
    public HashMap<String, Var> Mapa = new HashMap();
    /**
     * Constructor privado de la clase FabricaVar para unicidad.
     */
    private FabricaVariable() { }
    /**
     * Metodo estático que permite si saber si ya se inicializó la instancia
     * de esta clase o no, para utilizar la existente.
     */
    public static FabricaVariable getFabricaVariable(){
        if (FabricaVariable == null) { // only if no instance exists, then create a new
            FabricaVariable = new FabricaVariable();
        }
        return FabricaVariable;}
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos las Var que ha creado.
     */
    public HashMap<String, Var> getMapa() { return this.Mapa; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos las Var que ha creado.
     */
    public int getCantidadElementos(){
        return this.getMapa().size();
    }
    /**
     * Metodo que permite la creacion de las Var, al consultarle al
     * diccionario si tal Var consultada ya existe a partir de su identificación,
     * sino se crea una nuevo con el ITipo ingresada.
     */
    public Var crear(String valor, ITipo tipo){
        if(!this.getMapa().containsKey(valor)){
            this.getMapa().put(valor, new Var(valor, tipo));
        }
        return this.getMapa().get(valor);
    }

}
