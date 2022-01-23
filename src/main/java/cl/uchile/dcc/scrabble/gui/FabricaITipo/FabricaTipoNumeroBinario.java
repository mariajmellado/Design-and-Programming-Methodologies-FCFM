package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroBinario;

import java.util.HashMap;
/**
 * Clase que implementa una Fábrica de TipoNumeroBinario de Scrabble.
 * Existe solo una única instancia de este objeto.
 * Tiene un diccionario donde guarda todos los valores que alguna vez se han
 * creado con esta fábrica. Este diccionario es único a consecuencia de la unicidad
 * de esta fábrica.
 * @autor: María Jesús Mellado Tenorio.
 */
public class FabricaTipoNumeroBinario {
    private static FabricaTipoNumeroBinario FabricaTipoBinario;
    protected HashMap<String, TipoNumeroBinario> Mapa = new HashMap();
    /**
     * Constructor privado de la clase FabricaTipoNumeroBinario para unicidad.
     */
    private FabricaTipoNumeroBinario() { }
    /**
     * Metodo estático que permite si saber si ya se inicializó la instancia
     * de esta clase o no, para utilizar la existente.
     */
    public static FabricaTipoNumeroBinario getFabricaTipoBinario(){
        if (FabricaTipoBinario == null) {
            FabricaTipoBinario = new FabricaTipoNumeroBinario();
        }
        return FabricaTipoBinario; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNumeroBinario que ha creado.
     */
    public HashMap<String, TipoNumeroBinario> getMapa() { return this.Mapa; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNumeroBinario que ha creado.
     */
    public int getCantidadElementos(){
        return this.getMapa().size();
    }
    /**
     * Metodo que permite la creacion de los TipoNumeroBinario, al consultarle al
     * diccionario si tal TipoNumeroBinario consultado ya existe, sino se crea uno
     * nuevo con el String de java ingresado.
     */
    public TipoNumeroBinario crear(String valor){
        if(!this.getMapa().containsKey(valor)){
            TipoNumeroBinario nuevo_valor = new TipoNumeroBinario(valor);
            this.getMapa().put(valor, nuevo_valor);
        }
        return this.getMapa().get(valor);
    }

}
