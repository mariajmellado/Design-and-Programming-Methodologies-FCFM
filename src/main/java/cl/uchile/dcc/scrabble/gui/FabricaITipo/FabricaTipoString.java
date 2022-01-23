package cl.uchile.dcc.scrabble.gui.FabricaITipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoString;

import java.util.HashMap;

/**
 * Clase que implementa una Fábrica de TipoString de Scrabble.
 * Existe solo una única instancia de este objeto.
 * Tiene un diccionario donde guarda todos los valores que alguna vez se han
 * creado con esta fábrica. Este diccionario es único a consecuencia de la unicidad
 * de esta fábrica.
 * @autor: María Jesús Mellado Tenorio.
 */
public class FabricaTipoString {
    private static FabricaTipoString FabricaTipoString;
    protected HashMap<String, TipoString> Mapa = new HashMap();
    /**
     * Constructor privado de la clase FabricaTipoString para unicidad.
     */
    private FabricaTipoString() { }
    /**
     * Metodo estático que permite si saber si ya se inicializó la instancia
     * de esta clase o no, para utilizar la existente.
     */
    public static FabricaTipoString getFabricaTipoString(){
        if (FabricaTipoString == null) {
            FabricaTipoString = new FabricaTipoString(); }
        return FabricaTipoString; }
    /**
     * Metodo que permite obtener el diccionario donde esta fábrica ha
     * guardado todos los TipoString que ha creado.
     */
    public HashMap<String, TipoString> getMapa() { return this.Mapa; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoString que ha creado.
     */
    public int getCantidadElementos(){return this.getMapa().size();}
    /**
     * Metodo que permite la creacion de los TipoString, al consultarle al
     * diccionario si tal TipoString consultado ya existe, sino se crea uno
     * nuevo con el String de java ingresado.
     */
    public TipoString crear(String valor){
        if(!this.getMapa().containsKey(valor)){
            TipoString nuevo_valor = new TipoString(valor);
            this.getMapa().put(valor, nuevo_valor);
        }
        return this.getMapa().get(valor);
    }

}
