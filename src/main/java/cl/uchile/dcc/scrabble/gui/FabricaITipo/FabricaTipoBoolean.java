package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoBoolean;

import java.util.HashMap;
/**
 * Clase que implementa una Fábrica de TipoBoolean de Scrabble.
 * Existe solo una única instancia de este objeto.
 * Tiene un diccionario donde guarda todos los valores que alguna vez se han
 * creado con esta fábrica. Este diccionario es único a consecuencia de la unicidad
 * de esta fábrica.
 * @autor: María Jesús Mellado Tenorio.
 */
public class FabricaTipoBoolean {
    private static FabricaTipoBoolean FabricaTipoBoolean;
    protected HashMap<Boolean, TipoBoolean> Mapa = new HashMap();
    /**
     * Constructor privado de la clase FabricaTipoBoolean para unicidad.
     */
    private FabricaTipoBoolean() { }
    /**
     * Metodo estático que permite si saber si ya se inicializó la instancia
     * de esta clase o no, para utilizar la existente.
     */
    public static FabricaTipoBoolean getFabricaTipoBoolean(){
        if (FabricaTipoBoolean == null) {
            FabricaTipoBoolean = new FabricaTipoBoolean(); }
        return FabricaTipoBoolean; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNumeroInt que ha creado.
     */
    public HashMap<Boolean, TipoBoolean> getMapa() { return this.Mapa; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoString que ha creado.
     */
    public int getCantidadElementos(){
        return this.getMapa().size();
    }
    /**
     * Metodo que permite la creacion de los TipoString, al consultarle al
     * diccionario si el TipoString consultado ya existe, sino se crea uno
     * nuevo con el String de java ingresado.
     */
    public TipoBoolean crear(boolean valor){
        if(!this.getMapa().containsKey(valor)){
            TipoBoolean nuevo_valor = new TipoBoolean(valor);
            this.getMapa().put(valor, nuevo_valor);
        }
        return this.getMapa().get(valor);
    }

}
