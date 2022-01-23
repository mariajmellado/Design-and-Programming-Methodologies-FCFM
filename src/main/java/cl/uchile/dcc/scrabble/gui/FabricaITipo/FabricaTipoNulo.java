package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNulo;

import java.util.HashMap;
/**
 * Clase que implementa una Fábrica de TipoNulo.
 * Existe solo una única instancia de este objeto.
 * Tiene un diccionario donde guarda todos los valores que alguna vez se han
 * creado con esta fábrica. Este diccionario es único a consecuencia de la unicidad
 * de esta fábrica.
 * @autor: María Jesús Mellado Tenorio.
 */
public class FabricaTipoNulo {
    private static FabricaTipoNulo FabricaTipoNulo;
    protected HashMap<String, TipoNulo> Mapa = new HashMap();
    /**
     * Constructor privado de la clase FabricaTipoNulo para unicidad.
     */
    private FabricaTipoNulo() { }
    /**
     * Metodo estático que permite si saber si ya se inicializó la instancia
     * de esta clase o no, para utilizar la existente.
     */
    public static FabricaTipoNulo getFabricaTipoNulo(){
        if (FabricaTipoNulo == null) {
            FabricaTipoNulo = new FabricaTipoNulo(); }
        return FabricaTipoNulo; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNulo que ha creado.
     */
    public HashMap<String, TipoNulo> getMapa() { return this.Mapa; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNulo que ha creado.
     */
    public int getCantidadElementos(){return this.getMapa().size();}
    /**
     * Metodo que permite la creacion de los TipoString, al consultarle al
     * diccionario si el TipoNulo consultado ya existe, sino se crea uno con
     * argumento por defecto null.
     */
    public TipoNulo crear(){
        if(this.Mapa.size() == 0){
            TipoNulo nuevo_valor = new TipoNulo();
            this.getMapa().put("null", nuevo_valor);
        }
        return this.getMapa().get("null");
    }

}
