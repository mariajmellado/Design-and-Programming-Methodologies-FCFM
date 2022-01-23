package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroFloat;
import java.util.HashMap;
/**
 * Clase que implementa una Fábrica de TipoNumeroFloat de Scrabble.
 * Existe solo una única instancia de este objeto.
 * Tiene un diccionario donde guarda todos los valores que alguna vez se han
 * creado con esta fábrica. Este diccionario es único a consecuencia de la unicidad
 * de esta fábrica.
 * @autor: María Jesús Mellado Tenorio.
 */
public class FabricaTipoNumeroFloat {
    private static FabricaTipoNumeroFloat FabricaTipoFloat;
    protected HashMap<Double, TipoNumeroFloat> Mapa = new HashMap();
    /**
     * Constructor privado de la clase FabricaTipoNumeroFloat para unicidad.
     */
    private FabricaTipoNumeroFloat() { }
    /**
     * Metodo estático que permite si saber si ya se inicializó la instancia
     * de esta clase o no, para utilizar la existente.
     */
    public static FabricaTipoNumeroFloat getFabricaTipoFloat(){
        if (FabricaTipoFloat == null) {
            FabricaTipoFloat = new FabricaTipoNumeroFloat();
        }
        return FabricaTipoFloat;
    }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNumeroFloat que ha creado.
     */
    public HashMap<Double, TipoNumeroFloat> getMapa() { return this.Mapa; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNumeroFloat que ha creado.
     */
    public int getCantidadElementos(){
        return this.getMapa().size();
    }
    /**
     * Metodo que permite la creacion de los TipoString, al consultarle al
     * diccionario si el TipoNumeroFloat consultado ya existe, sino se crea uno
     * nuevo con el double de java ingresado.
     */
    public TipoNumeroFloat crear(double valor){
        if(!this.getMapa().containsKey(valor)){
            TipoNumeroFloat nuevo_valor = new TipoNumeroFloat(valor);
            this.getMapa().put(valor, nuevo_valor);
        }
        return this.getMapa().get(valor);
    }

}
