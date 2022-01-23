package cl.uchile.dcc.scrabble.gui.FabricaITipo;

import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.TipoNumeroInt;

import java.util.HashMap;
/**
 * Clase que implementa una Fábrica de TipoNumeroInt de Scrabble.
 * Existe solo una única instancia de este objeto.
 * Tiene un diccionario donde guarda todos los valores que alguna vez se han
 * creado con esta fábrica. Este diccionario es único a consecuencia de la unicidad
 * de esta fábrica.
 * @autor: María Jesús Mellado Tenorio.
 */
public class FabricaTipoNumeroInt{
    private static FabricaTipoNumeroInt FabricaTipoInt;
    protected HashMap<Integer, TipoNumeroInt> Mapa = new HashMap();
    /**
     * Constructor privado de la clase FabricaTipoNumeroInt para unicidad.
     */
    private FabricaTipoNumeroInt() { }
    /**
     * Metodo estático que permite si saber si ya se inicializó la instancia
     * de esta clase o no, para utilizar la existente.
     */
    public static FabricaTipoNumeroInt getFabricaTipoInt(){
        if (FabricaTipoInt == null) { // only if no instance exists, then create a new
                FabricaTipoInt = new FabricaTipoNumeroInt();
        }
        return FabricaTipoInt;}
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNumeroInt que ha creado.
     */
    public HashMap<Integer, TipoNumeroInt> getMapa() { return this.Mapa; }
    /**
     * Metodo que permite obtener la cantidad de elementos del diccionario
     * donde esta fábrica ha guardado todos los TipoNumeroInt que ha creado.
     */
    public int getCantidadElementos(){
        return this.getMapa().size();
    }
    /**
     * Metodo que permite la creacion de los TipoNumeroInt, al consultarle al
     * diccionario si tal TipoNumeroInt consultado ya existe, sino se crea uno
     * nuevo con el int de java ingresado.
     */
    public TipoNumeroInt crear(int valor){
        if(!this.getMapa().containsKey(valor)){
            TipoNumeroInt nuevo_valor = new TipoNumeroInt(valor);
            this.getMapa().put(valor, nuevo_valor);
        }
        return this.getMapa().get(valor);
    }


}
